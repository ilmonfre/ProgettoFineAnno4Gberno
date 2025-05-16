import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
public class FrameCambioValuta extends JFrame {
    private JTextField inputField, outputField;
    private JComboBox<String> currencyBox;
    private JButton btnImage;
    private Map<String, Double> exchangeRates;
    private JLabel labelCambioValuta, labelImporto, labelRisultato;
    private JPanel barraSuperiore, panelCambio, panelBar;
    private boolean darkTheme = false;

    // Icone
    private ImageIcon imageLuna, imageSole, imageCambioValuta, imageCambioValutaChiara;
    private ImageIcon imageHome, imageHomeChiara, imageMovimenti, imageMovimentiChiara;
    private ImageIcon imagePagamenti, imagePagamentiChiara, imageBudget, imageBudgetChiara;
    private ImageIcon imageRisparmi, imageRisparmiChiara;

    private JButton buttonHome, buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonBudget, buttonCambioValuta;

    public FrameCambioValuta() {
        setTitle("Cambio Valuta");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setFocusable(true);
        requestFocusInWindow();

        // Caricamento icone
        imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));
        imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));
        imageCambioValuta = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaScuraPiena.png"));
        imageCambioValutaChiara = new ImageIcon(getClass().getResource("/Immagini/IconaCambioValutaChiaraPiena.png"));
        imageHome = new ImageIcon(getClass().getResource("/Immagini/IconaHomeScura.png"));
        imageHomeChiara = new ImageIcon(getClass().getResource("/Immagini/IconaHomeChiara.png"));
        imageMovimenti = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiScura.png"));
        imageMovimentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaMovimentiChiara.png"));
        imagePagamenti = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiScura.png"));
        imagePagamentiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaPagamentiChiara.png"));
        imageBudget = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetScura.png"));
        imageBudgetChiara = new ImageIcon(getClass().getResource("/Immagini/IconaBudgetChiara.png"));
        imageRisparmi = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiScura.png"));
        imageRisparmiChiara = new ImageIcon(getClass().getResource("/Immagini/IconaRisparmiChiara.png"));

        // Barra superiore
        barraSuperiore = new JPanel(new BorderLayout());
        barraSuperiore.setPreferredSize(new Dimension(500, 50));
        barraSuperiore.setBackground(Color.decode("#cbf4f4"));

        // Pulsante tema (a destra)
        btnImage = new JButton(imageLuna);
        btnImage.setBorderPainted(false);
        btnImage.setContentAreaFilled(false);

        // Label centrale
        labelCambioValuta = new JLabel("Cambio Valuta", SwingConstants.CENTER);
        labelCambioValuta.setFont(new Font("Arial", Font.BOLD, 30));
        labelCambioValuta.setForeground(Color.decode("#1c2697"));

        barraSuperiore.add(labelCambioValuta, BorderLayout.CENTER);
        barraSuperiore.add(btnImage, BorderLayout.EAST);

        // Pannello centrale
        panelCambio = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCambio.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelCambio.setBackground(Color.decode("#cbf4f4"));

        labelImporto = new JLabel("Inserisci Importo:");
        labelImporto.setFont(new Font("Arial", Font.BOLD, 25));
        labelImporto.setHorizontalAlignment(SwingConstants.CENTER);
        labelImporto.setForeground(Color.decode("#1c2697"));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.BOLD, 25));
        inputField.setHorizontalAlignment(SwingConstants.CENTER);
        inputField.setBackground(Color.WHITE);
        inputField.setForeground(Color.decode("#1c2697"));

        labelRisultato = new JLabel("Importo Convertito:");
        labelRisultato.setFont(new Font("Arial", Font.BOLD, 25));
        labelRisultato.setHorizontalAlignment(SwingConstants.CENTER);
        labelRisultato.setForeground(Color.decode("#1c2697"));

        outputField = new JTextField();
        outputField.setFont(new Font("Arial", Font.BOLD, 25));
        outputField.setHorizontalAlignment(SwingConstants.CENTER);
        outputField.setBackground(Color.WHITE);
        outputField.setForeground(Color.decode("#1c2697"));
        outputField.setEditable(false);

        panelCambio.add(labelImporto);
        panelCambio.add(inputField);
        panelCambio.add(labelRisultato);
        panelCambio.add(outputField);

        // ComboBox valute
        currencyBox = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "JPY"});
        currencyBox.setFont(new Font("Arial", Font.BOLD, 18));
        currencyBox.setBackground(Color.WHITE);
        currencyBox.setForeground(Color.decode("#1c2697"));
        barraSuperiore.add(currencyBox, BorderLayout.WEST);

        // Tassi di cambio
        exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.1);
        exchangeRates.put("EUR", 1.0);
        exchangeRates.put("GBP", 0.85);
        exchangeRates.put("JPY", 130.0);

        // Barra inferiore con icone
        panelBar = new JPanel(new GridLayout(1, 6));
        panelBar.setBackground(Color.WHITE);

        buttonHome = new JButton(imageHome);
        buttonMovimenti = new JButton(imageMovimenti);
        buttonPagamenti = new JButton(imagePagamenti);
        buttonRisparmi = new JButton(imageRisparmi);
        buttonCambioValuta = new JButton(imageCambioValuta);
        buttonBudget = new JButton(imageBudget);

        JButton[] btns = {buttonHome, buttonMovimenti, buttonPagamenti, buttonRisparmi, buttonCambioValuta, buttonBudget};
        for (JButton b : btns) {
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);
        }

        panelBar.add(buttonHome);
        panelBar.add(buttonMovimenti);
        panelBar.add(buttonPagamenti);
        panelBar.add(buttonRisparmi);
        panelBar.add(buttonCambioValuta);
        panelBar.add(buttonBudget);

        // Listeners
        currencyBox.addActionListener(e -> convertCurrency());
        inputField.addActionListener(e -> convertCurrency());

        btnImage.addActionListener(e -> toggleTheme());

        // Azioni pulsanti barra inferiore (da personalizzare)
        buttonHome.addActionListener(e -> {
            dispose();
            new HomeFrame();
        });
        buttonMovimenti.addActionListener(e -> {
            dispose();
            // new MovimentiFrame();
        });
        buttonPagamenti.addActionListener(e -> {
            dispose();
            // new PagamentiFrame();
        });
        buttonRisparmi.addActionListener(e -> {
            dispose();
            new FrameRisparmi();
        });
        buttonBudget.addActionListener(e -> {
            dispose();
            // new BudgetFrame();
        });

        // Layout principale
        setLayout(new BorderLayout());
        add(barraSuperiore, BorderLayout.NORTH);
        add(panelCambio, BorderLayout.CENTER);
        add(panelBar, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            String selectedCurrency = (String) currencyBox.getSelectedItem();
            double convertedAmount = amount * exchangeRates.get(selectedCurrency);
            outputField.setText(String.format("%.2f %s", convertedAmount, selectedCurrency));
        } catch (NumberFormatException e) {
            outputField.setText("Inserisci un numero valido!");
        }
    }

    private void toggleTheme() {
        darkTheme = !darkTheme;
        if (darkTheme) {
            // Tema scuro
            btnImage.setIcon(imageSole);
            barraSuperiore.setBackground(Color.decode("#1c2697"));
            labelCambioValuta.setForeground(Color.decode("#cbf4f4"));
            labelImporto.setForeground(Color.decode("#cbf4f4"));
            labelRisultato.setForeground(Color.decode("#cbf4f4"));
            inputField.setBackground(Color.decode("#2f48d0"));
            inputField.setForeground(Color.decode("#cbf4f4"));
            outputField.setBackground(Color.decode("#2f48d0"));
            outputField.setForeground(Color.decode("#cbf4f4"));
            panelCambio.setBackground(Color.decode("#1c2697"));
            panelBar.setBackground(Color.decode("#2f48d0"));
            buttonHome.setIcon(imageHomeChiara);
            buttonMovimenti.setIcon(imageMovimentiChiara);
            buttonRisparmi.setIcon(imageRisparmiChiara);
            buttonPagamenti.setIcon(imagePagamentiChiara);
            buttonBudget.setIcon(imageBudgetChiara);
            buttonCambioValuta.setIcon(imageCambioValutaChiara);
            currencyBox.setBackground(Color.decode("#2f48d0"));
            currencyBox.setForeground(Color.decode("#cbf4f4"));
        } else {
            // Tema chiaro
            btnImage.setIcon(imageLuna);
            barraSuperiore.setBackground(Color.decode("#cbf4f4"));
            labelCambioValuta.setForeground(Color.decode("#1c2697"));
            labelImporto.setForeground(Color.decode("#1c2697"));
            labelRisultato.setForeground(Color.decode("#1c2697"));
            inputField.setBackground(Color.WHITE);
            inputField.setForeground(Color.decode("#1c2697"));
            outputField.setBackground(Color.WHITE);
            outputField.setForeground(Color.decode("#1c2697"));
            panelCambio.setBackground(Color.decode("#cbf4f4"));
            panelBar.setBackground(Color.WHITE);
            buttonHome.setIcon(imageHome);
            buttonMovimenti.setIcon(imageMovimenti);
            buttonRisparmi.setIcon(imageRisparmi);
            buttonPagamenti.setIcon(imagePagamenti);
            buttonBudget.setIcon(imageBudget);
            buttonCambioValuta.setIcon(imageCambioValuta);
            currencyBox.setBackground(Color.WHITE);
            currencyBox.setForeground(Color.decode("#1c2697"));
        }
    }

    // public static void main(String[] args) {
    //     new FrameCambioValuta();
    // }
}
