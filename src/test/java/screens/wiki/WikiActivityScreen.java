package screens.wiki;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WikiActivityScreen {

    private final SelenideElement activityTitle = $(AppiumBy.xpath("//android.widget.TextView[@text='Introducing Activity']"));
    private final SelenideElement readingPatternsLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='Reading patterns']"));
    private final SelenideElement waysToEnergyLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='More ways to engage']"));
    private final SelenideElement impactHighlightsLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='Impact highlights']"));
    private final SelenideElement stayInControlLabel = $(AppiumBy.xpath("//android.widget.TextView[@text='Stay in control']"));
    private final SelenideElement continueButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Continue']"));
    private final SelenideElement learnMoreButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Learn more']"));

    @Step("Проверить, что страница активности открылась")
    public WikiActivityScreen checkActivityScreen() {
        this.activityTitle.shouldBe(visible);
        this.readingPatternsLabel.shouldBe(visible);
        this.waysToEnergyLabel.shouldBe(visible);
        this.impactHighlightsLabel.shouldBe(visible);
        this.stayInControlLabel.shouldBe(visible);
        this.learnMoreButton.shouldBe(visible);
        this.continueButton.shouldBe(visible);
        return this;
    }

}
