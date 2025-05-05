import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameRisparmi {
   public FrameRisparmi() {
      // Creazione del frame
      JFrame frameRisparmi = new JFrame("Risparmi");
      frameRisparmi.setSize(500, 550);

      // Calcolo della posizione centrata
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width - frameRisparmi.getWidth()) / 2;
      int y = (screenSize.height - frameRisparmi.getHeight()) / 2;
      frameRisparmi.setLocation(x, y);

      ImageIcon imagePiu = new ImageIcon(getClass().getResource("/Immagini/Icona+Nera.png"));
      ImageIcon imagePiuBianca = new ImageIcon(getClass().getResource("/Immagini/Icona+Bianca.png"));
      ImageIcon imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));
      ImageIcon imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));

      // Creazione del pannello superiore (barra)
      JPanel barraSuperiore = new JPanel();
      barraSuperiore.setLayout(new BorderLayout());
      barraSuperiore.setPreferredSize(new Dimension(500, 50));

      // Pulsante "+" a sinistra
      JButton btnPlus = new JButton(imagePiu);
      btnPlus.setBorderPainted(false);
      btnPlus.setContentAreaFilled(false);
      
      // Pulsante immagine a destra
      JButton btnImage = new JButton(imageLuna);
      btnImage.setBorderPainted(false);
      btnImage.setContentAreaFilled(false);

      JLabel labelRisparmii = new JLabel("Risparmi");

      JTextField textFieldRisparmi = new JTextField("0 €");
      JTextField textFieldConto = new JTextField("1000 €"); // Valore iniziale del conto

      barraSuperiore.add(btnPlus, BorderLayout.WEST);
      barraSuperiore.add(btnImage, BorderLayout.EAST);
      labelRisparmii.setHorizontalAlignment(SwingConstants.CENTER);
      labelRisparmii.setFont(new Font("Arial", Font.BOLD, 18));
      barraSuperiore.add(labelRisparmii, BorderLayout.CENTER);

      // Creazione del pannello principale
      JPanel panelRisparmi = new JPanel();
      panelRisparmi.setLayout(new GridLayout(2, 2, 10, 10));
      panelRisparmi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      textFieldConto.setEditable(false);
      textFieldRisparmi.setEditable(false);
      textFieldConto.setHorizontalAlignment(SwingConstants.CENTER);
      textFieldRisparmi.setHorizontalAlignment(SwingConstants.CENTER);
      textFieldRisparmi.setFont(new Font("Arial", Font.BOLD, 16));
      textFieldConto.setFont(new Font("Arial", Font.BOLD, 16));

      // Creazione delle etichette
      JLabel labelConto = new JLabel("Conto:");
      JLabel labelRisparmio = new JLabel("Cassa di Risparmio:");
      labelConto.setHorizontalAlignment(SwingConstants.CENTER);
      labelRisparmio.setHorizontalAlignment(SwingConstants.CENTER);

      // Aggiunta delle etichette e dei campi di testo al pannello
      panelRisparmi.add(labelConto);
      panelRisparmi.add(textFieldConto);
      panelRisparmi.add(labelRisparmio);
      panelRisparmi.add(textFieldRisparmi);

      // Aggiunta dei pannelli al frame
      frameRisparmi.setLayout(new BorderLayout());
      frameRisparmi.add(barraSuperiore, BorderLayout.NORTH);
      frameRisparmi.add(panelRisparmi, BorderLayout.CENTER);

      frameRisparmi.setVisible(true);
      frameRisparmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      btnImage.addActionListener(e -> {
         // Cambia l'icona del pulsante
         if (btnImage.getIcon().equals(imageLuna)) {
         btnImage.setIcon(imageSole);
         btnPlus.setIcon(imagePiuBianca);

         // Cambia lo sfondo e il colore del testo
         barraSuperiore.setBackground(Color.BLACK);
         labelRisparmio.setForeground(Color.WHITE);
         labelConto.setForeground(Color.WHITE);
         labelRisparmio.setForeground(Color.WHITE);
         textFieldRisparmi.setBackground(Color.BLACK);
         textFieldRisparmi.setForeground(Color.WHITE);
         textFieldConto.setBackground(Color.BLACK);
         textFieldConto.setForeground(Color.WHITE);
         panelRisparmi.setBackground(Color.BLACK);
         } else {
         btnImage.setIcon(imageLuna);
         btnPlus.setIcon(imagePiu);

         // Ripristina lo sfondo e il colore del testo
         barraSuperiore.setBackground(Color.WHITE);
         labelRisparmio.setForeground(Color.BLACK);
         labelConto.setForeground(Color.BLACK);
         labelRisparmio.setForeground(Color.BLACK);
         textFieldRisparmi.setBackground(Color.WHITE);
         textFieldRisparmi.setForeground(Color.BLACK);
         textFieldConto.setBackground(Color.WHITE);
         textFieldConto.setForeground(Color.BLACK);
         panelRisparmi.setBackground(Color.WHITE);
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
   }

   public static void main(String[] args) {
      new FrameRisparmi();
   }
}

