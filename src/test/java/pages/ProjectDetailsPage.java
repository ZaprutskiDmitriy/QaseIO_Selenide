package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectDetailsPage {

    public ProjectDetailsPage isOpened() {
        $("img.avatar-xxs").shouldBe(Condition.visible);
        return this;
    }

    public void validateName(String projectName) {
        $("p.header").shouldHave(Condition.exactText(projectName));
    }

    public TestCasePage clickNewTestCase() {

        if($(".ms-2").text().contains("| 0 tests")) {
            $(By.xpath("//a[text()='Create new case']")).click();
        } else {
            $("#create-case-button").click();
        }
        return new TestCasePage();
    }

    public void validateCaseName(String title) {
        $$(".cases-container").shouldHave(CollectionCondition.texts(title));
    }
}
