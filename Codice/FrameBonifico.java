import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameBonifico {

    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1;
    JLabel lblIBANd, lblIBANm, lblPin, lblImporto, lblCausale;
    JTextField txtIBANd, txtIBANm, txtPin, txtImporto;
    JTextArea txtCausale;

    JButton btn;

    Font fontIniziale, fontMid;

    public FrameBonifico() {
        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Bonifico");
        frame.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 600) / 2;
        int y = (screenSize.height - 600) / 2;
        frame.setLocation(x, y);

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        // Top panel
        topPanel = new JPanel();
        topLabel = new JLabel("Bonifico");
        topLabel.setForeground(Color.decode("#1c2697"));
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(topPanel, BorderLayout.NORTH);

        // Mid panel
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.PLAIN, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(15, 40, 50, 20));

        panel1 = new JPanel(new GridLayout(5, 2, 20, 10)); // 5 rows, 2 cols

        lblIBANd = new JLabel("IBAN del destinatario del bonifico: ");
        lblIBANd.setForeground(Color.decode("#1c2697"));
        lblIBANd.setFont(fontMid);
        txtIBANd = new JTextField(20);

        lblIBANm = new JLabel("IBAN del mittente del bonifico: ");
        lblIBANm.setForeground(Color.decode("#1c2697"));
        lblIBANm.setFont(fontMid);
        txtIBANm = new JTextField(20);

        lblPin = new JLabel("Pin: ");
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

        panel1.add(lblIBANd);
        panel1.add(txtIBANd);
        panel1.add(lblIBANm);
        panel1.add(txtIBANm);
        panel1.add(lblPin);
        panel1.add(txtPin);
        panel1.add(lblImporto);
        panel1.add(txtImporto);
        panel1.add(lblCausale);
        panel1.add(new JScrollPane(txtCausale)); // per area testo scrollabile

        midPanel.add(panel1);
        frame.add(midPanel, BorderLayout.CENTER);

        // Bottom panel con bottone
        bottomPanel = new JPanel();
        btn = new JButton("Esegui");
        btn.setBackground(Color.decode("#1c2697"));
        btn.setForeground(Color.decode("#cbf4f4"));
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);
        bottomPanel.add(btn);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Set background colori
        panel1.setBackground(Color.decode("#cbf4f4"));
        topPanel.setBackground(Color.decode("#cbf4f4"));
        midPanel.setBackground(Color.decode("#cbf4f4"));
        bottomPanel.setBackground(Color.decode("#cbf4f4"));

        // Listener bottone con classe interna
        btn.addActionListener(new BonificoActionListener());

        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    // Classe interna per gestire l'evento del bottone
    private class BonificoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ibanDestinatario = txtIBANd.getText().trim();
            String ibanMittente = txtIBANm.getText().trim();
            String pinInserito = txtPin.getText().trim();
            String importoStr = txtImporto.getText().replace("€", "").trim();
            String causale = txtCausale.getText().trim();

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

            Bonifico bonifico = new Bonifico(ibanDestinatario, ibanMittente, pinInserito, importo, causale);
            try {
                bonifico.salvaSuFile("save.csv");
                JOptionPane.showMessageDialog(frame, "Bonifico salvato con successo!", "Successo", JOptionPane.INFORMATION_MESSAGE);
                // Pulisci i campi dopo il salvataggio
                txtIBANd.setText("");
                txtIBANm.setText("");
                txtPin.setText("");
                txtImporto.setText("€  ");
                txtCausale.setText("");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(frame, "Errore nel salvataggio del bonifico!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Metodo main per testare
    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrameBonifico());
    }*/
}
