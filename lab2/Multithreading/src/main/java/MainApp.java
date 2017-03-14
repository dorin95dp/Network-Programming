import java.util.Optional;

public class MainApp {

    public static void main(String []args) throws InterruptedException {

        Semaphore semaphore = new Semaphore();

//        SendingThread sender = new SendingThread(semaphore);
//        ReceivingThread receiver = new ReceivingThread(semaphore);
//
//        sender.start();
//        receiver.start();
        ThreadM threadM = new ThreadM(semaphore);
        ThreadR threadR = new ThreadR(semaphore);

        threadM.start();
        threadR.start();

//        MyThread t1 = new MyThread();
//        t1.setID(1);
//
//        Runnable t2 = () -> {
//            System.out.println("BBB");
//        };
//        Runnable t3 = () -> {
//            System.out.println("CCC");
//        };
//
//        t1.start();
//        t2.run();
//        t3.run();

    }

}
