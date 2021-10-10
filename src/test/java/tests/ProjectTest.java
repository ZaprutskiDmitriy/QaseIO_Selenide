package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import com.github.javafaker.Faker;

public class ProjectTest extends BaseTest {

//    static Faker faker;

    @Test
    public void projectShouldBeCreated() {
//        faker = new Faker();
        new LoginPage()
                .open()
                .login("zaprutsciy@mail.ru", "fE25hPhVXiu8xiM")
                .create("Test", " ", "Any description", "Private");
    }
}
