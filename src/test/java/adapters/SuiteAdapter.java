package adapters;

import com.google.gson.Gson;
import models.Project;
import models.ProjectResponse;
import models.Suite;
import models.SuiteResponse;

public class SuiteAdapter extends BaseAdapter {

    public void create(Suite suite, String code) {
        post(new Gson().toJson(suite), "v1/suite/" + code);
    }

    public void delete(String code, int suiteId) {
        del("v1/suite/" + code + "/" + suiteId);
    }

    public Suite get(String code, int suiteId) {
        String body = g("v1/suite/" + code + "/" + suiteId);
        return new Gson().fromJson(body, SuiteResponse.class).getResult();
    }

    public void update(Suite suite, String code, int suiteId) {
        patch(new Gson().toJson(suite), "v1/suite/" + code + "/" + suiteId);
    }
}


