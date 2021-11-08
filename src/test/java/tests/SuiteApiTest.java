package tests;

import models.Project;
import models.Suite;
import org.testng.annotations.Test;

public class SuiteApiTest extends BaseTest {

    @Test
    public void suiteShouldBeCreatedByApi() {

        Project project = Project.builder().
                title("08112021 Project").
                code("ABCD").
                build();

        Suite suite1 = Suite.builder().
                title("Suite#1").
                build();

        Suite suite2 = Suite.builder().
                title("Suite#2").
                build();

        projectAdapter.create(project);
        suiteAdapter.create(suite1, project.getCode());
        Suite actualSuite = suiteAdapter.get(project.getCode(), 1);
        System.out.println(actualSuite);
//        suiteAdapter.update(suite2, project.getCode(), actualSuite.getId());
//        Suite newActualSuite = suiteAdapter.get(project.getCode(), actualSuite.getId());
//        System.out.println(newActualSuite);
        suiteAdapter.delete(project.getCode(), actualSuite.getId());
        projectAdapter.delete(project.getCode());
    }
}
