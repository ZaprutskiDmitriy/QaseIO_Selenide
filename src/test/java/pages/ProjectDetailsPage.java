package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ProjectDetailsPage {

    public ProjectDetailsPage isOpened() {
        $(".ms-2").shouldBe(Condition.visible);
        return this;
    }
}
