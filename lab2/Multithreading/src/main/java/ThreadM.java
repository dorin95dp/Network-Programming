public class ThreadM extends Thread {
    Semaphore semaphore = null;

    public ThreadM(Semaphore semaphore){

        this.semaphore = semaphore;
    }

    public void run(){
        System.out.println("MMM");
        this.semaphore.take();
    }
}
