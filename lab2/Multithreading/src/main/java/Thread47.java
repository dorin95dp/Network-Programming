import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Thread47 extends Thread {
    public void run() {

        CountDownLatch latch47 = new CountDownLatch(1);

        new Activity(Optional.of(() -> System.out.println(444)),
                Optional.empty(),
                Optional.of(latch47)).start();

        new Activity(Optional.of(() -> System.out.println(777)),
                Optional.of(latch47),
                Optional.empty()).start();
    }
}
