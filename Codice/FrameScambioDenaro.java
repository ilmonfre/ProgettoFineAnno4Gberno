import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class FrameScambioDenaro {
    
    JFrame frame;
    JPanel topPanel, midPanel, bottomPanel;
    JLabel topLabel;

    JPanel panel1, btnPanel;
    JLabel lblNcartam, lblNcartad, lblCVV, lblImporto, lblCategoria, lblTipo, lblErrore;
    JTextField txtNcartam, txtNcartad,  txtCVV, txtImporto, txtCategoria, txtTipo;

    JButton btn;

    Font fontIniziale, fontMid;

    //static Utente utente;

    FrameScambioDenaro(Movimenti movimenti){

        frame = new JFrame();
        frame.setTitle("Zaphyra Bank - Scambio Denaro");
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
        topLabel = new JLabel("Scambio denaro");
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

        panel1 = new JPanel(new GridLayout(6, 1, 20, 40));

        lblNcartam = new JLabel("Numero di carta del destinatario: ");
        lblNcartam.setForeground(Color.decode("#1c2697"));
        lblNcartam.setFont(fontMid);
        txtNcartam = new JTextField(20);

        lblNcartad = new JLabel("Numero di carta del mittente: ");
        lblNcartad.setForeground(Color.decode("#1c2697"));
        lblNcartad.setFont(fontMid);
        txtNcartad = new JTextField(20);

        lblCVV = new JLabel("CVV: " );
        lblCVV.setForeground(Color.decode("#1c2697"));
        lblCVV.setFont(fontMid);
        txtCVV = new JTextField(20);

        lblImporto = new JLabel("Inserire l'importo: ");
        lblImporto.setForeground(Color.decode("#1c2697"));
        lblImporto.setFont(fontMid);
        txtImporto = new JTextField(10);

        lblTipo = new JLabel("Tipo: ");
        lblTipo.setForeground(Color.decode("#1c2697"));
        lblTipo.setFont(fontMid);
        txtTipo = new JTextField(10);

        lblCategoria = new JLabel("Categoria: ");
        lblCategoria.setForeground(Color.decode("#1c2697"));
        lblCategoria.setFont(fontMid);
        txtCategoria = new JTextField(10);

        panel1.add(lblNcartam);
        panel1.add(txtNcartam);
        panel1.add(lblNcartad);
        panel1.add(txtNcartad);
        panel1.add(lblCVV);
        panel1.add(txtCVV);
        panel1.add(lblImporto);
        panel1.add(txtImporto);
        panel1.add(lblTipo);
        panel1.add(txtTipo);
        panel1.add(lblCategoria);
        panel1.add(txtCategoria);

        // panel per un bottone
        bottomPanel = new JPanel();

        btn = new JButton("Esegui");
        btn.setBackground(Color.decode("#1c2697"));
        btn.setForeground(Color.decode("#cbf4f4"));
        Dimension d = new Dimension(200, 35);
        btn.setPreferredSize(d);

        lblErrore = new JLabel();

        bottomPanel.add(lblErrore);
        bottomPanel.add(btn);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        midPanel.add(panel1);
        frame.add(midPanel, BorderLayout.CENTER);

        btn.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed (ActionEvent e){

                double costo = Double.parseDouble(txtImporto.getText());
                if(movimenti.nuovaUscita(costo, LocalDate.now(), txtTipo.getText(), txtCategoria.getText(), txtNcartad.getText())==false || costo>movimenti.getSoldiConto() || movimenti.budget.controllaSettimanale(costo) == false || movimenti.budget.controllaMensile(costo) == false || movimenti.budget.controllaAnnuale(costo) == false){

                    lblErrore.setText("Si è verificato un errore");
                }else{

                    lblErrore.setText("");
                }
                frame.dispose();
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