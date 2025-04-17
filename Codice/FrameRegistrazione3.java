import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FrameRegistrazione3 {

    JFrame frame, previousFrame;

    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;
    
    JPanel panel1,panelPass;
    JLabel lblEmail, lblPass;
    JTextField txtEmail;
    JPasswordField pass;
    JButton btnPass;


    Font fontIniziale, fontMid;

    final FileWriter file; 

    FrameRegistrazione3 () throws IOException{

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Sign up");
        frame.setLayout(new BorderLayout());

        frame.setFocusable(true);  // per non far posizionare inizialmente il cursore
        frame.requestFocusInWindow();

        file = new FileWriter("save.csv", true);

        // per settare il frame in centro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 500) / 2;
        int y = (screenSize.height - 550) / 2;
        frame.setLocation(x, y);

        // top panel
        topPanel = new JPanel();
        topLabel = new JLabel("Crea un nuovo account!");
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        // mid panel
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        panel1 = new JPanel(new GridLayout(3,2, 10 ,10));

        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(fontMid);
        txtEmail = new JTextField(20);
        txtEmail.setHorizontalAlignment((int) SwingConstants.CENTER);
        
        

        lblPass = new JLabel("Password: ");
        lblPass.setFont(fontMid);
        pass = new JPasswordField(20);
        pass.setHorizontalAlignment((int) SwingConstants.CENTER);
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
        panel1.add(btnPass);

        midPanel.add(panel1);
       

        frame.add(midPanel, BorderLayout.CENTER);











        topPanel.setBackground(Color.decode("#f0ffff"));
        midPanel.setBackground(Color.decode("#f0ffff"));
        panel1.setBackground(Color.decode("#f0ffff"));
        //panelBtn.setBackground(Color.decode("#f0ffff"));
        //panel2.setBackground(Color.decode("#f0ffff"));
        //bottomPanel.setBackground(Color.decode("#f0ffff"));


        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
