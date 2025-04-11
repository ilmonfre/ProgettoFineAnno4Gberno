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

public class FrameAccedi {
   public FrameAccedi() {
      // Crea il frame principale
      JFrame frameAccedi = new JFrame("Accedi");
      // Imposta il pannello principale
      JPanel panel = new JPanel();
      // Imposta il pannello per l'accesso
      JPanel panelAccedi = new JPanel();
      // Crea il label per il titolo
      JLabel labelAccedi = new JLabel("Accedi al tuo account");
      // Crea il pannello per l'email e la password
      JPanel panelRegistrati = new JPanel();
      // Crea i label per l'email
      JLabel labelEmail = new JLabel("E-mail");
      // Crea l'area di testo per l'email
      JTextArea textAreaEmail = new JTextArea();
      // Crea i label per la password
      JLabel labelPassword = new JLabel("Password");
      // Crea l'area di testo per la password
      JTextArea textAreaPassword = new JTextArea();
      // Crea il pannello per il pulsante di accesso
      JPanel panelButtonAccedi = new JPanel();
      // Crea il pulsante di accesso
      JButton buttonAccedi = new JButton("Accedi");
      // Crea il pannello per la registrazione se non si ha gia un account
      JPanel panelRegistratiNuovoAccount = new JPanel();
      // Crea il label per la registrazione
      JLabel labelRegistrati = new JLabel("Non hai ancora un account?");
      // Crea il pannello per il pulsante di registrazione
      JPanel panelButtonRegistrati = new JPanel();
      // Crea il pulsante di registrazione
      JButton buttonRegistrati = new JButton("Registrati");

      // Aggiungi il pannello principale al frame
      frameAccedi.add(panel);
      // Imposta il layout del pannello principale
      panel.setLayout(new GridLayout(4, 1));
      // Imposta i bordi del pannello principale
      panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

      // Aggiungui il pannello per l'accesso al pannello principale
      panel.add(panelAccedi);
      // Imposta il layout del pannello per l'accesso
      panelAccedi.setLayout(new GridLayout(1, 1));
      // Aggiungi il label per il titolo al pannello per l'accesso
      panelAccedi.add(labelAccedi);
      // Allinea il label al centro
      labelAccedi.setHorizontalAlignment(JLabel.CENTER);
      // Imposta il font del label
      labelAccedi.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));

      // Aggiungi il pannello per l'email e la password al pannello principale
      panel.add(panelRegistrati);
      // Imposta il layout del pannello per l'email e la password
      panelRegistrati.setLayout(new GridLayout(4, 1));
      // Aggiungi i label e le aree di testo per l'email e la password al pannello per l'email e la password
      panelRegistrati.add(labelEmail);
      panelRegistrati.add(textAreaEmail);
      panelRegistrati.add(labelPassword);
      panelRegistrati.add(textAreaPassword);

      // Aggiungi il pannello per il pulsante di accesso e registrazione al pannello principale
      panel.add(panelButtonAccedi);
      // Imposta il layout del pannello per il pulsante di accesso
      panelButtonAccedi.setLayout(new GridLayout(1, 1));
      // Aggiungi il pulsante di accesso al pannello per il pulsante di accesso
      panelButtonAccedi.add(buttonAccedi);
      // Allinea il pulsante al centro
      buttonAccedi.setHorizontalAlignment(JButton.CENTER);
      // Imposta il colore del pulsante
      buttonAccedi.setBackground(Color.decode("#5299D5"));
      // Imposta i bordi del pulsante
      panelButtonAccedi.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 140, 30, 140));

      // Aggiungi il pannello per la registrazione se non si ha gia un account al pannello principale
      panel.add(panelRegistratiNuovoAccount);
      // Imposta il layout del pannello per la registrazione se non si ha gia un account
      panelRegistratiNuovoAccount.setLayout(new GridLayout(1, 2));
      // Aggiungi il label per la registrazione e il pulsante di registrazione al pannello per la registrazione se non si ha gia un account
      panelRegistratiNuovoAccount.add(labelRegistrati);
      // Allinea il label a destra
      labelRegistrati.setHorizontalAlignment(JLabel.RIGHT);
      // Aggiungi il pannello per il pulsante di registrazione al pannello per la registrazione se non si ha gia un account
      panelRegistratiNuovoAccount.add(panelButtonRegistrati);
      // Imposta il layout del pannello per il pulsante di registrazione
      panelButtonRegistrati.setLayout(new GridLayout(1, 1));
      // Imposta i bordi del pannello per il pulsante di registrazione
      panelRegistratiNuovoAccount.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 0, 0));
      // Aggiungi il pulsante di registrazione al pannello per il pulsante di registrazione
      panelButtonRegistrati.add(buttonRegistrati);
      // Allinea il pulsante al centro
      buttonRegistrati.setHorizontalAlignment(JButton.CENTER);
      // Togli i bordi del pulsante
      buttonRegistrati.setBorderPainted(false);
      // Togli lo sfondo del pulsante
      buttonRegistrati.setContentAreaFilled(false);

      // Funzione del pulsante di accesso quando viene premuto
      buttonAccedi.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // Prendi l'email e la password inseriti
            String email = textAreaEmail.getText();
            String password = textAreaPassword.getText();
            // Qui puoi aggiungere il codice per verificare le credenziali dell'utente
         }
      });

      // Funzione del pulsante di registrazione quando viene premuto
      buttonRegistrati.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            // Chiudi il frame di accesso
            frameAccedi.dispose();
            // Apri il frame di registrazione
            new FrameRegistrazione();
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

      frameAccedi.setVisible(true);
      frameAccedi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}