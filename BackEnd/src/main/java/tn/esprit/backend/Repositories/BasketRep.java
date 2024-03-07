package tn.esprit.backend.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.Basket;

@Repository
public interface BasketRep extends CrudRepository<Basket,Long> {

    Basket findByUserUserId(Long idU);

}
