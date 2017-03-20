import java.util.concurrent.*;

public class ThreadR extends Thread {
    Semaphore semaphore = null;

    public ThreadR(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            this.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("RRR");

        Runnable threadA = () -> {
//            System.out.println("AAA");
            Semaphore s25 = new Semaphore();
            SendingThread thread2 = new SendingThread(s25) {
                public void run() {
                    System.out.println("222");
                }
            };
            ReceivingThread thread5 = new ReceivingThread(s25) {
                public void run() {
                    System.out.println("555");
                }
            };
            thread2.start();
            thread5.start();
        };
        Runnable threadB = () -> {
//            System.out.println("BBB");
            Semaphore s36 = new Semaphore();
            SendingThread thread3 = new SendingThread(s36) {
                public void run() {
                    System.out.println("333");
                }
            };
            ReceivingThread thread6 = new ReceivingThread(s36) {
                public void run() {
                    System.out.println("666");
                }
            };
            thread3.start();
            thread6.start();
        };
        Runnable threadC = () -> {
//            System.out.println("CCC");
            Semaphore s47 = new Semaphore();
            SendingThread thread4 = new SendingThread(s47) {
                public void run() {
                    System.out.println("444");
                }
            };
            ReceivingThread thread7 = new ReceivingThread(s47) {
                public void run() {
                    System.out.println("777");
                }
            };
            thread4.start();
            thread7.start();
        };

        threadA.run();
        threadB.run();
        threadC.run();
    }
}