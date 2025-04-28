/*Manuel Pedretti */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FrameAccedi {
   public FrameAccedi() {
      JFrame frameAccedi = new JFrame("Accedi");
      JPanel panel = new JPanel();
      JPanel panelAccedi = new JPanel();
      JLabel labelAccedi = new JLabel("Accedi al tuo account");
      JPanel panelRegistrati = new JPanel();
      JLabel labelEmail = new JLabel("E-mail");
      JTextArea textAreaEmail = new JTextArea(1, 20);
      JLabel labelPassword = new JLabel("Password");
      JTextArea textAreaPassword = new JTextArea(1, 20);
      JPanel panelButtonAccedi = new JPanel();
      JButton buttonAccedi = new JButton("Accedi");
      JPanel panelRegistratiNuovoAccount = new JPanel();
      JLabel labelRegistrati = new JLabel("Non hai ancora un account?");
      JPanel panelButtonRegistrati = new JPanel();
      JButton buttonRegistrati = new JButton("Registrati");

      frameAccedi.add(panel);
      panel.setLayout(new GridLayout(4, 1));
      // Imposta i bordi del pannello principale
      panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

      panel.add(panelAccedi);
      panelAccedi.setLayout(new GridLayout(1, 1));
      panelAccedi.add(labelAccedi);
      labelAccedi.setHorizontalAlignment(JLabel.CENTER);
      labelAccedi.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));

      panel.add(panelRegistrati);
      panelRegistrati.setLayout(new GridLayout(4, 1));
      panelRegistrati.add(labelEmail);
      panelRegistrati.add(textAreaEmail);
      panelRegistrati.add(labelPassword);
      panelRegistrati.add(textAreaPassword);

      panel.add(panelButtonAccedi);
      panelButtonAccedi.setLayout(new GridLayout(1, 1));
      panelButtonAccedi.add(buttonAccedi);
      // Allinea il pulsante al centro
      buttonAccedi.setHorizontalAlignment(JButton.CENTER);
      // Imposta il colore del pulsante
      buttonAccedi.setBackground(Color.decode("#5299D5"));
      // Imposta i bordi del pulsante
      panelButtonAccedi.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 140, 30, 140));

      panel.add(panelRegistratiNuovoAccount);
      panelRegistratiNuovoAccount.setLayout(new GridLayout(1, 2));
      panelRegistratiNuovoAccount.add(labelRegistrati);
      // Allinea il label a destra
      labelRegistrati.setHorizontalAlignment(JLabel.RIGHT);
      panelRegistratiNuovoAccount.add(panelButtonRegistrati);
      panelButtonRegistrati.setLayout(new GridLayout(1, 1));
      panelRegistratiNuovoAccount.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 100, 0, 0));
      panelButtonRegistrati.add(buttonRegistrati);
      buttonRegistrati.setHorizontalAlignment(JButton.CENTER);
      // Togli i bordi del pulsante
      buttonRegistrati.setBorderPainted(false);
      // Togli lo sfondo del pulsante
      buttonRegistrati.setContentAreaFilled(false);

      // Funzione del pulsante di accesso quando viene premuto
      buttonAccedi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String email = textAreaEmail.getText();
            String password = textAreaPassword.getText();
            String csv = "save.csv";
            try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
               String line;

               while ((line = reader.readLine()) != null) {
                  String[] fields = line.split(";");
                  boolean found = false;

                  if (fields.length > 1 && fields[3].equals(email) && fields[5].equals(password)) {
                     found = true;
                     break;
                  }
                  if (found) {
                     // Chiudi il frame di accesso
                     frameAccedi.dispose();
                     // Apri il frame principale
                     new HomeFrame();
                  } else {
                     // Mostra un messaggio di errore se le credenziali non sono corrette
                  }
               }
            } catch (IOException e2) {
               e2.printStackTrace();
            }
         }
      });

      // Funzione del pulsante di registrazione quando viene premuto
      buttonRegistrati.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // Chiudi il frame di accesso
            frameAccedi.dispose();
            // Apri il frame di registrazione
            try {
               new FrameRegistrazione();
            } catch (IOException e1) {
               e1.printStackTrace();
            }
         }
      });

      // Imposta le dimensioni del frame
      frameAccedi.setSize(500, 550);

      // Calcola le coordinate per centrare il frame
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width - frameAccedi.getWidth()) / 2;
      int y = (screenSize.height - frameAccedi.getHeight()) / 2;
      // Imposta la posizione centrata
      frameAccedi.setLocation(x, y);

      panel.setBackground(Color.decode("#f0ffff"));
      panelAccedi.setBackground(Color.decode("#f0ffff"));
      panelButtonAccedi.setBackground(Color.decode("#f0ffff"));
      panelButtonRegistrati.setBackground(Color.decode("#f0ffff"));
      panelRegistrati.setBackground(Color.decode("#f0ffff"));
      panelRegistratiNuovoAccount.setBackground(Color.decode("#f0ffff"));

      frameAccedi.setVisible(true);
      frameAccedi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}