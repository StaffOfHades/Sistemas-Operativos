import java.util.Random;

public class Filosofo implements Runnable {
    
    private static final int PENSANDO = 1;
    private static final int COMIENDO = 2;
    private static final int ESPERANDO = 3;

    private int estado;
    private int id;
    private int timer;
    private int timerMax;
    private Random random;
    private int tenedorD;
    private bool hasTenedor;
    private int tenedorD;

    public Filosofo(int id) {
        this.id = id;
        this.timer = 0;
        this.random = new Random( System.currentTimeMillis() );
        this.timerMax = random.nextInt(5) + 1;
        this.estado = PENSANDO;
        this.hasTenedor = false;
        
        if id == 0 {
 +            this.tenedorD = SIZE-1;
 +            this.tenedorI = id;
 +      } else {
 +            this.tenedorD = id-1;
 +            this.tenedorI = id;
 +      }
        
    } 

    public synchronized void pensar() {
        System.out.println("Filosofo " + id + " pensando");
        timer++;
        if (timer >= timerMax) {
            timer = 0;
            timerMax = random.nextInt(5) + 1;
            estado = ESPERANDO;
        }

    }

    public synchronized void esperar() {
        // Checar los tendores
        if !this.hasTenedor {
            if mesa.getTenedor(this.tenedorD) {
                this.hasTenedor = true;
                if mesa.getTenedor(this.tenedorI){
                    estado = COMIENDO;
                    System.out.println("Filosofo " + id + " agarro los tenedores");
                }
            }
        }else if mesa.getTenedor(this.tenedorI) {
                estado = COMIENDO;
             System.out.println("Filosofo " + id + " agarro los tenedores");
        }
    }

    public synchronized void comer() {
        System.out.println("Filosofo " + id + " esta comiendo");
        timer++;
        if (timer >= timerMax) {
            timer = 0;
            timerMax = random.nextInt(5) + 1;
            estado = PENSANDO;
        }
    }

    @Override
    public void run() {
        //System.out.println("Filosofo " + id + " corre");

        switch (estado) {
            case PENSANDO:
                pensar();
                break;
            case ESPERANDO:
                esperar();
                break;
            case COMIENDO:
            default:
                comer();
                break;  
        }

    } 

}
