import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameDatiCarta {
    

    JFrame frame;
    JPanel topPanel, midPanel;
    JLabel topLabel;
    JButton btn;

    JLabel lblIban, lblNcarta, lblDataScadenza;
    JPasswordField lblcvv, lblpin;

    static DatiCartaUtente dati;

    Font fontIniziale, fontMid,fontBtn;

    FrameDatiCarta(){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Dati carta");
        frame.setLayout(new BorderLayout());

        // per settare il frame in centro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 500) / 2;
        int y = (screenSize.height - 550) / 2;
        frame.setLocation(x, y);


        // top panel
        topPanel = new JPanel();
        topLabel = new JLabel("La tua carta!");
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        // pannello per gestire i dati della carta
        midPanel = new JPanel(new GridLayout(7, 1, 10, 20));
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        lblIban = new JLabel("Iban: " + dati.getIBAN());
        lblIban.setFont(fontMid);

        lblNcarta = new JLabel("Numero della carta: " + dati.getnCarta());
        lblNcarta.setFont(fontMid);

        lblDataScadenza = new JLabel("Data di scadenza: " + dati.getDataScadenza());
        lblDataScadenza.setFont(fontMid);

        lblcvv = new JPasswordField("CVV: " + dati.getCvv());
        lblcvv.setFont(fontMid);

        lblpin = new JPasswordField("PIN: " + dati.getPin());
        lblpin.setFont(fontMid);

        midPanel.add(lblIban);
        midPanel.add(lblNcarta);
        midPanel.add(lblDataScadenza);
        midPanel.add(lblcvv);
        midPanel.add(lblpin);
        
        btn = new JButton("Indietro");

        btn.setBackground(Color.LIGHT_GRAY);
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);

        fontBtn = new Font("Segoe UI", Font.BOLD, 14);
        btn.setFont(fontBtn);
        btn.setFont(fontBtn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();  
            }
        });

        midPanel.add(btn);

        frame.add(midPanel, BorderLayout.CENTER);

        frame.setSize(600, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
