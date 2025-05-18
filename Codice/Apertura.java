import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Apertura extends JFrame {

    ImageIcon imageFinale;
    JLabel labelImmagine;
    JPanel panelImage, panelScelta;
    JButton buttonAccedi, buttonRegistrati;

    Font font;

    public Apertura() {

        setLayout(new GridLayout(2, 1));

        setFocusable(true);  // per non far posizionare inizialmente il cursore
        requestFocusInWindow();

        panelImage = new JPanel();
        //panelImage.setBackground(Color.WHITE);

        try {
            BufferedImage imageIcon = ImageIO.read(getClass().getResourceAsStream("/Immagini/LogoBanca.jpg/"));

            int larghezzaImmagine = 200;
            int altezzaImmagine = 200;

            BufferedImage imageRidimensionata = new BufferedImage(larghezzaImmagine, altezzaImmagine, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = imageRidimensionata.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.drawImage(imageIcon, 0, 0, larghezzaImmagine, altezzaImmagine, null);
            g2d.dispose();

            imageFinale = new ImageIcon(imageRidimensionata);
            labelImmagine = new JLabel(imageFinale);
            labelImmagine.setOpaque(false);

            panelImage.add(labelImmagine);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        panelScelta = new JPanel();
        panelScelta.setBackground(Color.WHITE);
        panelScelta.setBorder(BorderFactory.createEmptyBorder(20, 20, 40, 20));
        panelScelta.setLayout(new GridLayout(2, 1, 20, 40));

        font = new Font("Serif", Font.BOLD, 24);
        
        buttonAccedi = new JButton("Accedi");
        buttonAccedi.setForeground(Color.decode("#cbf4f4"));
        buttonRegistrati = new JButton("Registrati");
        buttonRegistrati.setForeground(Color.decode("#cbf4f4"));

        buttonAccedi.setFont(font);
        buttonRegistrati.setFont(font);

        buttonAccedi.setBackground(Color.decode("#1c2697"));
        buttonRegistrati.setBackground(Color.decode("#1c2697"));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int x = (screenSize.width - 500) / 2;
        int y = (screenSize.height - 550) / 2;

        setLocation(x, y);

        buttonAccedi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FrameAccedi();
            }
        });

        buttonRegistrati.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new FrameRegistrazione();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        panelScelta.add(buttonAccedi);
        panelScelta.add(buttonRegistrati);

        add(panelImage);
        add(panelScelta);

        panelImage.setBackground(Color.decode("#cbf4f4"));
        panelScelta.setBackground(Color.decode("#cbf4f4"));

        setSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(new Runnable() {
    //         @Override
    //         public void run() {
    //             new Apertura();
    //         }
    //     });
    // }

}