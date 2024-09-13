package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findSubjectByForumId(Long forumId);
    Optional<Subject> findSubjectBySlug(String slug);
}
