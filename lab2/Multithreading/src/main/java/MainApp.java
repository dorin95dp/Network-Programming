public class MainApp {

    public static void main(String []args) throws InterruptedException {

        for (int i = 1; i < 11; i++) {
            MyThread thread1 = new MyThread();
            thread1.setID(i);
            thread1.start();
        }


    }

}
