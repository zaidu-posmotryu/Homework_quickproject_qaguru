package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    @Tag("systemPropertiesTest")
    void systemPropertyTest() {
        System.getProperty("browser", "chrome");
        System.getProperty("browserVersion", "100.0");
        System.getProperty("windowSize", "800x600");
        System.getProperty("remoteURL"
                , "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }
}

