import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Thread25 extends Thread {
    public void run() {

        CountDownLatch latch25 = new CountDownLatch(1);

        new Activity(Optional.of(() -> System.out.println(222)),
                Optional.empty(),
                Optional.of(latch25)).start();

        new Activity(Optional.of(() -> System.out.println(555)),
                Optional.of(latch25),
                Optional.empty()).start();
    }
}
