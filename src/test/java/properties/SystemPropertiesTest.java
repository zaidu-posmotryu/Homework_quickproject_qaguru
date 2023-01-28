package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTest {
    @Test
    @Tag("trySystemProperties")
    void systemPropertyTest() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "99.0");
        String browserSize = System.getProperty("browserSize", "800x600");
        System.out.println(browser + " " + browserVersion + " " + browserSize);
    }
}