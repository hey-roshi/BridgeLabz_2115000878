import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest {
    void longRunningTask() throws InterruptedException {
        Thread.sleep(3000);
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testLongRunningTask() throws InterruptedException {
        longRunningTask();
    }
}
