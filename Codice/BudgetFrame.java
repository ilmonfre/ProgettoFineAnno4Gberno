import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.BorderLayout

public class BudgetFrame extends JFrame{

    JPanel panelSup, panelBudget;
    JButton buttonSettimanale, buttonMensile, buttonAnnuale, buttonTema;

    JTabbedPane panelCen;
    JPanel panelSettimanale, panelMensile, panelAnnuale, panelImpostazioni, panelModifica, panelCrea, panelSupCen;
    JProgressBar barSettimanale, barMensile, barAnnuale;
    JButton buttonAggiungi, buttonImpostazioni;
    RoundedBorderButton buttonModifica, buttonElimina, buttonConferma, buttonCrea, buttonConfCrea;
    JPopupMenu menuImpostazioni, menuModifica, menuCrea;
    RoundedTextField textModifica, textMax;
    JLabel labelErrore, labelCentrale, labelSpesiSett, labelSpesiMen, labelSpesiAnn, labelRimastiSett, labelRimastiMen, labelRimastiAnn, labelMaxSett, labelMaxMen, labelMaxAnn;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna, imageHome;

    Budget budget;

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
        buttonAggiungi.setIcon(imageImpostazioni);

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
        labelCentrale = new JLabel();
        buttonCrea = new RoundedBorderButton("Crea", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);

        buttonConferma.addActionListener(new ActionListener(){

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

                labelCentrale.setText("Non è presente nessun limite");
                panelCen.add(labelCentrale);
                panelCen.add(buttonCrea);
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

        buttonCrea.addActionListener(e -> {
            
            menuCrea.show(buttonCrea, 0, buttonCrea.getHeight());
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

        panelSupCen.setLayout(new BorderLayout());
        
        panelSupCen.add(buttonAggiungi, BorderLayout.WEST);
        panelSupCen.add(buttonImpostazioni, BorderLayout.EAST);

        if(budget.getMaxSett()==-1){

            panelSettimanale.setLayout(new GridLayout(3, 1));

            panelSettimanale.add(panelSupCen);
            panelSettimanale.add(labelCentrale);
            panelSettimanale.add(buttonCrea);
        }
        if(budget.getMaxSett()!=-1){

            barSettimanale = new JProgressBar();
        
            barSettimanale.setMaximum((int) Math.round(budget.getMaxSett()));
            
            new Timer(500, new ActionListener() {
                
                public void actionPerformed(ActionEvent e) {
                    
                    barSettimanale.setValue((int) Math.round(budget.getCorrenteSett()));
                }
            }).start();

            String spesiSett = String.valueOf(budget.getCorrenteSett());
            labelSpesiSett = new JLabel("Hai speso "+spesiSett+" €");

            String rimastiSett = String.valueOf(budget.getMaxSett()-budget.getCorrenteSett());
            labelSpesiSett = new JLabel("Rispetto al budget settimanale sono rimasti "+rimastiSett+" €");

            String limSett = String.valueOf(budget.getMaxSett());
            labelMaxSett = new JLabel("Il budget settimanale è "+limSett+" €");

            panelSettimanale.setLayout(new GridLayout(2, 2));
            
            panelSettimanale.add(barSettimanale);
            panelSettimanale.add(labelMaxSett);
            panelSettimanale.add(labelSpesiSett);
            panelSettimanale.add(labelRimastiSett);
        }

        panelCen.addTab("Budget settimanale", panelSettimanale);

        setLayout(new BorderLayout());

        add(panelSup, BorderLayout.NORTH);
        add(panelCen, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        setVisible(true);
    }
}