package ci.digitalacademy.ForumV1.web.ressources;

import ci.digitalacademy.ForumV1.services.SujetService;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SujetDTO save(@RequestBody SujetDTO sujetDTO) {
        log.debug("REST request to save Sujet : {}", sujetDTO);
        return sujetService.save(sujetDTO);
    }

    @GetMapping("/allsujets/{id}")
    public List<SujetDTO> getAllSujets(@PathVariable Long id) {
        log.debug("REST request to get all Sujets of forum : {}", id);
        return null;
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
