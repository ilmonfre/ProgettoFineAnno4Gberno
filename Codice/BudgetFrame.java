import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;

public class BudgetFrame extends JFrame {

    JPanel panelSup, panelBudget, panelBar;
    JButton buttonSettimanale, buttonMensile, buttonAnnuale, buttonTema;
    ImageIcon imageSole, imageLuna;

    JTabbedPane panelCen;
    
    JFrame frameCrea, frameImpostazioni, frameModifica, frameElimina;
    JPanel panelCrea, panelImpostazioni, panelModifica, panelElimina;
    JPanel panelSettimanale, panelMensile, panelAnnuale, panelSupCen;
    JProgressBar barSettimanale;
    JButton buttonAggiungi, buttonImpostazioni;
    RoundedBorderButton buttonSi, buttonNo, buttonModifica, buttonElimina, buttonConferma, buttonConfCrea;
    RoundedTextField textModifica, textMax;
    JLabel labelCentrale, labelSpesiSett, labelRimastiSett, labelMaxSett;

    JFrame frameCreaMensile, frameImpostazioniMensile, frameModificaMensile, frameEliminaMensile;
    JPanel panelCreaMensile, panelImpostazioniMensile, panelModificaMensile, panelEliminaMensile, panelSupCenMensile;
    JProgressBar barMensile;
    JButton buttonAggiungiMensile, buttonImpostazioniMensile;
    RoundedBorderButton buttonSiMensile, buttonNoMensile, buttonModificaMensile, buttonEliminaMensile, buttonConfermaMensile, buttonConfCreaMensile;
    RoundedTextField textModificaMensile, textMaxMensile;
    JLabel labelCentraleMensile, labelSpesiMens, labelRimastiMens, labelMaxMens;

    JFrame frameCreaAnnuale, frameImpostazioniAnnuale, frameModificaAnnuale, frameEliminaAnnuale;
    JPanel panelCreaAnnuale, panelImpostazioniAnnuale, panelModificaAnnuale, panelEliminaAnnuale, panelSupCenAnnuale;
    JProgressBar barAnnuale;
    JButton buttonAggiungiAnnuale, buttonImpostazioniAnnuale;
    RoundedBorderButton buttonSiAnnuale, buttonNoAnnuale, buttonModificaAnnuale, buttonEliminaAnnuale, buttonConfermaAnnuale, buttonConfCreaAnnuale;
    RoundedTextField textModificaAnnuale, textMaxAnnuale;
    JLabel labelCentraleAnnuale, labelSpesiAnn, labelRimastiAnn, labelMaxAnn;

    JButton buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta, buttonHome;
    ImageIcon iconaAggiungiChiara, iconaImpostazioniChiara, iconaHomeChiara, iconaMovimentiChiara, iconaPagamentiChiara, iconaRisparmiChiara, iconaCambioValutaChiara, iconaBudgetChiara;
    ImageIcon iconaAggiungiScura, iconaImpostazioniScura, iconaHomeScura, iconaMovimentiScura, iconaPagamentiScura, iconaRisparmiScura, iconaCambioValutaScura, iconaBudgetScura;

    JPanel panelTextTmp, panelVuotoTmp, panelButtonTmp, panelTextModifica, panelVuotoModificaTmp, panelButtonModificaTmp, panelTmpElimina, panelButtonImpostazioniTmp;
    JLabel labelTmp,labelModificaTmp, labelEliminaTmp;

    JPanel panelTextMensileTmp, panelVuotoMensileTmp, panelButtonMensileTmp, panelTextModificaMensile, panelVuotoModificaMensileTmp, panelButtonModificaMensileTmp, panelTmpEliminaMensile, panelButtonImpostazioniMensileTmp;
    JLabel labelMensileTmp,labelModificaMensileTmp, labelEliminaMensileTmp;

    JPanel panelTextAnnualeTmp, panelVuotoAnnualeTmp, panelButtonAnnualeTmp, panelTextModificaAnnuale, panelVuotoModificaAnnualeTmp, panelButtonModificaAnnualeTmp, panelTmpEliminaAnnuale, panelButtonImpostazioniAnnualeTmp;
    JLabel labelAnnualeTmp,labelModificaAnnualeTmp, labelEliminaAnnualeTmp;

    Color dark, light;

    Tema tema = new Tema(0);

    private void centraFrame(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - frame.getWidth()) / 2;
        int y = (screenSize.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);
    }

    public void aggiornaPannelloSettimanale() {
        panelSettimanale.removeAll();
        panelSupCen.removeAll();

        panelSupCen.setLayout(new BorderLayout(0, 0));
        panelSupCen.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // rimuove margini/padding

        // Aggiungi bottone Aggiungi a sinistra, Impostazioni a destra
        panelSupCen.add(buttonAggiungi, BorderLayout.WEST);
        panelSupCen.add(buttonImpostazioni, BorderLayout.EAST);

        // Disabilita margini interni dei bottoni (se presenti)
        buttonAggiungi.setMargin(new Insets(0, 0, 0, 0));
        buttonImpostazioni.setMargin(new Insets(0, 0, 0, 0));

        if (movimenti.budget.getMaxSett() == -1) {
            buttonImpostazioni.setEnabled(false);
            buttonAggiungi.setEnabled(true);
            labelCentrale.setFont(new Font("Arial", Font.BOLD, 25));
            labelCentrale.setHorizontalAlignment(SwingConstants.CENTER);

            panelSettimanale.setLayout(new BorderLayout());
            panelSettimanale.add(panelSupCen, BorderLayout.NORTH);
            panelSettimanale.add(labelCentrale, BorderLayout.CENTER);

        } else {
            buttonImpostazioni.setEnabled(true);
            buttonAggiungi.setEnabled(false);

            barSettimanale = new JProgressBar();
            barSettimanale.setMaximum((int) Math.round(movimenti.budget.getMaxSett()));
            barSettimanale.setValue((int) Math.round(movimenti.budget.getCorrenteSett()));
            barSettimanale.setPreferredSize(new Dimension(250, 30));

            labelSpesiSett = new JLabel("Hai speso " + String.format("%.2f", movimenti.budget.getCorrenteSett()) + " €");
            labelRimastiSett = new JLabel("Rispetto al budget settimanale sono rimasti " + String.format("%.2f", movimenti.budget.getMaxSett() - movimenti.budget.getCorrenteSett()) + " €");
            labelMaxSett = new JLabel("Il budget settimanale è " + String.format("%.2f", movimenti.budget.getMaxSett()) + " €");

            labelSpesiSett.setFont(new Font("Arial", Font.PLAIN, 18));
            labelRimastiSett.setFont(new Font("Arial", Font.PLAIN, 18));
            labelMaxSett.setFont(new Font("Arial", Font.PLAIN, 18));

            JPanel panelTmp = new JPanel();
            panelTmp.setLayout(new BoxLayout(panelTmp, BoxLayout.Y_AXIS));
            panelTmp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panelTmp.add(barSettimanale);
            panelTmp.add(Box.createVerticalStrut(10));
            panelTmp.add(labelMaxSett);

            JPanel panelTmp2 = new JPanel();
            panelTmp2.setLayout(new BoxLayout(panelTmp2, BoxLayout.Y_AXIS));
            panelTmp2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
            panelTmp2.add(labelSpesiSett);
            panelTmp2.add(Box.createVerticalStrut(10));
            panelTmp2.add(labelRimastiSett);

            panelSettimanale.setLayout(new BorderLayout());
            panelSettimanale.add(panelSupCen, BorderLayout.NORTH);
            panelSettimanale.add(panelTmp, BorderLayout.CENTER);
            panelSettimanale.add(panelTmp2, BorderLayout.SOUTH);
        }

        panelSettimanale.revalidate();
        panelSettimanale.repaint();
    }
    
    public void aggiornaPannelloMensile() {
        panelMensile.removeAll();
        panelSupCenMensile.removeAll();

        panelSupCenMensile.setLayout(new BorderLayout(0, 0));
        panelSupCenMensile.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // rimuove margini/padding

        // Aggiungi bottone Aggiungi a sinistra, Impostazioni a destra
        panelSupCenMensile.add(buttonAggiungiMensile, BorderLayout.WEST);
        panelSupCenMensile.add(buttonImpostazioniMensile, BorderLayout.EAST);

        // Disabilita margini interni dei bottoni (se presenti)
        buttonAggiungiMensile.setMargin(new Insets(0, 0, 0, 0));
        buttonImpostazioniMensile.setMargin(new Insets(0, 0, 0, 0));

        if (movimenti.budget.getMaxMen() == -1) {
            buttonImpostazioniMensile.setEnabled(false);
            buttonAggiungiMensile.setEnabled(true);
            labelCentraleMensile.setFont(new Font("Arial", Font.BOLD, 25));
            labelCentraleMensile.setHorizontalAlignment(SwingConstants.CENTER);

            panelMensile.setLayout(new BorderLayout());
            panelMensile.add(panelSupCenMensile, BorderLayout.NORTH);
            panelMensile.add(labelCentraleMensile, BorderLayout.CENTER);

        } else {
            buttonImpostazioniMensile.setEnabled(true);
            buttonAggiungiMensile.setEnabled(false);

            barMensile = new JProgressBar();
            barMensile.setMaximum((int) Math.round(movimenti.budget.getMaxMen()));
            barMensile.setValue((int) Math.round(movimenti.budget.getCorrenteMen()));
            barMensile.setPreferredSize(new Dimension(250, 30));

            labelSpesiMens = new JLabel("Hai speso " + String.format("%.2f", movimenti.budget.getCorrenteMen()) + " €");
            labelRimastiMens = new JLabel("Rispetto al budget mensile sono rimasti " + String.format("%.2f", movimenti.budget.getMaxMen() - movimenti.budget.getCorrenteMen()) + " €");
            labelMaxMens = new JLabel("Il budget mensile è " + String.format("%.2f", movimenti.budget.getMaxMen()) + " €");

            labelSpesiMens.setFont(new Font("Arial", Font.PLAIN, 18));
            labelRimastiMens.setFont(new Font("Arial", Font.PLAIN, 18));
            labelMaxMens.setFont(new Font("Arial", Font.PLAIN, 18));

            JPanel panelTmp = new JPanel();
            panelTmp.setLayout(new BoxLayout(panelTmp, BoxLayout.Y_AXIS));
            panelTmp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panelTmp.add(barMensile);
            panelTmp.add(Box.createVerticalStrut(10));
            panelTmp.add(labelMaxMens);

            JPanel panelTmp2 = new JPanel();
            panelTmp2.setLayout(new BoxLayout(panelTmp2, BoxLayout.Y_AXIS));
            panelTmp2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
            panelTmp2.add(labelSpesiMens);
            panelTmp2.add(Box.createVerticalStrut(10));
            panelTmp2.add(labelRimastiMens);

            panelMensile.setLayout(new BorderLayout());
            panelMensile.add(panelSupCenMensile, BorderLayout.NORTH);
            panelMensile.add(panelTmp, BorderLayout.CENTER);
            panelMensile.add(panelTmp2, BorderLayout.SOUTH);
        }

        panelMensile.revalidate();
        panelMensile.repaint();
    }

    public void aggiornaPannelloAnnuale() {
        panelAnnuale.removeAll();
        panelSupCenAnnuale.removeAll();

        panelSupCenAnnuale.setLayout(new BorderLayout(0, 0));
        panelSupCenAnnuale.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // rimuove margini/padding

        // Aggiungi bottone Aggiungi a sinistra, Impostazioni a destra
        panelSupCenAnnuale.add(buttonAggiungiAnnuale, BorderLayout.WEST);
        panelSupCenAnnuale.add(buttonImpostazioniAnnuale, BorderLayout.EAST);

        // Disabilita margini interni dei bottoni (se presenti)
        buttonAggiungiAnnuale.setMargin(new Insets(0, 0, 0, 0));
        buttonImpostazioniAnnuale.setMargin(new Insets(0, 0, 0, 0));

        if (movimenti.budget.getMaxAnn() == -1) {
            buttonImpostazioniAnnuale.setEnabled(false);
            buttonAggiungiAnnuale.setEnabled(true);
            labelCentraleAnnuale.setFont(new Font("Arial", Font.BOLD, 25));
            labelCentraleAnnuale.setHorizontalAlignment(SwingConstants.CENTER);

            panelAnnuale.setLayout(new BorderLayout());
            panelAnnuale.add(panelSupCenAnnuale, BorderLayout.NORTH);
            panelAnnuale.add(labelCentraleAnnuale, BorderLayout.CENTER);

        } else {
            buttonImpostazioniAnnuale.setEnabled(true);
            buttonAggiungiAnnuale.setEnabled(false);

            barAnnuale = new JProgressBar();
            barAnnuale.setMaximum((int) Math.round(movimenti.budget.getMaxAnn()));
            barAnnuale.setValue((int) Math.round(movimenti.budget.getCorrenteAnn()));
            barAnnuale.setPreferredSize(new Dimension(250, 30));

            labelSpesiAnn = new JLabel("Hai speso " + String.format("%.2f", movimenti.budget.getCorrenteAnn()) + " €");
            labelRimastiAnn = new JLabel("Rispetto al budget annuale sono rimasti " + String.format("%.2f", movimenti.budget.getMaxAnn() - movimenti.budget.getCorrenteAnn()) + " €");
            labelMaxAnn = new JLabel("Il budget annuale è " + String.format("%.2f", movimenti.budget.getMaxAnn()) + " €");

            labelSpesiAnn.setFont(new Font("Arial", Font.PLAIN, 18));
            labelRimastiAnn.setFont(new Font("Arial", Font.PLAIN, 18));
            labelMaxAnn.setFont(new Font("Arial", Font.PLAIN, 18));

            JPanel panelTmp = new JPanel();
            panelTmp.setLayout(new BoxLayout(panelTmp, BoxLayout.Y_AXIS));
            panelTmp.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panelTmp.add(barAnnuale);
            panelTmp.add(Box.createVerticalStrut(10));
            panelTmp.add(labelMaxAnn);

            JPanel panelTmp2 = new JPanel();
            panelTmp2.setLayout(new BoxLayout(panelTmp2, BoxLayout.Y_AXIS));
            panelTmp2.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
            panelTmp2.add(labelSpesiAnn);
            panelTmp2.add(Box.createVerticalStrut(10));
            panelTmp2.add(labelRimastiAnn);

            panelAnnuale.setLayout(new BorderLayout());
            panelAnnuale.add(panelSupCenAnnuale, BorderLayout.NORTH);
            panelAnnuale.add(panelTmp, BorderLayout.CENTER);
            panelAnnuale.add(panelTmp2, BorderLayout.SOUTH);
        }

        panelAnnuale.revalidate();
        panelAnnuale.repaint();
    }
    
    Movimenti movimenti;
    public BudgetFrame(Movimenti movimenti) {
        this.movimenti = movimenti;

        setTitle("Zaphyra Bank - Budget");

        Color dark = Color.decode("#1c2697");
        Color light = Color.decode("#cbf4f4");

        String basePath = "/Immagini/";
        
        // Icone tema scuro
        iconaAggiungiScura = new ImageIcon(getClass().getResource(basePath + "Icona+Chiara.png"));
        iconaImpostazioniScura = new ImageIcon(getClass().getResource(basePath + "IconaImpostazioniChiara.png"));
        iconaHomeScura = new ImageIcon(getClass().getResource(basePath + "IconaHomeScura.png"));
        iconaMovimentiScura = new ImageIcon(getClass().getResource(basePath + "IconaMovimentiScura.png"));
        iconaPagamentiScura = new ImageIcon(getClass().getResource(basePath + "IconaPagamentiScura.png"));
        iconaRisparmiScura = new ImageIcon(getClass().getResource(basePath + "IconaRisparmiScura.png"));
        iconaCambioValutaScura = new ImageIcon(getClass().getResource(basePath + "IconaCambioValutaScura.png"));
        iconaBudgetScura = new ImageIcon(getClass().getResource(basePath + "IconaBudgetScuraPiena.png"));

        panelSup = new JPanel();

        buttonSettimanale = new JButton();
        buttonMensile = new JButton();
        buttonAnnuale = new JButton();

        buttonSettimanale.setOpaque(false);
        buttonSettimanale.setContentAreaFilled(false);
        buttonSettimanale.setBorderPainted(false);
        buttonSettimanale.setFocusPainted(false);

        buttonMensile.setOpaque(false);
        buttonMensile.setContentAreaFilled(false);
        buttonMensile.setBorderPainted(false);
        buttonMensile.setFocusPainted(false);

        buttonAnnuale.setOpaque(false);
        buttonAnnuale.setContentAreaFilled(false);
        buttonAnnuale.setBorderPainted(false);
        buttonAnnuale.setFocusPainted(false);

        panelBudget = new JPanel();
        panelBudget.setLayout(new GridLayout(1, 3));

        panelBudget.add(buttonSettimanale);
        panelBudget.add(buttonMensile);
        panelBudget.add(buttonAnnuale);

        imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));
        imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));

        buttonTema = new JButton();

        buttonTema.setIcon(imageLuna);

        buttonTema.setOpaque(false);
        buttonTema.setContentAreaFilled(false);
        buttonTema.setBorderPainted(false);
        buttonTema.setFocusPainted(false);

        panelSup.setLayout(new BorderLayout());
        panelSup.add(buttonTema, BorderLayout.EAST);

        // Pannello centrale
        panelCen = new JTabbedPane(JTabbedPane.TOP);

        panelSettimanale = new JPanel();
        panelMensile = new JPanel();
        panelAnnuale = new JPanel();

        // Inizio pannello settimanale

        buttonAggiungi = new JButton();
        buttonImpostazioni = new JButton();

        // Carica immagini per i bottoni
        ImageIcon iconaAggiungi = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        ImageIcon iconaImpostazioni = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));

        buttonAggiungi.setIcon(iconaAggiungi);
        buttonImpostazioni.setIcon(iconaImpostazioni);

        buttonAggiungi.setOpaque(false);
        buttonAggiungi.setContentAreaFilled(false);
        buttonAggiungi.setBorderPainted(false);
        buttonAggiungi.setFocusPainted(false);

        buttonImpostazioni.setOpaque(false);
        buttonImpostazioni.setContentAreaFilled(false);
        buttonImpostazioni.setBorderPainted(false);
        buttonImpostazioni.setFocusPainted(false);

        // Frame impostazioni
        frameImpostazioni = new JFrame();
        frameImpostazioni.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImpostazioni.setSize(250, 200);
        centraFrame(frameImpostazioni);

        frameModifica = new JFrame();
        frameModifica.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModifica.setSize(250, 200);
        centraFrame(frameModifica);

        frameCrea = new JFrame();
        frameCrea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCrea.setSize(250, 200);
        centraFrame(frameCrea);

        frameElimina = new JFrame();
        frameElimina.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameElimina.setSize(250, 200);
        centraFrame(frameElimina);

        panelCrea = new JPanel();
        panelImpostazioni = new JPanel();
        panelElimina = new JPanel();
        panelModifica = new JPanel();

        buttonModifica = new RoundedBorderButton("Modifica", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonElimina = new RoundedBorderButton("Elimina", dark, dark, light, light, light, dark, 2, 20, 20);

        buttonModifica.setPreferredSize(new Dimension(50, 30));
        buttonElimina.setPreferredSize(new Dimension(50, 30));

        buttonSi = new RoundedBorderButton("Si", Color.decode("#be1327"), Color.decode("#be1327"), Color.white, Color.white, Color.white, Color.decode("#be1327"), 2, 20, 20);
        buttonNo = new RoundedBorderButton("No", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonConferma = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textModifica = new RoundedTextField(20, 30);
        labelCentrale = new JLabel("Non è presente nessun budget");

        buttonConfCrea = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textMax = new RoundedTextField(20, 30);
        panelSupCen = new JPanel();
        aggiornaPannelloSettimanale();

        // Placeholder gestione per textModifica
        textModifica.setBackground(Color.decode("#D3D3D3"));
        String placeholder = "Inserisci nuovo limite";
        textModifica.setForeground(Color.GRAY);
        textModifica.setText(placeholder);

        textModifica.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModifica.getText().equals(placeholder)) {
                    textModifica.setText("");
                    textModifica.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModifica.getText().isEmpty()) {
                    textModifica.setForeground(Color.GRAY);
                    textModifica.setText(placeholder);
                }
            }
        });

        // Placeholder gestione per textMax
        textMax.setBackground(Color.decode("#D3D3D3"));
        String placeholder2 = "Inserisci limite";
        textMax.setForeground(Color.GRAY);
        textMax.setText(placeholder2);

        textMax.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMax.getText().equals(placeholder2)) {
                    textMax.setText("");
                    textMax.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMax.getText().isEmpty()) {
                    textMax.setForeground(Color.GRAY);
                    textMax.setText(placeholder2);
                }
            }
        });

        buttonConfCrea.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textMax)) {
                JOptionPane.showMessageDialog(frameCrea, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textMax.getText().equals("")) {
                JOptionPane.showMessageDialog(frameCrea, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textMax.getText());
                movimenti.budget.setMaxSett(nuovoMax);
                aggiornaPannelloSettimanale();
                frameCrea.dispose();
            }

            // Reset del JTextField
            textMax.setBackground(Color.decode("#D3D3D3"));
            textMax.setForeground(Color.GRAY);
            textMax.setText(placeholder2);

            textMax.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textMax.getText().equals(placeholder2)) {
                        textMax.setText("");
                        textMax.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textMax.getText().isEmpty()) {
                        textMax.setForeground(Color.GRAY);
                        textMax.setText(placeholder2);
                    }
                }
            });
        });

        panelTextTmp = new JPanel();
        textMax.setPreferredSize(new Dimension(200, 40));
        panelTextTmp.add(textMax);

        labelTmp = new JLabel("");
        panelVuotoTmp = new JPanel();
        labelTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoTmp.add(labelTmp);

        panelButtonTmp = new JPanel();
        buttonConfCrea.setPreferredSize(new Dimension(200, 40));
        panelButtonTmp.add(buttonConfCrea);

        panelCrea.setLayout(new GridLayout(3, 1));
        panelCrea.add(panelTextTmp);
        panelCrea.add(panelVuotoTmp);
        panelCrea.add(panelButtonTmp);

        frameCrea.add(panelCrea);

        buttonAggiungi.addActionListener(e -> {
            centraFrame(frameCrea);
            frameCrea.setVisible(true);
        });

        buttonConferma.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textModifica)) {
                JOptionPane.showMessageDialog(frameModifica, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textModifica.getText().equals("")) {
                JOptionPane.showMessageDialog(frameModifica, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textModifica.getText());
                movimenti.budget.setMaxSett(nuovoMax);
                aggiornaPannelloSettimanale();
                frameModifica.dispose();
            }

            // Reset del JTextField
            textModifica.setBackground(Color.decode("#D3D3D3"));
            textModifica.setForeground(Color.GRAY);
            textModifica.setText(placeholder);

            textModifica.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textModifica.getText().equals(placeholder)) {
                        textModifica.setText("");
                        textModifica.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textModifica.getText().isEmpty()) {
                        textModifica.setForeground(Color.GRAY);
                        textModifica.setText(placeholder);
                    }
                }
            });
        });

        panelTextModifica = new JPanel();
        textModifica.setPreferredSize(new Dimension(200, 40));
        panelTextModifica.add(textModifica);

        labelModificaTmp = new JLabel("");
        panelVuotoModificaTmp = new JPanel();
        labelModificaTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoModificaTmp.add(labelModificaTmp);

        panelButtonModificaTmp = new JPanel();
        buttonConferma.setPreferredSize(new Dimension(200, 40));
        panelButtonModificaTmp.add(buttonConferma);

        panelModifica.setLayout(new GridLayout(3, 1));
        panelModifica.add(panelTextModifica);
        panelModifica.add(panelVuotoModificaTmp);
        panelModifica.add(panelButtonModificaTmp);

        frameModifica.add(panelModifica);

        buttonModifica.addActionListener(e -> {
            frameImpostazioni.dispose();
            centraFrame(frameModifica);
            frameModifica.setVisible(true);
        });

        buttonSi.addActionListener(e -> {
            frameImpostazioni.dispose();
            movimenti.budget.setMaxSett(-1);
            aggiornaPannelloSettimanale();
            frameElimina.dispose();
        });

        buttonNo.addActionListener(e -> {
            frameImpostazioni.dispose();
            frameElimina.dispose();
        });

        panelTmpElimina = new JPanel();
        buttonSi.setPreferredSize(new Dimension(200, 40));
        buttonNo.setPreferredSize(new Dimension(200, 40));
        panelTmpElimina.setLayout(new GridLayout(2, 1));
        panelTmpElimina.add(buttonSi);
        panelTmpElimina.add(buttonNo);

        labelEliminaTmp = new JLabel("<html>Sei sicuro di voler<br>eliminare questo budget?</html>");
        labelEliminaTmp.setHorizontalAlignment(SwingConstants.CENTER);

        panelElimina.setLayout(new GridLayout(2, 1));
        panelElimina.add(labelEliminaTmp);
        panelElimina.add(panelTmpElimina);

        frameElimina.add(panelElimina);

        buttonElimina.addActionListener(e -> {
            centraFrame(frameElimina);
            frameElimina.setVisible(true);
            frameImpostazioni.dispose();
        });

        panelButtonImpostazioniTmp = new JPanel();
        panelButtonImpostazioniTmp.setLayout(new GridLayout(2, 1, 0, 10));
        buttonModifica.setPreferredSize(new Dimension(200, 40));
        buttonElimina.setPreferredSize(new Dimension(200, 40));
        panelButtonImpostazioniTmp.add(buttonModifica);
        panelButtonImpostazioniTmp.add(buttonElimina);

        panelImpostazioni.add(panelButtonImpostazioniTmp);
        frameImpostazioni.add(panelImpostazioni);

        buttonImpostazioni.addActionListener(e -> {
            centraFrame(frameImpostazioni);
            frameImpostazioni.setVisible(true);
        });

        panelCen.addTab("Budget settimanale", panelSettimanale);

        // Fino pannello settimanale




        // Inizio pannello mensile

        buttonAggiungiMensile = new JButton();
        buttonImpostazioniMensile = new JButton();

        // Carica immagini per i bottoni
        ImageIcon iconaAggiungiMensile = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        ImageIcon iconaImpostazioniMensile = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));

        buttonAggiungiMensile.setIcon(iconaAggiungiMensile);
        buttonImpostazioniMensile.setIcon(iconaImpostazioniMensile);

        buttonAggiungiMensile.setOpaque(false);
        buttonAggiungiMensile.setContentAreaFilled(false);
        buttonAggiungiMensile.setBorderPainted(false);
        buttonAggiungiMensile.setFocusPainted(false);

        buttonImpostazioniMensile.setOpaque(false);
        buttonImpostazioniMensile.setContentAreaFilled(false);
        buttonImpostazioniMensile.setBorderPainted(false);
        buttonImpostazioniMensile.setFocusPainted(false);

        // Frame impostazioni
        frameImpostazioniMensile = new JFrame();
        frameImpostazioniMensile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImpostazioniMensile.setSize(250, 200);
        centraFrame(frameImpostazioniMensile);

        frameModificaMensile = new JFrame();
        frameModificaMensile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModificaMensile.setSize(250, 200);
        centraFrame(frameModificaMensile);

        frameCreaMensile = new JFrame();
        frameCreaMensile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCreaMensile.setSize(250, 200);
        centraFrame(frameCreaMensile);

        frameEliminaMensile = new JFrame();
        frameEliminaMensile.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEliminaMensile.setSize(250, 200);
        centraFrame(frameEliminaMensile);

        panelCreaMensile = new JPanel();
        panelImpostazioniMensile = new JPanel();
        panelEliminaMensile = new JPanel();
        panelModificaMensile = new JPanel();

        buttonModificaMensile = new RoundedBorderButton("Modifica", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonEliminaMensile = new RoundedBorderButton("Elimina", dark, dark, light, light, light, dark, 2, 20, 20);

        buttonModificaMensile.setPreferredSize(new Dimension(50, 30));
        buttonEliminaMensile.setPreferredSize(new Dimension(50, 30));

        buttonSiMensile = new RoundedBorderButton("Si", Color.decode("#be1327"), Color.decode("#be1327"), Color.white, Color.white, Color.white, Color.decode("#be1327"), 2, 20, 20);
        buttonNoMensile = new RoundedBorderButton("No", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonConfermaMensile = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textModificaMensile = new RoundedTextField(20, 30);
        labelCentraleMensile = new JLabel("Non è presente nessun budget");

        buttonConfCreaMensile = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textMaxMensile = new RoundedTextField(20, 30);
        panelSupCenMensile = new JPanel();
        aggiornaPannelloMensile();

        // Placeholder gestione per textModifica
        textModificaMensile.setBackground(Color.decode("#D3D3D3"));
        textModificaMensile.setForeground(Color.GRAY);
        textModificaMensile.setText(placeholder);

        textModificaMensile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModificaMensile.getText().equals(placeholder)) {
                    textModificaMensile.setText("");
                    textModificaMensile.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModificaMensile.getText().isEmpty()) {
                    textModificaMensile.setForeground(Color.GRAY);
                    textModificaMensile.setText(placeholder);
                }
            }
        });

        // Placeholder gestione per textMax
        textMaxMensile.setBackground(Color.decode("#D3D3D3"));
        textMaxMensile.setForeground(Color.GRAY);
        textMaxMensile.setText(placeholder2);

        textMaxMensile.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMaxMensile.getText().equals(placeholder2)) {
                    textMaxMensile.setText("");
                    textMaxMensile.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMaxMensile.getText().isEmpty()) {
                    textMaxMensile.setForeground(Color.GRAY);
                    textMaxMensile.setText(placeholder2);
                }
            }
        });

        buttonConfCreaMensile.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textMaxMensile)) {
                JOptionPane.showMessageDialog(frameCreaMensile, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textMaxMensile.getText().equals("")) {
                JOptionPane.showMessageDialog(frameCreaMensile, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textMaxMensile.getText());
                movimenti.budget.setMaxMen(nuovoMax);
                aggiornaPannelloMensile();
                frameCreaMensile.dispose();
            }

            // Reset del JTextField
            textModificaMensile.setBackground(Color.decode("#D3D3D3"));
            textModificaMensile.setForeground(Color.GRAY);
            textModificaMensile.setText(placeholder);

            textModificaMensile.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textModificaMensile.getText().equals(placeholder)) {
                        textModificaMensile.setText("");
                        textModificaMensile.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textModificaMensile.getText().isEmpty()) {
                        textModificaMensile.setForeground(Color.GRAY);
                        textModificaMensile.setText(placeholder);
                    }
                }
            });
        });

        panelTextMensileTmp = new JPanel();
        textMaxMensile.setPreferredSize(new Dimension(200, 40));
        panelTextMensileTmp.add(textMaxMensile);

        labelMensileTmp = new JLabel("");
        panelVuotoMensileTmp = new JPanel();
        labelMensileTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoMensileTmp.add(labelMensileTmp);

        panelButtonMensileTmp = new JPanel();
        buttonConfCreaMensile.setPreferredSize(new Dimension(200, 40));
        panelButtonMensileTmp.add(buttonConfCreaMensile);

        panelCreaMensile.setLayout(new GridLayout(3, 1));
        panelCreaMensile.add(panelTextMensileTmp);
        panelCreaMensile.add(panelVuotoMensileTmp);
        panelCreaMensile.add(panelButtonMensileTmp);

        frameCreaMensile.add(panelCreaMensile);

        buttonAggiungiMensile.addActionListener(e -> {
            centraFrame(frameCreaMensile);
            frameCreaMensile.setVisible(true);
        });

        buttonConfermaMensile.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textModificaMensile)) {
                JOptionPane.showMessageDialog(frameModificaMensile, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textModificaMensile.getText().equals("")) {
                JOptionPane.showMessageDialog(frameModificaMensile, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textModificaMensile.getText());
                movimenti.budget.setMaxMen(nuovoMax);
                aggiornaPannelloMensile();
                frameModificaMensile.dispose();
            }

            // Reset del JTextField
            textModificaMensile.setBackground(Color.decode("#D3D3D3"));
            textModificaMensile.setForeground(Color.GRAY);
            textModificaMensile.setText(placeholder);

            textModificaMensile.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textModificaMensile.getText().equals(placeholder)) {
                        textModificaMensile.setText("");
                        textModificaMensile.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textModificaMensile.getText().isEmpty()) {
                        textModificaMensile.setForeground(Color.GRAY);
                        textModificaMensile.setText(placeholder);
                    }
                }
            });
        });

        panelTextModificaMensile = new JPanel();
        textModificaMensile.setPreferredSize(new Dimension(200, 40));
        panelTextModificaMensile.add(textModificaMensile);

        labelModificaMensileTmp = new JLabel("");
        panelVuotoModificaMensileTmp = new JPanel();
        labelModificaMensileTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoModificaMensileTmp.add(labelModificaMensileTmp);

        panelButtonModificaMensileTmp = new JPanel();
        buttonConfermaMensile.setPreferredSize(new Dimension(200, 40));
        panelButtonModificaMensileTmp.add(buttonConfermaMensile);

        panelModificaMensile.setLayout(new GridLayout(3, 1));
        panelModificaMensile.add(panelTextModificaMensile);
        panelModificaMensile.add(panelVuotoModificaMensileTmp);
        panelModificaMensile.add(panelButtonModificaMensileTmp);

        frameModificaMensile.add(panelModificaMensile);

        buttonModificaMensile.addActionListener(e -> {
            frameImpostazioniMensile.dispose();
            centraFrame(frameModificaMensile);
            frameModificaMensile.setVisible(true);
        });

        buttonSiMensile.addActionListener(e -> {
            frameImpostazioniMensile.dispose();
            movimenti.budget.setMaxMen(-1);
            aggiornaPannelloMensile();
            frameEliminaMensile.dispose();
        });

        buttonNoMensile.addActionListener(e -> {
            frameImpostazioniMensile.dispose();
            frameEliminaMensile.dispose();
        });

        panelTmpEliminaMensile = new JPanel();
        buttonSiMensile.setPreferredSize(new Dimension(200, 40));
        buttonNoMensile.setPreferredSize(new Dimension(200, 40));
        panelTmpEliminaMensile.setLayout(new GridLayout(2, 1));
        panelTmpEliminaMensile.add(buttonSiMensile);
        panelTmpEliminaMensile.add(buttonNoMensile);

        labelEliminaMensileTmp = new JLabel("<html>Sei sicuro di voler<br>eliminare questo budget?</html>");
        labelEliminaMensileTmp.setHorizontalAlignment(SwingConstants.CENTER);

        panelEliminaMensile.setLayout(new GridLayout(2, 1));
        panelEliminaMensile.add(labelEliminaMensileTmp);
        panelEliminaMensile.add(panelTmpEliminaMensile);

        frameEliminaMensile.add(panelEliminaMensile);

        buttonEliminaMensile.addActionListener(e -> {
            centraFrame(frameEliminaMensile);
            frameEliminaMensile.setVisible(true);
            frameImpostazioniMensile.dispose();
        });

        panelButtonImpostazioniMensileTmp = new JPanel();
        panelButtonImpostazioniMensileTmp.setLayout(new GridLayout(2, 1, 0, 10));
        buttonModificaMensile.setPreferredSize(new Dimension(200, 40));
        buttonEliminaMensile.setPreferredSize(new Dimension(200, 40));
        panelButtonImpostazioniMensileTmp.add(buttonModificaMensile);
        panelButtonImpostazioniMensileTmp.add(buttonEliminaMensile);

        panelImpostazioniMensile.add(panelButtonImpostazioniMensileTmp);
        frameImpostazioniMensile.add(panelImpostazioniMensile);

        buttonImpostazioniMensile.addActionListener(e -> {
            centraFrame(frameImpostazioniMensile);
            frameImpostazioniMensile.setVisible(true);
        });

        panelCen.addTab("Budget mensile", panelMensile);

        // Fino pannello mensile




        // Inizio pannello annuale

        buttonAggiungiAnnuale = new JButton();
        buttonImpostazioniAnnuale = new JButton();

        // Carica immagini per i bottoni
        ImageIcon iconaAggiungiAnnuale = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        ImageIcon iconaImpostazioniAnnuale = new ImageIcon(getClass().getResource("/Immagini/IconaImpostazioniScura.png"));

        buttonAggiungiAnnuale.setIcon(iconaAggiungiAnnuale);
        buttonImpostazioniAnnuale.setIcon(iconaImpostazioniAnnuale);

        buttonAggiungiAnnuale.setOpaque(false);
        buttonAggiungiAnnuale.setContentAreaFilled(false);
        buttonAggiungiAnnuale.setBorderPainted(false);
        buttonAggiungiAnnuale.setFocusPainted(false);

        buttonImpostazioniAnnuale.setOpaque(false);
        buttonImpostazioniAnnuale.setContentAreaFilled(false);
        buttonImpostazioniAnnuale.setBorderPainted(false);
        buttonImpostazioniAnnuale.setFocusPainted(false);

        // Frame impostazioni
        frameImpostazioniAnnuale = new JFrame();
        frameImpostazioniAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameImpostazioniAnnuale.setSize(250, 200);
        centraFrame(frameImpostazioniAnnuale);

        frameModificaAnnuale = new JFrame();
        frameModificaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameModificaAnnuale.setSize(250, 200);
        centraFrame(frameModificaAnnuale);

        frameCreaAnnuale = new JFrame();
        frameCreaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameCreaAnnuale.setSize(250, 200);
        centraFrame(frameCreaAnnuale);

        frameEliminaAnnuale = new JFrame();
        frameEliminaAnnuale.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameEliminaAnnuale.setSize(250, 200);
        centraFrame(frameEliminaAnnuale);

        panelCreaAnnuale = new JPanel();
        panelImpostazioniAnnuale = new JPanel();
        panelEliminaAnnuale = new JPanel();
        panelModificaAnnuale = new JPanel();

        buttonModificaAnnuale = new RoundedBorderButton("Modifica", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonEliminaAnnuale = new RoundedBorderButton("Elimina", dark, dark, light, light, light, dark, 2, 20, 20);

        buttonModificaAnnuale.setPreferredSize(new Dimension(50, 30));
        buttonEliminaAnnuale.setPreferredSize(new Dimension(50, 30));

        buttonSiAnnuale = new RoundedBorderButton("Si", Color.decode("#be1327"), Color.decode("#be1327"), Color.white, Color.white, Color.white, Color.decode("#be1327"), 2, 20, 20);
        buttonNoAnnuale = new RoundedBorderButton("No", dark, dark, light, light, light, dark, 2, 20, 20);
        buttonConfermaAnnuale = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textModificaAnnuale = new RoundedTextField(20, 30);
        labelCentraleAnnuale = new JLabel("Non è presente nessun budget");

        buttonConfCreaAnnuale = new RoundedBorderButton("Conferma", dark, dark, light, light, light, dark, 2, 20, 20);
        textMaxAnnuale = new RoundedTextField(20, 30);
        panelSupCenAnnuale = new JPanel();
        aggiornaPannelloAnnuale();

        // Placeholder gestione per textModifica
        textModificaAnnuale.setBackground(Color.decode("#D3D3D3"));
        textModificaAnnuale.setForeground(Color.GRAY);
        textModificaAnnuale.setText(placeholder);

        textModificaAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textModificaAnnuale.getText().equals(placeholder)) {
                    textModificaAnnuale.setText("");
                    textModificaAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textModificaAnnuale.getText().isEmpty()) {
                    textModificaAnnuale.setForeground(Color.GRAY);
                    textModificaAnnuale.setText(placeholder);
                }
            }
        });

        // Placeholder gestione per textMax
        textMaxAnnuale.setBackground(Color.decode("#D3D3D3"));
        textMaxAnnuale.setForeground(Color.GRAY);
        textMaxAnnuale.setText(placeholder2);

        textMaxAnnuale.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textMaxAnnuale.getText().equals(placeholder2)) {
                    textMaxAnnuale.setText("");
                    textMaxAnnuale.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (textMaxAnnuale.getText().isEmpty()) {
                    textMaxAnnuale.setForeground(Color.GRAY);
                    textMaxAnnuale.setText(placeholder2);
                }
            }
        });

        buttonConfCreaAnnuale.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textMaxAnnuale)) {
                JOptionPane.showMessageDialog(frameCreaAnnuale, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textMaxAnnuale.getText().equals("")) {
                JOptionPane.showMessageDialog(frameCreaAnnuale, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textMaxAnnuale.getText());
                movimenti.budget.setMaxAnn(nuovoMax);
                aggiornaPannelloAnnuale();
                frameCreaAnnuale.dispose();
            }

            // Reset del JTextField
            textMaxAnnuale.setBackground(Color.decode("#D3D3D3"));
            textMaxAnnuale.setForeground(Color.GRAY);
            textMaxAnnuale.setText(placeholder2);
            textMaxAnnuale.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textMaxAnnuale.getText().equals(placeholder2)) {
                        textMaxAnnuale.setText("");
                        textMaxAnnuale.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textMaxAnnuale.getText().isEmpty()) {
                        textMaxAnnuale.setForeground(Color.GRAY);
                        textMaxAnnuale.setText(placeholder2);
                    }
                }
            });
        });

        panelTextAnnualeTmp = new JPanel();
        textMaxAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTextAnnualeTmp.add(textMaxAnnuale);

        labelAnnualeTmp = new JLabel("");
        panelVuotoAnnualeTmp = new JPanel();
        labelAnnualeTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoAnnualeTmp.add(labelAnnualeTmp);

        panelButtonAnnualeTmp = new JPanel();
        buttonConfCreaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonAnnualeTmp.add(buttonConfCreaAnnuale);

        panelCreaAnnuale.setLayout(new GridLayout(3, 1));
        panelCreaAnnuale.add(panelTextAnnualeTmp);
        panelCreaAnnuale.add(panelVuotoAnnualeTmp);
        panelCreaAnnuale.add(panelButtonAnnualeTmp);

        frameCreaAnnuale.add(panelCreaAnnuale);

        buttonAggiungiAnnuale.addActionListener(e -> {
            centraFrame(frameCreaAnnuale);
            frameCreaAnnuale.setVisible(true);
        });

        buttonConfermaAnnuale.addActionListener(e -> {

            if (!movimenti.budget.controlloNumero(textModificaAnnuale)) {
                JOptionPane.showMessageDialog(frameModificaAnnuale, "Inserisci un numero!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (textModificaAnnuale.getText().equals("")) {
                JOptionPane.showMessageDialog(frameModificaAnnuale, "Il campo non può essere vuoto!", "Errore", JOptionPane.ERROR_MESSAGE);
            } else {
                double nuovoMax = Double.parseDouble(textModificaAnnuale.getText());
                movimenti.budget.setMaxAnn(nuovoMax);
                aggiornaPannelloAnnuale();
                frameModificaAnnuale.dispose();
            }

            // Reset del JTextField
            textModificaAnnuale.setBackground(Color.decode("#D3D3D3"));
            textModificaAnnuale.setForeground(Color.GRAY);
            textModificaAnnuale.setText(placeholder);

            textModificaAnnuale.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textModificaAnnuale.getText().equals(placeholder)) {
                        textModificaAnnuale.setText("");
                        textModificaAnnuale.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (textModificaAnnuale.getText().isEmpty()) {
                        textModificaAnnuale.setForeground(Color.GRAY);
                        textModificaAnnuale.setText(placeholder);
                    }
                }
            });
        });

        panelTextModificaAnnuale = new JPanel();
        textModificaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTextModificaAnnuale.add(textModificaAnnuale);

        labelModificaAnnualeTmp = new JLabel("");
        panelVuotoModificaAnnualeTmp = new JPanel();
        labelModificaAnnualeTmp.setPreferredSize(new Dimension(200, 10));
        panelVuotoModificaAnnualeTmp.add(labelModificaAnnualeTmp);

        panelButtonModificaAnnualeTmp = new JPanel();
        buttonConfermaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonModificaAnnualeTmp.add(buttonConfermaAnnuale);

        panelModificaAnnuale.setLayout(new GridLayout(3, 1));
        panelModificaAnnuale.add(panelTextModificaAnnuale);
        panelModificaAnnuale.add(panelVuotoModificaAnnualeTmp);
        panelModificaAnnuale.add(panelButtonModificaAnnualeTmp);

        frameModificaAnnuale.add(panelModificaAnnuale);

        buttonModificaAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            centraFrame(frameModificaAnnuale);
            frameModificaAnnuale.setVisible(true);
        });

        buttonSiAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            movimenti.budget.setMaxAnn(-1);
            aggiornaPannelloAnnuale();
            frameEliminaAnnuale.dispose();
        });

        buttonNoAnnuale.addActionListener(e -> {
            frameImpostazioniAnnuale.dispose();
            frameEliminaAnnuale.dispose();
        });

        panelTmpEliminaAnnuale = new JPanel();
        buttonSiAnnuale.setPreferredSize(new Dimension(200, 40));
        buttonNoAnnuale.setPreferredSize(new Dimension(200, 40));
        panelTmpEliminaAnnuale.setLayout(new GridLayout(2, 1));
        panelTmpEliminaAnnuale.add(buttonSiAnnuale);
        panelTmpEliminaAnnuale.add(buttonNoAnnuale);

        labelEliminaAnnualeTmp = new JLabel("<html>Sei sicuro di voler<br>eliminare questo budget?</html>");
        labelEliminaAnnualeTmp.setHorizontalAlignment(SwingConstants.CENTER);

        panelEliminaAnnuale.setLayout(new GridLayout(2, 1));
        panelEliminaAnnuale.add(labelEliminaAnnualeTmp);
        panelEliminaAnnuale.add(panelTmpEliminaAnnuale);

        frameEliminaAnnuale.add(panelEliminaAnnuale);

        buttonEliminaAnnuale.addActionListener(e -> {
            centraFrame(frameEliminaAnnuale);
            frameEliminaAnnuale.setVisible(true);
            frameImpostazioniAnnuale.dispose();
        });

        panelButtonImpostazioniAnnualeTmp = new JPanel();
        panelButtonImpostazioniAnnualeTmp.setLayout(new GridLayout(2, 1, 0, 10));
        buttonModificaAnnuale.setPreferredSize(new Dimension(200, 40));
        buttonEliminaAnnuale.setPreferredSize(new Dimension(200, 40));
        panelButtonImpostazioniAnnualeTmp.add(buttonModificaAnnuale);
        panelButtonImpostazioniAnnualeTmp.add(buttonEliminaAnnuale);

        panelImpostazioniAnnuale.add(panelButtonImpostazioniAnnualeTmp);
        frameImpostazioniAnnuale.add(panelImpostazioniAnnuale);

        buttonImpostazioniAnnuale.addActionListener(e -> {
            centraFrame(frameImpostazioniAnnuale);
            frameImpostazioniAnnuale.setVisible(true);
        });

        panelCen.addTab("Budget annuale", panelAnnuale);

        // Fino pannello annuale

        buttonHome = new JButton();
        buttonMovimenti = new JButton();
        buttonPagamenti = new JButton();
        buttonRisparmi = new JButton();
        buttonCambioValuta = new JButton();
        buttonBudget = new JButton();

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

        buttonHome.setIcon(iconaHomeScura);
        buttonMovimenti.setIcon(iconaMovimentiScura);
        buttonPagamenti.setIcon(iconaPagamentiScura);
        buttonRisparmi.setIcon(iconaRisparmiScura);
        buttonCambioValuta.setIcon(iconaCambioValutaScura);
        buttonBudget.setIcon(iconaBudgetScura);

        buttonHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new HomeFrame(movimenti);
            }
        });

        buttonMovimenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameMovimenti(movimenti);
            }
        });

        buttonPagamenti.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FramePagamenti(movimenti);
            }
        });

        buttonRisparmi.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameRisparmi(movimenti);
            }
        });

        buttonCambioValuta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                dispose();
                new FrameCambioValuta(movimenti);
            }
        });

        panelBar = new JPanel();

        panelBar.setLayout(new GridLayout(1, 6));
        panelBar.add(buttonHome);
        panelBar.add(buttonMovimenti);
        panelBar.add(buttonPagamenti);
        panelBar.add(buttonRisparmi);
        panelBar.add(buttonCambioValuta);
        panelBar.add(buttonBudget);

        setLayout(new BorderLayout());
        add(panelBudget, BorderLayout.NORTH);
        add(panelCen, BorderLayout.CENTER);
        add(panelBar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Massimizza la finestra
        setVisible(true);
    }
}