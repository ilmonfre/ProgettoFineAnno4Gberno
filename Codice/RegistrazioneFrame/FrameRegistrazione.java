import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class FrameRegistrazione{

    JFrame frame, frame2;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;
    Font fontIniziale, fontMid;

    JPanel panel1, panelEmail;
    JLabel lblName, lblSurname, lblCodFis;
    JTextField txtName, txtSurname, txtCodFis;
    JLabel lblEmail, lblEmail2, lblNtel;
    JTextField txtEmail,txtEmail2, txtNtel;
    JButton btn;

    File file; 

    FrameRegistrazione() throws IOException{
        frame = new JFrame();
        frame.setTitle("Zaphyra Bank");
        frame.setLayout(new BorderLayout());
        
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

        panel1 = new JPanel(new GridLayout(5, 4, 10, 10));

        lblName = new JLabel("Nome: ");
        lblName.setFont(fontMid);
        txtName = new JTextField(20);

        lblSurname = new JLabel("Cognome: ");
        lblSurname.setFont(fontMid);
        txtSurname = new JTextField(20);

        lblCodFis = new JLabel("Codice fiscale: ");
        lblCodFis.setFont(fontMid);
        txtCodFis = new JTextField(20);
      
        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(fontMid);
        txtEmail = new JTextField(20);

        lblNtel = new JLabel("Numero di telefono: ");
        lblNtel.setFont(fontMid);
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
        
        bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(50, 20, 50, 20));
        btn = new JButton("Avanti");
      
        int x1 = (screenSize.width - 500) / 2;
        int y1 = (screenSize.height - 550) / 2;
        btn.setLocation(x1, y1);

        bottomPanel.add(btn);
        midPanel.add(bottomPanel);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                String m = "";

                if (txtName.getText().isEmpty() || txtSurname.getText().isEmpty() || txtCodFis.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNtel.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                m += txtName.getText() + " ; ";
                m += txtSurname.getText() + " ; ";
                m += txtCodFis.getText() + " ; ";
                m += txtEmail.getText() + " ; ";
                m += txtNtel.getText() + " ; ";

                try (FileWriter writer = new FileWriter("save.csv", true);) {
                    writer.write(m);
                    writer.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }             
                frame.dispose();
                
            }

        });

        frame.add(midPanel, BorderLayout.CENTER);

        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*frame2 = new JFrame();
        frame2.setTitle("Zaphyra Bank");
        frame2.setLayout(new BorderLayout());
        
        // per settare il frame in centro
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        x = (screenSize.width - 500) / 2;
        y = (screenSize.height - 550) / 2;
        frame2.setLocation(x, y);

        frame2.setSize(500, 550);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    
 

    }


}