package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;


public interface ForumService {

    //La liste des Forums
    List<ForumDTO> findAllForums();

    //Creation d'un Forum
    ForumDTO saveForum(ForumDTO forumDTO);

    //Recupère les détails d'un forum
    Optional<ForumDTO> getForumById(Long id);

    Optional<ForumDTO> findForumBySlug(String slug);

    ForumDTO saveForumBySlug(ForumDTO forumDTO);

}
