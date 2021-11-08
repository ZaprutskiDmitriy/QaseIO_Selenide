package adapters;

import com.google.gson.Gson;
import models.Project;
import models.ProjectResponse;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter{

    public void create(Project project) {
        post(new Gson().toJson(project), "v1/project");
    }

    public void delete(String code) {
        del("v1/project/" + code);
    }

    public Project get(String code) {
        String body = g("v1/project/" + code);
        return new Gson().fromJson(body, ProjectResponse.class).getResult();
    }
}

//aeb945e5747fba275e526fe98c404806f541b9ca

/*{
    "title": "Project 01112021",
    "code": "abcd"
}*/
