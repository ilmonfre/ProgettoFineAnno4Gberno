import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.net.URL;

public class HomeFrame extends JFrame{

    JLabel labelScrittaSuperiore;
    JPanel panelSuperiore;
    JButton buttonAccount, buttonTema;

    JPanel panelCentrale, panelSoldi, panelRadar, panelEntrate, panelUscite, panelMovimenti, panelPrimo, panelSecondo, panelTerzo, panelInternoPrimo, panelInternoSecondo, panelInternoTerzo;
    JLabel labelSoldi, labelDisponibilita, labelEntrateUMese, labelUsciteUMese, labelImageEntrate, labelImageUscite, labelEntrate, labelUscite;
    JLabel labelTipoPrimo, labelTipoSecondo, labelTipoTerzo, labelCostoPrimo, labelCostoSecondo, labelCostoTerzo, labelGiornoPrimo, labelGiornoSecondo, labelGiornoTerzo, labelIconaPrimo, labelIconaSecondo, labelIconaTerzo;
    ImageIcon imageEntrate, imageUscite;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna;

    public HomeFrame(){

        panelSuperiore = new JPanel();

        panelSuperiore.setLayout(new GridLayout(1, 3));
        panelSuperiore.setBackground(Color.decode("#CCFFFF"));

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

        panelSuperiore.add(buttonAccount);
        panelSuperiore.add(labelScrittaSuperiore);
        panelSuperiore.add(buttonTema);





        panelCentrale = new JPanel();
        panelCentrale.setBackground(Color.decode("#CCFFFF"));
        panelCentrale.setLayout(new GridLayout(3, 2));
        panelSoldi = new JPanel();
        panelSoldi.setBackground(Color.decode("#CCFFFF"));

        TitledBorder bordoDisponibilita = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Disponibilità");
        Font fontDisponibilita = new Font("Serif", Font.ITALIC, 20);

        bordoDisponibilita.setTitleFont(fontDisponibilita);

        panelSoldi.setBorder(bordoDisponibilita);

        labelSoldi = new JLabel();
        //labelSoldi.setText(GestioneSoldi.getSoldi()+"  €");
        
        panelSoldi.add(labelSoldi);

        panelRadar = new JPanel();
        panelRadar.setBackground(Color.decode("#CCFFFF"));
        panelEntrate = new JPanel();
        panelEntrate.setBackground(Color.decode("#CCFFFF"));
        panelUscite = new JPanel();
        panelUscite.setBackground(Color.decode("#CCFFFF"));

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
        //labelUscite.setText(GestioneDenaro.getUsciteUMese());

        panelEntrate.add(labelImageEntrate);
        panelEntrate.add(labelEntrate);

        panelUscite.add(labelImageUscite);
        panelUscite.add(labelUscite);

        panelRadar.setLayout(new GridLayout(1, 2));

        panelRadar.add(panelEntrate);
        panelRadar.add(panelUscite);

        panelMovimenti = new JPanel();
        panelMovimenti.setBackground(Color.decode("#CCFFFF"));

        panelPrimo = new JPanel();
        panelSecondo = new JPanel();
        panelTerzo = new JPanel();

        labelTipoPrimo = new JLabel();
        labelTipoSecondo = new JLabel();
        labelTipoTerzo = new JLabel();

        labelCostoPrimo = new JLabel();
        labelCostoSecondo = new JLabel();
        labelCostoTerzo = new JLabel();

        labelGiornoPrimo = new JLabel();
        labelGiornoSecondo = new JLabel();
        labelGiornoTerzo = new JLabel();

        labelIconaPrimo = new JLabel();
        labelIconaSecondo = new JLabel();
        labelIconaTerzo = new JLabel();
        
        /*
        if(Movimenti.getTipoPrimo().toLowerCase().equals("entrata")){

            labelTipoPrimo.setText("Entrata");
            labelCostoPrimo.setText(Movimenti.getCostoPrimo());
            Aggiungere giorno
            labelIconaPrimo.setIcon(imageEntrate);
        }else if(Movimenti.getTipoPrimo().toLowerCase().equals("uscita")){

            labelTipoPrimo.setText("Entrata");
            labelCostoPrimo.setText(Movimenti.getCostoPrimo());
            Aggiungere giorno
            labelIconaPrimo.setIcon(imageUscite);
        }

        if(Movimenti.getTipoSecondo().toLowerCase().equals("entrata")){

            labelTipoSecondo.setText("Entrata");
            labelCostoSecondo.setText(Movimenti.getCostoSecondo());
            Aggiungere giorno
            labelIconaSecondo.setIcon(imageEntrate);
        }else if(Movimenti.getTipoSecondo().toLowerCase().equals("uscita")){

            labelTipoSecondo.setText("Entrata");
            labelCostoSecondo.setText(Movimenti.getCostoSecondo());
            Aggiungere giorno
            labelIconaSecondo.setIcon(imageUscite);
        }
            
        if(Movimenti.getTipoTerzo().toLowerCase().equals("entrata")){

            labelTipoTerzo.setText("Entrata");
            labelCostoTerzo.setText(Movimenti.getCostoTerzo());
            Aggiungere giorno
            labelIconaTerzo.setIcon(imageEntrate);
        }else if(Movimenti.getTipoTerzo().toLowerCase().equals("uscita")){

            labelTipoTerzo.setText("Entrata");
            labelCostoTerzo.setText(Movimenti.getCostoTerzo());
            Aggiungere giorno
            labelIconaTerzo.setIcon(imageUscite);
        }
        */

        panelPrimo.setLayout(new BorderLayout());
        panelPrimo.setBackground(Color.decode("#CCFFFF"));

        panelInternoPrimo = new JPanel();
        panelInternoPrimo.setBackground(Color.decode("#CCFFFF"));

        panelInternoPrimo.setLayout(new GridLayout(1, 2));
        panelInternoPrimo.add(labelGiornoPrimo);
        panelInternoPrimo.add(labelTipoPrimo);

        panelPrimo.add(labelIconaPrimo, BorderLayout.WEST);
        panelPrimo.add(labelCostoPrimo, BorderLayout.NORTH);
        panelPrimo.add(panelInternoPrimo, BorderLayout.CENTER);
        
        panelSecondo.setLayout(new BorderLayout());
        panelSecondo.setBackground(Color.decode("#CCFFFF"));

        panelInternoSecondo = new JPanel();
        panelInternoSecondo.setBackground(Color.decode("#CCFFFF"));

        panelInternoSecondo.setLayout(new GridLayout(1, 2));
        panelInternoSecondo.add(labelGiornoSecondo);
        panelInternoSecondo.add(labelTipoSecondo);

        panelSecondo.add(labelIconaSecondo, BorderLayout.WEST);
        panelSecondo.add(labelCostoSecondo, BorderLayout.NORTH);
        panelSecondo.add(panelInternoSecondo, BorderLayout.CENTER);

        panelTerzo.setLayout(new BorderLayout());
        panelTerzo.setBackground(Color.decode("#CCFFFF"));

        panelInternoTerzo = new JPanel();
        panelInternoTerzo.setBackground(Color.decode("#CCFFFF"));

        panelInternoTerzo.setLayout(new GridLayout(1, 2));
        panelInternoTerzo.add(labelGiornoTerzo);
        panelInternoTerzo.add(labelTipoTerzo);

        panelTerzo.add(labelIconaTerzo, BorderLayout.WEST);
        panelTerzo.add(labelCostoTerzo, BorderLayout.NORTH);
        panelTerzo.add(panelInternoTerzo, BorderLayout.CENTER);

        TitledBorder bordoMovimenti = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Ultimi movimenti");

        bordoMovimenti.setTitleFont(fontRadar);

        panelMovimenti.setBorder(bordoMovimenti);

        panelMovimenti.setLayout(new BorderLayout());

        panelMovimenti.add(panelPrimo, BorderLayout.NORTH);
        panelMovimenti.add(panelSecondo, BorderLayout.CENTER);
        panelMovimenti.add(panelTerzo, BorderLayout.SOUTH);

        panelCentrale.add(panelSoldi);
        panelCentrale.add(panelRadar);
        panelCentrale.add(panelMovimenti);





        imageMovimenti = new ImageIcon();
        imageRisparmi = new ImageIcon();
        imagePagamenti = new ImageIcon();
        imageBudget = new ImageIcon();
        imageCambioValuta = new ImageIcon();

        panelBar = new JPanel();
        panelBar.setLayout(new GridLayout(1, 5));
        panelBar.setBackground(Color.decode("#CCFFFF"));

        buttonMovimenti = new JButton();
        buttonPagamenti = new JButton();
        buttonRisparmi = new JButton();
        buttonBudget = new JButton();
        buttonCambioValuta = new JButton();

        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimenti.png"));
        buttonMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmi.png"));
        buttonRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamenti.png"));
        buttonPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudget.png"));
        buttonBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValuta.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        buttonMovimenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new MovimentiFrame();
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new PagamentiFrame();
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new RisparmiFrame();
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new CambioValutaFrame();
            }
        });

        buttonBudget.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                //new BudgetFrame();
            }
        });

        buttonMovimenti.setOpaque(false);
        buttonMovimenti.setContentAreaFilled(false);
        buttonMovimenti.setBorderPainted(false);
        buttonMovimenti.setFocusPainted(false);

        buttonPagamenti.setOpaque(false);
        buttonPagamenti.setContentAreaFilled(false);
        buttonPagamenti.setBorderPainted(false);
        buttonPagamenti.setFocusPainted(false);

        buttonRisparmi.setOpaque(false);
        buttonRisparmi.setContentAreaFilled(false);
        buttonRisparmi.setBorderPainted(false);
        buttonRisparmi.setFocusPainted(false);

        buttonCambioValuta.setOpaque(false);
        buttonCambioValuta.setContentAreaFilled(false);
        buttonCambioValuta.setBorderPainted(false);
        buttonCambioValuta.setFocusPainted(false);

        buttonBudget.setOpaque(false);
        buttonBudget.setContentAreaFilled(false);
        buttonBudget.setBorderPainted(false);
        buttonBudget.setFocusPainted(false);

        panelBar.add(buttonMovimenti);
        panelBar.add(buttonPagamenti);
        panelBar.add(buttonRisparmi);
        panelBar.add(buttonCambioValuta);
        panelBar.add(buttonBudget);

        setLayout(new BorderLayout());

        add(panelSuperiore, BorderLayout.NORTH);
        add(panelCentrale, BorderLayout.CENTER);
        add(panelBar, BorderLayout.SOUTH);

        buttonTema.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

                if(buttonTema.getIcon().equals(imageLuna)){

                    panelSuperiore.setBackground(Color.decode("#336699"));
                    buttonAccount.setForeground(Color.decode("#336699"));
                    buttonTema.setForeground(Color.decode("#336699"));
                    panelCentrale.setBackground(Color.decode("#336699"));
                    panelSoldi.setBackground(Color.decode("#336699"));
                    bordoDisponibilita.setTitleColor(Color.decode("#336699"));
                    bordoDisponibilita.setBorder(BorderFactory.createLineBorder(Color.decode("#336699"), 2));
                    labelSoldi.setForeground(Color.decode("#336699"));

                    panelRadar.setBackground(Color.decode("#336699"));
                    bordoRadar.setTitleColor(Color.decode("#336699"));
                    bordoRadar.setBorder(BorderFactory.createLineBorder(Color.decode("#336699"), 2));
                    bordoEntrate.setTitleColor(Color.decode("#336699"));
                    bordoEntrate.setBorder(BorderFactory.createLineBorder(Color.decode("#336699"), 2));
                    URL url = getClass().getResource("/Immagini/IconaFrecciaAzzurrina.png");
                    Image imageTmp = new ImageIcon(url).getImage();
                    imageEntrate.setImage(imageTmp);
                    
                    bordoUscite.setTitleColor(Color.decode("#336699"));
                    bordoUscite.setBorder(BorderFactory.createLineBorder(Color.decode("#336699"), 2));
                    panelEntrate.setBackground(Color.decode("#336699"));
                    panelUscite.setBackground(Color.decode("#336699"));

                    panelMovimenti.setBackground(Color.decode("#336699"));
                    panelPrimo.setBackground(Color.decode("#336699"));
                    panelInternoPrimo.setBackground(Color.decode("#336699"));
                    panelSecondo.setBackground(Color.decode("#336699"));
                    panelInternoSecondo.setBackground(Color.decode("#336699"));
                    panelTerzo.setBackground(Color.decode("#336699"));
                    panelInternoTerzo.setBackground(Color.decode("#336699"));
                    panelBar.setBackground(Color.decode("#336699"));
                    buttonTema.setIcon(imageSole);
                }else{

                    panelSuperiore.setBackground(Color.decode("#CCFFFF"));
                    panelCentrale.setBackground(Color.decode("#CCFFFF"));
                    panelSoldi.setBackground(Color.decode("#CCFFFF"));
                    panelRadar.setBackground(Color.decode("#CCFFFF"));
                    panelEntrate.setBackground(Color.decode("#CCFFFF"));
                    panelUscite.setBackground(Color.decode("#CCFFFF"));
                    panelMovimenti.setBackground(Color.decode("#CCFFFF"));
                    panelPrimo.setBackground(Color.decode("#CCFFFF"));
                    panelInternoPrimo.setBackground(Color.decode("#CCFFFF"));
                    panelSecondo.setBackground(Color.decode("#CCFFFF"));
                    panelInternoSecondo.setBackground(Color.decode("#CCFFFF"));
                    panelTerzo.setBackground(Color.decode("#CCFFFF"));
                    panelInternoTerzo.setBackground(Color.decode("#CCFFFF"));
                    panelBar.setBackground(Color.decode("#CCFFFF"));
                    buttonTema.setIcon(imageLuna);
                }
            }
        });

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}