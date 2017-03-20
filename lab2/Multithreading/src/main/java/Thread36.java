import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Thread36 extends Thread {
    public void run() {

        CountDownLatch latch36 = new CountDownLatch(1);

        new Activity(Optional.of(() -> System.out.println(333)),
                Optional.empty(),
                Optional.of(latch36)).start();

        new Activity(Optional.of(() -> System.out.println(666)),
                Optional.of(latch36),
                Optional.empty()).start();
    }
}
