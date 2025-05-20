import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;

public class FrameMovimenti extends JFrame{

    JPanel panelCerca, panelCercaSup, panelCercaInf, panelSuperiore;
    RoundedTextField textCerca;
    RoundedBorderButton buttonFiltra, buttonEntrate, buttonUscite, buttonCerca, buttonReset;
    JRadioButton radioReset;
    JSlider sliderSoldi;
    JPopupMenu menuFiltro;
    JPanel panelSlider;
    JLabel labelSlider, labelValore, labelVuoto;
    JButton buttonTema;

    JPanel panelRisultati;
    JScrollPane barRisultati;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna, imageHome;

    Movimenti movimenti;
    Budget budget;

    public FrameMovimenti(Movimenti movimenti){
        this.movimenti = movimenti;

        imageSole = new ImageIcon();
        imageLuna = new ImageIcon();

        imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));
        imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));

        buttonTema = new JButton();
        
        buttonTema.setIcon(imageLuna);
        buttonTema.setOpaque(false);
        buttonTema.setContentAreaFilled(false);
        buttonTema.setBorderPainted(false);
        buttonTema.setFocusPainted(false);

        buttonTema.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(buttonTema.getIcon().equals(imageLuna)){

                    buttonTema.setIcon(imageSole);
                }else if(buttonTema.getIcon().equals(imageSole)){

                    buttonTema.setIcon(imageLuna);
                }
            }
        });

        panelCerca = new JPanel();
        panelCerca.setBackground(Color.decode("#cbf4f4"));
        panelCercaSup = new JPanel();
        panelCercaSup.setBackground(Color.decode("#cbf4f4"));
        panelCercaInf = new JPanel();
        panelCercaInf.setBackground(Color.decode("#cbf4f4"));


        textCerca = new RoundedTextField(20, 30);
        textCerca.setBackground(Color.decode("#1c2697"));
        String placeholder = "Cerca movimento";
        textCerca.setForeground(Color.decode("#cbf4f4"));
        textCerca.setText(placeholder);

        textCerca.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCerca.getText().equals(placeholder)) {
                    textCerca.setText("");
                    textCerca.setForeground(Color.decode("1c2697"));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textCerca.getText().isEmpty()) {
                    textCerca.setForeground(Color.decode("#cbf4f4"));
                    textCerca.setText(placeholder);
                }
            }
        });
        textCerca.setSize(new Dimension(200, 50));

        Color colorButton = Color.decode("#1c2697");
        Color colorHover = Color.decode("#cbf4f4");
        ImageIcon iconFiltra = new ImageIcon(getClass().getResource("/Immagini/IconaFiltriChiara.png"));
        buttonFiltra = new RoundedBorderButton("", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        buttonFiltra.setIcon(iconFiltra);
        buttonFiltra.setPreferredSize(new Dimension(50, 50));
        
        buttonEntrate = new RoundedBorderButton("Entrate", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        buttonEntrate.setFont(new Font("Arial", Font.BOLD, 20));
        buttonEntrate.setPreferredSize(new Dimension(125, 50));

        buttonUscite = new RoundedBorderButton("Uscite", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        buttonUscite.setFont(new Font("Arial", Font.BOLD, 20));
        buttonUscite.setPreferredSize(new Dimension(125, 50));

        ImageIcon iconCerca = new ImageIcon(getClass().getResource("/Immagini/IconaCercaChiara.png"));
        buttonCerca = new RoundedBorderButton("", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        buttonCerca.setIcon(iconCerca);
        buttonCerca.setPreferredSize(new Dimension(50, 50));

        ImageIcon iconReset = new ImageIcon(getClass().getResource("/Immagini/IconaResetChiara.png"));
        buttonReset = new RoundedBorderButton("", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        buttonReset.setIcon(iconReset);
        buttonReset.setPreferredSize(new Dimension(50, 50));

        int costoMax = movimenti.trovaCostoso();
        sliderSoldi = new JSlider(JSlider.HORIZONTAL, 0, costoMax, 0);

        sliderSoldi.setPaintTicks(false);
        sliderSoldi.setPaintLabels(false);
        sliderSoldi.setEnabled(true);

        menuFiltro = new JPopupMenu();
        panelSlider = new JPanel();
        labelSlider = new JLabel("Seleziona il costo massimo");

        labelValore = new JLabel("Valore selezionato: 0");

        sliderSoldi.addChangeListener(e -> {
            int valore = sliderSoldi.getValue();
            labelValore.setText("Valore selezionato: " + valore);
        });

        panelSlider.setLayout(new GridLayout(3, 1));
        panelSlider.setBackground(Color.decode("#cbf4f4"));
        panelSlider.add(labelSlider);
        panelSlider.add(sliderSoldi);
        panelSlider.add(labelValore);

        menuFiltro.add(panelSlider);

        buttonFiltra.addActionListener(e -> {

            menuFiltro.show(buttonFiltra, 0, buttonFiltra.getHeight());
        });

        panelCerca.setLayout(new GridLayout(2, 1));

        panelCercaSup.add(textCerca);
        panelCercaSup.add(buttonFiltra);
        panelCercaSup.add(buttonCerca);
        panelCercaInf.add(buttonEntrate);
        panelCercaInf.add(buttonUscite);
        panelCercaInf.add(buttonReset);
        
        panelCerca.add(panelCercaSup);
        panelCerca.add(panelCercaInf);

        panelSuperiore = new JPanel();

        panelSuperiore.setLayout(new BorderLayout());

        panelSuperiore.add(panelCerca, BorderLayout.CENTER);
        panelSuperiore.add(buttonTema, BorderLayout.EAST);

        panelRisultati = new JPanel();

        panelRisultati.setLayout(new GridLayout(movimenti.movimentiList.size(), 1));
        for(int i=0;i<movimenti.movimentiList.size();i++){

            JPanel panelTmp = new JPanel();
            String costoString = String.valueOf(movimenti.movimentiList.get(i).getCosto());
            JLabel labelCostoTmp = new JLabel(costoString);
            JLabel labelTipoTmp = new JLabel(movimenti.movimentiList.get(i).getTipo());
            panelTmp.add(labelCostoTmp);
            panelTmp.add(labelTipoTmp);
            panelRisultati.add(panelTmp);
        }

        labelVuoto = new JLabel("Nessun movimento trovato");
        labelVuoto.setForeground(Color.decode("#1c2697"));
        labelVuoto.setFont(new Font("Arial", Font.BOLD, 25));

        buttonCerca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelRisultati.removeAll();
                
                String utenteFiltro = textCerca.getText().trim();
                int costoFiltro = sliderSoldi.getValue();
                boolean filtroUtente = !utenteFiltro.isEmpty();
                boolean filtroCosto = costoFiltro != costoMax;
                boolean filtroTipo = buttonEntrate.isSelected() || buttonUscite.isSelected();
        
                ArrayList<Movimento> tutti = new ArrayList<>();
                tutti.addAll(movimenti.movimentiList);
                ArrayList<Movimento> filtrati = new ArrayList<>();
        
                for (Movimento m : tutti) {
                    boolean valido = true;
        
                    if (filtroUtente && !m.getUtente().toLowerCase().contains(utenteFiltro.toLowerCase())) {
                        valido = false;
                    }
                    if (filtroCosto && m.getCosto() > costoFiltro) {
                        valido = false;
                    }
                    if (filtroTipo) {
                        if (buttonEntrate.isSelected() && !m.getTipo().equalsIgnoreCase("Entrata")) {
                            valido = false;
                        } else if (buttonUscite.isSelected() && !m.getTipo().equalsIgnoreCase("Uscita")) {
                            valido = false;
                        }
                    }
        
                    if (valido) {
                        filtrati.add(m);
                    }
                }
        
                if (filtrati.size() > 0) {
                    panelRisultati.setLayout(new GridLayout(filtrati.size(), 1));
                    for (Movimento m : filtrati) {
                        JPanel panelTmp = new JPanel();
                        panelTmp.add(new JLabel(String.valueOf(m.getCosto())));
                        panelTmp.add(new JLabel(m.getTipo()));
                        panelRisultati.add(panelTmp);
                    }
                } else {
                    labelVuoto.setHorizontalAlignment(JLabel.CENTER);
                    panelRisultati.setLayout(new BorderLayout());
                    panelRisultati.add(labelVuoto, BorderLayout.CENTER);
                }
        
                panelRisultati.revalidate();
                panelRisultati.repaint();
            }
        });

        buttonReset.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                textCerca.setForeground(Color.decode("#cbf4f4"));
                textCerca.setText(placeholder);

                textCerca.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if (textCerca.getText().equals(placeholder)) {
                            textCerca.setText("");
                            textCerca.setForeground(Color.decode("1c2697"));
                        }
                    }
                    @Override
                    public void focusLost(FocusEvent e) {
                        if (textCerca.getText().isEmpty()) {
                            textCerca.setForeground(Color.decode("#cbf4f4"));
                            textCerca.setText(placeholder);
                        }
                    }
                });
                panelRisultati.removeAll();
                panelRisultati.setLayout(new GridLayout(movimenti.movimentiList.size(), 1));
                for(int i=0;i<movimenti.movimentiList.size();i++){

                    JPanel panelTmp = new JPanel();
                    String costoString = String.valueOf(movimenti.movimentiList.get(i).getCosto());
                    JLabel labelCostoTmp = new JLabel(costoString);
                    JLabel labelTipoTmp = new JLabel(movimenti.movimentiList.get(i).getTipo());
                    panelTmp.add(labelCostoTmp);
                    panelTmp.add(labelTipoTmp);
                    panelRisultati.add(panelTmp);
                }
            }
        });

        panelRisultati.setBackground(Color.decode("#cbf4f4"));
        barRisultati = new JScrollPane(panelRisultati);

        imageMovimenti = new ImageIcon();
        imageRisparmi = new ImageIcon();
        imagePagamenti = new ImageIcon();
        imageBudget = new ImageIcon();
        imageCambioValuta = new ImageIcon();

        panelBar = new JPanel();
        panelBar.setLayout(new GridLayout(1, 6));
        panelBar.setBackground(Color.decode("#cbf4f4"));

        buttonHome = new JButton();
        buttonMovimenti = new JButton();
        buttonPagamenti = new JButton();
        buttonRisparmi = new JButton();
        buttonBudget = new JButton();
        buttonCambioValuta = new JButton();

        imageHome = new ImageIcon(getClass().getResource("/Immagini/IconaHomeScura.png"));
        buttonHome.setIcon(imageHome);
        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiScuraPiena.png"));
        buttonMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiScura.png"));
        buttonRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScura.png"));
        buttonPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScura.png"));
        buttonBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScura.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        buttonHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new HomeFrame(movimenti);
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FramePagamenti(movimenti);
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameRisparmi(movimenti);
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameCambioValuta(movimenti);
            }
        });

        buttonBudget.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new BudgetFrame(movimenti);
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

        add(panelSuperiore, BorderLayout.NORTH);
        add(barRisultati, BorderLayout.CENTER);
        add(panelBar, BorderLayout.SOUTH);

        setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        buttonTema.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                if(buttonTema.getIcon().equals(imageLuna)){

                    buttonTema.setIcon(imageSole);

                }else{

                    buttonTema.setIcon(imageLuna);
                }
            }
        });
    }
}