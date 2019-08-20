package AtomicIn;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIn {
    static AtomicInteger count = new AtomicInteger(0);

    public static void increment() {
        count.getAndIncrement();// 先返回在++
        System.err.println(Thread.currentThread().getName() + "--" + count + "-----");

    }
    public static void main(String[] args) {
        System.err.println("**********" + Thread.activeCount());
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Th1());
            t.start();
        }
        System.err.println("**********" + Thread.activeCount());
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.err.println(AtomicIn.count);
    }
}
