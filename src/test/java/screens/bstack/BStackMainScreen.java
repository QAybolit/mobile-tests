package screens.bstack;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BStackMainScreen {

    private final SelenideElement title = $(AppiumBy.xpath("//XCUIElementTypeNavigationBar[@name='UI Elements']"));
    private final SelenideElement textButton = $(AppiumBy.name("Text Button"));
    private final SelenideElement alertButton = $(AppiumBy.xpath("//XCUIElementTypeButton[@name='Alert']"));

    @Step("Проверить, что главная страница загрузилась")
    public BStackMainScreen checkMainScreen() {
        this.title.shouldBe(visible);
        this.alertButton.shouldBe(visible);
        this.textButton.shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку 'Text'")
    public BStackTextScreen clickTextButton() {
        this.textButton.click();
        return new BStackTextScreen();
    }
}
