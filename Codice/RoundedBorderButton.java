import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedBorderButton extends JToggleButton {

    private final Color borderColor;
    private final Color fillColor;
    private final Color textColor;

    private final Color hoverBorderColor;
    private final Color hoverFillColor;
    private final Color hoverTextColor;

    private final int thickness;
    private final int arcWidth;
    private final int arcHeight;

    private boolean hovering = false;

    public RoundedBorderButton(String text,
                                Color borderColor, Color fillColor, Color textColor,
                                Color hoverBorderColor, Color hoverFillColor, Color hoverTextColor,
                                int thickness, int arcWidth, int arcHeight) {

        super(text);
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.textColor = textColor;

        this.hoverBorderColor = hoverBorderColor;
        this.hoverFillColor = hoverFillColor;
        this.hoverTextColor = hoverTextColor;

        this.thickness = thickness;
        this.arcWidth = arcWidth;
        this.arcHeight = arcHeight;

        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(textColor);
        setFont(new Font("Arial", Font.BOLD, 16));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(hovering ? hoverFillColor : fillColor);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
        setForeground(hovering ? hoverTextColor : textColor);
        super.paintComponent(g);
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(hovering ? hoverBorderColor : borderColor);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRoundRect(thickness / 2, thickness / 2, getWidth() - thickness, getHeight() - thickness, arcWidth, arcHeight);
        g2d.dispose();
    }
}
