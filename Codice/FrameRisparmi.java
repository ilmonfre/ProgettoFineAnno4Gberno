// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JPanel;
// import javax.swing.JTextArea;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.GridLayout;
// import java.awt.Toolkit;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;

// public class FrameRisparmi {
//    public FrameRisparmi() {
//       JFrame frameRisparmi = new JFrame("Risparmi");
//       JPanel panel = new JPanel();
//       JPanel panelRisparmi = new JPanel();
//       JLabel labelRisparmi = new JLabel("Risparmi"); 


//       // Imposta le dimensioni del frame
//       frameRisparmi.setSize(500, 550);

//       // Calcola le coordinate per centrare il frame
//       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//       int x = (screenSize.width - frameRisparmi.getWidth()) / 2;
//       int y = (screenSize.height - frameRisparmi.getHeight()) / 2;
//       // Imposta la posizione centrata
//       frameRisparmi.setLocation(x, y);

//       frameRisparmi.setVisible(true);
//       frameRisparmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
// }

import javax.swing.*;
import java.awt.*;

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
      ImageIcon imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));

      // Creazione del pannello superiore (barra)
      JPanel barraSuperiore = new JPanel();
      barraSuperiore.setLayout(new BorderLayout());
      barraSuperiore.setPreferredSize(new Dimension(500, 50));

      // Pulsante "+" a sinistra
      JButton btnPlus = new JButton(new ImageIcon("C:\\Users\\mp7sc\\Desktop\\Linguaggi Programmazione\\Progetto banca\\ProgettoFineAnno4Gberno\\Codice\\Immagini\\Icona+Nera.png")); // Sostituisci con il percorso corretto dell'immagine
      btnPlus.setBorderPainted(false);
      btnPlus.setContentAreaFilled(false);
      
      // Pulsante immagine a destra
      JButton btnImage = new JButton(new ImageIcon("C:\\Users\\mp7sc\\Desktop\\Linguaggi Programmazione\\Progetto banca\\ProgettoFineAnno4Gberno\\Codice\\Immagini\\IconaLuna.png")); // Sostituisci con il percorso corretto dell'immagine
      btnImage.setBorderPainted(false);
      btnImage.setContentAreaFilled(false);

      // Aggiunta dei componenti alla barra
      barraSuperiore.add(btnPlus, BorderLayout.WEST);
      barraSuperiore.add(btnImage, BorderLayout.EAST);

      // Creazione del pannello principale
      JPanel panelRisparmi = new JPanel();
      JLabel labelRisparmi = new JLabel("Risparmi");

      panelRisparmi.add(labelRisparmi);

      // Aggiunta dei pannelli al frame
      frameRisparmi.setLayout(new BorderLayout());
      frameRisparmi.add(barraSuperiore, BorderLayout.NORTH);
      frameRisparmi.add(panelRisparmi, BorderLayout.CENTER);

      frameRisparmi.setVisible(true);
      frameRisparmi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) {
      new FrameRisparmi();
   }
}

