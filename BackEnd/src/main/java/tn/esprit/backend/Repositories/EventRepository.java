package tn.esprit.backend.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entities.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
