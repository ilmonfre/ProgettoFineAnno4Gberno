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
    JPanel panelSettimanale, panelMensile, panelAnnuale, panelImpostazioni, panelModifica, panelCrea, panelSupCen;
    JProgressBar barSettimanale, barMensile, barAnnuale;
    JButton buttonAggiungi, buttonImpostazioni;
    RoundedBorderButton buttonModifica, buttonElimina, buttonConferma, buttonConfCrea;
    JPopupMenu menuImpostazioni, menuModifica, menuCrea;
    RoundedTextField textModifica, textMax;
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

        ImageIcon imageAggiungi = new ImageIcon(getClass().getResource("/Immagini/Icona+Nera.png"));
        buttonAggiungi.setIcon(imageAggiungi);

        ImageIcon imageImpostazioni = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniNera.png"));
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

        imageHome = new ImageIcon(getClass().getResource("/Immagini/IconaHomeNera.png"));
        buttonHome.setIcon(imageHome);
        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimenti.png"));
        buttonMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiNera.png"));
        buttonRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamenti.png"));
        buttonPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudget.png"));
        buttonBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValuta.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        buttonHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                //Utente utente = new Utente();
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