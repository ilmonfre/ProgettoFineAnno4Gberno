import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameBonifico {
    
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1, btnPanel;
    JLabel lblIBANd, lblIBANm, lblPin, lblImporto;
    JTextField txtIBANd, txtIBANm,  txtPin, txtImporto;

    JButton btn;

    Font fontIniziale, fontMid;

    //static Utente utente;

    FrameBonifico(){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Bonifico");
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
        topLabel = new JLabel("Bonifico");
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

        lblIBANd = new JLabel("IBAN del destinatario del bonifico: ");
        lblIBANd.setForeground(Color.decode("#1c2697"));
        lblIBANd.setFont(fontMid);
        txtIBANd = new JTextField(20);

        lblIBANm = new JLabel("IBAN del mittente del bonifico: ");
        lblIBANm.setForeground(Color.decode("#1c2697"));
        lblIBANm.setFont(fontMid);
        txtIBANm = new JTextField(20);

        lblPin = new JLabel("Pin: " );
        lblPin.setForeground(Color.decode("#1c2697"));
        lblPin.setFont(fontMid);
        txtPin = new JTextField(20);

        lblImporto = new JLabel("Inserire l'importo: ");
        lblImporto.setForeground(Color.decode("#1c2697"));
        lblImporto.setFont(fontMid);
        txtImporto = new JTextField("€  ");
        txtImporto.setColumns(10);

        panel1.add(lblIBANd);
        panel1.add(txtIBANd);
        panel1.add(lblIBANm);
        panel1.add(txtIBANm);
        panel1.add(lblPin);
        panel1.add(txtPin);
        panel1.add(lblImporto);
        panel1.add(txtImporto);

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

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ibanDestinatario = txtIBANd.getText().trim();
                String ibanMittente = txtIBANm.getText().trim();
                String pinInserito = txtPin.getText().trim();
                String importoStr = txtImporto.getText().replace("€", "").trim();

                if (ibanDestinatario.isEmpty() || ibanMittente.isEmpty() || pinInserito.isEmpty() || importoStr.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tutti i campi sono obbligatori!", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double importo;
                try {
                    importo = Double.parseDouble(importoStr.replace(",", "."));
                    if (importo <= 0) throw new NumberFormatException();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Importo non valido!", "Errore", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
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
