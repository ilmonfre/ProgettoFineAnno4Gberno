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
      JFrame frameAccedi = new JFrame("Accedi");
      JPanel panel = new JPanel();
      JPanel panelAccedi = new JPanel();
      JLabel labelAccedi = new JLabel("Accedi al tuo account");
      JPanel panelRegistrati = new JPanel();
      JLabel labelEmail = new JLabel("E-mail");
      JTextArea textAreaEmail = new JTextArea();
      JLabel labelPassword = new JLabel("Password");
      JTextArea textAreaPassword = new JTextArea();
      JPanel panelButtonAccedi = new JPanel();
      JButton buttonAccedi = new JButton("Accedi");
      JPanel panelRegistratiNuovoAccount = new JPanel();
      JLabel labelRegistrati = new JLabel("Non hai ancora un account?");
      JPanel panelButtonRegistrati = new JPanel();
      JButton buttonRegistrati = new JButton("Registrati");
      frameAccedi.add(panel);
      panel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));

      // Aggiungi componenti ai rispettivi pannelli
      panel.add(panelAccedi);
      labelAccedi.setHorizontalAlignment(JLabel.CENTER);
      labelAccedi.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 24));
      panelAccedi.add(labelAccedi);

      panel.add(panelRegistrati);
      panelRegistrati.add(labelEmail);
      panelRegistrati.add(textAreaEmail);
      panelRegistrati.add(labelPassword);
      panelRegistrati.add(textAreaPassword);

      panel.add(panelButtonAccedi);
      panelButtonAccedi.add(buttonAccedi);
      buttonAccedi.setHorizontalAlignment(JButton.CENTER);
      buttonAccedi.setBackground(Color.decode("#5299D5"));
      panelButtonAccedi.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 140, 30, 140));

      panel.add(panelRegistratiNuovoAccount);
      panelRegistratiNuovoAccount.add(labelRegistrati);
      labelRegistrati.setHorizontalAlignment(JLabel.RIGHT);
      panelRegistratiNuovoAccount.add(panelButtonRegistrati);
      panelRegistratiNuovoAccount.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 120, 0, 0));
      panelButtonRegistrati.add(buttonRegistrati);
      
      buttonRegistrati.setHorizontalAlignment(JButton.CENTER);
      buttonRegistrati.setBorderPainted(false);
      buttonRegistrati.setContentAreaFilled(false);

      buttonRegistrati.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            frameAccedi.dispose();
            new FrameRegistrazione();
         }
      });

      // Configura layout per i pannelli
      panel.setLayout(new GridLayout(4, 1));
      panelAccedi.setLayout(new GridLayout(1, 1));
      panelRegistrati.setLayout(new GridLayout(4, 1));
      panelButtonAccedi.setLayout(new GridLayout(1, 1));
      panelRegistratiNuovoAccount.setLayout(new GridLayout(1, 2));
      panelButtonRegistrati.setLayout(new GridLayout(1, 1));

      // Imposta le dimensioni del frame
      frameAccedi.setSize(500, 550);

      // Calcola le coordinate per centrare il frame
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      int x = (screenSize.width - frameAccedi.getWidth()) / 2;
      int y = (screenSize.height - frameAccedi.getHeight()) / 2;
      frameAccedi.setLocation(x, y); // Imposta la posizione centrata

      frameAccedi.setVisible(true);
      frameAccedi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}