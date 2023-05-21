import java.util.concurrent.Semaphore;

public class Outcar implements Runnable{
    private final int car;
    private final Semaphore name;

    public Outcar(int car, Semaphore name) {
        this.car = car;
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
            try {
                name.acquire();
                for (int i = 0; i < car; i++) {
                   if (Paking.queue>0){
                        Paking.queue--;
                        }
                   else if (Paking.count<0) {
                       System.out.println("На парковке нет столько машин");
                       Paking.count=0;
                       System.exit(1);

                   } else{
                       Paking.count--;}
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

