
public class Filosofo implements Runnable implements Constant{
    
    private static final int PENSANDO = 1;
    private static final int COMIENDO = 2;
    private static final int ESPERANDO = 3;

    private int estado;
    private int id;
    private int tenedorI; //tenedor izquierdo
    private int tenedorD; //tenedor derecho
    
    // o = filosofo
    // y = tenedor
    //     0 0 1 1
    //     O y O y 
    //   4 y     O 2
    //     O y O y 2
    //     4 3 3
    //

    public Filosofo(int id) {
        this.id = id;
        
        if id == 0 {
            tenedorD = SIZE-1;
            tenedorI = id;
        } else {
            tenedorD = id-1;
            tenedorI = id;
        }
        
        estado = PENSANDO;
            
    } 

    public synchronized void pensar() {

    }

    public synchronized void esperar() {
        
        if mesa.getTenedor(tenedorD) {
            
            if mesa.getTenedor(tenedorI) {
                estado = COMIENDO;
            }
        }

    }

    public synchronized void comer() {

    }

    @Override
    public void run() {
        System.out.println("Filosofo " + id + " corre");
    } 

}
