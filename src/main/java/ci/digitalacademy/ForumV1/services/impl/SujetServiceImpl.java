package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.models.Sujet;
import ci.digitalacademy.ForumV1.repositories.SujetRepository;
import ci.digitalacademy.ForumV1.services.SujetService;
import ci.digitalacademy.ForumV1.services.dto.SujetDTO;
import ci.digitalacademy.ForumV1.services.mapper.SujetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SujetServiceImpl implements SujetService {

    private final SujetRepository sujetRepository;
    private final SujetMapper sujetMapper;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        log.debug("Request to save Sujet : {}", sujetDTO);
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        sujet = sujetRepository.save(sujet);
        return sujetMapper.toDto(sujet);
    }

    @Override
    public Optional<SujetDTO> findOne(Long id) {
        log.debug("Request to get Sujet : {}", id);
        return sujetRepository.findById(id).map(sujet -> {
            return sujetMapper.toDto(sujet);
        });
    }

    @Override
    public List<SujetDTO> findAll() {
        log.debug("Request to get all Sujets");
        return sujetRepository.findAll().stream().map(sujet -> {
            return sujetMapper.toDto(sujet);
        }).toList();
    }

    @Override
    public List<SujetDTO> findSujetByForumId(Long forumId) {
        log.debug("Request to get Sujets by Forum : {}", forumId);
        return sujetRepository.findSujetByForumId(forumId).stream().map(sujet -> {
            return sujetMapper.toDto(sujet);
        }).toList();
    }
}
