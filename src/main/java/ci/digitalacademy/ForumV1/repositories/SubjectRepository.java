package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<subject, Long> {
    List<subject> findSubjectByForumId(Long forumId);
}
