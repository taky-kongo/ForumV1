package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.models.Message;
import ci.digitalacademy.ForumV1.repositories.MessageRepository;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import ci.digitalacademy.ForumV1.services.mapper.MessageMapper;
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
    public Optional<MessageDTO> findOne(Long id) {
        log.debug("Request to get Message : {}", id);
        return messageRepository.findById(id).map(message -> {
            return messageMapper.toDto(message);
        });
    }

    @Override
    public List<MessageDTO> findAll() {
        log.debug("Request to get all Messages");
        return messageRepository.findAll().stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

    @Override
    public List<MessageDTO> findMessageBySujetId(Long sujetId) {
        log.debug("Request to get Message by sujet id : {}", sujetId);
        return messageRepository.findMessageBySujetId(sujetId).stream().map(message -> {
            return messageMapper.toDto(message);
        }).toList();
    }

}
