
public class Filosofo implements Runnable {
    
    private static final int PENSANDO = 1;
    private static final int COMIENDO = 2;
    private static final int ESPERANDO = 3;

    private int estado;
    private int id;

    public Filosofo(int id) {
        this.id = id;
    } 

    public synchronized void pensar() {

    }

    public synchronized void esperar() {

    }

    public synchronized boolean agarrarTenedor() {
        return false;
    }

    public synchronized void comer() {

    }

    @Override
    public void run() {
        System.out.println("Filosofo " + id + " corre");
    } 

}
