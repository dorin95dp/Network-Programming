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
            System.out.println("AAA");
        };
        Runnable threadB = () -> {
            System.out.println("BBB");
        };
        Runnable threadC = () -> {
            System.out.println("CCC");
        };

        threadA.run();
        threadB.run();
        threadC.run();
    }
}