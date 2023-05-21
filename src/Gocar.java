import java.util.concurrent.Semaphore;

public class Gocar implements Runnable {
    private final int car;
    private final Semaphore name;

    public Gocar(int car, Semaphore name) {
        this.car = car;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            name.acquire();
            for (int i = 0; i < car; i++) {
                if (Paking.count<=Paking.maxCount){
                    Paking.count++;
                }
                else  {
                    Paking.queue++;
                }
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("На парковке "+Paking.count);
        System.out.println("В очереди "+Paking.queue);
        System.out.println();
        name.release();
    }
    }

