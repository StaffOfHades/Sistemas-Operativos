import java.awt.*;
import javax.swing.*;

public class View extends JPanel {

    public View() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GRAY);
        drawCenteredCircle(g, 300, 300, 400);
        g.setColor(Color.PINK); 
        drawCenteredCircle(g, 300, 100, 100);
        g.setColor(Color.RED);
        drawCenteredCircle(g, 480, 230, 100);
        g.setColor(Color.ORANGE);
        drawCenteredCircle(g, 440, 430, 100);
        g.setColor(Color.MAGENTA);
        drawCenteredCircle(g, 160, 430, 100);
        g.setColor(Color.CYAN);
        drawCenteredCircle(g, 120, 230, 100);

        g.setColor(Color.GREEN);
        drawLine(g, 200, 150, 230, 180, 3);
        drawLine(g, 370, 180, 400, 150, 4); 
        drawLine(g, 430, 320, 470, 340, 3); 
        drawLine(g, 170, 320, 130, 340, 4); 
        drawLine(g, 300, 470, 300, 420, 3); 
    }

    public void drawCenteredCircle(Graphics g, int x, int y, int r) {
        x = x - ( r / 2 );
        y = y - ( r / 2 );
        g.fillOval( x, y, r, r );
    }

    public void drawLine(Graphics g, int x, int y, int w, int h, int t) {
        ( (Graphics2D) g).setStroke( new BasicStroke( t ) );
        g.drawLine( x, y, w, h );
    }


}
