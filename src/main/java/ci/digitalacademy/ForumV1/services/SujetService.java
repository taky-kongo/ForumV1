package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    Optional<SujetDTO> findOne(Long id);

    List<SujetDTO> findAll();

    List<SujetDTO> findSujetByForumId(Long forumId);
}
