package ci.digitalacademy.ForumV1.services;

import ci.digitalacademy.ForumV1.services.dto.SubjectDTO;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    SubjectDTO save(SubjectDTO subjectDTO);

    Optional<SubjectDTO> findOne(Long id);

    List<SubjectDTO> findSubjectByForumId(Long forumId);

    SubjectDTO saveSubject(SubjectDTO subjectDTO);

    Optional<SubjectDTO> findSubjectBySlug(String slug);
}
