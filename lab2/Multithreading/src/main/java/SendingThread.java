
public class SendingThread extends Thread {
    Semaphore semaphore = null;

    public SendingThread(Semaphore semaphore){
        this.semaphore = semaphore;
    }

    public void run(){
        System.out.println("AAA");
        this.semaphore.take();
    }
}
