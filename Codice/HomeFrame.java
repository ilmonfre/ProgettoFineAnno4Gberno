import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.net.URL;

public class HomeFrame extends JFrame{

    int tema=0; // 0 = chiaro 1 = scuro

    Budget budget;
    Movimenti movimenti = new Movimenti(0, 0, 0, budget);
    private String email;
    private String pass;

    TitledBorder titoloDisponibilita, titoloRadar, titoloEntrate, titoloUscite, titoloMovimenti;

    JLabel labelScrittaSuperiore;
    JPanel panelSuperiore;
    JButton buttonAccount, buttonTema;

    JPanel panelCentrale, panelSoldi, panelRadar, panelEntrate, panelUscite, panelMovimenti, panelPrimo, panelSecondo, panelTerzo, panelInternoPrimo, panelInternoSecondo, panelInternoTerzo, panelSpecPrimo, panelSpecSecondo, panelSpecTerzo;
    JLabel labelSoldi, labelDisponibilita, labelEntrateUMese, labelUsciteUMese, labelImageEntrate, labelImageUscite, labelEntrate, labelUscite;
    JLabel labelTipoPrimo, labelTipoSecondo, labelTipoTerzo, labelCostoPrimo, labelCostoSecondo, labelCostoTerzo, labelGiornoPrimo, labelGiornoSecondo, labelGiornoTerzo, labelIconaPrimo, labelIconaSecondo, labelIconaTerzo, labelCategoriaPrimo, labelCategoriaSecondo, labelCategoriaTerzo, labelUtentePrimo, labelUtenteSecondo, labelUtenteTerzo;
    ImageIcon imageEntrate, imageUscite, imagePrimo, imageSecondo, imageTerzo;

    JLabel labelAccount, labelMovimenti, labelRisparmi, labelPagamenti, labelBudget, labelCambioValuta, labelSole, labelLuna, labelHome;
    JPanel panelBar;
    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon imageAccount, imageMovimenti, imageRisparmi, imagePagamenti, imageBudget, imageCambioValuta, imageSole, imageLuna, imageHome;

    ImageIcon iconaHomeChiara, iconaMovimentiChiara, iconaPagamentiChiara, iconaRisparmiChiara, iconaCambioValutaChiara, iconaBudgetChiara, iconaHomeScura, iconaMovimentiScura, iconaPagamentiScura, iconaRisparmiScura, iconaCambioValutaScura, iconaBudgetScura;

    public HomeFrame(){

        setTitle("Zaphyra Bank - Home");

        String basePath = "/Immagini/";// Icone tema chiaro
        iconaHomeChiara = new ImageIcon(getClass().getResource(basePath + "IconaHomeChiaraPiena.png"));
        iconaMovimentiChiara = new ImageIcon(getClass().getResource(basePath + "IconaMovimentiChiara.png"));
        iconaPagamentiChiara = new ImageIcon(getClass().getResource(basePath + "IconaPagamentiChiara.png"));
        iconaRisparmiChiara = new ImageIcon(getClass().getResource(basePath + "IconaRisparmiChiara.png"));
        iconaCambioValutaChiara = new ImageIcon(getClass().getResource(basePath + "IconaCambioValutaChiara.png"));
        iconaBudgetChiara = new ImageIcon(getClass().getResource(basePath + "IconaBudgetChiara.png"));

        // Icone tema scuro
        iconaHomeScura = new ImageIcon(getClass().getResource(basePath + "IconaHomeScuraPiena.png"));
        iconaMovimentiScura = new ImageIcon(getClass().getResource(basePath + "IconaMovimentiScura.png"));
        iconaPagamentiScura = new ImageIcon(getClass().getResource(basePath + "IconaPagamentiScura.png"));
        iconaRisparmiScura = new ImageIcon(getClass().getResource(basePath + "IconaRisparmiScura.png"));
        iconaCambioValutaScura = new ImageIcon(getClass().getResource(basePath + "IconaCambioValutaScura.png"));
        iconaBudgetScura = new ImageIcon(getClass().getResource(basePath + "IconaBudgetScura.png"));
        
        panelSuperiore = new JPanel();

        panelSuperiore.setLayout(new GridLayout(1, 3));
        panelSuperiore.setBackground(Color.decode("#cbf4f4"));

        imageAccount = new ImageIcon();
        imageSole = new ImageIcon();
        imageLuna = new ImageIcon();

        imageAccount = new ImageIcon(getClass().getResource("/Immagini/IconaAccountScura.png"));
        imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));
        imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));

        labelScrittaSuperiore = new JLabel("ZaphiraBank");
        labelScrittaSuperiore.setForeground(Color.decode("#1c2697"));

        try {

            InputStream is = getClass().getResourceAsStream("/Font/PlayfairDisplayRegular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(32f);
            labelScrittaSuperiore.setFont(font);
            labelScrittaSuperiore.setHorizontalAlignment(SwingConstants.CENTER);
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

                new FrameAccount();
            }
        });

        panelSuperiore.add(buttonAccount);
        panelSuperiore.add(labelScrittaSuperiore);
        panelSuperiore.add(buttonTema);





        panelCentrale = new JPanel();
        panelCentrale.setBackground(Color.decode("#cbf4f4"));
        panelCentrale.setLayout(new GridLayout(3, 2));
        panelSoldi = new JPanel();
        panelSoldi.setBackground(Color.decode("#cbf4f4"));

        RoundedBorder bordoDisponibilita = new RoundedBorder(2, 20, 20, Color.decode("#1c2697"));
        TitledBorder titoloDisponibilita = new TitledBorder(bordoDisponibilita, "Disponibilità");
        titoloDisponibilita.setTitleColor(Color.decode("#1c2697"));
        titoloDisponibilita.setTitleFont(new Font("Arial", Font.BOLD, 20));

        panelSoldi.setBorder(titoloDisponibilita);

        labelSoldi = new JLabel();
        labelSoldi.setText(movimenti.getSoldiConto()+" €");
        labelSoldi.setFont(new Font("Arial", Font.BOLD, 28));
        labelSoldi.setForeground(Color.decode("#1c2697"));
        
        panelSoldi.add(labelSoldi);

        panelRadar = new JPanel();
        panelRadar.setBackground(Color.decode("#cbf4f4"));
        panelEntrate = new JPanel();
        panelEntrate.setBackground(Color.decode("#cbf4f4"));
        panelUscite = new JPanel();
        panelUscite.setBackground(Color.decode("#cbf4f4"));

        RoundedBorder bordoRadar = new RoundedBorder(2, 20, 20, Color.decode("#1c2697"));
        TitledBorder titoloRadar = new TitledBorder(bordoRadar, "Radar mensile");
        titoloRadar.setTitleColor(Color.decode("#1c2697"));
        titoloRadar.setTitleFont(new Font("Arial", Font.BOLD, 20));

        panelRadar.setBorder(titoloRadar);

        RoundedBorder bordoEntrate = new RoundedBorder(2, 20, 20, Color.decode("#1c2697"));
        TitledBorder titoloEntrate = new TitledBorder(bordoEntrate, "Entrate");
        titoloEntrate.setTitleColor(Color.decode("#1c2697"));
        titoloEntrate.setTitleFont(new Font("Arial", Font.BOLD, 20));
        titoloEntrate.setTitleJustification(TitledBorder.CENTER);

        panelEntrate.setBorder(titoloEntrate);

        RoundedBorder bordoUscite = new RoundedBorder(2, 20, 20, Color.decode("#be1327"));
        TitledBorder titoloUscite = new TitledBorder(bordoUscite, "Uscite");
        titoloUscite.setTitleColor(Color.decode("#be1327"));
        titoloUscite.setTitleFont(new Font("Arial", Font.BOLD, 20));
        titoloUscite.setTitleJustification(TitledBorder.CENTER);

        panelUscite.setBorder(titoloUscite);
        
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
        labelEntrate.setForeground(Color.decode("#1c2697"));
        labelUscite = new JLabel();
        labelUscite.setForeground(Color.decode("#be1327"));

        double entrateUMese = movimenti.calcolaEntrateUMese();
        labelEntrate.setText(String.valueOf(entrateUMese)+" €");
        double usciteUMese = movimenti.calcolaUsciteUMese();
        labelUscite.setText(String.valueOf(usciteUMese)+" €");

        labelEntrate.setFont(new Font("Arial", Font.BOLD, 28));
        labelUscite.setFont(new Font("Arial", Font.BOLD, 28));

        panelEntrate.add(labelImageEntrate);
        panelEntrate.add(labelEntrate);

        panelUscite.add(labelImageUscite);
        panelUscite.add(labelUscite);

        panelRadar.setLayout(new GridLayout(1, 2));

        panelRadar.add(panelEntrate);
        panelRadar.add(panelUscite);

        panelMovimenti = new JPanel();
        panelMovimenti.setBackground(Color.decode("#cbf4f4"));

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

        labelCategoriaPrimo = new JLabel();
        labelCategoriaSecondo = new JLabel();
        labelCategoriaTerzo = new JLabel();

        labelUtentePrimo = new JLabel();
        labelUtenteSecondo = new JLabel();
        labelUtenteTerzo = new JLabel();
        
        Movimento primo = movimenti.calcoloPrimo();
        Movimento secondo = movimenti.calcoloSecondo();
        Movimento terzo = movimenti.calcoloTerzo();

        if(primo!=null){

            if(primo.getTipo().toLowerCase().equals("entrata")){

                labelTipoPrimo.setText("Tipo: Entrata");
                String costoPrimo=String.valueOf(primo.getCosto());
                labelCostoPrimo.setText(costoPrimo+"€");
                String dataPrimo=String.valueOf(primo.getData());
                labelGiornoPrimo.setText("Data: "+dataPrimo);
                labelCategoriaPrimo.setText("Categoria: "+primo.getCategoria());
                labelUtentePrimo.setText("Da: "+primo.getUtente());
                imagePrimo = new ImageIcon(getClass().getResource("/Immagini/IconaEntrate.png"));
                labelIconaPrimo.setIcon(imagePrimo);
                labelTipoPrimo = new JLabel();

                labelTipoPrimo.setForeground(Color.decode("#1c2697"));
                labelCostoPrimo.setForeground(Color.decode("#1c2697"));
                labelGiornoPrimo.setForeground(Color.decode("#1c2697"));
                labelCategoriaPrimo.setForeground(Color.decode("#1c2697"));
                labelUtentePrimo.setForeground(Color.decode("#1c2697"));
            }else if(primo.getTipo().toLowerCase().equals("uscita")){
    
                labelTipoPrimo.setText("Tipo: Entrata");
                String costoPrimo=String.valueOf(primo.getCosto());
                labelCostoPrimo.setText(costoPrimo+"€");
                String dataPrimo=String.valueOf(primo.getData());
                labelGiornoPrimo.setText("Data: "+dataPrimo);
                labelCategoriaPrimo.setText("Categoria: "+primo.getCategoria());
                labelUtentePrimo.setText("A: "+primo.getUtente());
                imagePrimo = new ImageIcon(getClass().getResource("/Immagini/IconaUscite.png"));
                labelIconaPrimo.setIcon(imagePrimo);

                labelTipoPrimo.setForeground(Color.decode("#be1327"));
                labelCostoPrimo.setForeground(Color.decode("#be1327"));
                labelGiornoPrimo.setForeground(Color.decode("#be1327"));
                labelCategoriaPrimo.setForeground(Color.decode("#be1327"));
                labelUtentePrimo.setForeground(Color.decode("#be1327"));
            }
        }

        if(secondo!=null){

            if(secondo.getTipo().toLowerCase().equals("entrata")){

                labelTipoSecondo.setText("Tipo: Entrata");
                String costoSecondo=String.valueOf(secondo.getCosto());
                labelCostoSecondo.setText(costoSecondo+"€");
                String dataSecondo=String.valueOf(secondo.getData());
                labelGiornoSecondo.setText("Data: "+dataSecondo);
                labelCategoriaSecondo.setText("Categoria: "+secondo.getCategoria());
                labelUtenteSecondo.setText("Da: "+secondo.getUtente());
                imageSecondo = new ImageIcon(getClass().getResource("/Immagini/IconaEntrate.png"));
                labelIconaSecondo.setIcon(imageSecondo);

                labelTipoSecondo.setForeground(Color.decode("#1c2697"));
                labelCostoSecondo.setForeground(Color.decode("#1c2697"));
                labelGiornoSecondo.setForeground(Color.decode("#1c2697"));
                labelCategoriaSecondo.setForeground(Color.decode("#1c2697"));
                labelUtenteSecondo.setForeground(Color.decode("#1c2697"));
            }else if(secondo.getTipo().toLowerCase().equals("uscita")){
    
                labelTipoSecondo.setText("Tipo: Entrata");
                String costoSecondo=String.valueOf(secondo.getCosto());
                labelCostoSecondo.setText(costoSecondo+"€");
                String dataSecondo=String.valueOf(secondo.getData());
                labelGiornoSecondo.setText("Data: "+dataSecondo);
                labelCategoriaSecondo.setText("Categoria: "+secondo.getCategoria());
                labelUtenteSecondo.setText("A: "+secondo.getUtente());
                imageSecondo = new ImageIcon(getClass().getResource("/Immagini/IconaUscite.png"));
                labelIconaSecondo.setIcon(imageSecondo);

                labelTipoSecondo.setForeground(Color.decode("#be1327"));
                labelCostoSecondo.setForeground(Color.decode("#be1327"));
                labelGiornoSecondo.setForeground(Color.decode("#be1327"));
                labelCategoriaSecondo.setForeground(Color.decode("#be1327"));
                labelUtenteSecondo.setForeground(Color.decode("#be1327"));
            }
        }

        if(terzo!=null){

            if(terzo.getTipo().toLowerCase().equals("entrata")){

                labelTipoTerzo.setText("Tipo: Entrata");
                String costoTerzo=String.valueOf(terzo.getCosto());
                labelCostoTerzo.setText(costoTerzo+"€");
                String dataTerzo=String.valueOf(terzo.getData());
                labelGiornoTerzo.setText("Data: "+dataTerzo);
                labelCategoriaTerzo.setText("Categoria: "+terzo.getCategoria());
                labelUtenteTerzo.setText("Da: "+terzo.getUtente());
                imageTerzo = new ImageIcon(getClass().getResource("/Immagini/IconaEntrate.png"));
                labelIconaTerzo.setIcon(imageTerzo);

                labelTipoTerzo.setForeground(Color.decode("#1c2697"));
                labelCostoTerzo.setForeground(Color.decode("#1c2697"));
                labelGiornoTerzo.setForeground(Color.decode("#1c2697"));
                labelCategoriaTerzo.setForeground(Color.decode("#1c2697"));
                labelUtenteTerzo.setForeground(Color.decode("#1c2697"));
            }else if(terzo.getTipo().toLowerCase().equals("uscita")){
    
                labelTipoTerzo.setText("Tipo: Entrata");
                String costoTerzo=String.valueOf(terzo.getCosto());
                labelCostoTerzo.setText(costoTerzo+"€");
                String dataTerzo=String.valueOf(terzo.getData());
                labelGiornoTerzo.setText("Data: "+dataTerzo);
                labelCategoriaTerzo.setText("Categoria: "+terzo.getCategoria());
                labelUtenteTerzo.setText("A: "+terzo.getUtente());
                imageTerzo = new ImageIcon(getClass().getResource("/Immagini/IconaUscite.png"));
                labelIconaTerzo.setIcon(imageTerzo);

                labelTipoTerzo.setForeground(Color.decode("#be1327"));
                labelCostoTerzo.setForeground(Color.decode("#be1327"));
                labelGiornoTerzo.setForeground(Color.decode("#be1327"));
                labelCategoriaTerzo.setForeground(Color.decode("#be1327"));
                labelUtenteTerzo.setForeground(Color.decode("#be1327"));
            }
        }

        panelPrimo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        panelPrimo.setBackground(Color.decode("#cbf4f4"));

        panelInternoPrimo = new JPanel(new GridLayout(2, 1, 5, 5)); 
        panelInternoPrimo.setBackground(Color.decode("#cbf4f4"));

        panelSpecPrimo = new JPanel(new GridLayout(1, 4, 5, 5)); 
        panelSpecPrimo.setBackground(Color.decode("#cbf4f4"));

        labelCostoPrimo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTipoPrimo.setFont(new Font("Arial", Font.BOLD, 16));
        labelGiornoPrimo.setFont(new Font("Arial", Font.BOLD, 16));
        labelCategoriaPrimo.setFont(new Font("Arial", Font.BOLD, 16));
        labelUtentePrimo.setFont(new Font("Arial", Font.BOLD, 16));

        panelSpecPrimo.add(labelTipoPrimo);
        panelSpecPrimo.add(labelGiornoPrimo);
        panelSpecPrimo.add(labelCategoriaPrimo);
        panelSpecPrimo.add(labelUtentePrimo);

        panelInternoPrimo.add(labelCostoPrimo);
        panelInternoPrimo.add(panelSpecPrimo);

        panelPrimo.add(labelIconaPrimo);
        panelPrimo.add(panelInternoPrimo);
        
        panelSecondo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        panelSecondo.setBackground(Color.decode("#cbf4f4"));

        panelInternoSecondo = new JPanel(new GridLayout(2, 1, 5, 5)); 
        panelInternoSecondo.setBackground(Color.decode("#cbf4f4"));

        panelSpecSecondo = new JPanel(new GridLayout(1, 4, 5, 5)); 
        panelSpecSecondo.setBackground(Color.decode("#cbf4f4"));

        labelCostoSecondo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTipoSecondo.setFont(new Font("Arial", Font.BOLD, 16));
        labelGiornoSecondo.setFont(new Font("Arial", Font.BOLD, 16));
        labelCategoriaSecondo.setFont(new Font("Arial", Font.BOLD, 16));
        labelUtenteSecondo.setFont(new Font("Arial", Font.BOLD, 16));

        panelSpecSecondo.add(labelTipoSecondo);
        panelSpecSecondo.add(labelGiornoSecondo);
        panelSpecSecondo.add(labelCategoriaSecondo);
        panelSpecSecondo.add(labelUtenteSecondo);

        panelInternoSecondo.add(labelCostoSecondo);
        panelInternoSecondo.add(panelSpecSecondo);

        panelSecondo.add(labelIconaSecondo);
        panelSecondo.add(panelInternoSecondo);

        panelTerzo = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        panelTerzo.setBackground(Color.decode("#cbf4f4"));

        panelInternoTerzo = new JPanel(new GridLayout(2, 1, 5, 5)); 
        panelInternoTerzo.setBackground(Color.decode("#cbf4f4"));

        panelSpecTerzo = new JPanel(new GridLayout(1, 4, 5, 5)); 
        panelSpecTerzo.setBackground(Color.decode("#cbf4f4"));

        labelCostoTerzo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTipoTerzo.setFont(new Font("Arial", Font.BOLD, 16));
        labelGiornoTerzo.setFont(new Font("Arial", Font.BOLD, 16));
        labelCategoriaTerzo.setFont(new Font("Arial", Font.BOLD, 16));
        labelUtenteTerzo.setFont(new Font("Arial", Font.BOLD, 16));

        panelSpecTerzo.add(labelTipoTerzo);
        panelSpecTerzo.add(labelGiornoTerzo);
        panelSpecTerzo.add(labelCategoriaTerzo);
        panelSpecTerzo.add(labelUtenteTerzo);

        panelInternoTerzo.add(labelCostoTerzo);
        panelInternoTerzo.add(panelSpecTerzo);

        panelTerzo.add(labelIconaTerzo);
        panelTerzo.add(panelInternoTerzo);

        RoundedBorder bordoMovimenti = new RoundedBorder(2, 20, 20, Color.decode("#1c2697"));
        TitledBorder titoloMovimenti = new TitledBorder(bordoMovimenti, "Ultimi movimenti");
        titoloMovimenti.setTitleColor(Color.decode("#1c2697"));
        titoloMovimenti.setTitleFont(new Font("Arial", Font.BOLD, 20));

        panelMovimenti.setBorder(titoloMovimenti);

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
        panelBar.setLayout(new GridLayout(1, 6));
        panelBar.setBackground(Color.decode("#cbf4f4"));

        buttonHome = new JButton();
        buttonMovimenti = new JButton();
        buttonPagamenti = new JButton();
        buttonRisparmi = new JButton();
        buttonBudget = new JButton();
        buttonCambioValuta = new JButton();

        imageHome = new ImageIcon(getClass().getResource("/Immagini/IconaHomeScuraPiena.png"));
        buttonHome.setIcon(imageHome);
        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiScura.png"));
        buttonMovimenti.setIcon(imageMovimenti);
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiScura.png"));
        buttonRisparmi.setIcon(imageRisparmi);
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScura.png"));
        buttonPagamenti.setIcon(imagePagamenti);
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScura.png"));
        buttonBudget.setIcon(imageBudget);
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScura.png"));
        buttonCambioValuta.setIcon(imageCambioValuta);

        buttonMovimenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameMovimenti();
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
                new FrameRisparmi();
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

        buttonHome.setOpaque(false);
        buttonHome.setContentAreaFilled(false);
        buttonHome.setBorderPainted(false);
        buttonHome.setFocusPainted(false);

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

        panelBar.add(buttonHome);
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

                if(tema==0){

                    tema=1;
                }else{

                    tema=0;
                }

                if (tema==1) {
                    // Tema Scuro
                    buttonTema.setIcon(imageSole);
                    panelSuperiore.setBackground(Color.decode("#1c2697"));
                    buttonAccount.setForeground(Color.WHITE);
                    buttonTema.setForeground(Color.WHITE);
                    panelCentrale.setBackground(Color.decode("#1c2697"));
                    panelSoldi.setBackground(Color.decode("#1c2697"));
                    //bordoDisponibilita.setTitleColor(Color.WHITE);
                    //bordoDisponibilita.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    labelSoldi.setForeground(Color.WHITE);
                    URL urlAccount = getClass().getResource("/Immagini/IconaAccountChiara.png");
                    Image imageTmpAccount = new ImageIcon(urlAccount).getImage();
                    imageAccount.setImage(imageTmpAccount);
                    labelScrittaSuperiore.setForeground(Color.WHITE);

                    panelRadar.setBackground(Color.decode("#1c2697"));
                    //bordoRadar.setTitleColor(Color.WHITE);
                    //bordoRadar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    //bordoEntrate.setTitleColor(Color.WHITE);
                    //bordoEntrate.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    URL urlFreccia = getClass().getResource("/Immagini/IconaFrecciaAzzurrina.png");
                    Image imageTmpFreccia = new ImageIcon(urlFreccia).getImage();
                    imageEntrate.setImage(imageTmpFreccia);
                    
                    //bordoUscite.setTitleColor(Color.WHITE);
                    //bordoUscite.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    panelEntrate.setBackground(Color.decode("#1c2697"));
                    panelUscite.setBackground(Color.decode("#1c2697"));

                    panelMovimenti.setBackground(Color.decode("#1c2697"));
                    panelPrimo.setBackground(Color.decode("#1c2697"));
                    panelInternoPrimo.setBackground(Color.decode("#1c2697"));
                    panelSecondo.setBackground(Color.decode("#1c2697"));
                    panelInternoSecondo.setBackground(Color.decode("#1c2697"));
                    panelTerzo.setBackground(Color.decode("#1c2697"));
                    panelInternoTerzo.setBackground(Color.decode("#1c2697"));
                    panelBar.setBackground(Color.decode("#1c2697"));
                    labelTipoPrimo.setForeground(Color.WHITE);
                    labelCostoPrimo.setForeground(Color.WHITE);
                    labelGiornoPrimo.setForeground(Color.WHITE);
                    /*
                    if(!labelIconaPrimo.getIcon().equals(imageUscite)){
                        
                        Image imageTmpPrimo = new ImageIcon(urlFreccia).getImage();
                        labelIconaPrimo.setIcon(new ImageIcon(imageTmpPrimo));
                    }
                    labelTipoSecondo.setForeground(Color.WHITE);
                    labelCostoSecondo.setForeground(Color.WHITE);
                    labelGiornoSecondo.setForeground(Color.WHITE);
                    if(!labelIconaSecondo.getIcon().equals(imageUscite)){
                        
                        Image imageTmpSecondo = new ImageIcon(urlFreccia).getImage();
                        labelIconaSecondo.setIcon(new ImageIcon(imageTmpSecondo));
                    }
                    labelTipoTerzo.setForeground(Color.WHITE);
                    labelCostoTerzo.setForeground(Color.WHITE);
                    labelGiornoTerzo.setForeground(Color.WHITE);
                    if(!labelIconaTerzo.getIcon().equals(imageUscite)){
                        
                        Image imageTmpTerzo = new ImageIcon(urlFreccia).getImage();
                        labelIconaTerzo.setIcon(new ImageIcon(imageTmpTerzo));
                    }
                    */
                    //bordoMovimenti.setTitleColor(Color.WHITE);
                    //bordoMovimenti.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

                    ImageIcon imageHomeBianca = new ImageIcon(getClass().getResource("/Immagini/IconaHomeChiaraPiena.png"));
                    buttonHome.setIcon(imageHomeBianca);
                    ImageIcon imageMovimentiBianca = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiChiara.png"));
                    buttonMovimenti.setIcon(imageMovimentiBianca);
                    ImageIcon imagePagamentiBianca = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiChiara.png"));
                    buttonPagamenti.setIcon(imagePagamentiBianca);
                    ImageIcon imageRisparmiBianca = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiChiara.png"));
                    buttonRisparmi.setIcon(imageRisparmiBianca);
                    ImageIcon imageCambioValutaBianca = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaChiara.png"));
                    buttonCambioValuta.setIcon(imageCambioValutaBianca);
                    ImageIcon imageBudgetBianca = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetChiara.png"));
                    buttonBudget.setIcon(imageBudgetBianca);
                }else{

                    buttonTema.setIcon(imageLuna);

                    Color darkBg = Color.decode("#1c2697");
                    Color lightFg = Color.decode("#cbf4f4");

                    // Colori principali
                    panelSuperiore.setBackground(lightFg);
                    panelCentrale.setBackground(lightFg);
                    panelSoldi.setBackground(lightFg);
                    panelRadar.setBackground(lightFg);
                    panelEntrate.setBackground(lightFg);
                    panelUscite.setBackground(lightFg);
                    panelMovimenti.setBackground(lightFg);
                    panelPrimo.setBackground(lightFg);
                    panelInternoPrimo.setBackground(lightFg);
                    panelSecondo.setBackground(lightFg);
                    panelInternoSecondo.setBackground(lightFg);
                    panelTerzo.setBackground(lightFg);
                    panelInternoTerzo.setBackground(lightFg);
                    panelBar.setBackground(lightFg);

                    buttonAccount.setForeground(darkBg);
                    buttonTema.setForeground(darkBg);
                    labelScrittaSuperiore.setForeground(darkBg);
                    labelSoldi.setForeground(darkBg);
                    labelEntrate.setForeground(darkBg);

                    // Titoli e bordi

                    titoloDisponibilita.setTitleColor(darkBg);
                    titoloDisponibilita.setBorder(new RoundedBorder(2, 20, 20, darkBg));

                    titoloRadar.setTitleColor(darkBg);
                    titoloRadar.setBorder(new RoundedBorder(2, 20, 20, darkBg));

                    titoloEntrate.setTitleColor(darkBg);
                    titoloEntrate.setBorder(new RoundedBorder(2, 20, 20, darkBg));

                    titoloMovimenti.setTitleColor(darkBg);
                    titoloMovimenti.setBorder(new RoundedBorder(2, 20, 20, darkBg));

                    // Icone
                    imageAccount.setImage(new ImageIcon(getClass().getResource("/Immagini/IconaAccountScura.png")).getImage());
                    Image imageTmpFreccia = new ImageIcon(getClass().getResource("/Immagini/IconaEntrate.png")).getImage();
                    imageEntrate.setImage(imageTmpFreccia);

                    // Labels movimenti
                    labelTipoPrimo.setForeground(darkBg);
                    labelCostoPrimo.setForeground(darkBg);
                    labelGiornoPrimo.setForeground(darkBg);

                    labelTipoSecondo.setForeground(darkBg);
                    labelCostoSecondo.setForeground(darkBg);
                    labelGiornoSecondo.setForeground(darkBg);

                    labelTipoTerzo.setForeground(darkBg);
                    labelCostoTerzo.setForeground(darkBg);
                    labelGiornoTerzo.setForeground(darkBg);

                    // Frecce se non sono uscite
                    if (!labelIconaPrimo.getIcon().equals(imageUscite)) labelIconaPrimo.setIcon(new ImageIcon(imageTmpFreccia));
                    if (!labelIconaSecondo.getIcon().equals(imageUscite)) labelIconaSecondo.setIcon(new ImageIcon(imageTmpFreccia));
                    if (!labelIconaTerzo.getIcon().equals(imageUscite)) labelIconaTerzo.setIcon(new ImageIcon(imageTmpFreccia));

                    // Icone menu
                    buttonHome.repaint();
                    buttonHome.revalidate();
                    buttonMovimenti.repaint();
                    buttonMovimenti.revalidate();
                    buttonPagamenti.repaint();
                    buttonPagamenti.revalidate();
                    buttonRisparmi.repaint();
                    buttonRisparmi.revalidate();
                    buttonCambioValuta.repaint();
                    buttonCambioValuta.revalidate();
                    buttonBudget.repaint();
                    buttonBudget.revalidate();

                    buttonHome.setIcon(iconaHomeScura);
                    buttonMovimenti.setIcon(iconaMovimentiScura);
                    buttonPagamenti.setIcon(iconaPagamentiScura);
                    buttonRisparmi.setIcon(iconaRisparmiScura);
                    buttonCambioValuta.setIcon(iconaCambioValutaScura);
                    buttonBudget.setIcon(iconaBudgetScura);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        setVisible(true);

    } 
}