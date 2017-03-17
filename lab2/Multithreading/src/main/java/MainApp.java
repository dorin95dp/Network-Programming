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

    }

}
