package screens.bstack;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BStackTextScreen {

    private final SelenideElement info = $(AppiumBy.name("Text Output"));
    private final SelenideElement textInput = $(AppiumBy.name("Text Input"));
    private final SelenideElement backButton = $(AppiumBy.xpath("//XCUIElementTypeButton[@name='UI Elements']"));

    @Step("Проверить, что страница для ввода текста загрузилась")
    public BStackTextScreen checkTextScreen() {
        this.info.shouldBe(visible).shouldHave(text("Waiting for text input."));
        this.textInput.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку возвращения на предыдущую страницу")
    public BStackMainScreen pressBackButton() {
        this.backButton.shouldBe(visible).click();
        return new BStackMainScreen();
    }
}
