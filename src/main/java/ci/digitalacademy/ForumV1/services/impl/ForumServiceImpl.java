package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.models.Forum;
import ci.digitalacademy.ForumV1.repositories.ForumRepository;
import ci.digitalacademy.ForumV1.services.ForumService;
import ci.digitalacademy.ForumV1.services.dto.ForumDTO;
import ci.digitalacademy.ForumV1.services.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@Service
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;


    @Override
    public List<ForumDTO> findAllForums() {
        log.debug("Request to get all Forums");
        // Retourne la liste de tous les forums
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.toDto(forum);
        }).toList();
    }

    @Override
    public ForumDTO saveForum(ForumDTO forumDTO) {
        log.debug("Request to save forum: {}", forumDTO);
        // Enregistrer un nouveau forum
        Forum forum = forumMapper.toEntity(forumDTO);
        forum = forumRepository.save(forum);
        return forumMapper.toDto(forum);
    }

    @Override
    public Optional<ForumDTO> getForumById(Long id) {
        log.debug("Request to get Forum : {}", id);
        // Récupère un forum par son ID, ou lève une exception si non trouvé
        return forumRepository.findById(id).map(forum -> {
            return forumMapper.toDto(forum);
        });

    }

    @Override
    public Optional<ForumDTO> findForumBySlug(String id) {
        log.debug("Request to get Forum : {}", id);
        return forumRepository.findForumBySlug(id).map(forum -> {
            return forumMapper.toDto(forum);
        });
    }
}
