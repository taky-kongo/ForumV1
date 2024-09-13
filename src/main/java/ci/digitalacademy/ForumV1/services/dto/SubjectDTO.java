package ci.digitalacademy.ForumV1.services.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {

    private Long id;

    private String title;

    private  String slug;

    private ForumDTO forum;
}
