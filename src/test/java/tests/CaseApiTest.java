package tests;

import models.Case;
import models.Project;
import models.Suite;
import org.testng.annotations.Test;

public class CaseApiTest extends BaseTest {

    @Test
    public void caseShouldBeCreatedByApi() {

        Project project = Project.builder().
                title("08112021 Project").
                code("ABCD").
                build();

        Suite suite1 = Suite.builder().
                title("Suite#1").
                build();

        Case case1 = Case.builder().
                title("Case#1").
                suiteId(1).
                build();

        projectAdapter.create(project);
        suiteAdapter.create(suite1, project.getCode());
        Suite actualSuite = suiteAdapter.get(project.getCode(), 1);
        System.out.println(actualSuite);
        caseAdapter.create(case1, project.getCode());
        Case actualCase = caseAdapter.get(project.getCode(), 1);
        System.out.println(actualCase);

        Case case2 = Case.builder().
                title("Case#2").
                id(actualCase.getId()).
                build();

        caseAdapter.update(case2, project.getCode(), actualCase.getId());
        Case newActualCase = caseAdapter.get(project.getCode(), actualCase.getId());
        System.out.println(newActualCase);
        caseAdapter.delete(project.getCode(), actualCase.getId());
        suiteAdapter.delete(project.getCode(), actualSuite.getId());
        projectAdapter.delete(project.getCode());
    }
}
