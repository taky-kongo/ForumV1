package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    MessageDTO save(MessageDTO messageDTO);

    List<MessageDTO> findMessageBySubjectId(Long subjectId);

    MessageDTO saveMessage(MessageDTO messageDTO);

    Optional<MessageDTO> findMessageBySlug(String slug);
}
