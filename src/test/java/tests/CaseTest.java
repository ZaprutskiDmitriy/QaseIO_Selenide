package tests;

import models.Project;
import models.TestCase;
import models.TestCaseFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.TestCasePage;

public class CaseTest extends BaseTest {

    @Test
    public void testCaseShouldBeCreated() {

        new LoginPage()
                .open()
                .login(user, password)
                .openProject("AQA_Project")
                .clickNewTestCase()
                .isOpened();

        TestCase testCase = TestCaseFactory.get();

        new TestCasePage()
                .createTestCase(testCase)
                .clickSaveTestCase()
                .isOpened()
                .validateCaseName(testCase.getTitle());
    }
}
