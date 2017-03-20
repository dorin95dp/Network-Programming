import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class MainApp {

    public static void main(String []args) throws InterruptedException {

        CountDownLatch dependency = new CountDownLatch(2);

        new Activity(Optional.of(() -> System.out.println("Action in 3")),
                     Optional.of(dependency),
                     Optional.empty()).start();

        new Activity(Optional.of(() -> System.out.println("Action in 1")),
                     Optional.empty(),
                     Optional.of(dependency)).start();

        new Activity(Optional.of(() -> System.out.println("Action in 2")),
                     Optional.empty(),
                     Optional.of(dependency)).start();

    }

}
