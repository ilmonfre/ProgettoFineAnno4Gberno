import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FramePagamenti {

    JFrame frame;
    RoundedBorderButton btnBonifico, btnScambioDenaro, btnRicarica;


    Budget budget;
    Movimenti movimenti;
    FramePagamenti(Movimenti movimenti){
        this.movimenti = movimenti;
        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Pagamenti");

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        ImageIcon imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));
        ImageIcon imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));

        // Creazione del pannello superiore (barra)
        JPanel barraSuperiore = new JPanel();
        barraSuperiore.setLayout(new BorderLayout());
        barraSuperiore.setPreferredSize(new Dimension(500, 50));
        barraSuperiore.setBackground(Color.decode("#cbf4f4"));

        // Pulsante immagine a destra
        JButton btnImage = new JButton(imageLuna);
        btnImage.setBorderPainted(false);
        btnImage.setContentAreaFilled(false);

        JLabel lblPagamenti = new JLabel("Pagamenti");

        RoundedTextField textFieldRisparmi = new RoundedTextField(20, 30);
        RoundedTextField textFieldConto = new RoundedTextField(20, 30);
        
        barraSuperiore.add(btnImage, BorderLayout.EAST);
        lblPagamenti.setHorizontalAlignment(SwingConstants.CENTER);
        lblPagamenti.setFont(new Font("Arial", Font.BOLD, 30));
        lblPagamenti.setForeground(Color.decode("#1c2697"));
        lblPagamenti.setBackground(Color.decode("#cbf4f4"));
        barraSuperiore.add(lblPagamenti, BorderLayout.CENTER);

        frame.add(barraSuperiore, BorderLayout.NORTH);

        // pannello centrale
        JPanel panelCentrale = new JPanel();
        panelCentrale.setLayout(new BorderLayout());
        panelCentrale.setBackground(Color.decode("#cbf4f4"));

        JPanel panel = new JPanel(new GridLayout(3,2, 10, 10));

        Color colorButton = Color.decode("#1c2697");
        Color colorScritta = Color.decode("#cbf4f4");
        Color color3 = Color.decode("#2f48d0");

        JLabel lblBonifico = new JLabel("Bonifico: ");
        lblBonifico.setFont(new Font("Arial", Font.BOLD, 25));
        lblBonifico.setHorizontalAlignment(SwingConstants.CENTER);
        lblBonifico.setForeground(Color.decode("#1c2697"));
        btnBonifico = new RoundedBorderButton("Bonifico", colorButton, Color.white, colorButton, color3, color3, colorScritta ,2, 20, 20);
        btnBonifico.setForeground(Color.decode("#cbf4f4"));

        JLabel lblScambioDenaro = new JLabel("Scambio Denaro: ");
        lblScambioDenaro.setFont(new Font("Arial", Font.BOLD, 25));
        lblScambioDenaro.setHorizontalAlignment(SwingConstants.CENTER);
        lblScambioDenaro.setForeground(Color.decode("#1c2697"));
        btnScambioDenaro = new RoundedBorderButton("Scambio Denaro", colorButton, Color.white, colorButton, color3, color3, colorScritta ,2, 20, 20);
        btnScambioDenaro.setForeground(Color.decode("#cbf4f4"));

        JLabel lblRicarica = new JLabel("Ricarica conto: ");
        lblRicarica.setFont(new Font("Arial", Font.BOLD, 25));
        lblRicarica.setHorizontalAlignment(SwingConstants.CENTER);
        lblRicarica.setForeground(Color.decode("#1c2697"));
        btnRicarica = new RoundedBorderButton("Ricarica", colorButton, Color.white, colorButton, color3, color3, colorScritta ,2, 20, 20);
        btnRicarica.setForeground(Color.decode("#cbf4f4"));

        panel.add(lblBonifico, BorderLayout.CENTER);
        panel.add(btnBonifico, BorderLayout.CENTER);
        panel.add(lblScambioDenaro, BorderLayout.CENTER);
        panel.add(btnScambioDenaro, BorderLayout.CENTER);
        panel.add(lblRicarica, BorderLayout.CENTER);
        panel.add(btnRicarica, BorderLayout.CENTER);
        panel.setBackground(Color.decode("#cbf4f4"));

        panelCentrale.add(panel);

        frame.add(panelCentrale);
        frame.setBackground(Color.decode("#cbf4f4"));


        // pannello inferiore
        JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
        JPanel panelBar;
        JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
        ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageHome;
        ImageIcon imageAccountChiara, imageMovimentiChiara, imageRisparmiChiara, imagePagamentiChiara, imageBudgetChiara, imageCambioValutaChiara, imageHomeChiara;

    
        panelBar = new JPanel();
        panelBar.setLayout(new GridLayout(1, 6));

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

        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScuraPiena.png"));
        buttonPagamenti.setIcon(imagePagamenti);

        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScura.png"));
        buttonBudget.setIcon(imageBudget);

        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScura.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        imageHomeChiara = new ImageIcon(getClass().getResource("/Immagini/IconaHomeChiara.png"));
        imageMovimentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiChiara.png"));
        imageRisparmiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiChiara.png"));
        imagePagamentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiChiaraPiena.png"));
        imageBudgetChiara = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetChiara.png"));
        imageCambioValutaChiara = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaChiara.png"));

        buttonMovimenti.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FrameMovimenti(movimenti);
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FrameRisparmi(movimenti);
            }
        });

        buttonHome.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new HomeFrame(movimenti);
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FramePagamenti(movimenti);
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FrameCambioValuta(movimenti);
            }
        });

        buttonBudget.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
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
        panelBar.setBackground(Color.WHITE);

        btnImage.addActionListener(e -> {
            // chiaro
            if (btnImage.getIcon().equals(imageLuna)) {
                btnImage.setIcon(imageSole);
                barraSuperiore.setBackground(Color.decode("#1c2697"));
                lblPagamenti.setForeground(Color.decode("#cbf4f4"));
                lblBonifico.setForeground(Color.decode("#cbf4f4"));
                lblScambioDenaro.setForeground(Color.decode("#cbf4f4"));
                lblRicarica.setForeground(Color.decode("#cbf4f4"));
                panel.setBackground(Color.decode("#1c2697"));
                frame.setBackground(Color.decode("#1c2697"));
                // btnScambioDenaro.setForeground(Color.decode("#cbf4f4"));
                // btnScambioDenaro.setBackground(Color.decode("#2f48d0"));
                // btnRicarica.setForeground(Color.decode("#cbf4f4"));
                // btnRicarica.setBackground(Color.decode("#2f48d0"));
                // btnBonifico.setForeground(Color.decode("#cbf4f4"));
                // btnBonifico.setBackground(Color.decode("#2f48d0"));
                panelCentrale.setBackground(Color.decode("#1c2697"));
                panelBar.setBackground(Color.decode("#2f48d0"));
                buttonHome.setIcon(imageHomeChiara);
                buttonMovimenti.setIcon(imageMovimentiChiara);
                buttonRisparmi.setIcon(imageRisparmiChiara);
                buttonPagamenti.setIcon(imagePagamentiChiara);
                buttonBudget.setIcon(imageBudgetChiara);
                buttonCambioValuta.setIcon(imageCambioValutaChiara);
            // scuro
            } else {
                btnImage.setIcon(imageLuna);
                barraSuperiore.setBackground(Color.decode("#cbf4f4"));
                lblPagamenti.setForeground(Color.decode("#1c2697"));
                lblBonifico.setForeground(Color.decode("#1c2697"));
                lblScambioDenaro.setForeground(Color.decode("#1c2697"));
                lblRicarica.setForeground(Color.decode("#1c2697"));
                panel.setBackground(Color.decode("#cbf4f4"));
                frame.setBackground(Color.decode("#cbf4f4"));
                // btnScambioDenaro.setForeground(Color.decode("#1c2697"));
                // btnScambioDenaro.setBackground(Color.WHITE);
                // btnRicarica.setForeground(Color.decode("#1c2697"));
                // btnRicarica.setBackground(Color.WHITE);
                // btnBonifico.setForeground(Color.decode("#1c2697"));
                // btnBonifico.setBackground(Color.WHITE);
                panelCentrale.setBackground(Color.decode("#cbf4f4"));
                panelBar.setBackground(Color.WHITE);
                buttonHome.setIcon(imageHome);
                buttonMovimenti.setIcon(imageMovimenti);
                buttonRisparmi.setIcon(imageRisparmi);
                buttonPagamenti.setIcon(imagePagamenti);
                buttonBudget.setIcon(imageBudget);
                buttonCambioValuta.setIcon(imageCambioValuta);
            }
        });


        // pagamenti
        
        btnBonifico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameBonifico();
            }
        });

        btnScambioDenaro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameScambioDenaro(movimenti);
            }
        });

        btnRicarica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameRicaricaConto(movimenti);
            }
        });


        // Aggiunta dei pannelli al frame
        frame.setLayout(new BorderLayout());
        frame.add(barraSuperiore, BorderLayout.NORTH);
        frame.add(panelCentrale, BorderLayout.CENTER);
        frame.add(panelBar, BorderLayout.SOUTH);

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}




