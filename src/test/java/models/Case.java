package models;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Case {
    String title;
    int id;
    @SerializedName("suite_id")
    int suiteId;
    int position;
    int severity;
    int priority;
}
