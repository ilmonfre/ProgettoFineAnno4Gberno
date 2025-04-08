import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

class FrameRegistrazione{

    JFrame frame;
    JPanel panelIniziale, midPanel;
    JLabel labelIniziale;
    Font font;

    JPanel panel1;
    JLabel lblName, lblSurname, lblCodFis;
    JTextField txtName, txtSurname, txtCodFis;
    JLabel lblEmail, lblNtel;
    JTextField txtEmail, txtNtel;
   

    FrameRegistrazione(){
        frame = new JFrame();
        frame.setTitle("Zaphyra Bank");
        frame.setLayout(new BorderLayout());
        
        // per settare il frame in centro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 500) / 2;
        int y = (screenSize.height - 550) / 2;
        frame.setLocation(x, y);

        panelIniziale = new JPanel();
        labelIniziale = new JLabel("Crea un nuovo account!");
        font = new Font("Serif", Font.BOLD, 24);
        labelIniziale.setFont(font);
        panelIniziale.add(labelIniziale);
        panelIniziale.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(panelIniziale, BorderLayout.NORTH);

        // mid panel

        midPanel = new JPanel();
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        panel1 = new JPanel(new GridLayout(5, 1, 10, 10));

        lblName = new JLabel("Nome: ");
        txtName = new JTextField(20);
        lblSurname = new JLabel("Cognome: ");
        txtSurname = new JTextField(20);
        lblCodFis = new JLabel("Codice fiscale: ");
        txtCodFis = new JTextField(20);
        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(20);
        lblNtel = new JLabel("Numero di telefono: ");
        txtNtel = new JTextField(20);
        
        panel1.add(lblName); 
        panel1.add(txtName);            
        panel1.add(lblSurname);
        panel1.add(txtSurname);
        panel1.add(lblCodFis);
        panel1.add(txtCodFis);
        panel1.add(lblEmail);
        panel1.add(txtEmail);
        panel1.add(lblNtel);
        panel1.add(txtNtel);
        
        midPanel.add(panel1);
       



        frame.add(midPanel, BorderLayout.CENTER);

        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}