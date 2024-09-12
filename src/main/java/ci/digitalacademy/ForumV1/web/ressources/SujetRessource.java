package ci.digitalacademy.ForumV1.web.ressources;

import ci.digitalacademy.ForumV1.services.ForumService;
import ci.digitalacademy.ForumV1.services.SujetService;
import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import ci.digitalacademy.ForumV1.services.dto.SujetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/sujets")
public class SujetRessource {

    private final SujetService sujetService;
    private final ForumService forumService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SujetDTO save(@RequestBody SujetDTO sujetDTO) {
        log.debug("REST request to save Sujet : {}", sujetDTO);
        return sujetService.save(sujetDTO);
    }

    @GetMapping("/all-sujets/{id}")
    public ResponseEntity<?> getAllSujets(@PathVariable Long id) {
        log.debug("REST request to get all Sujets of forum : {}", id);
        Optional<ForumDTO> forum = forumService.getForumById(id);
        if (forum.isPresent()) {
            List<SujetDTO> sujets = sujetService.findSujetByForumId(id);
            return new ResponseEntity<>(sujets, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSujet(@PathVariable Long id) {
        log.debug("REST request to get Sujet : {}", id);
        Optional<SujetDTO> sujetDTO = sujetService.findOne(id);
        if (sujetDTO.isPresent()) {
            return new ResponseEntity<>(sujetDTO.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Subject not found", HttpStatus.NOT_FOUND);
        }
    }

}
