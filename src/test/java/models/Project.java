package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Project {
    String title;
    String code;
}
