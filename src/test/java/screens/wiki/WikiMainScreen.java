package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiMainScreen {

    private final SelenideElement searchButton = $(AppiumBy.id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement savedTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_reading_lists"));
    private final SelenideElement searchTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_search"));
    private final SelenideElement activityTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_edits"));
    private final SelenideElement mainScreenTitle = $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar_wordmark"));

    @Step("Нажать на кнопку поиска")
    public WikiSearchScreen clickSearchButton() {
        this.searchButton.shouldBe(visible).click();
        return new WikiSearchScreen();
    }

    @Step("Нажать на кнопку 'Saved' в таббаре")
    public WikiSavedScreen clickSavedTab() {
        this.savedTab.shouldBe(visible).click();
        return new WikiSavedScreen();
    }

    @Step("Нажать на кнопку 'Search' в таббаре")
    public WikiSearchScreen clickSearchTab() {
        this.searchTab.shouldBe(visible).click();
        return new WikiSearchScreen();
    }

    @Step("Нажать на кнопку 'Activity' в таббаре")
    public WikiActivityScreen clickActivityTab() {
        this.activityTab.shouldBe(visible).click();
        return new WikiActivityScreen();
    }

    @Step("Проверить, что главная страница открылась")
    public WikiMainScreen checkMainScreen() {
        this.mainScreenTitle.shouldBe(visible);
        this.searchButton.shouldBe(visible);
        return this;
    }

}





