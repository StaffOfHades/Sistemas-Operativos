
public class Mesa implements Constant {

    private static Integer[] tenedorOcupadoPor;
    private static int[] estadoFilosofos;
    private static Mesa mesa;

    private Mesa() {
        tenedorOcupadoPor = new Integer[SIZE];
        estadoFilosofos = new int[SIZE];
    }

    public static synchronized Mesa getInstance() {
        if (mesa == null)
            mesa = new Mesa();
        return mesa;
    }

    public synchronized Integer getOcupador(int i) {
        return tenedorOcupadoPor[i];
    }

    public synchronized boolean getTenedor(int i, int por) { 
        if (tenedorOcupadoPor[i] == null) {
            tenedorOcupadoPor[i] = por;
            return true;
        }
        return false;
    }

    public synchronized void returnTenedor(int i) {
        tenedorOcupadoPor[i] = null;
    }

    public synchronized int getEstadoFilosofo(int i) {
        return estadoFilosofos[i];
    }

    public synchronized void setEstadoFilosofo(int i, int estado) {
        estadoFilosofos[i] = estado;
    }

    public synchronized boolean deadlock() {
        boolean deadlock = true;
        int i = 0;
        while (deadlock && i < SIZE) {
            deadlock = estadoFilosofos[i] == Filosofo.ESPERANDO;
            i++;
        }
        return deadlock;
    }

}
