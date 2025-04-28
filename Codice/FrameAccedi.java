/*Manuel Pedretti */
import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FrameAccedi {

   Font fontIniziale, fontMid, fontBtn;
   

   public FrameAccedi() {

      JFrame frameAccedi = new JFrame("Accedi");
      frameAccedi.setTitle("Zaphyra Bank - Log in");

      JPanel panel = new JPanel(new BorderLayout());
      JPanel topPanel, midPanel, bottomPanel;

      // topPanel
      topPanel = new JPanel();
      JLabel topLabel = new JLabel("Accedi al tuo account!");
      fontIniziale = new Font("Serif", Font.BOLD, 28);
      topLabel.setFont(fontIniziale);
      topPanel.add(topLabel);
      topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      frameAccedi.add(topPanel, BorderLayout.NORTH);


      // midPanel
      midPanel = new JPanel();
      JPanel panel1;
      JLabel lblEmail, lblPass, lblPass2;
      JTextField txtEmail;
      JButton btnPass;
      JPasswordField pass;

      fontMid = new Font("Segoe UI", Font.PLAIN, 14);
      midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));
      panel1 = new JPanel(new GridLayout(3,1,10 ,20));
      lblEmail = new JLabel("Email: ");
      lblEmail.setFont(fontMid);
      txtEmail = new JTextField(20);
      txtEmail.setHorizontalAlignment((int) SwingConstants.CENTER);
      
      lblPass = new JLabel("Password: ");
      lblPass.setFont(fontMid);
      pass = new JPasswordField(20);
      pass.setHorizontalAlignment((int) SwingConstants.CENTER);
      lblPass2 = new JLabel("Mostra password: ");
      btnPass = new JButton("👁");
      btnPass.setPreferredSize(new Dimension(5,2));
      btnPass.setBackground(Color.LIGHT_GRAY);

      final boolean[] isPasswordVisible = {false};
      btnPass.addActionListener(e -> {
          if (isPasswordVisible[0]) {
              pass.setEchoChar('*'); // Nasconde la password
              isPasswordVisible[0] = false;
          } else {
              pass.setEchoChar('\u0000'); // Mostra la password
              isPasswordVisible[0] = true;
          }
      });
        
      panel1.add(lblEmail);
      panel1.add(txtEmail);
      panel1.add(lblPass);
      panel1.add(pass);
      panel1.add(lblPass2);
      panel1.add(btnPass);
      midPanel.add(panel1);
      
      frameAccedi.add(midPanel, BorderLayout.CENTER);

      // pannello per gestire i bottoni
      JPanel panelBtn;
      JButton btn;
      panelBtn = new JPanel(new GridLayout(2 , 1, 10, 10));
      panelBtn.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));

      btn = new JButton("Accedi");
      btn.setBackground(Color.decode("#5299D5"));
      Dimension d = new Dimension(200, 35);
      btn.setPreferredSize(d);
      fontBtn = new Font("Segoe UI", Font.BOLD, 14);
      btn.setFont(fontBtn);
     
      panelBtn.add(btn);
      midPanel.add(panelBtn);
      frameAccedi.add(midPanel, BorderLayout.CENTER);

      btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String m = "";
              
              if(txtEmail.getText().isEmpty() || pass.getPassword().length == 0){
                  JOptionPane.showMessageDialog(frameAccedi, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE );
                  return;
              }
              m += txtEmail.getText() + " ; ";
              m += new String(pass.getPassword()) + " ; ";
       
              new HomeFrame();
              
          }
      });



      frameAccedi.add(panel);

      

      // Funzione del pulsante di accesso quando viene premuto
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String email = txtEmail.getText();
            JPasswordField password = pass;
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
      JButton btnRegistrati = new JButton("Registrati");

      btnRegistrati.setHorizontalAlignment(JButton.CENTER);
      btnRegistrati.setBorderPainted(false);
      btnRegistrati.setContentAreaFilled(false);

      btnRegistrati.addActionListener(new ActionListener() {
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
      topPanel.setBackground(Color.decode("#f0ffff"));
      midPanel.setBackground(Color.decode("#f0ffff"));

      frameAccedi.setVisible(true);
      frameAccedi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}