package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
    List<Sujet> findSujetByForumId(Long forumId);
}
