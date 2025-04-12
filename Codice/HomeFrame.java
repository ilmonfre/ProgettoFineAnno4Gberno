import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;

public class HomeFrame extends JFrame{

    JLabel labelScrittaSuperiore;
    JPanel panelSuperiore, panelAccount, panelSole, panelLuna;
    JButton buttonAccount, buttonTema;

    JPanel panelCentrale, panelSoldi, panelRadar, panelEntrate, panelUscite, panelUMovimenti, panelPrimo, panelSecondo, panelTerzo;
    JLabel labelSoldi, labelDisponibilita, labelEntrateUMese, labelUsciteUMese, labelImageEntrate, labelImageUscite, labelEntrate, labelUscite;
    JLabel labelTipoPrimo, labelTipoSecondo, labelTipoTerzo, labelCostoPrimo, labelCostoSecondo, labelCostoTerzo, labelGiornoPrimo, labelGiornoSecondo, labelGiornoTerzo;
    ImageIcon imageEntrate, imageUscite;

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





        panelCentrale = new JPanel();
        panelCentrale.setLayout(new GridLayout(3, 2));
        panelSoldi = new JPanel();

        TitledBorder bordoDisponibilita = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Disponibilità");
        Font fontDisponibilita = new Font("Serif", Font.ITALIC, 20);

        bordoDisponibilita.setTitleFont(fontDisponibilita);

        panelSoldi.setBorder(bordoDisponibilita);

        labelSoldi = new JLabel();
        //labelSoldi.setText(GestioneSoldi.getSoldi()+"  €");
        
        panelSoldi.add(labelSoldi);

        panelRadar = new JPanel();
        panelEntrate = new JPanel();
        panelUscite = new JPanel();

        TitledBorder bordoRadar = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Radar");
        Font fontRadar = new Font("Serif", Font.ITALIC, 20);

        bordoRadar.setTitleFont(fontRadar);

        panelRadar.setBorder(bordoRadar);

        TitledBorder bordoEntrate = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Entrate");
        TitledBorder bordoUscite = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Uscite");

        bordoEntrate.setTitleFont(fontRadar);
        bordoEntrate.setTitleJustification(TitledBorder.CENTER);

        bordoUscite.setTitleFont(fontRadar);
        bordoUscite.setTitleJustification(TitledBorder.CENTER);

        panelEntrate.setBorder(bordoEntrate);
        panelUscite.setBorder(bordoUscite);
        
        labelEntrateUMese = new JLabel();
        labelUsciteUMese = new JLabel();

        panelEntrate.setLayout(new GridLayout(1, 2));
        panelUscite.setLayout(new GridLayout(1, 2));

        imageEntrate = new ImageIcon();
        imageUscite = new ImageIcon();

        imageEntrate = new ImageIcon(getClass().getResource("/Immagini/IconaEntrate.png"));
        imageUscite = new ImageIcon(getClass().getResource("/Immagini/IconaUscite.png"));

        labelImageEntrate = new JLabel(imageEntrate);
        labelImageUscite = new JLabel(imageUscite);

        labelEntrate = new JLabel();
        labelUscite = new JLabel();

        //labelEntrate.setText(GestioneDenaro.getEntrateUMese());
        //labelEntrate.setText(GestioneDenaro.getUsciteUMese());

        panelEntrate.add(labelImageEntrate);
        panelEntrate.add(labelEntrate);

        panelUscite.add(labelImageUscite);
        panelUscite.add(labelUscite);

        panelRadar.setLayout(new GridLayout(1, 2));

        panelRadar.add(panelEntrate);
        panelRadar.add(panelUscite);

        panelMovimenti = new JPanel();

        panelPrimo = new JPanel();
        panelSecondo = new JPanel();
        panelTerzo = new JPanel();

        

        panelCentrale.add(panelSoldi);
        panelCentrale.add(panelRadar);





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
        add(panelCentrale, BorderLayout.CENTER);
        add(menuBarAzioni, BorderLayout.SOUTH);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}