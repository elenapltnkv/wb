package stepPages;


import wildberriesSearch.Base;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class LongTextSteps extends Base {


    public String longValue;

    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

        });
    }


    public void longTextSearch(String longValue) {
        step("Ввести в поле поиска текст " + longValue, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(longValue).click();

        });
    }

    public void shouldHaveLongText(String longValue) {
        step("Проверить, что на странице поиска отображается текст "+ longValue, () ->
        {
            $(withText(longValue)).shouldHave(text(longValue));

        });
    }


}
