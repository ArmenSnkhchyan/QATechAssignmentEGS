package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static helpers.DriverHelper.getDriver;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
    }

    /**
     * If you need this method, change the value to true.
     */
    @AfterMethod(enabled = false)
    public static void closeDriver() {
        getDriver().close();
    }

    @AfterClass
    public static void turnDown() {
        getDriver().quit();
    }
}