package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;

public interface MessageService {

    MessageDTO save(MessageDTO messageDTO);

    MessageDTO update(MessageDTO messageDTO);
    MessageDTO update(MessageDTO messageDTO, Long id);

    Optional<MessageDTO> findOne(Long id);

    List<MessageDTO> findAll();

    void delete(Long id);



}
