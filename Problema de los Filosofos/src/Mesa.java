
public class Mesa implements Constant {

    private static boolean[] tenedorOcupado;
    private static Mesa mesa;

    private Mesa() {
        tenedorOcupado = new boolean[SIZE];
    }

    public static synchronized Mesa getInstance() {
        if (mesa == null)
            mesa = new Mesa();
        return mesa;
    }


    public synchronized boolean getTenedor(int i) { 
        if (!tenedorOcupado[i])
            return tenedorOcupado[i] = true;
        return false;
    }

    public synchronized void returnTenedor(int i) {
        tenedorOcupado[i] = false;
    }

}
