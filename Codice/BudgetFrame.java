import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.awt.KeyboardFocusManager;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;

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
    JLabel labelErrore, labelErroreMensile, labelErroreAnnuale, labelCentrale, labelCentraleMensile, labelCentraleAnnuale, labelSpesiSett, labelSpesiMen, labelSpesiAnn, labelRimastiSett, labelRimastiMen, labelRimastiAnn, labelMaxSett, labelMaxMen, labelMaxAnn;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna, imageHome;
    
    Budget budget = new Budget(0, 0, 0, 0, 0, 0);

    public void aggiornaPannelloSettimanale() {
        panelSettimanale.removeAll();

        // Sezione superiore con pulsanti
        panelSupCen.setLayout(new BorderLayout());
        panelSupCen.add(buttonAggiungi, BorderLayout.WEST);
        panelSupCen.add(buttonImpostazioni, BorderLayout.EAST);

        // Controllo: budget settimanale non ancora impostato
        if (budget.getMaxSett() == -1) {
            buttonImpostazioni.setEnabled(false);
            buttonAggiungi.setEnabled(true);

            labelCentrale.setFont(new Font("Arial", Font.BOLD, 25));
            labelCentrale.setHorizontalAlignment(SwingConstants.CENTER);

            panelSettimanale.setLayout(new BorderLayout());
            panelSettimanale.add(panelSupCen, BorderLayout.NORTH);
            panelSettimanale.add(labelCentrale, BorderLayout.CENTER);

        } else {
            buttonImpostazioni.setEnabled(true);
            buttonAggiungi.setEnabled(false);

            // Barra di progresso
            barSettimanale = new JProgressBar();
            barSettimanale.setMaximum((int) Math.round(budget.getMaxSett()));
            barSettimanale.setValue((int) Math.round(budget.getCorrenteSett()));
            barSettimanale.setPreferredSize(new Dimension(250, 30));
            barSettimanale.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Etichette
            String spesiSett = String.valueOf(budget.getCorrenteSett());
            labelSpesiSett = new JLabel("Hai speso " + spesiSett + " €");
            labelSpesiSett.setFont(new Font("Arial", Font.PLAIN, 18));
            labelSpesiSett.setAlignmentX(Component.CENTER_ALIGNMENT);

            String rimastiSett = String.valueOf(budget.getMaxSett() - budget.getCorrenteSett());
            labelRimastiSett = new JLabel("Rispetto al budget settimanale sono rimasti " + rimastiSett + " €");
            labelRimastiSett.setFont(new Font("Arial", Font.PLAIN, 18));
            labelRimastiSett.setAlignmentX(Component.CENTER_ALIGNMENT);

            String limSett = String.valueOf(budget.getMaxSett());
            labelMaxSett = new JLabel("Il budget settimanale è " + limSett + " €");
            labelMaxSett.setFont(new Font("Arial", Font.PLAIN, 18));
            labelMaxSett.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Pannello per barra e limite
            JPanel panelTmp = new JPanel();
            panelTmp.setLayout(new BoxLayout(panelTmp, BoxLayout.Y_AXIS));
            panelTmp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panelTmp.add(barSettimanale);
            panelTmp.add(Box.createVerticalStrut(10));
            panelTmp.add(labelMaxSett);

            // Pannello per spesi e rimasti
            JPanel panelTmp2 = new JPanel();
            panelTmp2.setLayout(new BoxLayout(panelTmp2, BoxLayout.Y_AXIS));
            panelTmp2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
            panelTmp2.add(labelSpesiSett);
            panelTmp2.add(Box.createVerticalStrut(10));
            panelTmp2.add(labelRimastiSett);

            // Layout principale
            panelSettimanale.setLayout(new BorderLayout());
            panelSettimanale.add(panelSupCen, BorderLayout.NORTH);
            panelSettimanale.add(panelTmp, BorderLayout.CENTER);
            panelSettimanale.add(panelTmp2, BorderLayout.SOUTH);
        }

        panelSettimanale.revalidate();
        panelSettimanale.repaint();
    }


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
        menuModifica.setFocusable(false);
        panelModifica = new JPanel();
        buttonConferma = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        textModifica = new RoundedTextField(20, 30);
        labelErrore = new JLabel();
        labelCentrale = new JLabel("Non è presente nessun budget");
        menuCrea = new JPopupMenu();
        panelCrea = new JPanel();

        buttonConfCrea = new RoundedBorderButton("Conferma", Color.blue, Color.blue, Color.white, Color.cyan, Color.cyan, Color.blue, 2, 20, 20);
        textMax = new RoundedTextField(20, 30);
        panelSupCen = new JPanel();
        aggiornaPannelloSettimanale();

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

        // Bottone conferma nuovo budget
        buttonConfCrea.addActionListener(e -> {
            if (!budget.controlloNumero(textMax)) {
                labelErrore.setText("Inserisci un valore numerico");
            } else {
                labelErrore.setText("");
                double nuovoMax = Double.parseDouble(textMax.getText());
                budget.setMaxSett(nuovoMax);
                menuCrea.setVisible(false);
                aggiornaPannelloSettimanale();
            }
        });
        
        // Pannello nuovo budget
        panelCrea.setLayout(new GridLayout(3, 1));
        panelCrea.add(textMax);
        panelCrea.add(labelErrore);
        panelCrea.add(buttonConfCrea);
        menuCrea.add(panelCrea);

        buttonAggiungi.addActionListener(e -> {
            menuCrea.show(buttonAggiungi, 0, buttonAggiungi.getHeight());
            textMax.requestFocusInWindow();  // Forza il focus
        });

        // Bottone conferma modifica
        buttonConferma.addActionListener(e -> {
            if (!budget.controlloNumero(textMax)) {
                labelErrore.setText("Inserisci un valore numerico");
            } else {
                labelErrore.setText("");
                double nuovoMax = Double.parseDouble(textModifica.getText());
                budget.setMaxSett(nuovoMax);
                menuModifica.setVisible(false);
                aggiornaPannelloSettimanale();
            }
        });

        // Pannello modifica
        panelModifica.setLayout(new GridLayout(3, 1));
        panelModifica.add(textModifica);
        panelModifica.add(labelErrore);
        panelModifica.add(buttonConferma);
        menuModifica.add(panelModifica);

        buttonModifica.addActionListener(e -> {
            menuModifica.show(buttonModifica, 0, buttonModifica.getHeight());
            textModifica.requestFocusInWindow();  // Forza il focus
        });

        // Bottone elimina budget
        buttonElimina.addActionListener(e -> {
            panelSettimanale.removeAll();
            panelSettimanale.setLayout(new GridLayout(2, 1));
            panelSettimanale.add(labelCentrale);
            panelSettimanale.revalidate();
            panelSettimanale.repaint();
        });

        // Pannello impostazioni
        panelImpostazioni.setLayout(new GridLayout(1, 2));
        panelImpostazioni.add(buttonModifica);
        panelImpostazioni.add(buttonElimina);
        menuImpostazioni.add(panelImpostazioni);

        buttonImpostazioni.addActionListener(e -> {
            menuImpostazioni.show(buttonImpostazioni, 0, buttonImpostazioni.getHeight());
        });

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