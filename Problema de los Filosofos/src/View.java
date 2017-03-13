import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class View extends JPanel implements Constant {

    private Color[] colors;
    private Circle[] circles;
    private BufferedImage[] images;
    private BufferedImage laMesa;
    private int[] position;
    private Line[] lines;

    private BufferedImage WAITING;
    private BufferedImage EATING;
    private BufferedImage THINKING;

    private static final Color ESPERANDO = new Color(137, 162, 54);
    private static final Color PENSANDO = new Color(66, 48, 117);
    private static final Color COMIENDO = new Color(128, 72, 21);
    private static final Color LIBRE = new Color(33, 85, 11);

    public View() {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(600, 600));
        
        colors = new Color[SIZE];
        circles = new Circle[SIZE];
        lines = new Line[SIZE];

        colors[0] = Color.PINK;
        colors[1] = Color.RED;
        colors[2] = Color.ORANGE;
        colors[3] = Color.MAGENTA;
        colors[4] = Color.CYAN;

        circles[0] = new Circle(300, 100, 100, 5, ESPERANDO);
        circles[1] = new Circle(480, 230, 100, 5, ESPERANDO);
        circles[2] = new Circle(440, 430, 100, 5, ESPERANDO);
        circles[3] = new Circle(160, 430, 100, 5, ESPERANDO);
        circles[4] = new Circle(120, 230, 100, 2, ESPERANDO);

      /*  position[0] = 300,100;
        position[1] = 480,230;
        position[2] = 440, 430;
        position[3] = 160,430;
        position[4] = 120,230;
        */

        try {
            laMesa = ImageIO.read(new File("assets/mesa.png"));
            WAITING = ImageIO.read(new File("assets/waiting.png"));
            EATING = ImageIO.read(new File("assets/eating.png"));
            THINKING = ImageIO.read(new File("assets/thinking.png"));

        } catch (IOException e) {}

        images[0] = WAITING;
        images[1] = WAITING;
        images[2] = WAITING;
        images[3] = WAITING;
        images[4] = WAITING;

        lines[4] = new Line(200, 230, 150, 180, 3, LIBRE);
        lines[0] = new Line(370, 400, 180, 150, 3, LIBRE);
        lines[1] = new Line(430, 470, 320, 340, 3, LIBRE);
        lines[3] = new Line(130, 170, 340, 320, 3, LIBRE);
        lines[2] = new Line(300, 300, 470, 420, 3, LIBRE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        updateColors();
        drawMesa(g);
        drawFilosofos(g);   
        drawTenedores(g);
    }

    private void updateColors() {
        Mesa mesa = Mesa.getInstance();
        Integer n;        
        int t;

        for (int i = 0; i < SIZE; i++) {
            n = mesa.getOcupador(i);
            t = i + 1;
            if (t >= SIZE) {
                t = 0;
            }
            if (n != null) {
                lines[i].color = colors[n]; //set fork to filosofo
            } else {
                lines[i].color = LIBRE;     //set fork to free
            }
        }
         
        for (int i = 0; i < SIZE; i++) {
            n = mesa.getEstadoFilosofo(i);
            switch (n) {
                case Filosofo.PENSANDO:
                    circles[i].outline = PENSANDO; // set filosofos
                    //images[i] = THINKING;
                    break;
                case Filosofo.COMIENDO:
                    circles[i].outline = COMIENDO;
                    //images[i] = EATING;
                    break;
                case Filosofo.ESPERANDO:
                default:
                    circles[i].outline = ESPERANDO;
                    //images[i] = WAITING;
                    break;
                }
        }
  
    }

    private void drawMesa(Graphics g) {
       /* g.setColor(Color.GRAY);
        fillCenteredCircle(g, 300, 300, 400);
        g.setColor(Color.BLACK);
        drawCenteredCircle(g, 300, 300, 400, 2);
        */
        g.drawImage(laMesa, 0, 0, null);
    }

    private void drawFilosofos(Graphics g) {
        for (int i = 0; i < SIZE; i++) {
            Circle c = circles[i]; //change to draw image
            g.setColor(colors[i]);
            fillCenteredCircle(g, c.x, c.y, c.r);
            g.setColor(c.outline);
            drawCenteredCircle(g, c.x, c.y, c.r, c.t);

        }
    }

    private void drawTenedores(Graphics g) {
        for (int i = 0; i < SIZE; i++) {
            Line l = lines[i];
            g.setColor(l.color);
            drawLine(g, l.x1, l.y1, l.x2, l.y2, l.t);
        }
    }

    private void fillCenteredCircle(Graphics g, int x, int y, int r) { 
        x = x - ( r / 2 );
        y = y - ( r / 2 );
        g.fillOval( x, y, r, r );
    }
    
    private void drawCenteredCircle(Graphics g, int x, int y, int r, int t) {
         ( (Graphics2D) g).setStroke( new BasicStroke( t ) );
         x = x - ( r / 2 );
        y = y - ( r / 2 );
        g.drawOval( x, y, r, r );
    }

    private void drawLine(Graphics g, int x, int y, int w, int h, int t) {
        ( (Graphics2D) g).setStroke( new BasicStroke( t ) );
        g.drawLine( x, y, w, h );
    }

    private class Circle {
        int x;
        int y;
        int r;
        Color outline;
        int t;

        Circle(int x, int y, int r, int t, Color outline) {
            this.x = x;
            this.y = y;
            this.r = r;
            this.outline = outline;
            this.t = t;
        }  
    }

    private class Line {
        int x1; 
        int y1;
        int x2;
        int y2;
        int t;
        Color color;
        
        Line(int x1, int x2, int y1, int y2, int t, Color color) {
            this.color = color;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.t = t;
        } 
       
    }
}
