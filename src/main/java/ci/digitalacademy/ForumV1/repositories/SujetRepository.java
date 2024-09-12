package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Sujet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SujetRepository extends JpaRepository<Sujet, Long> {
}
