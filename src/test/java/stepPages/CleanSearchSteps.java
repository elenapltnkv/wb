package stepPages;


import wildberriesSearch.Base;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class CleanSearchSteps extends Base {
    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

        });
    }
    public String value;
      public void cleanSearchInputText(String value) {
        step("Ввести в поле поиска текст. " + value, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(value).click();

        });
    }
    public void cleanSearchText() {
        step("Кликнуть на крестик и очистить поисковую строку.", () ->
        {
            $("button.search-catalog__btn--clear").click();
            $(".search-catalog__input").shouldHave(attribute("placeholder", "Найти на Wildberries"));

        });
    }
    public void shouldHaveCleanSearch() {
        step("Проверить, что поисковая строка пустая и в placeholder отображается текст 'Найти на Wildberries'.", () ->
        {

            $(".search-catalog__input").shouldHave(attribute("placeholder", "Найти на Wildberries"));

        });
    }
}
