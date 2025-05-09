import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class FrameDatiCarta {
    

    JFrame frame, previousFrame;
    JPanel topPanel, midPanel;
    JLabel topLabel;
    JButton btn;

    JLabel lblIban, lblNcarta, lblDataScadenza;
    JPasswordField lblcvv, lblpin;

    static DatiCartaUtente dati;

    Font fontIniziale, fontMid;

    FrameDatiCarta(JFrame previousFrame) throws IOException{
        this.previousFrame = previousFrame;

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Dati carta");
        frame.setLayout(new BorderLayout());


        // top panel
        topPanel = new JPanel();
        topLabel = new JLabel("ILa tua carta!");
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

        frame.add(midPanel, BorderLayout.CENTER);
        

        

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
