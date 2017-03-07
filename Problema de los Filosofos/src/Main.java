import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

public class Main implements Constant {

    private static Filosofo[] filosofos;

    public static void main(String[] args) {
        //crearFilosofos();
        crearGui();
    }

    private static void crearFilosofos() {
        Mesa mesa = Mesa.getInstance();
        filosofos = new Filosofo[SIZE];
        for (int i = 0; i < SIZE; i++) {
            filosofos[i]  = new Filosofo(i);
            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(filosofos[i], 0, DELAY, TimeUnit.MILLISECONDS);
        }
    }

    private static void crearGui() {
        JFrame frame = new JFrame("Problema de los Filosofos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(100, 100, 450, 300);

        frame.getContentPane().add(new View());
        frame.pack();
        frame.setVisible(true);

    }

}
