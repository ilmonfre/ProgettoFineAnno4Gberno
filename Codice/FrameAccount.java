import javax.swing.*;
import java.awt.*;


public class FrameAccount {
    
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1;
    JLabel lblTitolare, lblDataNascita, lblCodFis, lblNtel;
    

    Font fontIniziale, fontMid;

    FrameAccount(){
        frame.setTitle("Zaphyra Bank - Account");
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
        topLabel = new JLabel("Il tuo account!");
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);


         // mid panel
         midPanel = new JPanel();
         fontMid = new Font("Segoe UI", Font.PLAIN, 14);
         midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));
 
         panel1 = new JPanel(new GridLayout(5, 1, 10, 20));
 
         lblTitolare = new JLabel("Titolare conto: " + );
         lblTitolare.setFont(fontMid);
 
         lblCodFis = new JLabel();
         lblCodFis.setFont(fontMid);
         
 
         lblNtel = new JLabel("Numero di telefono: ");
         lblNtel.setFont(fontMid);
         
         panel1.add(lblTitolare);

         panel1.add(lblCodFis);

         panel1.add(lblNtel);

         
         midPanel.add(panel1);




        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



    }







}
