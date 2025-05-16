import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameRisparmi {
   public FrameRisparmi() {
      // Creazione del frame
      JFrame frameRisparmi = new JFrame("Zaphyra Bank - Risparmi");
      frameRisparmi.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frameRisparmi.setFocusable(true);
      frameRisparmi.requestFocusInWindow();

      

      ImageIcon imagePiu = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
      ImageIcon imagePiuBianca = new ImageIcon(getClass().getResource("/Immagini/Icona+Chiara.png"));
      ImageIcon imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));
      ImageIcon imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));

      // Creazione del pannello superiore (barra)
      JPanel barraSuperiore = new JPanel();
      barraSuperiore.setLayout(new BorderLayout());
      barraSuperiore.setPreferredSize(new Dimension(500, 50));
      barraSuperiore.setBackground(Color.decode("#cbf4f4"));

      // Pulsante "+" a sinistra
      JButton btnPlus = new JButton(imagePiu);
      btnPlus.setBorderPainted(false);
      btnPlus.setContentAreaFilled(false);
      
      // Pulsante immagine a destra
      JButton btnImage = new JButton(imageLuna);
      btnImage.setBorderPainted(false);
      btnImage.setContentAreaFilled(false);

      JLabel labelRisparmii = new JLabel("Risparmi");

      RoundedTextField textFieldRisparmi = new RoundedTextField(20, 30);
      RoundedTextField textFieldConto = new RoundedTextField(20, 30); // Valore iniziale del conto

      barraSuperiore.add(btnPlus, BorderLayout.WEST);
      barraSuperiore.add(btnImage, BorderLayout.EAST);
      labelRisparmii.setHorizontalAlignment(SwingConstants.CENTER);
      labelRisparmii.setFont(new Font("Arial", Font.BOLD, 30));
      labelRisparmii.setForeground(Color.decode("#1c2697"));
      barraSuperiore.add(labelRisparmii, BorderLayout.CENTER);

      // Creazione del pannello principale
      JPanel panelRisparmi = new JPanel();
      panelRisparmi.setLayout(new GridLayout(2, 2, 10, 10));
      panelRisparmi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      textFieldConto.setEditable(false);
      textFieldRisparmi.setEditable(false);
      textFieldConto.setHorizontalAlignment(SwingConstants.CENTER);
      textFieldConto.setBackground(Color.WHITE);
      textFieldRisparmi.setHorizontalAlignment(SwingConstants.CENTER);
      textFieldRisparmi.setBackground(Color.WHITE);
      textFieldRisparmi.setForeground(Color.decode("#1c2697"));
      textFieldRisparmi.setFont(new Font("Arial", Font.BOLD, 25));
      textFieldConto.setForeground(Color.decode("#1c2697"));
      textFieldConto.setFont(new Font("Arial", Font.BOLD, 25));

      // Creazione delle etichette
      JLabel labelConto = new JLabel("Conto:");
      labelConto.setFont(new Font("Arial", Font.BOLD, 25));
      JLabel labelRisparmio = new JLabel("Cassa di Risparmio:");
      labelRisparmio.setFont(new Font("Arial", Font.BOLD, 25));
      labelConto.setHorizontalAlignment(SwingConstants.CENTER);
      labelConto.setForeground(Color.decode("#1c2697"));
      labelRisparmio.setHorizontalAlignment(SwingConstants.CENTER);
      labelRisparmio.setForeground(Color.decode("#1c2697"));

      // Aggiunta delle etichette e dei campi di testo al pannello
      panelRisparmi.add(labelConto);
      panelRisparmi.add(textFieldConto);
      panelRisparmi.add(labelRisparmio);
      panelRisparmi.add(textFieldRisparmi);
      panelRisparmi.setBackground(Color.decode("#cbf4f4"));

      
















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
      imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiScuraPiena.png"));
      buttonRisparmi.setIcon(imageRisparmi);
      imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScura.png"));
      buttonPagamenti.setIcon(imagePagamenti);
      imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScura.png"));
      buttonBudget.setIcon(imageBudget);
      imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScura.png"));
      buttonCambioValuta.setIcon(imageCambioValuta);

      imageHomeChiara = new ImageIcon(getClass().getResource("/Immagini/IconaHomeChiara.png"));
      imageMovimentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiChiara.png"));
      imageRisparmiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiChiaraPiena.png"));
      imagePagamentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiChiara.png"));
      imageBudgetChiara = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetChiara.png"));
      imageCambioValutaChiara = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaChiara.png"));

      buttonMovimenti.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e){

            frameRisparmi.dispose();
            new FrameMovimenti();
         }
      });

      buttonPagamenti.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e){

            frameRisparmi.dispose();
            //new PagamentiFrame();
         }
      });

      buttonHome.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e){

            frameRisparmi.dispose();
            new HomeFrame();
         }
      });

      buttonCambioValuta.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e){

            frameRisparmi.dispose();
            //new CambioValutaFrame();
         }
      });

      buttonBudget.addActionListener(new ActionListener(){

         @Override
         public void actionPerformed(ActionEvent e){

            frameRisparmi.dispose();
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
         btnPlus.setIcon(imagePiuBianca);
         barraSuperiore.setBackground(Color.decode("#1c2697"));
         labelRisparmii.setForeground(Color.decode("#cbf4f4"));
         labelRisparmio.setForeground(Color.decode("#cbf4f4"));
         labelConto.setForeground(Color.decode("#cbf4f4"));
         labelRisparmio.setForeground(Color.decode("#cbf4f4"));
         textFieldRisparmi.setBackground(Color.decode("#2f48d0"));
         textFieldRisparmi.setForeground(Color.decode("#cbf4f4"));
         textFieldConto.setBackground(Color.decode("#2f48d0"));
         textFieldConto.setForeground(Color.decode("#cbf4f4"));
         panelRisparmi.setBackground(Color.decode("#1c2697"));
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
         btnPlus.setIcon(imagePiu);
         barraSuperiore.setBackground(Color.decode("#cbf4f4"));
         labelRisparmii.setForeground(Color.decode("#1c2697"));
         labelRisparmio.setForeground(Color.decode("#1c2697"));
         labelConto.setForeground(Color.decode("#1c2697"));
         labelRisparmio.setForeground(Color.decode("#1c2697"));
         textFieldRisparmi.setBackground(Color.WHITE);
         textFieldRisparmi.setForeground(Color.decode("#1c2697"));
         textFieldConto.setBackground(Color.WHITE);
         textFieldConto.setForeground(Color.decode("#1c2697"));
         panelRisparmi.setBackground(Color.decode("#cbf4f4"));
         panelBar.setBackground(Color.WHITE);
         buttonHome.setIcon(imageHome);
         buttonMovimenti.setIcon(imageMovimenti);
         buttonRisparmi.setIcon(imageRisparmi);
         buttonPagamenti.setIcon(imagePagamenti);
         buttonBudget.setIcon(imageBudget);
         buttonCambioValuta.setIcon(imageCambioValuta);
         }
      });

      btnPlus.addActionListener(e -> {
         // Creazione del nuovo frame per l'importo
         JFrame frameImporto = new JFrame("Aggiungi Importo");
         frameImporto.setSize(300, 200);

         // Calcolo della posizione centrata
         Dimension screenSizeImporto = Toolkit.getDefaultToolkit().getScreenSize();
         int xImporto = (screenSizeImporto.width - frameImporto.getWidth()) / 2;
         int yImporto = (screenSizeImporto.height - frameImporto.getHeight()) / 2;
         frameImporto.setLocation(xImporto, yImporto);

         // Creazione del pannello e dei componenti
         JPanel panelImporto = new JPanel();
         panelImporto.setLayout(new GridLayout(3, 1, 10, 10));
         panelImporto.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
         JLabel label = new JLabel("Inserisci l'importo:");
         label.setHorizontalAlignment(SwingConstants.CENTER);
         label.setFont(new Font("Arial", Font.BOLD, 16));
         JTextField textField = new JTextField();
         JButton btnConferma = new JButton("Conferma");

         // Aggiunta dei componenti al pannello
         panelImporto.add(label);
         panelImporto.add(textField);
         panelImporto.add(btnConferma);

         // Aggiunta del pannello al frame
         frameImporto.add(panelImporto);
         frameImporto.setVisible(true);

         // Azione per il pulsante "Conferma"
         btnConferma.addActionListener(ev -> {
         String importo = textField.getText().trim();

         // Controllo se il campo è vuoto
         if (importo.isEmpty()) {
         JFrame frameErrore = new JFrame("Errore");
         JOptionPane.showMessageDialog(frameErrore, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
         return;
         }
      
         // Controllo se l'importo è numerico
         try {
         double valoreCorrente = Double.parseDouble(textFieldRisparmi.getText().replace(" €", ""));
         double valoreAggiunto = Double.parseDouble(importo);
         double valoreConto = Double.parseDouble(textFieldConto.getText().replace(" €", ""));

         // Controllo se il conto è sufficiente
         if (valoreAggiunto > valoreConto) {
            JFrame frameErrore = new JFrame("Errore");
            JOptionPane.showMessageDialog(frameErrore, "Fondi insufficienti nel conto!", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
         }

         double nuovoValoreRisparmi = valoreCorrente + valoreAggiunto;
         double nuovoValoreConto = valoreConto - valoreAggiunto;

         textFieldRisparmi.setText(nuovoValoreRisparmi + " €");
         textFieldConto.setText(nuovoValoreConto + " €");
         JOptionPane.showMessageDialog(frameImporto, "Importo aggiunto: " + importo + " €");
         frameImporto.dispose(); // Chiude il frame dopo la conferma
         } catch (NumberFormatException ex) {
         JFrame frameErrore = new JFrame("Errore");
         JOptionPane.showMessageDialog(frameErrore, "L'importo deve essere un valore numerico!", "Errore", JOptionPane.ERROR_MESSAGE);
         }
         });
      });
      // Aggiunta dei pannelli al frame
      frameRisparmi.setLayout(new BorderLayout());
      frameRisparmi.add(barraSuperiore, BorderLayout.NORTH);
      frameRisparmi.add(panelRisparmi, BorderLayout.CENTER);
      frameRisparmi.add(panelBar, BorderLayout.SOUTH);

      frameRisparmi.setVisible(true);
      frameRisparmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      new FrameRisparmi();
   }
}

