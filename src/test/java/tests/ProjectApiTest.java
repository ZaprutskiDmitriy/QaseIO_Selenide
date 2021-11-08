package tests;

import models.Project;
import org.testng.annotations.Test;

public class ProjectApiTest extends BaseTest {

    @Test
    public void projectShouldBeCreatedByApi() {

        Project project = Project.builder().
                title("08112021 Project").
                code("ABCD").
                build();

        projectAdapter.create(project);
        Project actualProject = projectAdapter.get(project.getCode());
        System.out.println(actualProject);
        projectAdapter.delete(project.getCode());
    }
}
