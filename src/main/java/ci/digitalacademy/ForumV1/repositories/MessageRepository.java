package ci.digitalacademy.ForumV1.repositories;

import ci.digitalacademy.ForumV1.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessageBySujetId(Long sujetId);
}
