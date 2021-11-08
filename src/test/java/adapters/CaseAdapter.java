package adapters;

import com.google.gson.Gson;
import models.Case;
import models.CaseResponse;
import models.Suite;
import models.SuiteResponse;

public class CaseAdapter extends BaseAdapter {

    public void create(Case testCase, String code) {
        post(new Gson().toJson(testCase), "v1/case/" + code);
    }

    public void delete(String code, int caseId) {
        del("v1/case/" + code + "/" + caseId);
    }

    public Case get(String code, int caseId) {
        String body = g("v1/case/" + code + "/" + caseId);
        return new Gson().fromJson(body, CaseResponse.class).getResult();
    }

    public void update(Case testCase, String code, int caseId) {
        patch(new Gson().toJson(testCase), "v1/case/" + code + "/" + caseId);
    }
}


