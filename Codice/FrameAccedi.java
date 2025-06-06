import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;


public class FrameAccedi {

   JFrame frame;
   JPanel topPanel, midPanel;
   JLabel topLabel;

   Budget budget;

   JPanel panel1, panelBtn, panel2;
   JLabel lblEmail, lblPass, lblPass2;
   JTextField txtEmail;
   JPasswordField pass;
   JButton btnPass;

   JButton btn, btnReg;
   JLabel lblReg;

   Font fontIniziale, fontMid, fontBtn;


   public FrameAccedi(Movimenti movimenti){

      frame = new JFrame();
      frame.setTitle("Zaphyra Bank - Log in");
      frame.setLayout(new BorderLayout());

      frame.setFocusable(true);  // per non far posizionare inizialmente il cursore
      frame.requestFocusInWindow();

      // per settare il frame in centro
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width - 500) / 2;
      int y = (screenSize.height - 550) / 2;
      frame.setLocation(x, y);

      // top panel
      topPanel = new JPanel();
      topLabel = new JLabel("Accedi al tuo account!");
      topLabel.setForeground(Color.decode("#1c2697"));
      fontIniziale = new Font("Serif", Font.BOLD, 28);
      topLabel.setFont(fontIniziale);
      topPanel.add(topLabel);

      topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

      frame.add(topPanel, BorderLayout.NORTH);  

      // mid panel
      midPanel = new JPanel();
      fontMid = new Font("Segoe UI", Font.PLAIN, 14);
      midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));
      panel1 = new JPanel(new GridLayout(3,1,10 ,20));
      lblEmail = new JLabel("Email: ");
      lblEmail.setForeground(Color.decode("#1c2697"));
      lblEmail.setFont(fontMid);
      txtEmail = new JTextField(20);
      txtEmail.setHorizontalAlignment((int) SwingConstants.CENTER);
      
      lblPass = new JLabel("Password: ");
      lblPass.setForeground(Color.decode("#1c2697"));
      lblPass.setFont(fontMid);
      pass = new JPasswordField(20);
      pass.setHorizontalAlignment((int) SwingConstants.CENTER);
      lblPass2 = new JLabel("Mostra password: ");
      lblPass2.setForeground(Color.decode("#1c2697"));
      btnPass = new JButton("👁");
      btnPass.setPreferredSize(new Dimension(3,2));
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
      
      frame.add(midPanel, BorderLayout.CENTER);
      
      // pannello per gestire i bottoni
      panelBtn = new JPanel(new GridLayout(2 , 1, 10, 10));

      panelBtn.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));
      btn = new JButton("Avanti");
      btn.setBackground(Color.decode("#1c2697"));
      btn.setForeground(Color.decode("#cbf4f4"));
      btn.setPreferredSize(new Dimension(150, 30));

      fontBtn = new Font("Segoe UI", Font.BOLD, 14);
      btn.setFont(fontBtn);

      panel2 = new JPanel();

      lblReg = new JLabel("Non hai ancora un account?");
      lblReg.setForeground(Color.decode("#1c2697"));
      btnReg = new JButton("Registrati");
      btnReg.setForeground(Color.decode("#1c2697"));
      
      btnReg.setHorizontalAlignment(JButton.CENTER);
      btnReg.setBorderPainted(false);
      btnReg.setContentAreaFilled(false);

      panelBtn.add(lblReg);
      panelBtn.add(btnReg);
      panel2.add(lblReg);
      panel2.add(btnReg);

      panelBtn.add(btn);
      panelBtn.add(panel2);

      midPanel.add(panelBtn);
      
      frame.add(midPanel, BorderLayout.CENTER);

      // funzione del pulsante di accesso
      btn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String email = txtEmail.getText();
            String password = new String(pass.getPassword());
            
            String csv = "save.csv";
            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
                  String line;

                  while ((line = reader.readLine()) != null) {
                     String[] fields = line.split(";");

                     if (fields.length > 14 && fields[8].trim().equals(email.trim()) && fields[9].trim().equals(password.trim())) { 
                        found = true;
                        FrameAccount.utente = new Utente(fields);
                        break;
                     }
                  }
            } catch (IOException e2) {
                  e2.printStackTrace();
            }

            if (found) {
                  frame.dispose();
                  new HomeFrame(movimenti);
            } else {
                  JOptionPane.showMessageDialog(null, "Email o password errati", "Errore", JOptionPane.ERROR_MESSAGE);
            }

         }
      });


      btnReg.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

               frame.dispose();
               try {
                  new FrameRegistrazione(movimenti);
               } catch (IOException e1) {
                  e1.printStackTrace();
               }
         }
      });


      topPanel.setBackground(Color.decode("#cbf4f4"));
      midPanel.setBackground(Color.decode("#cbf4f4"));
      panel1.setBackground(Color.decode("#cbf4f4"));
      panelBtn.setBackground(Color.decode("#cbf4f4"));
      panel2.setBackground(Color.decode("#cbf4f4"));


      frame.setSize(500, 550);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   // public static void main(String[] args) {
   //    SwingUtilities.invokeLater(new Runnable() {
   //       @Override
   //       public void run() {
   //          new FrameAccedi();
   //       }
   //    });
   // }
}