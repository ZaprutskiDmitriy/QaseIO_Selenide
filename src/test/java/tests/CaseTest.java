package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class CaseTest extends BaseTest {

    @Test
    public void testCaseShouldBeCreated() {

        new LoginPage()
                .open()
                .login("zaprutsciy@mail.ru", "fE25hPhVXiu8xiM")
                .openProject("AQA_Project");


    }
}
