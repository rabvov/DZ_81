import java.util.concurrent.Semaphore;

public class DZ_81 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Gocar gocar = new Gocar(14,semaphore);
        Outcar outcar3 = new Outcar(4,semaphore);
        Gocar gocar1 = new Gocar(2,semaphore);
        Outcar outcar = new Outcar(8,semaphore);
        Outcar outcar2 = new Outcar(2,semaphore);
    }
}
