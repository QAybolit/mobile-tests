package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.wiki.WikiMainScreen;

@Owner("Dina")
@Story("Android тесты для приложения Wikipedia")
public class WikipediaTests extends BaseTest {

    @Test
    @DisplayName("Ошибка при поиске статьи о мамонтах")
    @Tag("Android")
    public void searchArticleAboutMammothWithErrorTest() {
        WikiMainScreen mainScreen = new WikiMainScreen();
        String searchText = "Mammoth";

        mainScreen.clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .checkArticleErrorScreen(searchText);
    }
}
