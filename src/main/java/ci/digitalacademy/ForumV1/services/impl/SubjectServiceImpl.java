package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.models.Subject;
import ci.digitalacademy.ForumV1.repositories.SubjectRepository;
import ci.digitalacademy.ForumV1.services.SubjectService;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;
import ci.digitalacademy.ForumV1.services.mapper.SubjectMapper;
import ci.digitalacademy.ForumV1.utils.SlugifyUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDTO save(SubjectDTO subjectDTO) {
        log.debug("Request to save Subject : {}", subjectDTO);
        Subject subject = subjectMapper.toEntity(subjectDTO);
        subject = subjectRepository.save(subject);
        return subjectMapper.toDto(subject);
    }

    @Override
    public Optional<SubjectDTO> findOne(Long id) {
        log.debug("Request to get Subject : {}", id);
        return subjectRepository.findById(id).map(subject -> {
            return subjectMapper.toDto(subject);
        });
    }

    @Override
    public List<SubjectDTO> findSubjectByForumId(Long forumId) {
        log.debug("Request to get Subjects by Forum : {}", forumId);
        return subjectRepository.findSubjectByForumId(forumId).stream().map(subject -> {
            return subjectMapper.toDto(subject);
        }).toList();
    }

    @Override
    public SubjectDTO saveSubject(SubjectDTO subjectDTO) {
        log.debug("Request to save Subject with the slug : {}", subjectDTO);
        final String slug = SlugifyUtils.generateSlugify(subjectDTO.getTitle());
        subjectDTO.setSlug(slug);
        return save(subjectDTO);
    }

    @Override
    public Optional<SubjectDTO> findSubjectBySlug(String slug) {
        log.debug("Request to get Subject by slug : {}", slug);
        return subjectRepository.findSubjectBySlug(slug).map(subject -> {
            return subjectMapper.toDto(subject);
        });
    }
}
