import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class Activity extends Thread {
    private Optional<CountDownLatch> precondition;
    private Optional<Runnable> action;
    private Optional<CountDownLatch> postSignal;

    public Activity(Optional<Runnable> action,
                    Optional<CountDownLatch> precondition,
                    Optional<CountDownLatch> postSignal) {
        this.action = action;
        this.precondition = precondition;
        this.postSignal = postSignal;
    }

    public void run() {
        precondition.ifPresent(latch -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                System.out.print(e.getMessage());
            }
        });

        action.ifPresent(Runnable::run);
        postSignal.ifPresent(CountDownLatch::countDown);
    }
}
