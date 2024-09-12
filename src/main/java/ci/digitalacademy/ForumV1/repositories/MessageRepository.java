package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
