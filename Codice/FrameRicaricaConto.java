
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameRicaricaConto {
    
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1, btnPanel;
    JLabel lblIBAN, lblPin, lblImporto, lblCausale;
    JTextField txtIBAN, txtPin, txtImporto;
    JTextArea txtCausale;

    JButton btn;

    Font fontIniziale, fontMid;

    //static Utente utente;

    FrameRicaricaConto(){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Ricarica conto");
        frame.setLayout(new BorderLayout());

        // per settare il frame in centro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 600) / 2;
        int y = (screenSize.height - 600) / 2;
        frame.setLocation(x, y);

        frame.setFocusable(true);  // per non far posizionare inizialmente il cursore
        frame.requestFocusInWindow();

        // top panel
        topPanel = new JPanel();
        topLabel = new JLabel("Ricarica conto");
        topLabel.setForeground(Color.decode("#1c2697"));
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        // mid panel
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(15, 40, 50, 20));

        panel1 = new JPanel(new GridLayout(4, 1, 20, 40));

        lblIBAN = new JLabel("IBAN del destinatario della ricarica: ");
        lblIBAN.setForeground(Color.decode("#1c2697"));
        lblIBAN.setFont(fontMid);
        txtIBAN = new JTextField(20);

        lblPin = new JLabel("Pin: " );
        lblPin.setForeground(Color.decode("#1c2697"));
        lblPin.setFont(fontMid);
        txtPin = new JTextField(20);

        lblImporto = new JLabel("Inserire l'importo: ");
        lblImporto.setForeground(Color.decode("#1c2697"));
        lblImporto.setFont(fontMid);
        txtImporto = new JTextField("€  ");
        txtImporto.setColumns(10);

        lblCausale = new JLabel("Inserire causale: ");
        lblCausale.setForeground(Color.decode("#1c2697"));
        lblCausale.setFont(fontMid);
        txtCausale = new JTextArea(2, 20);
        txtCausale.setLineWrap(true);
        txtCausale.setWrapStyleWord(true);

        panel1.add(lblIBAN);
        panel1.add(txtIBAN);
        panel1.add(lblPin);
        panel1.add(txtPin);
        panel1.add(lblImporto);
        panel1.add(txtImporto);
        panel1.add(lblCausale);
        panel1.add(txtCausale);

        // panel per un bottone
        bottomPanel = new JPanel();

        btn = new JButton("Esegui");
        btn.setBackground(Color.decode("#1c2697"));
        btn.setForeground(Color.decode("#cbf4f4"));
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);     

        bottomPanel.add(btn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        midPanel.add(panel1); 
        frame.add(midPanel, BorderLayout.CENTER);

        btn.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent e){
                
            }
        });

        panel1.setBackground(Color.decode("#cbf4f4"));
        topPanel.setBackground(Color.decode("#cbf4f4"));
        midPanel.setBackground(Color.decode("#cbf4f4"));
        bottomPanel.setBackground(Color.decode("#cbf4f4"));


        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}


