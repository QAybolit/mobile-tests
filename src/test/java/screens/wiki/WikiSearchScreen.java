package screens.wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WikiSearchScreen {

    private final SelenideElement searchInput = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));

    private final ElementsCollection searchResults = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Ввести в строку поиска '{searchText}'")
    public WikiSearchScreen searchArticle(String searchText) {
        this.searchInput.shouldBe(visible).sendKeys(searchText);
        return this;
    }

    @Step("Нажать на первый найденый результат в списке статей")
    public WikiArticleErrorScreen chooseArticleInList() {
        this.searchResults.shouldHave(sizeGreaterThan(0)).first().click();
        return new WikiArticleErrorScreen();
    }

}
