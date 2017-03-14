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
        Thread treadA = new Thread() {
            public void run() {
                // implement a node dependent of another
                System.out.println("AAA");
            }
        };
        Thread treadB = new Thread() {
            public void run() {
                // implement a node dependent of another
                System.out.println("BBB");
            }
        };
        Thread treadC = new Thread() {
            public void run() {
                // implement a node dependent of another
                System.out.println("CCC");
            }
        };

        treadA.start();
        treadB.start();
        treadC.start();
    }
}