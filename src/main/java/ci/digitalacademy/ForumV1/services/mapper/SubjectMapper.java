package ci.digitalacademy.ForumV1.services.mapper;

import ci.digitalacademy.ForumV1.models.Subject;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends EntityMapper<SubjectDTO, Subject> {
}
