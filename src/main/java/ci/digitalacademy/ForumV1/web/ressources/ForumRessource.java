package ci.digitalacademy.ForumV1.web.ressources;

import ci.digitalacademy.ForumV1.services.ForumService;
import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/forums")
public class ForumRessource {

    private final ForumService forumService;

    @PostMapping
    public ResponseEntity<ForumDTO> save(@RequestBody ForumDTO forumDTO) {
        log.debug("REST, Request to save forum : {}", forumDTO);
        return new ResponseEntity<>(forumService.saveForumWithSlug(forumDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getForumById(@PathVariable Long id) {
        log.debug("REST, Request to get forum : {}", id);
        Optional<ForumDTO> forumDTO = forumService.getForumById(id);
        if (forumDTO.isPresent()) {
            return new ResponseEntity<>(forumDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<ForumDTO> getAllForums() {
        log.debug("REST, Request to get all forum");
        return forumService.findAllForums();
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getForumBySlug(@PathVariable String slug) {
        log.debug("REST request to get Forum by slug : {}", slug);
        Optional<ForumDTO> forum = forumService.findForumBySlug(slug);
        if (forum.isPresent()) {
            return new ResponseEntity<>(forum.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }
}
