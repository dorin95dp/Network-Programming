import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class MainApp {

    public static void main(String []args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);
        // threadM - the signalizer thread M
        Activity threadM =  new Activity(Optional.of(() -> System.out.println("111")),
                Optional.empty(),
                Optional.of(latch)
        );
        // the receiver thread R
        Activity threadR =  new Activity(
                Optional.of(() -> {
                    new Thread25().start();
                    new Thread36().start();
                    new Thread47().start();

                }),
                Optional.of(latch),
                Optional.empty()
        );

        threadM.start();
        threadR.start();
    }
}
