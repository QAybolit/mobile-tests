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
    @Tag("BsAndroid")
    public void searchArticleAboutMammothWithErrorTest() {
        WikiMainScreen mainScreen = new WikiMainScreen();
        String searchText = "Mammoth";

        mainScreen.clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .checkArticleError(searchText);
    }

    @Test
    @DisplayName("Успешный поиск статьи о мамонтах")
    @Tag("Local")
    public void searchArticleAboutMammothTest() {
        WikiMainScreen mainScreen = new WikiMainScreen();
        String searchText = "Mammoth";
        String subtitle = "Extinct genus of mammals";

        mainScreen.skipOnboardingIfExist()
                .clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .closeWikiGamesModalIfExist()
                .checkArticleScreen(searchText, subtitle);
    }
}
