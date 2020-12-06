package ui;

import org.testng.annotations.Test;
import pages.ImagesPage;
import pages.SearchResultPage;

import static helpers.DriverHelper.getDriver;
import static helpers.Constants.COUNTRY_NAME;

public class GoogleSearchFunctionalityTest extends BaseTest {

    @Test
    public void checkSearchFunctionalityWithValidData() {
        ImagesPage imagesPage = new ImagesPage(getDriver());
        SearchResultPage searchResultPage;

        imagesPage.get();
        imagesPage.setSearchValue(COUNTRY_NAME);
        searchResultPage = imagesPage.clickOnSearchButton();

        assert searchResultPage.isOnPage();
        assert searchResultPage.isGoogleLogoDisplayed();
        assert searchResultPage.getSearchResultValue().equals(COUNTRY_NAME);
    }

    @Test
    public void checkSearchFunctionalityWithInvalidData() {
        ImagesPage imagesPage = new ImagesPage(getDriver());
        SearchResultPage searchResultPage;

        imagesPage.get();
        imagesPage.setSearchValue("");
        searchResultPage = imagesPage.clickOnSearchButton();

        assert !searchResultPage.isOnPage();
    }
}