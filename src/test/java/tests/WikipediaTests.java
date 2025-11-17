package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.wiki.WikiOnboardingScreen;
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
    @DisplayName("Прохождение онбординга")
    @Tag("LocalAndroid")
    public void gettingStartedTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();

        onboardingScreen.checkFirstOnboardingFragment()
                .clickContinueButton()
                .checkSecondOnboardingFragment()
                .clickContinueButton()
                .checkThirdOnboardingFragment()
                .clickContinueButton()
                .checkFourthOnboardingFragment()
                .finishOnboarding();
    }

    @Test
    @DisplayName("Успешный поиск статьи о мамонтах")
    @Tag("LocalAndroid")
    public void searchArticleAboutMammothTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
        String searchText = "Mammoth";
        String subtitle = "Extinct genus of mammals";

        onboardingScreen.skipOnboarding()
                .clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .closeWikiGamesModalIfExist()
                .checkArticleScreen(searchText, subtitle);
    }

    @Test
    @DisplayName("Поиск несуществующей статьи")
    @Tag("LocalAndroid")
    public void searchNonExistentArticleTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
        String searchText = "lsjkfiaor";

        onboardingScreen.skipOnboarding()
                .clickSearchButton()
                .searchArticle(searchText)
                .checkArticleListIsEmpty();
    }
}
