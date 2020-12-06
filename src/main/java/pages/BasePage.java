package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    private final WebDriver driver;
    private final String baseUrl;
    private final String path;

    public BasePage(WebDriver driver, String baseUrl, String path) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        this.path = path;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(baseUrl + path);
    }

    @Override
    protected void isLoaded() throws Error {
        assert isOnPage();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getPath() {
        return path;
    }

    public boolean isOnPage() {
        return driver.getCurrentUrl().endsWith(path);
    }
}