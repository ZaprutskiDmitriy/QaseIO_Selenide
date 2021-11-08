package models;


import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    String title;
    int id;
    int position;
    @SerializedName("cases_count")
    int casesCount;
}
