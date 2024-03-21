package wildberriesSearch;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import stepPages.ArticulSteps;
import stepPages.SimpleTextSteps;
import stepPages.UploadPhotoSteps;



public class SearchNegativeStepsTest extends Base {
    ArticulSteps aStep = new ArticulSteps();
    SimpleTextSteps simpleStep = new SimpleTextSteps();
    UploadPhotoSteps upStep = new UploadPhotoSteps();

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить поиск несуществующего артикула")
    public void searchUnknownArticulNoAuthorizedUser() {

        aStep.openMainPage();
        aStep.articulSearch("1770048888");
        aStep.shouldHaveNoArticul("1770048888", "Попробуйте поискать по-другому или сократить запрос");

    }

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить перевод текста в другую раскладку")
    @Tag("smoke")
    public void searchSimpleNoTranslateTextNoAuthorizedUser() {

        simpleStep.openMainPage();
        simpleStep.inputValueInSearch("gkfnmt");
        simpleStep.shouldHaveText("платье");
    }

    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Проверить ввод пробелов в поисковую строку")
    public void searchInputWhitespaceNoAuthorizedUser() {

        simpleStep.openMainPage();
        simpleStep.inputValueInSearch("     ");
        simpleStep.shouldHaveWhitespaceText("По Вашему запросу ничего не найдено");
    }
    @Test
    @Owner("samigullaeva.ea")
    @DisplayName("Загрузить PDF файл и проверить, что страница уходит в бесконечный лоадер")
    public void searchUploadPDFNoAuthorizedUser() {

        upStep.openMainPage();
        upStep.photoSearch();
        upStep.uploadPDFInSearch();
        upStep.shouldHaveLoader();
    }
}
