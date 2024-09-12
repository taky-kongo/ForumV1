package ci.digitalacademy.ForumV1.services.mapper;

import ci.digitalacademy.ForumV1.models.Sujet;
import ci.digitalacademy.ForumV1.services.dto.SujetDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SujetMapper extends EntityMapper<SujetDTO, Sujet> {
}
