package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ScribblePanel extends JPanel {
    private static final float STROKE_WIDTH = 4f;
    private final ArrayList<Point> points = new ArrayList<>();

    public ScribblePanel() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();
            }
        });
    }

    public BufferedImage getSignatureImage() {
        BufferedImage img = new BufferedImage(
            Math.max(getWidth(), 1),
            Math.max(getHeight(), 1),
            BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g2 = img.createGraphics();
        paint(g2);
        g2.dispose();

        return img;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(STROKE_WIDTH, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        for (int i = 1; i < points.size(); i++) {
            Point p1 = points.get(i - 1);
            Point p2 = points.get(i);
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        g2.dispose();
    }
}
