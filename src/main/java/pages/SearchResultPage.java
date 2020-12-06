package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Constants.VALUE;

public class SearchResultPage extends BasePage<SearchResultPage> {

    private static final String BASE_URL = "https://www.google.com";
    private static final String PATH = "/search";

    @FindBy(css = "input[class='JSAgYe']")
    private WebElement searchInputField;

    @FindBy(css = "img[src*='/logos/']")
    private WebElement googleLogo;

    public SearchResultPage(WebDriver driver) {
        super(driver, BASE_URL, PATH);
    }

    public String getSearchResultValue() {
        return searchInputField.getAttribute(VALUE);
    }

    public boolean isGoogleLogoDisplayed() {
        return googleLogo.isDisplayed();
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getCurrentUrl().startsWith(BASE_URL + PATH);
    }
}