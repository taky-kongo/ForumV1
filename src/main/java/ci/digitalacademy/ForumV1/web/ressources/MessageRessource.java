package ci.digitalacademy.ForumV1.web.ressources;


import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.services.SubjectService;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageRessource {

    private final MessageService messageService;
    private final SubjectService subjectService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save message : {}", messageDTO);
        Optional<SubjectDTO> subject = subjectService.findOne(messageDTO.getSubject().getId());
        if (subject.isPresent()) {
            messageDTO.setSubject(subject.get());
            return new ResponseEntity<>(messageService.saveMessage(messageDTO), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/subjects/{id}")
    private ResponseEntity<?> getAllMessages(@PathVariable Long id) {
        log.debug("REST request to get all messages by subject id : {}", id);
        Optional<SubjectDTO> subject = subjectService.findOne(id);
        if (subject.isPresent()) {
            List<MessageDTO> messages = messageService.findMessageBySubjectId(id);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id of subject not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getMessageBySlug(@PathVariable String slug) {
        log.debug("REST request to get message by slug : {}", slug);
        Optional<MessageDTO> message = messageService.findMessageBySlug(slug);
        if (message.isPresent()) {
            return new ResponseEntity<>(message.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Message not found", HttpStatus.NOT_FOUND);
        }
    }
}



