package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class ProjectTest extends BaseTest {

    @Test
    public void projectShouldBeCreated() {
        new LoginPage()
                .open()
                .login("zaprutsciy@mail.ru", "fE25hPhVXiu8xiM")
                .create("Test", "", "Description", "Public")
                .validateName("Test");
    }
}
