package stepPages;



import wildberriesSearch.Base;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class SimpleTextSteps extends Base {

    public String value;


    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

        });
    }

    public void inputValueInSearch(String value) {

        step("Ввести в поле поиска текст " + value, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(value).click();

        });
    }

    public void shouldHaveText(String value) {
        step("Проверить, что на странице поиска отображается текст " + value, () ->
        {
            $(withText(value)).shouldHave(text(value));

        });
    }
    public void shouldHaveWhitespaceText(String massage) {
        step("Проверить, что на странице поиска отображается текст " + massage, () ->
        {
            open("/catalog/0/search.aspx?search=");
            $(".content404__title").shouldHave(text(massage));

        });
    }


}
