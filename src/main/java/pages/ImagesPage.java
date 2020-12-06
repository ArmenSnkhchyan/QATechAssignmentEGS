package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImagesPage extends BasePage<ImagesPage> {

    private static final String BASE_URL = "https://images.google.com";
    private static final String PATH = "/";

    @FindBy(css = "input[class='gLFyf gsfi']")
    private WebElement searchInputField;

    @FindBy(css = "button[class='Tg7LZd']")
    private WebElement searchButton;

    public ImagesPage(WebDriver driver) {
        super(driver, BASE_URL, PATH);
    }

    public void setSearchValue(String searchValue) {
        searchInputField.sendKeys(searchValue);
    }

    public SearchResultPage clickOnSearchButton() {
        searchButton.click();
        return new SearchResultPage(getDriver());
    }
}