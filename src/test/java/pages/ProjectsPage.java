package pages;

import com.codeborne.selenide.Condition;
import org.apache.commons.lang.StringUtils;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectsPage {

    public ProjectsPage isOpened() {
        $("#createButton").shouldBe(Condition.visible);
        return this;
    }

    public ProjectDetailsPage create(String projectName, String projectCode, String description, String accessType) {
        $("#inputTitle").sendKeys(projectName);
        if(StringUtils.isNotEmpty(projectCode)) {
            $("#inputCode").sendKeys(projectCode);
        }
        $("#inputDescription").sendKeys(description);
        switch (accessType) {
            case "Private": {
                $("#private-access-type").click();
                break;
        }
            case "Public": {
                $("#public-access-type").click();
                break;
            }
        }

        $("#inputTitle").submit();
        return new ProjectDetailsPage().isOpened();
    }

    public ProjectDetailsPage openProject(String name) {
        $$("a.defect-title").findBy(Condition.text(name)).click();
        return new ProjectDetailsPage();
    }
}
