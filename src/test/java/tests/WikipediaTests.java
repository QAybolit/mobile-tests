package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import screens.wiki.WikiOnboardingScreen;
import screens.wiki.WikiMainScreen;

@Owner("Dina")
@Story("Android тесты для приложения Wikipedia")
public class WikipediaTests extends BaseTest {

    @Test
    @DisplayName("Проверка поиска")
    @Tags({@Tag("LocalAndroid"), @Tag("BsAndroid")})
    @Story("Поиск статьи")
    public void checkSearchTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
        String searchText = "Mammoth";

        onboardingScreen.skipOnboardingIfExist()
                .clickSearchButton()
                .searchArticle(searchText)
                .checkArticleList(searchText);
    }

    @Test
    @DisplayName("Поиск несуществующей статьи")
    @Tag("BsAndroid")
    @Story("Поиск статьи")
    public void searchNonExistentArticleTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
        String searchText = "lsjkfiaor";

        onboardingScreen.skipOnboardingIfExist()
                .clickSearchButton()
                .searchArticle(searchText)
                .checkArticleListIsEmpty();
    }

    @Test
    @DisplayName("Ошибка при открытии статьи о мамонтах")
    @Tag("BsAndroid")
    @Story("Поиск статьи")
    public void searchArticleAboutMammothWithErrorTest() {
        WikiMainScreen mainScreen = new WikiMainScreen();
        String searchText = "Mammoth";

        mainScreen.clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .checkArticleError(searchText);
    }

    @Test
    @DisplayName("Проверка кнопки 'Saved' в таббаре")
    @Tag("LocalAndroid")
    @Story("Панель навигации")
    public void checkSavedTabTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();

        onboardingScreen.skipOnboardingIfExist()
                .clickSavedTab()
                .checkSavedScreen()
                .clickExploreTab()
                .checkMainScreen();
    }

    @Test
    @DisplayName("Проверка кнопки 'Search' в таббаре")
    @Tag("LocalAndroid")
    @Story("Панель навигации")
    public void checkSearchTabTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();

        onboardingScreen.skipOnboardingIfExist()
                .clickSearchTab()
                .checkSearchScreen()
                .clickExploreTab()
                .checkMainScreen();
    }

    @Test
    @DisplayName("Проверка кнопки 'Activity' в таббаре")
    @Tag("LocalAndroid")
    @Story("Панель навигации")
    public void checkActivityTabTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();

        onboardingScreen.skipOnboardingIfExist()
                .clickActivityTab()
                .checkActivityScreen();
    }

    @Test
    @DisplayName("Прохождение онбординга")
    @Tag("LocalAndroid")
    @Story("Онбординг")
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
    @Story("Поиск статьи")
    public void searchArticleAboutMammothTest() {
        WikiOnboardingScreen onboardingScreen = new WikiOnboardingScreen();
        String searchText = "Mammoth";
        String subtitle = "Extinct genus of mammals";

        onboardingScreen.skipOnboardingIfExist()
                .clickSearchButton()
                .searchArticle(searchText)
                .chooseArticleInList()
                .closeWikiGamesModalIfExist()
                .checkArticleScreen(searchText, subtitle);
    }
}
