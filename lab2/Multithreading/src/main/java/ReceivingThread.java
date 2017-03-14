public class ReceivingThread extends Thread {
    Semaphore semaphore = null;

    public ReceivingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run() {
        try {
            this.semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("BBB");
    }
}
