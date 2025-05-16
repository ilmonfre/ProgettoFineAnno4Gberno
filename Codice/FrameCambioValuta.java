import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class FrameCambioValuta {
    public FrameCambioValuta(){
        JFrame frameCambioValuta = new JFrame("Zaphyra Bank - Cambio Valuta");
        frameCambioValuta.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frameCambioValuta.setFocusable(true);
        frameCambioValuta.requestFocusInWindow();

        JPanel barraSuperiore = new JPanel();
        barraSuperiore.setBackground(Color.decode("#cbf4f4"));

        ImageIcon imagePiu = new ImageIcon(getClass().getResource("/Immagini/Icona+Scura.png"));
        ImageIcon imagePiuBianca = new ImageIcon(getClass().getResource("/Immagini/Icona+Chiara.png"));
        ImageIcon imageLuna = new ImageIcon(getClass().getResource("/Immagini/IconaLuna.png"));
        ImageIcon imageSole = new ImageIcon(getClass().getResource("/Immagini/IconaSole.png"));

        JButton btnPls = new JButton(imagePiu);
        btnPls.setBorderPainted(false);
        btnPls.setContentAreaFilled(false);

        JButton btnImage = new JButton(imageLuna);
        btnImage.setBorderPainted(false);
        btnImage.setContentAreaFilled(false);

        JLabel labelCambioValuta = new JLabel("Cambio Valuta");
        labelCambioValuta.setFont(new Font("Arial", Font.BOLD, 30));
        labelCambioValuta.setForeground(Color.decode("#1c2697"));

        barraSuperiore.add(btnPls, BorderLayout.WEST);
        barraSuperiore.add(btnImage, BorderLayout.EAST);
        labelCambioValuta.setHorizontalAlignment(SwingConstants.CENTER);
        barraSuperiore.add(labelCambioValuta, BorderLayout.CENTER);

        JPanel panelCambioValuta = new JPanel();
        panelCambioValuta.setLayout(new GridLayout(2, 2));
        panelCambioValuta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        RoundedTextField textFieldOriginaria = new RoundedTextField(20, 30);
        RoundedTextField textFieldDestinazione = new RoundedTextField(20, 30);
        



    }
    



    public static void main(String[] args) {
        new FrameCambioValuta();
    }
}
