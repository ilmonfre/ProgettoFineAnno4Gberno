import javax.swing.border.Border;
import java.awt.*;

public class RoundedBorder implements Border {
    private final int thickness;
    private final int arcWidth;
    private final int arcHeight;
    private final Color color;

    public RoundedBorder(int thickness, int arcWidth, int arcHeight, Color color) {
        this.thickness = thickness;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;
        this.color = color;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect(x + thickness / 2, y + thickness / 2,
        width - thickness, height - thickness,
        arcWidth, arcHeight);
        g2.dispose();
    }
}