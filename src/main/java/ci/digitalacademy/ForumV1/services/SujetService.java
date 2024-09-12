package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    SujetDTO update(SujetDTO sujetDTO);

    Optional<SujetDTO> findOne(Long id);

    List<SujetDTO> findAll();

    void delete(Long id);

    List<SujetDTO> findSujetByForumId(Long forumId);
}
