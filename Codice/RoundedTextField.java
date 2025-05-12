import javax.swing.*;
import java.awt.*;

public class RoundedTextField extends JTextField {

    private int arc;

    public RoundedTextField(int columns, int arc) {
        super(columns);
        this.arc = arc;
        setOpaque(false);  // per rendere lo sfondo trasparente
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // padding interno
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.GRAY);  // colore del bordo
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, arc, arc);
        g2.dispose();
    }
}