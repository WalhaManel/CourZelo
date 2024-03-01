package tn.esprit.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.Purshase;
@Repository
public interface PurshaseRep extends CrudRepository<Purshase,Long> {
}
