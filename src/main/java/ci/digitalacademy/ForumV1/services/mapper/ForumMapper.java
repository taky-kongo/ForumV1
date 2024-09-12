package ci.digitalacademy.ForumV1.services.mapper;


import ci.digitalacademy.ForumV1.models.Forum;
import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForumMapper extends EntityMapper<ForumDTO, Forum>  {
}
