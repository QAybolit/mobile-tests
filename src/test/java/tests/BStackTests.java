package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.bstack.BStackMainScreen;

@Owner("Dina")
@Story("IOS тесты для приложения BStack")
public class BStackTests extends BaseTest {

    @Test
    @DisplayName("Проверка кнопки 'Text'")
    @Tag("IOS")
    public void checkTextButtonTest() {
        BStackMainScreen mainScreen = new BStackMainScreen();

        mainScreen.checkMainScreen()
                .clickTextButton()
                .checkTextScreen()
                .pressBackButton()
                .checkMainScreen();
    }
}
