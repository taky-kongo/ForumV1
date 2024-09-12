package ci.digitalacademy.ForumV1.services.mapper;

import ci.digitalacademy.ForumV1.models.Message;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends EntityMapper <MessageDTO, Message> {
}
