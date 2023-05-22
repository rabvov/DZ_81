import java.util.concurrent.Semaphore;

public class Gocar implements Runnable {
    private final int number;
    private final Semaphore semaphore;

    public Gocar(int number, Semaphore semaphore) {
        this.number = number;
        this.semaphore = semaphore;
        new Thread(this).start();
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Заехала "+number+" машина");
            Thread.sleep(2000);
            System.out.println("Выехала "+number+" машина");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }}