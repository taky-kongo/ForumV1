package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ForumRepository extends JpaRepository<Forum, Long> {
}
