package tn.esprit.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.backend.entities.Hardware;

public interface HardwareRepository extends JpaRepository<Hardware,Long> {
}
