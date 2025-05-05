import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class FrameRegistrazione2 {

    JFrame frame;
    JFrame previousFrame;
    JPanel topPanel, midPanel, bottomPanel;

    JLabel topLabel, topLabel2;
    Font fontMid;

    JPanel panel1;
    JLabel lblData, lblLuogo;
    JTextField txtData, txtLuogo;
    JLabel lblIndirizzo, lblCitta;
    JTextField txtIndirizzo, txtCitta;

    JPanel panelBtn;
    JButton btn, btnIndietro;
    Font fontBtn;

    JProgressBar progressBar;

    final FileWriter file;


    FrameRegistrazione2 (JFrame previousFrame) throws IOException{
        this.previousFrame=previousFrame;

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
        topLabel.setFont(new Font("Serif", Font.BOLD, 28));
        topPanel.add(topLabel);

        topPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        //  mid panel
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        panel1 = new JPanel(new GridLayout(4, 1, 10, 20));

        lblData = new JLabel("Data di nascita: ");
        lblData.setFont(fontMid);
        txtData = new JTextField(20);
        txtData.setHorizontalAlignment((int) SwingConstants.CENTER);

        String placeholder = "gg/mm/yyyy";
        txtData.setForeground(Color.GRAY);
        txtData.setText(placeholder);

        txtData.addFocusListener(new FocusAdapter() {           // per mostrare il testo "nascosto"
            @Override
            public void focusGained(FocusEvent e) {
                if (txtData.getText().equals(placeholder)) {
                    txtData.setText("");
                    txtData.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtData.getText().isEmpty()) {
                    txtData.setForeground(Color.GRAY);
                    txtData.setText(placeholder);
                }
            }
        });
        
        lblLuogo = new JLabel("Luogo di nascita (comune): ");
        lblLuogo.setFont(fontMid);
        txtLuogo = new JTextField(20);
        txtLuogo.setHorizontalAlignment((int) SwingConstants.CENTER);

        lblIndirizzo = new JLabel("Indirizzo di residenza: ");
        lblIndirizzo.setFont(fontMid);
        txtIndirizzo = new JTextField( 20);
        txtIndirizzo.setHorizontalAlignment((int) SwingConstants.CENTER);

        String placeholder2 = "ad es.: via Giuseppe Verdi 20";
        txtIndirizzo.setForeground(Color.GRAY);
        txtIndirizzo.setText(placeholder2);

        txtIndirizzo.addFocusListener(new FocusAdapter() {          // per mostrare il testo "nascosto"
            @Override
            public void focusGained(FocusEvent e) {
                if (txtIndirizzo.getText().equals(placeholder2)) {
                    txtIndirizzo.setText("");
                    txtIndirizzo.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (txtIndirizzo.getText().isEmpty()) {
                    txtIndirizzo.setForeground(Color.GRAY);
                    txtIndirizzo.setText(placeholder2);
                }
            }
        });

        lblCitta = new JLabel("Città di residenza: ");
        lblCitta.setFont(fontMid);
        txtCitta = new JTextField(20);
        txtCitta.setHorizontalAlignment((int) SwingConstants.CENTER);


        panel1.add(lblData);
        panel1.add(txtData);
        panel1.add(lblLuogo);
        panel1.add(txtLuogo);
        panel1.add(lblIndirizzo);
        panel1.add(txtIndirizzo);
        panel1.add(lblCitta);
        panel1.add(txtCitta);

        midPanel.add(panel1);

        // pannello per gestire i bottoni
        panelBtn = new JPanel(new GridLayout(2 , 1, 10, 10));
        panelBtn.setBorder(BorderFactory.createEmptyBorder(60, 20, 50, 20));

        btn = new JButton("Avanti");
        btn.setBackground(Color.decode("#5299D5"));
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);

        btnIndietro = new JButton("Indietro");
        btnIndietro.setBackground(Color.LIGHT_GRAY);
        btnIndietro.setPreferredSize(d);

        fontBtn = new Font("Segoe UI", Font.BOLD, 14);
        btn.setFont(fontBtn);
        btnIndietro.setFont(fontBtn);

        panelBtn.add(btn);
        panelBtn.add(btnIndietro);

        midPanel.add(panelBtn);

        frame.add(midPanel, BorderLayout.CENTER);


        // bottom panel
        bottomPanel = new JPanel();

        progressBar = new JProgressBar(0, 100);
        progressBar.setPreferredSize(new Dimension(450, 15));
        progressBar.setForeground(Color.decode("#5299D5"));
        progressBar.setValue(66);
        progressBar.setStringPainted(false);

        bottomPanel.add(progressBar);

        frame.add(bottomPanel, BorderLayout.SOUTH);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String m = "";
                
                if(txtData.getText().isEmpty() || txtData.equals("gg/mm/yyyy") || txtLuogo.getText().isEmpty() || txtIndirizzo.getText().isEmpty() || txtIndirizzo.equals("ad es.: via Giuseppe Verdi 20")){
                    JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE );
                    return;
                }

                m += txtData.getText() + " ; ";
                m += txtLuogo.getText() + " ; ";
                m += txtIndirizzo.getText() + " ; ";
                

                try (FileWriter writer = new FileWriter("save.csv", true)){
                    writer.write(m);
                    //writer.write("\n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
                frame.setVisible(false);

                try {
                    new FrameRegistrazione3(frame);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                
            }
        });

        btnIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                
                previousFrame.setVisible(true);   
            }
        });

        topPanel.setBackground(Color.decode("#f0ffff"));
        midPanel.setBackground(Color.decode("#f0ffff"));
        panel1.setBackground(Color.decode("#f0ffff"));
        panelBtn.setBackground(Color.decode("#f0ffff"));
        bottomPanel.setBackground(Color.decode("#f0ffff"));

        frame.setSize(500, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
}
