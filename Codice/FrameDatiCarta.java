import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrameDatiCarta {
    
    JFrame frame;
    JPanel topPanel, midPanel, panel, btnPanel;
    JLabel topLabel;
    JButton btn;

    JLabel lblIban, lblNcarta, lblDataScadenza, lblcvv, lblpin;
    
    // static Utente utente;

    Font fontIniziale, fontMid,fontBtn;

    FrameDatiCarta(){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - La tua carta");
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
        topLabel = new JLabel("La tua carta!");
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        // pannello per gestire i dati della carta
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        panel = new JPanel(new GridLayout(6, 0, 10, 20));

        lblIban = new JLabel("Iban: " + FrameAccount.utente.getIBAN());
        lblIban.setFont(fontMid);

        lblNcarta = new JLabel("Numero della carta: " + FrameAccount.utente.getnCarta());
        lblNcarta.setFont(fontMid);

        lblDataScadenza = new JLabel("Data di scadenza: " + FrameAccount.utente.getDataScadenza());
        lblDataScadenza.setFont(fontMid);

        lblcvv = new JLabel("CVV: " + FrameAccount.utente.getCvv());
        lblcvv.setFont(fontMid);

        lblpin = new JLabel("PIN: " + FrameAccount.utente.getPin());
        lblpin.setFont(fontMid);

        panel.add(lblIban);
        panel.add(lblNcarta);
        panel.add(lblDataScadenza);
        panel.add(lblcvv);
        panel.add(lblpin);

        midPanel.add(panel);

        frame.add(midPanel, BorderLayout.CENTER);

        topPanel.setBackground(Color.decode("#f0ffff"));
        midPanel.setBackground(Color.decode("#f0ffff"));
        panel.setBackground(Color.decode("#f0ffff"));

        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}