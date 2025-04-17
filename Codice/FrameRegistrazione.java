import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class FrameRegistrazione{

    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel ; // per gestire il border layout
    JLabel topLabel;
    Font fontIniziale, fontMid, fontBtn;

    JPanel panel1, panel2, panelBtn; // per gestire il mid panel
    JLabel lblNome, lblCognome;
    JTextField txtNome, txtCognome;
    JLabel lblCodFis, lblEmail, lblNtel;
    JTextField txtCodFis, txtEmail, txtNTel;
    JLabel lblAccedi;
    JButton btn, btnAccedi;

    JProgressBar progressBar;

    final FileWriter file; 

    FrameRegistrazione() throws IOException {

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

        panel1 = new JPanel(new GridLayout(5, 1, 10, 20));

        lblNome = new JLabel("Nome: ");
        lblNome.setFont(fontMid);
        txtNome = new JTextField(20);
        txtNome.setHorizontalAlignment((int) SwingConstants.CENTER);

        lblCognome = new JLabel("Cognome: ");
        lblCognome.setFont(fontMid);
        txtCognome = new JTextField(20);
        txtCognome.setHorizontalAlignment((int) SwingConstants.CENTER);

        lblCodFis = new JLabel("Codice fiscale: ");
        lblCodFis.setFont(fontMid);
        txtCodFis = new JTextField(20);
        txtCodFis.setHorizontalAlignment((int) SwingConstants.CENTER);
      
        lblEmail = new JLabel("Email: ");
        lblEmail.setFont(fontMid);
        txtEmail = new JTextField(20);
        txtEmail.setHorizontalAlignment((int) SwingConstants.CENTER);

        lblNtel = new JLabel("Numero di telefono: ");
        lblNtel.setFont(fontMid);
        txtNTel = new JTextField(20);
        txtNTel.setHorizontalAlignment((int) SwingConstants.CENTER);
  
        panel1.add(lblNome); 
        panel1.add(txtNome);            
        panel1.add(lblCognome);
        panel1.add(txtCognome);
        panel1.add(lblCodFis);
        panel1.add(txtCodFis);
        panel1.add(lblEmail);
        panel1.add(txtEmail);
        panel1.add(lblNtel);
        panel1.add(txtNTel);
        
        midPanel.add(panel1);

        // pannello per gestire i bottoni
        panelBtn = new JPanel(new GridLayout(2 , 1, 10, 10));

        panelBtn.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));
        btn = new JButton("Avanti");
        btn.setBackground(Color.decode("#5299D5"));
        btn.setPreferredSize(new Dimension(200, 30));

        fontBtn = new Font("Segoe UI", Font.BOLD, 14);
        btn.setFont(fontBtn);

        panel2 = new JPanel();

        lblAccedi = new JLabel("Hai già un account?");
        btnAccedi = new JButton("Accedi");
        
        btnAccedi.setHorizontalAlignment(JButton.CENTER);
        btnAccedi.setBorderPainted(false);
        btnAccedi.setContentAreaFilled(false);

        panelBtn.add(lblAccedi);
        panelBtn.add(btnAccedi);
        panel2.add(lblAccedi);
        panel2.add(btnAccedi);

        panelBtn.add(btn);
        panelBtn.add(panel2);

        midPanel.add(panelBtn);
        
        frame.add(midPanel, BorderLayout.CENTER);

        // bottom panel
        bottomPanel = new JPanel();

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(x, 15));
        progressBar.setForeground(Color.decode("#5299D5"));
        progressBar.setValue(33);
        progressBar.setStringPainted(false);

        bottomPanel.add(progressBar);

        frame.add(bottomPanel, BorderLayout.SOUTH);


        // action listener del bottone registrazione
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                String m = "\n";

                if (txtNome.getText().isEmpty() || txtCognome.getText().isEmpty() || txtCodFis.getText().isEmpty() || txtEmail.getText().isEmpty() || txtNTel.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori.", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                m += txtNome.getText() + " ; ";
                m += txtCognome.getText() + " ; ";
                m += txtCodFis.getText() + " ; ";
                m += txtEmail.getText() + " ; ";
                m += txtNTel.getText() + " ; ";
               

                try (FileWriter writer = new FileWriter("save.csv", true)){
                    writer.write(m);
                    //writer.write("\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                             
                frame.setVisible(false);

                try {
                    new FrameRegistrazione2(frame);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            }

        });

        // action listener del bottone accedi
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame.dispose();
                new FrameAccedi();
                
            }
        });


        topPanel.setBackground(Color.decode("#f0ffff"));
        midPanel.setBackground(Color.decode("#f0ffff"));
        panel1.setBackground(Color.decode("#f0ffff"));
        panelBtn.setBackground(Color.decode("#f0ffff"));
        panel2.setBackground(Color.decode("#f0ffff"));
        bottomPanel.setBackground(Color.decode("#f0ffff"));


        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }


}