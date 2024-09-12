package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.models.Message;
import ci.digitalacademy.ForumV1.repositories.MessageRepository;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import ci.digitalacademy.ForumV1.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
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
    public MessageDTO update(MessageDTO messageDTO) {
        log.debug("Request to update message: {}", messageDTO);
         return findOne(messageDTO.getId()).map(message ->{
             message.setTitle(messageDTO.getTitle());
             message.setBody(messageDTO.getBody());
             return save(message);
         }).orElseThrow(() -> new IllegalArgumentException("not message found with id"+ messageDTO.getId()));

    }

    @Override
    public MessageDTO update(MessageDTO messageDTO, Long id) {
        log.debug("Request to update message By id: {}", id);
        return findOne(id).map(message ->{
            message.setTitle(messageDTO.getTitle());
            message.setBody(messageDTO.getBody());
            return save(message);
        }).orElseThrow(() -> new IllegalArgumentException("not message found with id"+ messageDTO.getId()));


    }

    @Override
    public Optional<MessageDTO> findOne(Long id) {
        log.debug("Request to get Message : {}", id);
        return messageRepository.findById(id).map(message ->{
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
    public void delete(Long id) {
        log.debug("Request to delete Message : {}", id);
        messageRepository.deleteById(id);

    }

}
