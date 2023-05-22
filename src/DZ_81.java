import java.util.concurrent.Semaphore;

public class DZ_81 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        for (int i = 0; i < 50; i++) {
            Gocar gocar = new Gocar(i,semaphore);
        }
    }
}
