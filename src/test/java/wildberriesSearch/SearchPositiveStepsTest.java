package wildberriesSearch;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import stepPages.*;

public class SearchPositiveStepsTest extends Base {

    SimpleTextSteps simpleStep = new SimpleTextSteps();
    LongTextSteps longStep = new LongTextSteps();
    UploadPhotoSteps upStep = new UploadPhotoSteps();
    ArticulSteps aStep =  new ArticulSteps();
    CleanSearchSteps cleanStep = new CleanSearchSteps();


    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить простой поиск")
    @Tag("smoke")
    public void searchSimpleTextNoAuthorizedUser() {

        simpleStep.openMainPage();
        simpleStep.inputValueInSearch("платье");
        simpleStep.shouldHaveText("платье");
    }

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить поиск сразу нескольких слов одновременно")
    public void searchLongTextNoAuthorizedUser() {

        longStep.openMainPage();
        longStep.longTextSearch("платье беленькое праздничное короткое");
        longStep.shouldHaveLongText("платье беленькое праздничное короткое");
    }

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить поиск по фото")
    public void searchUploadPhotoNoAuthorizedUser() {

        upStep.openMainPage();
        upStep.photoSearch();
        upStep.uploadPhotoInSearch();
        upStep.shouldHaveSearchResult();
    }
    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить поиск по артикулу")
    @Tag("smoke")
    public void searchArticulNoAuthorizedUser() {

        aStep.openMainPage();
        aStep.articulSearch("17700488");
        aStep.shouldHaveArticul("17700488");

    }

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить сброс поиска")
    public void cleanSimpleTextSearchLineNoAuthorizedUser() {

        cleanStep.openMainPage();
        cleanStep.cleanSearchInputText("платье");
        cleanStep.cleanSearchText();
        cleanStep.shouldHaveCleanSearch();
    }


}
