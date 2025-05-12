import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FrameAccount {
    
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1;
    JLabel lblNomeTitolare, lblCognomeTitolare, lblCodFis, lblNtel, lblDataNascita, lblLuogoNascita, lblIndirizzo, lblCitta, lblEmail, lblPassword;

    JButton btn;

    Font fontIniziale, fontMid;

    static Utente utente;

    FrameAccount(){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Account");
        frame.setLayout(new BorderLayout());

        // per settare il frame in centro
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - 500) / 2;
        int y = (screenSize.height - 550) / 2;
        frame.setLocation(x, y);

        // top panel
        topPanel = new JPanel();
        topLabel = new JLabel("Il tuo account!");
        fontIniziale = new Font("Serif", Font.BOLD, 28);
        topLabel.setFont(fontIniziale);
        topPanel.add(topLabel);
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(topPanel, BorderLayout.NORTH);

        // mid panel
        midPanel = new JPanel();
        fontMid = new Font("Segoe UI", Font.BOLD, 14);
        midPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 50, 20));

        panel1 = new JPanel(new GridLayout(9, 1, 10, 20));

        lblNomeTitolare = new JLabel("Nome: " + utente.getNome());
        lblNomeTitolare.setFont(fontMid);

        lblCognomeTitolare = new JLabel("Cognome: " + utente.getCognome());
        lblCognomeTitolare.setFont(fontMid);

        lblCodFis = new JLabel("Codice fiscale: " + utente.getCodFis());
        lblCodFis.setFont(fontMid);
        
        lblNtel = new JLabel("Numero di telefono: " + utente.getnTel());
        lblNtel.setFont(fontMid);

        lblDataNascita = new JLabel("Data di nascita: " + utente.getDataNascita());
        lblDataNascita.setFont(fontMid);

        lblLuogoNascita = new JLabel("Luogo di nascita: " + utente.getLuogoNascita());
        lblLuogoNascita.setFont(fontMid);

        lblIndirizzo = new JLabel("Indirizzo di residenza: " + utente.getIndirizzo());
        lblIndirizzo.setFont(fontMid);

        lblCitta = new JLabel("Citta di residenza: " + utente.getCitta());
        lblCitta.setFont(fontMid);

        lblEmail = new JLabel("Email: " + utente.getEmail());
        lblEmail.setFont(fontMid);

        lblPassword = new JLabel("Password: " + utente.getPassword());
        lblPassword.setFont(fontMid);
        
        panel1.add(lblNomeTitolare);
        panel1.add(lblCognomeTitolare);
        panel1.add(lblCodFis);
        panel1.add(lblNtel);
        panel1.add(lblDataNascita);
        panel1.add(lblLuogoNascita);
        panel1.add(lblIndirizzo);
        panel1.add(lblCitta);
        panel1.add(lblEmail);
        panel1.add(lblPassword);

        midPanel.add(panel1);

        frame.add(midPanel, BorderLayout.CENTER);

        // panel per un bottone
        btn = new JButton("Dati della carta");
        btn.setBackground(Color.decode("#5299D5"));
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);

        btn.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent e){

                try {
                    new FrameDatiCarta(frame);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        
        });

        //frame.add(btn);


        frame.setSize(550, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
