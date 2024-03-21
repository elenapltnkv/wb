package stepPages;

import wildberriesSearch.Base;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.textCaseSensitive;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class ArticulSteps extends Base {

    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

        });
    }


    public void articulSearch(String articul) {
        step("Ввести в поле поиска артикул " + articul, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(articul).click();

        });
    }

    public void shouldHaveArticul(String articul) {
        step("Проверить, что на странице поиска отображается карточка товара с артикулом " +articul, () ->
        {
            $(withText(articul)).shouldHave(text(articul));

        });
    }

public void shouldHaveNoArticul(String articul, String massage) {
    step("Проверить, что на странице поиска отображается текст " + massage, () ->
    {
       open("https://www.wildberries.ru/catalog/0/search.aspx?search="+articul);
        $(".catalog-page__not-found").shouldHave(text(massage));

    });
}

}
