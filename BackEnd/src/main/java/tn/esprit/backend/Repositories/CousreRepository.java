package tn.esprit.backend.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entities.Course;

public interface CousreRepository extends JpaRepository<Course, Long> {
}
