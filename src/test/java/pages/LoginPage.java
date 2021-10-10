package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public LoginPage open() {
        Selenide.open("login");
        $("#inputPassword").shouldBe(Condition.visible);
        return this;
    }

    public ProjectsPage login(String user, String password) {
        $("#inputEmail").sendKeys(user);
        $("#inputPassword").sendKeys(password);
        $("#inputPassword").submit();
        return new ProjectsPage().isOpened();
    }
}
