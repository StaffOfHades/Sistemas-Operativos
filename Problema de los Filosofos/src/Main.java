public class Main implements Constant {

    private static int[] filosofos;

    public static void main(String[] args) {
        Mesa mesa = Mesa.getInstance();
        filosofos = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Filosofo f = new Filosofo(i);
            f.run();
        }

    }

}
