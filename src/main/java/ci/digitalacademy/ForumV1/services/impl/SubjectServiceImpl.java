package ci.digitalacademy.ForumV1.services.impl;

import ci.digitalacademy.ForumV1.models.subject;
import ci.digitalacademy.ForumV1.repositories.SubjectRepository;
import ci.digitalacademy.ForumV1.services.SubjectService;
import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;
import ci.digitalacademy.ForumV1.services.mapper.SubjectMapper;
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
        subject subject = subjectMapper.toEntity(subjectDTO);
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
}
