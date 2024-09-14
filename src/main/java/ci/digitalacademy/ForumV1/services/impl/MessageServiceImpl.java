package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.models.Message;
import ci.digitalacademy.ForumV1.repositories.MessageRepository;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import ci.digitalacademy.ForumV1.services.mapper.MessageMapper;
import ci.digitalacademy.ForumV1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Request to save message: {}", messageDTO);
        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDTO> findMessageBySubjectId(Long subjectId) {
        log.debug("Request to get Message by subject id : {}", subjectId);
        return messageRepository.findMessageBySubjectId(subjectId).stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

    @Override
    public MessageDTO saveMessage(MessageDTO messageDTO) {
        log.debug("Request to save message with slug {}", messageDTO);
        final String slug = SlugifyUtils.generateSlugify(messageDTO.getTitle());
        messageDTO.setSlug(slug);
        return save(messageDTO);
    }

    @Override
    public Optional<MessageDTO> findMessageBySlug(String slug) {
        log.debug("Request to get Message by slug {}", slug);
        return messageRepository.findMessageBySlug(slug).map(message -> {
            return messageMapper.toDto(message);
        });
    }
}
