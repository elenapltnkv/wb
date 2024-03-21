package stepPages;


import org.openqa.selenium.By;
import wildberriesSearch.Base;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class UploadPhotoSteps extends Base {

    public void openMainPage() {
        step("Открыть главную страницу.", () ->
        {
            open(baseUrl);

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
            $(".search-catalog__btn--photo input").uploadFile(new File("src/test/resources/beagle-dog-standing-on-grass-9xzx8rwvo3gl57xd.jpg"));

        });
    }
    public void uploadPDFInSearch() {
        step("Загрузить PDF.", () ->
        {
            $(".search-catalog__btn--photo input").uploadFile(new File("src/test/resources/IntelliJIDEA_ReferenceCard.pdf"));

        });
    }

    public void shouldHaveSearchResult() {
        step("Проверить, что на странице поиска правильно отображаются результаты.", () ->
        {
            $("#c183876708 .product-card__name").shouldHave(text("/ Мягкая игрушка реалистичная собака Бигль подарок детям"));
        });
    }
    public void shouldHaveLoader() {
        step("Проверить, что на странице отображается бесконечный лоадер.", () ->
        {
            $(".general-preloader").shouldHave(tagName("div"));
        });
    }


}
