package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.MessageDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    MessageDTO save(MessageDTO messageDTO);

    Optional<MessageDTO> findOne(Long id);

    List<MessageDTO> findAll();

    List<MessageDTO> findMessageBySujetId(Long sujetId);
}
