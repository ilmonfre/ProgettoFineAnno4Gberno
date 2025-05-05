import javax.swing.*;
import java.awt.GridLayout;

public class MovimentiFrame extends JFrame{

    JPanel panelCerca;
    JTextField textCerca;
    JButton buttonFiltra, buttonEntrate, buttonUscite;
    JRadioButton radioReset;
    JSlider sliderSoldi;

    Movimenti movimenti;

    public MovimentiFrame(){

        panelCerca = new JPanel();
        panelCerca.setLayout(new GridLayout(1, 2));

        textCerca = new JTextField("Cerca movimento");
        textCerca.setColumns(20);

        buttonFiltra = new JButton();
        buttonEntrate = new JButton();
        buttonUscite = new JButton();

        sliderSoldi = new JSlider(JSlider.HORIZONTAL, 0, (int) movimenti.trovaCostoso(), 0);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}