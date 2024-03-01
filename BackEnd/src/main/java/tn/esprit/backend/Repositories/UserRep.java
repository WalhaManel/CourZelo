package tn.esprit.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.backend.entities.User;

public interface UserRep extends CrudRepository<User,Long> {
}
