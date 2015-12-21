import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleLoggingTest {

    Logger log = LoggerFactory.getLogger(SimpleLoggingTest.class);


    @Test
    public void ShouldLogSomething() {
        log.info("Hello World");
    }
}
