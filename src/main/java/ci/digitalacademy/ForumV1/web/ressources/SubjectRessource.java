package ci.digitalacademy.ForumV1.web.ressources;

import ci.digitalacademy.ForumV1.services.ForumService;
import ci.digitalacademy.ForumV1.services.SubjectService;
import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/subjects")
public class SubjectRessource {

    private final SubjectService subjectService;
    private final ForumService forumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDTO save(@RequestBody SubjectDTO subjectDTO) {
        log.debug("REST request to save Subject : {}", subjectDTO);
        Optional<ForumDTO> forum = forumService.getForumById(subjectDTO.getForum().getId());
        if (forum.isPresent()) {
            subjectDTO.setForum(forum.get());
            return subjectService.saveSubject(subjectDTO);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/forums/{id}")
    public ResponseEntity<?> getAllSubjectsByForumId(@PathVariable Long id) {
        log.debug("REST request to get all Subjects of forum : {}", id);
        Optional<ForumDTO> forum = forumService.getForumById(id);
        if (forum.isPresent()) {
            List<SubjectDTO> subjects = subjectService.findSubjectByForumId(id);
            return new ResponseEntity<>(subjects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSubjectById(@PathVariable Long id) {
        log.debug("REST request to get Subject : {}", id);
        Optional<SubjectDTO> subject = subjectService.findOne(id);
        if (subject.isPresent()) {
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getSubjectBySlug(@PathVariable String slug) {
        log.debug("REST request to get Subject by slug : {}", slug);
        Optional<SubjectDTO> subject = subjectService.findSubjectBySlug(slug);
        if (subject.isPresent()) {
            return new ResponseEntity<>(subject.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

}
