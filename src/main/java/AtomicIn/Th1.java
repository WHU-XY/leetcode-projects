package AtomicIn;

public class Th1 implements Runnable {
    @Override
    public void run() {
        AtomicIn.increment();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
