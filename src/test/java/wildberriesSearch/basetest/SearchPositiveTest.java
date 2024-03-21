package wildberriesSearch.basetest;

import org.junit.jupiter.api.Test;
import wildberriesSearch.Base;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;



public class SearchPositiveTest extends Base {
    @Test
    public void textSearchNoAuthorizedUser(){
        open(baseUrl);
        $(".search-catalog__input").click();
        $("#searchInput").setValue("платье").click();
        $(withText("платье")).shouldHave(text("Платье"));
    }

    @Test
    public void longTextSearchNoAuthorizedUser(){
        open(baseUrl);
        $(".search-catalog__input").click();
        $("#searchInput").setValue("платье беленькое праздничное короткое").click();
        $(withText("платье")).shouldHave(text("Платье беленькое праздничное короткое"));
    }
    @Test
    public void photoSearchNoAuthorizedUser(){
        open(baseUrl);
        $(".search-catalog__btn--photo").click();
        $(".search-catalog__btn--photo input").uploadFile(new File("src/test/resources/beagle-dog-standing-on-grass-9xzx8rwvo3gl57xd.jpg"));
        $("#c183876708 .product-card__name").shouldHave(text("/ Мягкая игрушка реалистичная собака Бигль подарок детям"));


    }
    //17700488
    @Test
    public void articulSearchNoAuthorizedUser(){
        open(baseUrl);
        $(".search-catalog__input").click();
        $("#searchInput").setValue("17700488").click();
        $(withText("17700488")).shouldHave(text("17700488"));
    }

    @Test
    public void cleanSearchNoAuthorizedUser(){
        open(baseUrl);
        $(".search-catalog__input").click();
        $("#searchInput").setValue("платье").click();
        $("button.search-catalog__btn--clear").click();
        $(".search-catalog__input").shouldHave(attribute("placeholder", "Найти на Wildberries"));
        
    }
}
