package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pages.LoginPage;

public class ProjectTest extends BaseTest {

    static Faker faker;

    @Test
    public void projectShouldBeCreated() {
        faker = new Faker();
        String projectName = faker.team().sport();

        new LoginPage()
                .open()
                .login("zaprutsciy@mail.ru", "fE25hPhVXiu8xiM")
                .create(projectName, "", "Description", "Public")
                .validateName(projectName);
    }
}
