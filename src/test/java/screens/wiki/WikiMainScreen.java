package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiMainScreen {

    private final SelenideElement searchButton = $(AppiumBy.id("org.wikipedia.alpha:id/search_container"));

    @Step("Нажать на кнопку поиска")
    public WikiSearchScreen clickSearchButton() {
        this.searchButton.shouldBe(visible).click();
        return new WikiSearchScreen();
    }
}





