import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

public class HomeFrame extends JFrame{

    JLabel labelScrittaSuperiore;
    JPanel panelSuperiore, panelAccount, panelSole, panelLuna;
    JButton buttonAccount, buttonTema;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna;
    JPanel panelMovimenti, panelRisparmi, panelPagamenti, panelBudget, panelCambioValuta;
    JMenuBar menuBarAzioni;
    JMenu menuMovimenti, menuPagamenti, menuRisparmi, menuBudget, menuCambioValuta;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna;

    public HomeFrame(){

        panelSuperiore = new JPanel();

        panelSuperiore.setLayout(new GridLayout(1, 3));

        imageAccount = new ImageIcon();
        imageSole = new ImageIcon();
        imageLuna = new ImageIcon();

        imageAccount = new ImageIcon(getClass().getResource("/Immagini/IconaAccount.png"));
        imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));
        imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));

        labelScrittaSuperiore = new JLabel("ZaphiraBank");

        try {

            InputStream is = getClass().getResourceAsStream("/Font/PlayfairDisplayRegular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(32f);
            labelScrittaSuperiore.setFont(font);
            labelScrittaSuperiore.setAlignmentX(CENTER_ALIGNMENT);
        } catch (Exception e) {

            e.printStackTrace();
        }
        
        buttonAccount = new JButton(imageAccount);
        buttonTema = new JButton(imageLuna);

        buttonAccount.setOpaque(false);
        buttonAccount.setContentAreaFilled(false);
        buttonAccount.setBorderPainted(false);
        buttonAccount.setFocusPainted(false);

        buttonTema.setOpaque(false);
        buttonTema.setContentAreaFilled(false);
        buttonTema.setBorderPainted(false);
        buttonTema.setFocusPainted(false);

        buttonAccount.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new AccountFrame();
            }
        });

        buttonTema.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                if(buttonTema.getIcon().equals(imageSole)){

                    //Rendere tutto scuro
                    buttonTema.setIcon(imageLuna);
                }else{

                    //Rendere tutto chiaro
                    buttonTema.setIcon(imageSole);
                }
            }
        });

        panelSuperiore.add(buttonAccount);
        panelSuperiore.add(labelScrittaSuperiore);
        panelSuperiore.add(buttonTema);





        imageMovimenti = new ImageIcon();
        imageRisparmi = new ImageIcon();
        imagePagamenti = new ImageIcon();
        imageBudget = new ImageIcon();
        imageCambioValuta = new ImageIcon();

        panelAccount = new JPanel();
        panelAccount.setBackground(Color.WHITE);
        
        menuBarAzioni = new JMenuBar();

        menuMovimenti = new JMenu();
        menuPagamenti = new JMenu();
        menuRisparmi = new JMenu();
        menuBudget = new JMenu();
        menuCambioValuta = new JMenu();

        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimenti.png"));
        menuMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmi.png"));
        menuRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamenti.png"));
        menuPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudget.png"));
        menuBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValuta.png"));
        menuCambioValuta.setIcon(imageCambioValuta);

        menuBarAzioni.add(menuMovimenti);
        menuBarAzioni.add(menuRisparmi);
        menuBarAzioni.add(menuPagamenti);
        menuBarAzioni.add(menuBudget);
        menuBarAzioni.add(menuCambioValuta);

        setLayout(new BorderLayout());

        add(panelSuperiore, BorderLayout.NORTH);
        add(menuBarAzioni, BorderLayout.SOUTH);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}