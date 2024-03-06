package tn.esprit.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.User;

import java.util.Optional;

@Repository
public interface BasketRep extends CrudRepository<Basket,Long> {

    Optional<Basket> findByUser(User idU);
}
