import java.util.concurrent.*;

public class MainApp {

//    static Semaphore s = new Semaphore(0);
    static Semaphore s = new Semaphore(0, true);


    public static void main(String []args) throws InterruptedException {

        MyThread t1 = new MyThread();
        t1.setID(1);

        Runnable t2 = () -> {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("BBB");
        };
        Runnable t3 = () -> {
            System.out.println("CCC");
            s.release();
        };

        t1.start();
        t2.run();
        t3.run();



    }

}
