package stepPages.basesteps;


import wildberriesSearch.Base;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class SearchPositiveSteps extends Base {

    public String value;
    public String longValue;
    public String articul;


    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

        });
    }

    public void inputValueInSearch(String value) {

        step("Ввести в поле поиска текст. " + value, () ->
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


    public void longTextSearch(String longValue) {
        step("Ввести в поле поиска текст " + longValue, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(longValue).click();

        });
    }

    public void shouldHaveLongText(String longValue) {
        step("Проверить, что на странице поиска отображается текст 'платье беленькое праздничное короткое'", () ->
        {
            $(withText(longValue)).shouldHave(text(longValue));

        });
    }

    public void photoSearch() {
        step("Кликнуть на иконку 'Поиск по фото'.", () ->
        {
            $(".search-catalog__btn--photo").click();

        });
    }

    public void uploadPhotoInSearch() {
        step("Загрузить фото.", () ->
        {
            $(".search-catalog__btn--photo input").uploadFile(new File("/home/user/IdeaProjects/wildberries/src/test/resources/beagle-dog-standing-on-grass-9xzx8rwvo3gl57xd.jpg"));

        });
    }

    public void shouldHaveSearchResult() {
        step("Проверить, что на странице поиска правильно отображаются результаты.", () ->
        {
            $("#c183876708 .product-card__name").shouldHave(text("/ Мягкая игрушка реалистичная собака Бигль подарок детям"));
        });
    }
    //17700488

    public void articulSearchNoAuthorizedUser(String articul) {
        step("Ввести в поле поиска артикул " + articul, () ->
        {
            $(".search-catalog__input").click();
            $("#searchInput").setValue(articul).click();

        });
    }
    public void shouldHaveArticul() {
        step("Проверить, что на странице поиска отображается карточка товара с артикулом "+ articul, () ->
        {
            $(withText("17700488")).shouldHave(text(articul));

        });
    }

    public void cleanSearchInputText() {
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
