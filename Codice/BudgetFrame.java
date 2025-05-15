import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class BudgetFrame extends JFrame{

    JPanel panelSup, panelBudget;
    JButton buttonSettimanale, buttonMensile, buttonAnnuale, buttonTema;

    JTabbedPane panelCen;
    JPanel panelSettimanale, panelMensile, panelAnnuale, panelImpostazioni, panelModifica, panelCrea, panelSupCen, panelImpostazioniMensile, panelModificaMensile, panelCreaMensile, panelSupCenMensile, panelImpostazioniAnnuale, panelModificaAnnuale, panelCreaAnnuale, panelSupCenAnnuale;
    JProgressBar barSettimanale, barMensile, barAnnuale;
    JButton buttonAggiungi, buttonImpostazioni, buttonAggiungiMensile, buttonImpostazioniMensile, buttonAggiungiAnnuale, buttonImpostazioniAnnuale;
    RoundedBorderButton buttonModifica, buttonElimina, buttonConferma, buttonConfCrea, buttonModificaMensile, buttonEliminaMensile, buttonConfermaMensile, buttonConfCreaMensile, buttonModificaAnnuale, buttonEliminaAnnuale, buttonConfermaAnnuale, buttonConfCreaAnnuale;
    JPopupMenu menuImpostazioni, menuModifica, menuCrea, menuImpostazioniMensile, menuModificaMensile, menuCreaMensile, menuImpostazioniAnnuale, menuModificaAnnuale, menuCreaAnnuale;
    RoundedTextField textModifica, textMax, textModificaMensile, textMaxMensile, textModificaAnnuale, textMaxAnnuale;
    JLabel labelErrore, labelCentrale, labelSpesiSett, labelSpesiMen, labelSpesiAnn, labelRimastiSett, labelRimastiMen, labelRimastiAnn, labelMaxSett, labelMaxMen, labelMaxAnn;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna, imageHome;
    
    Budget budget = new Budget(0, 0, 0, 0, 0, 0);

    public BudgetFrame(){

        panelSup = new JPanel();

        buttonSettimanale = new JButton();
        buttonMensile = new JButton();
        buttonAnnuale = new JButton();

        buttonSettimanale.setOpaque(false);
        buttonSettimanale.setContentAreaFilled(false);
        buttonSettimanale.setBorderPainted(false);
        buttonSettimanale.setFocusPainted(false);

        buttonMensile.setOpaque(false);
        buttonMensile.setContentAreaFilled(false);
        buttonMensile.setBorderPainted(false);
        buttonMensile.setFocusPainted(false);

        buttonAnnuale.setOpaque(false);
        buttonAnnuale.setContentAreaFilled(false);
        buttonAnnuale.setBorderPainted(false);
        buttonAnnuale.setFocusPainted(false);

        panelBudget = new JPanel();

        panelBudget.setLayout(new GridLayout(1, 3));

        panelBudget.add(buttonSettimanale);
        panelBudget.add(buttonMensile);
        panelBudget.add(buttonAnnuale);

        buttonTema = new JButton();

        buttonTema.setIcon(imageLuna);
        buttonTema.setOpaque(false);
        buttonTema.setContentAreaFilled(false);
        buttonTema.setBorderPainted(false);
        buttonTema.setFocusPainted(false);

        panelCen = new JTabbedPane();

        panelSettimanale = new JPanel();
        panelMensile = new JPanel();
        panelAnnuale = new JPanel();

        buttonAggiungi = new JButton();
        buttonImpostazioni = new JButton();

        ImageIcon imageAggiungi = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        buttonAggiungi.setIcon(imageAggiungi);

        ImageIcon imageImpostazioni = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));
        buttonImpostazioni.setIcon(imageImpostazioni);

        buttonAggiungi.setOpaque(false);
        buttonAggiungi.setContentAreaFilled(false);
        buttonAggiungi.setBorderPainted(false);
        buttonAggiungi.setFocusPainted(false);

        buttonImpostazioni.setOpaque(false);
        buttonImpostazioni.setContentAreaFilled(false);
        buttonImpostazioni.setBorderPainted(false);
        buttonImpostazioni.setFocusPainted(false);

        menuImpostazioni = new JPopupMenu();
        panelImpostazioni = new JPanel();

        buttonModifica = new RoundedBorderButton("Modifica", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        buttonElimina = new RoundedBorderButton("Elimina", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        menuModifica = new JPopupMenu();
        panelModifica = new JPanel();

        textModifica = new RoundedTextField(20, 30);

        textModifica.setBackground(Color.decode("#D3D3D3"));
        String placeholder = "Inserisci nuovo limite";
        textModifica.setForeground(Color.GRAY);
        textModifica.setText(placeholder);

        textModifica.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModifica.getText().equals(placeholder)) {
                    textModifica.setText("");
                    textModifica.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModifica.getText().isEmpty()) {
                    textModifica.setForeground(Color.GRAY);
                    textModifica.setText(placeholder);
                }
            }
        });
        textModifica.setSize(200, 50);

        buttonConferma = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        labelErrore = new JLabel();
        labelCentrale = new JLabel("Non è presente nessun budget");

        buttonAggiungi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textModifica)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textModifica.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }

                menuCrea.setVisible(false);
            }
        });

        buttonElimina.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                panelSettimanale.removeAll();
                panelSettimanale.setLayout(new GridLayout(2, 1));
                panelSettimanale.add(labelCentrale);
                panelSettimanale.revalidate();
                panelSettimanale.repaint();
            }
        });

        menuCrea = new JPopupMenu();
        panelCrea = new JPanel();

        buttonConfCrea = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        textMax = new RoundedTextField(20, 30);

        textMax.setBackground(Color.decode("#D3D3D3"));
        String placeholder2 = "Inserisci limite";
        textMax.setForeground(Color.GRAY);
        textMax.setText(placeholder2);

        textMax.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMax.getText().equals(placeholder2)) {
                    textMax.setText("");
                    textMax.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMax.getText().isEmpty()) {
                    textMax.setForeground(Color.GRAY);
                    textMax.setText(placeholder2);
                }
            }
        });
        textMax.setSize(200, 50);

        buttonConfCrea.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textMax)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textMax.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }
            }
        });

        panelCrea.setLayout(new GridLayout(3, 1));

        panelCrea.add(textMax);
        panelCrea.add(labelErrore);
        panelCrea.add(buttonConfCrea);
        menuCrea.add(panelCrea);

        buttonAggiungi.addActionListener(e -> {
            
            menuCrea.show(buttonAggiungi, 0, buttonAggiungi.getHeight());
        });

        panelImpostazioni.setLayout(new GridLayout(1, 2));
        
        panelImpostazioni.add(buttonModifica);
        panelImpostazioni.add(buttonElimina);
        menuImpostazioni.add(panelImpostazioni);

        panelModifica.setLayout(new GridLayout(3, 1));

        panelModifica.add(textModifica);
        panelModifica.add(labelErrore);
        panelModifica.add(buttonConferma);
        menuModifica.add(panelModifica);

        buttonModifica.addActionListener(e -> {
            
            menuModifica.show(buttonModifica, 0, buttonModifica.getHeight());
        });

        buttonImpostazioni.addActionListener(e -> {
            
            menuImpostazioni.show(buttonImpostazioni, 0, buttonImpostazioni.getHeight());
        });

        budget.visualizzaLimiti();

        panelSupCen = new JPanel();

        new Timer(500, new ActionListener(){
            
            int prec = 0;
            boolean stop = false;

            @Override
            public void actionPerformed(ActionEvent e){

                if(stop==false){

                    if(budget.getMaxSett()==-1){

                        if(prec==1){
    
                            stop=true;
                        }else{
    
                            panelSettimanale.repaint();
            
                            panelSupCen.setLayout(new BorderLayout());
                        
                            panelSupCen.add(buttonAggiungi, BorderLayout.WEST);
                            panelSupCen.add(buttonImpostazioni, BorderLayout.EAST);
                
                            buttonImpostazioni.setEnabled(false);
                            buttonAggiungi.setEnabled(true);
                
                            labelCentrale.setFont(new Font("Arial", Font.BOLD, 25));
                            labelCentrale.setAlignmentX(CENTER_ALIGNMENT);
                            labelCentrale.setAlignmentY(CENTER_ALIGNMENT);
                
                            panelSettimanale.setLayout(new GridLayout(2, 1));
                
                            panelSettimanale.add(panelSupCen);
                            panelSettimanale.add(labelCentrale);
    
                            prec=1;
                        }
                    }
                    if(budget.getMaxSett()!=-1){
                        
                        if(prec==2){
    
                            stop=true;
                        }else{
    
                            panelSettimanale.repaint();
            
                            barSettimanale = new JProgressBar();
                        
                            barSettimanale.setMaximum((int) Math.round(budget.getMaxSett()));
                            
                            new Timer(500, new ActionListener() {
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    barSettimanale.setValue((int) Math.round(budget.getCorrenteSett()));
                                    barSettimanale.repaint();
                                }
                            }).start();
                
                            buttonImpostazioni.setEnabled(true);
                            buttonAggiungi.setEnabled(false);
                
                            panelSupCen.setLayout(new BorderLayout());
                        
                            panelSupCen.add(buttonAggiungi, BorderLayout.WEST);
                            panelSupCen.add(buttonImpostazioni, BorderLayout.EAST);
                
                            buttonImpostazioni.setEnabled(false);
                
                            String spesiSett = String.valueOf(budget.getCorrenteSett());
                            labelSpesiSett = new JLabel("Hai speso "+spesiSett+" €");
                
                            String rimastiSett = String.valueOf(budget.getMaxSett()-budget.getCorrenteSett());
                            labelRimastiSett = new JLabel("Rispetto al budget settimanale sono rimasti "+rimastiSett+" €");
                
                            String limSett = String.valueOf(budget.getMaxSett());
                            labelMaxSett = new JLabel("Il budget settimanale è "+limSett+" €");
                
                            JPanel panelTmp = new JPanel();
                            panelTmp.add(barSettimanale);
                            panelTmp.add(labelMaxSett);
                
                            JPanel panelTmp2 = new JPanel();
                            panelTmp2.add(labelSpesiSett);
                            panelTmp2.add(labelRimastiSett);
                
                            panelSettimanale.setLayout(new GridLayout(3, 1));
                            
                            panelSettimanale.add(panelSupCen);
                            panelSettimanale.add(panelTmp);
                            panelSettimanale.add(panelTmp2);
    
                            prec=2;
                        }
                    }
                }
            }
        }).start();

        panelCen.addTab("Budget settimanale", panelSettimanale);




        ImageIcon imageAggiungiMensile = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        buttonAggiungiMensile.setIcon(imageAggiungiMensile);

        ImageIcon imageImpostazioniMensile = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));
        buttonImpostazioniMensile.setIcon(imageImpostazioniMensile);

        buttonAggiungiMensile.setOpaque(false);
        buttonAggiungiMensile.setContentAreaFilled(false);
        buttonAggiungiMensile.setBorderPainted(false);
        buttonAggiungiMensile.setFocusPainted(false);

        buttonImpostazioniMensile.setOpaque(false);
        buttonImpostazioniMensile.setContentAreaFilled(false);
        buttonImpostazioniMensile.setBorderPainted(false);
        buttonImpostazioniMensile.setFocusPainted(false);

        menuImpostazioniMensile = new JPopupMenu();
        panelImpostazioniMensile = new JPanel();

        buttonModificaMensile = new RoundedBorderButton("Modifica", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        buttonEliminaMensile = new RoundedBorderButton("Elimina", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        menuModificaMensile = new JPopupMenu();
        panelModificaMensile = new JPanel();

        textModificaMensile = new RoundedTextField(20, 30);

        textModificaMensile.setBackground(Color.decode("#D3D3D3"));
        String placeholderMensile = "Inserisci nuovo limite";
        textModificaMensile.setForeground(Color.GRAY);
        textModificaMensile.setText(placeholder);

        textModificaMensile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModificaMensile.getText().equals(placeholderMensile)) {
                    textModificaMensile.setText("");
                    textModificaMensile.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModificaMensile.getText().isEmpty()) {
                    textModificaMensile.setForeground(Color.GRAY);
                    textModificaMensile.setText(placeholderMensile);
                }
            }
        });
        textModificaMensile.setSize(200, 50);

        buttonConfermaMensile = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        labelErrore = new JLabel();
        labelCentrale = new JLabel("Non è presente nessun budget");

        buttonAggiungiMensile.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textModificaMensile)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textModificaMensile.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }

                menuCreaMensile.setVisible(false);
            }
        });

        buttonEliminaMensile.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                panelMensile.removeAll();
                panelMensile.setLayout(new GridLayout(2, 1));
                panelMensile.add(labelCentrale);
                panelMensile.revalidate();
                panelMensile.repaint();
            }
        });

        menuCreaMensile = new JPopupMenu();
        panelCreaMensile = new JPanel();

        buttonConfCreaMensile = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        textMaxMensile = new RoundedTextField(20, 30);

        textMaxMensile.setBackground(Color.decode("#D3D3D3"));
        String placeholder2Mensile = "Inserisci limite";
        textMaxMensile.setForeground(Color.GRAY);
        textMaxMensile.setText(placeholder2Mensile);

        textMaxMensile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMaxMensile.getText().equals(placeholder2)) {
                    textMaxMensile.setText("");
                    textMaxMensile.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMaxMensile.getText().isEmpty()) {
                    textMaxMensile.setForeground(Color.GRAY);
                    textMaxMensile.setText(placeholder2Mensile);
                }
            }
        });
        textMaxMensile.setSize(200, 50);

        buttonConfCreaMensile.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textMaxMensile)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textMaxMensile.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }
            }
        });

        panelCreaMensile.setLayout(new GridLayout(3, 1));

        panelCreaMensile.add(textMaxMensile);
        panelCreaMensile.add(labelErrore);
        panelCreaMensile.add(buttonConfCreaMensile);
        menuCreaMensile.add(panelCreaMensile);

        buttonAggiungiMensile.addActionListener(e -> {
            
            menuCreaMensile.show(buttonAggiungiMensile, 0, buttonAggiungiMensile.getHeight());
        });

        panelImpostazioniMensile.setLayout(new GridLayout(1, 2));
        
        panelImpostazioniMensile.add(buttonModificaMensile);
        panelImpostazioniMensile.add(buttonEliminaMensile);
        menuImpostazioniMensile.add(panelImpostazioniMensile);

        panelModificaMensile.setLayout(new GridLayout(3, 1));

        panelModificaMensile.add(textModificaMensile);
        panelModificaMensile.add(labelErrore);
        panelModificaMensile.add(buttonConfermaMensile);
        menuModificaMensile.add(panelModificaMensile);

        buttonModificaMensile.addActionListener(e -> {
            
            menuModificaMensile.show(buttonModificaMensile, 0, buttonModificaMensile.getHeight());
        });

        buttonImpostazioniMensile.addActionListener(e -> {
            
            menuImpostazioniMensile.show(buttonImpostazioniMensile, 0, buttonImpostazioniMensile.getHeight());
        });

        budget.visualizzaLimiti();

        panelSupCenMensile = new JPanel();

        new Timer(500, new ActionListener(){
            
            int prec = 0;
            boolean stop = false;

            @Override
            public void actionPerformed(ActionEvent e){

                if(stop==false){

                    if(budget.getMaxMen()==-1){

                        if(prec==1){
    
                            stop=true;
                        }else{
    
                            panelMensile.repaint();
            
                            panelSupCenMensile.setLayout(new BorderLayout());
                        
                            panelSupCenMensile.add(buttonAggiungiMensile, BorderLayout.WEST);
                            panelSupCenMensile.add(buttonImpostazioniMensile, BorderLayout.EAST);
                
                            buttonImpostazioniMensile.setEnabled(false);
                            buttonAggiungiMensile.setEnabled(true);
                
                            labelCentrale.setFont(new Font("Arial", Font.BOLD, 25));
                            labelCentrale.setAlignmentX(CENTER_ALIGNMENT);
                            labelCentrale.setAlignmentY(CENTER_ALIGNMENT);
                
                            panelMensile.setLayout(new GridLayout(2, 1));
                
                            panelMensile.add(panelSupCenMensile);
                            panelMensile.add(labelCentrale);
    
                            prec=1;
                        }
                    }
                    if(budget.getMaxMen()!=-1){
                        
                        if(prec==2){
    
                            stop=true;
                        }else{
    
                            panelMensile.repaint();
            
                            barMensile = new JProgressBar();
                        
                            barMensile.setMaximum((int) Math.round(budget.getMaxMen()));
                            
                            new Timer(500, new ActionListener() {
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    barMensile.setValue((int) Math.round(budget.getCorrenteMen()));
                                    barMensile.repaint();
                                }
                            }).start();
                
                            buttonImpostazioniMensile.setEnabled(true);
                            buttonAggiungiMensile.setEnabled(false);
                
                            panelSupCenMensile.setLayout(new BorderLayout());
                        
                            panelSupCenMensile.add(buttonAggiungiMensile, BorderLayout.WEST);
                            panelSupCenMensile.add(buttonImpostazioniMensile, BorderLayout.EAST);
                
                            buttonImpostazioniMensile.setEnabled(false);
                
                            String spesiMensile = String.valueOf(budget.getCorrenteMen());
                            labelSpesiMen = new JLabel("Hai speso "+spesiMensile+" €");
                
                            String rimastiMensile = String.valueOf(budget.getMaxMen()-budget.getCorrenteMen());
                            labelRimastiMen = new JLabel("Rispetto al budget settimanale sono rimasti "+rimastiMensile+" €");
                
                            String limMensile = String.valueOf(budget.getMaxMen());
                            labelMaxMen = new JLabel("Il budget settimanale è "+limMensile+" €");
                
                            JPanel panelTmp = new JPanel();
                            panelTmp.add(barMensile);
                            panelTmp.add(labelMaxMen);
                
                            JPanel panelTmp2 = new JPanel();
                            panelTmp2.add(labelSpesiMen);
                            panelTmp2.add(labelRimastiMen);
                
                            panelMensile.setLayout(new GridLayout(3, 1));
                            
                            panelMensile.add(panelSupCenMensile);
                            panelMensile.add(panelTmp);
                            panelMensile.add(panelTmp2);
    
                            prec=2;
                        }
                    }
                }
            }
        }).start();

        panelCen.addTab("Budget settimanale", panelMensile);





        ImageIcon imageAggiungiAnnuale = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        buttonAggiungiAnnuale.setIcon(imageAggiungiAnnuale);

        ImageIcon imageImpostazioniAnnuale = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));
        buttonImpostazioniAnnuale.setIcon(imageImpostazioniAnnuale);

        buttonAggiungiAnnuale.setOpaque(false);
        buttonAggiungiAnnuale.setContentAreaFilled(false);
        buttonAggiungiAnnuale.setBorderPainted(false);
        buttonAggiungiAnnuale.setFocusPainted(false);

        buttonImpostazioniAnnuale.setOpaque(false);
        buttonImpostazioniAnnuale.setContentAreaFilled(false);
        buttonImpostazioniAnnuale.setBorderPainted(false);
        buttonImpostazioniAnnuale.setFocusPainted(false);

        menuImpostazioniAnnuale = new JPopupMenu();
        panelImpostazioniAnnuale = new JPanel();

        buttonModificaAnnuale = new RoundedBorderButton("Modifica", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        buttonEliminaAnnuale = new RoundedBorderButton("Elimina", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        menuModificaAnnuale = new JPopupMenu();
        panelModificaAnnuale = new JPanel();

        textModificaAnnuale = new RoundedTextField(20, 30);

        textModificaAnnuale.setBackground(Color.decode("#D3D3D3"));
        String placeholderAnnuale = "Inserisci nuovo limite";
        textModificaAnnuale.setForeground(Color.GRAY);
        textModificaAnnuale.setText(placeholderAnnuale);

        textModificaAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModificaAnnuale.getText().equals(placeholderAnnuale)) {
                    textModificaAnnuale.setText("");
                    textModificaAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModificaAnnuale.getText().isEmpty()) {
                    textModificaAnnuale.setForeground(Color.GRAY);
                    textModificaAnnuale.setText(placeholderAnnuale);
                }
            }
        });
        textModificaAnnuale.setSize(200, 50);

        buttonConfermaAnnuale = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        labelErrore = new JLabel();
        labelCentrale = new JLabel("Non è presente nessun budget");

        buttonAggiungiAnnuale.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textModificaAnnuale)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textModificaAnnuale.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }

                menuCreaAnnuale.setVisible(false);
            }
        });

        buttonEliminaAnnuale.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                panelAnnuale.removeAll();
                panelAnnuale.setLayout(new GridLayout(2, 1));
                panelAnnuale.add(labelCentrale);
                panelAnnuale.revalidate();
                panelAnnuale.repaint();
            }
        });

        menuCreaAnnuale = new JPopupMenu();
        panelCreaAnnuale = new JPanel();

        buttonConfCreaAnnuale = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        textMaxAnnuale = new RoundedTextField(20, 30);

        textMaxAnnuale.setBackground(Color.decode("#D3D3D3"));
        String placeholder2Annuale = "Inserisci limite";
        textMaxAnnuale.setForeground(Color.GRAY);
        textMaxAnnuale.setText(placeholder2Annuale);

        textMaxAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMaxAnnuale.getText().equals(placeholder2Annuale)) {
                    textMaxAnnuale.setText("");
                    textMaxAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMaxAnnuale.getText().isEmpty()) {
                    textMaxAnnuale.setForeground(Color.GRAY);
                    textMaxAnnuale.setText(placeholder2Annuale);
                }
            }
        });
        textMaxAnnuale.setSize(200, 50);

        buttonConfCreaAnnuale.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(budget.controlloNumero(textMaxAnnuale)==false){

                    labelErrore.setText("Inserisci un valore numerico");
                }else{

                    labelErrore.setText("");
                    double nuovoMax = Double.parseDouble(textMaxAnnuale.getText());

                    if(panelCen.getSelectedIndex()==0){

                        budget.setMaxSett(nuovoMax);
                    }else if(panelCen.getSelectedIndex()==1){

                        budget.setMaxMen(nuovoMax);
                    }else{

                        budget.setMaxAnn(nuovoMax);
                    }
                }
            }
        });

        panelCreaAnnuale.setLayout(new GridLayout(3, 1));

        panelCreaAnnuale.add(textMaxAnnuale);
        panelCreaAnnuale.add(labelErrore);
        panelCreaAnnuale.add(buttonConfCreaAnnuale);
        menuCreaAnnuale.add(panelCreaAnnuale);

        buttonAggiungiAnnuale.addActionListener(e -> {
            
            menuCreaAnnuale.show(buttonAggiungiAnnuale, 0, buttonAggiungiAnnuale.getHeight());
        });

        panelImpostazioniAnnuale.setLayout(new GridLayout(1, 2));
        
        panelImpostazioniAnnuale.add(buttonModificaAnnuale);
        panelImpostazioniAnnuale.add(buttonEliminaAnnuale);
        menuImpostazioniAnnuale.add(panelImpostazioniAnnuale);

        panelModificaAnnuale.setLayout(new GridLayout(3, 1));

        panelModificaAnnuale.add(textModificaAnnuale);
        panelModificaAnnuale.add(labelErrore);
        panelModificaAnnuale.add(buttonConfermaAnnuale);
        menuModificaAnnuale.add(panelModificaAnnuale);

        buttonModificaAnnuale.addActionListener(e -> {
            
            menuModificaAnnuale.show(buttonModificaAnnuale, 0, buttonModificaAnnuale.getHeight());
        });

        buttonImpostazioniAnnuale.addActionListener(e -> {
            
            menuImpostazioniAnnuale.show(buttonImpostazioniAnnuale, 0, buttonImpostazioniAnnuale.getHeight());
        });

        budget.visualizzaLimiti();

        panelSupCenAnnuale = new JPanel();

        new Timer(500, new ActionListener(){
            
            int prec = 0;
            boolean stop = false;

            @Override
            public void actionPerformed(ActionEvent e){

                if(stop==false){

                    if(budget.getMaxAnn()==-1){

                        if(prec==1){
    
                            stop=true;
                        }else{
    
                            panelAnnuale.repaint();
            
                            panelSupCenAnnuale.setLayout(new BorderLayout());
                        
                            panelSupCenAnnuale.add(buttonAggiungiAnnuale, BorderLayout.WEST);
                            panelSupCenAnnuale.add(buttonImpostazioniAnnuale, BorderLayout.EAST);
                
                            buttonImpostazioniAnnuale.setEnabled(false);
                            buttonAggiungiAnnuale.setEnabled(true);
                
                            labelCentrale.setFont(new Font("Arial", Font.BOLD, 25));
                            labelCentrale.setAlignmentX(CENTER_ALIGNMENT);
                            labelCentrale.setAlignmentY(CENTER_ALIGNMENT);
                
                            panelAnnuale.setLayout(new GridLayout(2, 1));
                
                            panelAnnuale.add(panelSupCenAnnuale);
                            panelAnnuale.add(labelCentrale);
    
                            prec=1;
                        }
                    }
                    if(budget.getMaxAnn()!=-1){
                        
                        if(prec==2){
    
                            stop=true;
                        }else{
    
                            panelAnnuale.repaint();
            
                            barAnnuale = new JProgressBar();
                        
                            barAnnuale.setMaximum((int) Math.round(budget.getMaxAnn()));
                            
                            new Timer(500, new ActionListener() {
                                
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    
                                    barAnnuale.setValue((int) Math.round(budget.getCorrenteAnn()));
                                    barAnnuale.repaint();
                                }
                            }).start();
                
                            buttonImpostazioniAnnuale.setEnabled(true);
                            buttonAggiungiAnnuale.setEnabled(false);
                
                            panelSupCenAnnuale.setLayout(new BorderLayout());
                        
                            panelSupCenAnnuale.add(buttonAggiungiAnnuale, BorderLayout.WEST);
                            panelSupCenAnnuale.add(buttonImpostazioniAnnuale, BorderLayout.EAST);
                
                            buttonImpostazioniAnnuale.setEnabled(false);
                
                            String spesiAnnuale = String.valueOf(budget.getCorrenteAnn());
                            labelSpesiAnn = new JLabel("Hai speso "+spesiAnnuale+" €");
                
                            String rimastiAnnuale = String.valueOf(budget.getMaxAnn()-budget.getCorrenteAnn());
                            labelRimastiAnn = new JLabel("Rispetto al budget settimanale sono rimasti "+rimastiAnnuale+" €");
                
                            String limAnnuale = String.valueOf(budget.getMaxAnn());
                            labelMaxAnn = new JLabel("Il budget settimanale è "+limAnnuale+" €");
                
                            JPanel panelTmp = new JPanel();
                            panelTmp.add(barAnnuale);
                            panelTmp.add(labelMaxAnn);
                
                            JPanel panelTmp2 = new JPanel();
                            panelTmp2.add(labelSpesiAnn);
                            panelTmp2.add(labelRimastiAnn);
                
                            panelAnnuale.setLayout(new GridLayout(3, 1));
                            
                            panelAnnuale.add(panelSupCenAnnuale);
                            panelAnnuale.add(panelTmp);
                            panelAnnuale.add(panelTmp2);
    
                            prec=2;
                        }
                    }
                }
            }
        }).start();

        panelCen.addTab("Budget settimanale", panelAnnuale);





        imageMovimenti = new ImageIcon();
        imageRisparmi = new ImageIcon();
        imagePagamenti = new ImageIcon();
        imageBudget = new ImageIcon();
        imageCambioValuta = new ImageIcon();

        panelBar = new JPanel();
        panelBar.setLayout(new GridLayout(1, 6));
        panelBar.setBackground(Color.decode("#CCFFFF"));

        buttonHome = new JButton();
        buttonMovimenti = new JButton();
        buttonPagamenti = new JButton();
        buttonRisparmi = new JButton();
        buttonBudget = new JButton();
        buttonCambioValuta = new JButton();

        imageHome = new ImageIcon(getClass().getResource("/Immagini/IconaHomeScura.png"));
        buttonHome.setIcon(imageHome);
        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiScura.png"));
        buttonMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiScura.png"));
        buttonRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScura.png"));
        buttonPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScuraPiena.png"));
        buttonBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScura.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        buttonHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                new HomeFrame();
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new PagamentiFrame();
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameRisparmi();
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new CambioValutaFrame();
            }
        });

        buttonMovimenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new MovimentiFrame();
            }
        });

        buttonHome.setOpaque(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setBorderPainted(false);
        buttonHome.setFocusPainted(false);

        buttonMovimenti.setOpaque(false);
        buttonMovimenti.setContentAreaFilled(false);
        buttonMovimenti.setBorderPainted(false);
        buttonMovimenti.setFocusPainted(false);

        buttonPagamenti.setOpaque(false);
        buttonPagamenti.setContentAreaFilled(false);
        buttonPagamenti.setBorderPainted(false);
        buttonPagamenti.setFocusPainted(false);

        buttonRisparmi.setOpaque(false);
        buttonRisparmi.setContentAreaFilled(false);
        buttonRisparmi.setBorderPainted(false);
        buttonRisparmi.setFocusPainted(false);

        buttonCambioValuta.setOpaque(false);
        buttonCambioValuta.setContentAreaFilled(false);
        buttonCambioValuta.setBorderPainted(false);
        buttonCambioValuta.setFocusPainted(false);

        buttonBudget.setOpaque(false);
        buttonBudget.setContentAreaFilled(false);
        buttonBudget.setBorderPainted(false);
        buttonBudget.setFocusPainted(false);

        panelBar.add(buttonHome);
        panelBar.add(buttonMovimenti);
        panelBar.add(buttonPagamenti);
        panelBar.add(buttonRisparmi);
        panelBar.add(buttonCambioValuta);
        panelBar.add(buttonBudget);

        panelBar.setPreferredSize(new Dimension(0, 60));

        setLayout(new BorderLayout());

        add(panelSup, BorderLayout.NORTH);
        add(panelCen, BorderLayout.CENTER);
        add(panelBar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        setVisible(true);
    }
}