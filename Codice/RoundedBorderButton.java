import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoundedBorderButton extends JToggleButton {

    private Color borderColor;
    private Color fillColor;
    private Color textColor;

    private Color hoverBorderColor;
    private Color hoverFillColor;
    private Color hoverTextColor;

    private int thickness;
    private int arcWidth;
    private int arcHeight;

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

    public void setColors(Color borderColor, Color fillColor, Color textColor, Color hoverBorderColor, Color hoverFillColor, Color hoverTextColor) {
        
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.textColor = textColor;

        this.hoverBorderColor = hoverBorderColor;
        this.hoverFillColor = hoverFillColor;
        this.hoverTextColor = hoverTextColor;

        setForeground(textColor); // aggiorna colore testo subito
        repaint();
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
