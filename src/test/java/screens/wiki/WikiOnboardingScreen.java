package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiOnboardingScreen {

    private final SelenideElement image = $(AppiumBy.id("org.wikipedia.alpha:id/imageViewCentered"));
    private final SelenideElement addLanguageButton = $(AppiumBy.id("org.wikipedia.alpha:id/addLanguageButton"));
    private final SelenideElement onboardingTitle = $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView"));

    private final SelenideElement continueButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button"));
    private final SelenideElement skipOnboardingButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button"));
    private final SelenideElement doneButton = $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_done_button"));

    @Step("Пропустить страницу онбординга")
    public WikiMainScreen skipOnboardingIfExist() {
        if (this.skipOnboardingButton.is(visible, Duration.ofMillis(6000))) {
            this.skipOnboardingButton.click();
        }
        return new WikiMainScreen();
    }

    @Step("Проверить, что первая страница онбординга открылась")
    public WikiOnboardingScreen checkFirstOnboardingFragment() {
        this.image.shouldBe(visible);
        this.onboardingTitle.shouldBe(visible).shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        this.addLanguageButton.shouldBe(visible);
        this.skipOnboardingButton.shouldBe(visible);
        this.continueButton.shouldBe(visible);
        return this;
    }

    @Step("Перейти на следующую страницу онбординга")
    public WikiOnboardingScreen clickContinueButton() {
        this.continueButton.click();
        return this;
    }

    @Step("Проверить, что вторая страница онбординга открылась")
    public WikiOnboardingScreen checkSecondOnboardingFragment() {
        this.image.shouldBe(visible);
        this.onboardingTitle.shouldBe(visible).shouldHave(text("New ways to explore"));
        this.skipOnboardingButton.shouldBe(visible);
        this.continueButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что третья страница онбординга открылась")
    public WikiOnboardingScreen checkThirdOnboardingFragment() {
        this.image.shouldBe(visible);
        this.onboardingTitle.shouldBe(visible).shouldHave(text("Reading lists with sync"));
        this.skipOnboardingButton.shouldBe(visible);
        this.continueButton.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что четвертая страница онбординга открылась")
    public WikiOnboardingScreen checkFourthOnboardingFragment() {
        this.image.shouldBe(visible);
        this.onboardingTitle.shouldBe(visible).shouldHave(text("Data & Privacy"));
        this.skipOnboardingButton.shouldNotBe(visible);
        this.continueButton.shouldNotBe(visible);
        this.doneButton.shouldBe(visible);
        return this;
    }

    @Step("Завершить онбординг")
    public WikiMainScreen finishOnboarding() {
        this.doneButton.click();
        return new WikiMainScreen();
    }
}
