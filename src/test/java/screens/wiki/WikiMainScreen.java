package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiMainScreen {

    private final SelenideElement searchButton = $(AppiumBy.id("org.wikipedia.alpha:id/search_container"));
    private final SelenideElement skipOnboardingButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));

    @Step("Пропустить страницу онбординга, если она открылась")
    public WikiMainScreen skipOnboardingIfExist() {
        if (this.skipOnboardingButton.is(visible, Duration.ofMillis(4000))) {
            this.skipOnboardingButton.click();
        }
        return this;
    }

    @Step("Нажать на кнопку поиска")
    public WikiSearchScreen clickSearchButton() {
        this.searchButton.shouldBe(visible).click();
        return new WikiSearchScreen();
    }
}





