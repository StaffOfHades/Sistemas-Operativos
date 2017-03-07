import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

public class Main implements Constant {

    public static void main(String[] args) {
        crearFilosofos();
        crearGui();
    }

    private static void crearFilosofos() {
        Mesa mesa = Mesa.getInstance();
        for (int i = 0; i < SIZE; i++) {
            Filosofo f  = new Filosofo(i);
            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(f, 0, DELAY, UNIT);
        }
    }

    private static void crearGui() {
        JFrame frame = new JFrame("Problema de los Filosofos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 450, 300);
        final View view = new View();

        frame.getContentPane().add(view);
        frame.pack();
        frame.setVisible(true);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                view.repaint();
            }
        }, 0, DELAY, UNIT);

    }

}
