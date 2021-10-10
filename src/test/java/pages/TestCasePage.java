package pages;

import com.codeborne.selenide.Condition;
import models.TestCase;
import org.openqa.selenium.By;
import wrappers.Dropdown;

import static com.codeborne.selenide.Selenide.$;

public class TestCasePage {

    public TestCasePage isOpened() {
        $("#save-case").shouldBe(Condition.visible);
        return this;
    }

    public TestCasePage createTestCase(TestCase testCase) {
        $("input[name=title]").sendKeys(testCase.getTitle());
        new Dropdown("status").select(testCase.getStatus());
        new Dropdown("suite").select(testCase.getSuite());
        new Dropdown("severity").select(testCase.getSeverity());
        new Dropdown("priority").select(testCase.getPriority());
        new Dropdown("type").select(testCase.getType());
        new Dropdown("layer").select(testCase.getLayer());
        new Dropdown("is_flaky").select(testCase.getIsFlaky());
        new Dropdown("milestone").select(testCase.getMilestone());
        new Dropdown("behavior").select(testCase.getBehavior());
        new Dropdown("automationStatus").select(testCase.getAutomationStatus());
        return this;
    }

    public ProjectDetailsPage clickSaveTestCase() {
        $("#save-case").click();
        return new ProjectDetailsPage();
    }
}
