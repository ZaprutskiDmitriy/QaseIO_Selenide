package adapters;

import com.google.gson.Gson;
import models.Project;
import models.ProjectResponse;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    String BASE_URL = "https://api.qase.io/";

    public void post(String body, String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "aeb945e5747fba275e526fe98c404806f541b9ca").
                body(body).
        when().
                post(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public void del(String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "aeb945e5747fba275e526fe98c404806f541b9ca").
        when().
                delete(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

    public String g(String uri) {
        String body =
                given().
                        header("Content-Type", "application/json").
                        header("Token", "aeb945e5747fba275e526fe98c404806f541b9ca").
                when().
                        get(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(200).
                        extract().body().asString();
        return body;
    }

    public void patch(String body, String uri) {
        given().
                header("Content-Type", "application/json").
                header("Token", "aeb945e5747fba275e526fe98c404806f541b9ca").
                body(body).
        when().
                patch(BASE_URL + uri).
        then().
                log().all().
                statusCode(200);
    }

}
