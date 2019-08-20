package volatileTest;

public class volatileTest {
    public static  int race = 0;

    public static synchronized void increase(){
        race++;
    }

    private static final int THREAD_COUNT = 200;

    public static void main(String[] args) {
        //Thread[] threads = new Thread[THREAD_COUNT];
//        for (int i = 0; i < THREAD_COUNT; i++){
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int i = 0; i < 10000; i++){
//                        increase();
//                        System.out.println(race);
//                    }
//                }
//            });
//            thread.start();
//        }
//        while (Thread.activeCount() > 1){
//            Thread.yield();
//            System.out.println(Thread.activeCount());
//        }

        //System.out.println();
        Thread.currentThread().getThreadGroup().list();

    }
}
