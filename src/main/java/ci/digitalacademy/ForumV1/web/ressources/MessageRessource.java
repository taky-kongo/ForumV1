package ci.digitalacademy.ForumV1.web.ressources;


import ci.digitalacademy.ForumV1.services.MessageService;
import ci.digitalacademy.ForumV1.services.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageRessource {

    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDTO> save(@RequestBody MessageDTO messageDTO) {
        log.debug("REST request to save message : {}", messageDTO);
        return new ResponseEntity<>(messageService.save(messageDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MessageDTO messageDTO) {
        log.debug("REST request to update message : {}", messageDTO);
        return new ResponseEntity<>(messageService.update(messageDTO, id), HttpStatus.OK);
    }

    @GetMapping
    private List<MessageDTO> getAllMessages() {
        log.debug("REST request to get all messages");
        return messageService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete message : {}", id);
        messageService.delete(id);
    }
}



