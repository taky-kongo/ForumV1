package ci.digitalacademy.ForumV1.web.ressources;


import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.services.SujetService;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import ci.digitalacademy.ForumV1.services.dto.SujetDTO;
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
    private final SujetService sujetService;

    @PostMapping
    public ResponseEntity<MessageDTO> save(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save message : {}", messageDTO);
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @GetMapping("/all-messages/{id}")
    private ResponseEntity<?> getAllMessages(@PathVariable Long id) {
        log.debug("REST request to get all messages by sujet id : {}", id);
        Optional<SujetDTO> sujet = sujetService.findOne(id);
        if (sujet.isPresent()) {
            List<MessageDTO> messages = messageService.findMessageBySujetId(id);
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Id of sujet not found", HttpStatus.NOT_FOUND);
        }
    }
}



