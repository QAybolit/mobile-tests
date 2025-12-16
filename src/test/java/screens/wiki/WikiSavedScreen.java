package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiSavedScreen {

    private final SelenideElement toolbar = $(AppiumBy.id("org.wikipedia.alpha:id/main_toolbar"));
    private final SelenideElement messageTitle = $(AppiumBy.id("org.wikipedia.alpha:id/messageTitleView"));
    private final SelenideElement getStartedButton = $(AppiumBy.id("org.wikipedia.alpha:id/positiveButton"));
    private final SelenideElement noThanksButton = $(AppiumBy.id("org.wikipedia.alpha:id/negativeButton"));
    private final SelenideElement exploreTab = $(AppiumBy.id("org.wikipedia.alpha:id/nav_tab_explore"));

    @Step("Нажать на кнопку 'Explore' в таббаре")
    public WikiMainScreen clickExploreTab() {
        this.exploreTab.shouldBe(visible).click();
        return new WikiMainScreen();
    }

    @Step("Проверить, что страница с сохраненными статьями открылась")
    public WikiSavedScreen checkSavedScreen() {
        this.toolbar.shouldBe(visible);
        this.messageTitle.shouldBe(visible).shouldHave(text("Discover articles picked just for you"));
        this.getStartedButton.shouldBe(visible);
        this.noThanksButton.shouldBe(visible);
        return this;
    }

}
