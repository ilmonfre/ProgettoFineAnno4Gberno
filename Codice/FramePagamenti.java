import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FramePagamenti {

    JFrame frame;
    RoundedBorderButton btnBonifico, btnScambioDenaro; 


    FramePagamenti(){
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
        barraSuperiore.add(lblPagamenti, BorderLayout.CENTER);

        frame.add(barraSuperiore, BorderLayout.NORTH);

        // pannello centrale
        JPanel panelCentrale = new JPanel();
        panelCentrale.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2,2, 10, 10));

        Color colorButton = Color.decode("#1c2697");
        Color colorHover = Color.decode("#cbf4f4");

        JLabel lblBonifico = new JLabel("Bonifico: ");
        lblBonifico.setFont(new Font("Arial", Font.BOLD, 25));
        lblBonifico.setHorizontalAlignment(SwingConstants.CENTER);
        lblBonifico.setForeground(Color.decode("#1c2697"));
        btnBonifico = new RoundedBorderButton("Bonifico", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        btnBonifico.setForeground(Color.decode("#cbf4f4"));

        JLabel lblScambioDenaro = new JLabel("Scambio Denaro: ");
        lblScambioDenaro.setFont(new Font("Arial", Font.BOLD, 25));
        lblScambioDenaro.setHorizontalAlignment(SwingConstants.CENTER);
        lblScambioDenaro.setForeground(Color.decode("#1c2697"));
        btnScambioDenaro = new RoundedBorderButton("Scambio Denaro", colorButton, colorButton, Color.white, colorHover, colorHover, Color.white ,2, 20, 20);
        btnScambioDenaro.setForeground(Color.decode("#cbf4f4"));

        panel.add(lblBonifico, BorderLayout.CENTER);
        panel.add(btnBonifico, BorderLayout.CENTER);
        panel.add(lblScambioDenaro, BorderLayout.CENTER);
        panel.add(btnScambioDenaro, BorderLayout.CENTER);

        panelCentrale.add(panel);

        frame.add(panelCentrale);


        // pannello inferiore
        JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
        JPanel panelBar;
        JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
        ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageHome;
        ImageIcon imageAccountChiara, imageMovimentiChiara, imageRisparmiChiara, imagePagamentiChiara, imageBudgetChiara, imageCambioValutaChiara, imageHomeChiara;

    
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
                new FrameMovimenti();
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FrameRisparmi();
            }
        });

        buttonHome.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new HomeFrame();
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FramePagamenti();
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new FrameCambioValuta();
            }
        });

        buttonBudget.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frame.dispose();
                new BudgetFrame();
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
            // Chiaro
            if (btnImage.getIcon().equals(imageLuna)) {
                btnImage.setIcon(imageSole);
                barraSuperiore.setBackground(Color.decode("#1c2697"));

                lblPagamenti.setForeground(Color.decode("#cbf4f4"));

                btnScambioDenaro.setForeground(Color.decode("#cbf4f4"));
                btnBonifico.setForeground(Color.decode("#cbf4f4"));
                btnScambioDenaro.setForeground(Color.decode("#cbf4f4"));

                panelCentrale.setBackground(Color.decode("#1c2697"));
                panelBar.setBackground(Color.decode("#2f48d0"));
                buttonHome.setIcon(imageHomeChiara);
                buttonMovimenti.setIcon(imageMovimentiChiara);
                buttonRisparmi.setIcon(imageRisparmiChiara);
                buttonPagamenti.setIcon(imagePagamentiChiara);
                buttonBudget.setIcon(imageBudgetChiara);
                buttonCambioValuta.setIcon(imageCambioValutaChiara);
            //Scuro
            } else {
                btnImage.setIcon(imageLuna);
                barraSuperiore.setBackground(Color.decode("#cbf4f4"));

                lblPagamenti.setForeground(Color.decode("#1c2697"));
                btnScambioDenaro.setForeground(Color.decode("#1c2697"));
                btnBonifico.setForeground(Color.decode("#1c2697"));
                btnScambioDenaro.setForeground(Color.decode("#1c2697"));

                textFieldRisparmi.setBackground(Color.WHITE);
                textFieldRisparmi.setForeground(Color.decode("#1c2697"));
                textFieldConto.setBackground(Color.WHITE);
                textFieldConto.setForeground(Color.decode("#1c2697"));
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
                new FrameScambioDenaro();
            }
        });

        panelCentrale.setBackground(Color.decode("#cbf4f4"));


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




