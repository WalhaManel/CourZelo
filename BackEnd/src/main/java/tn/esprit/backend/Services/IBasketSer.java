package tn.esprit.backend.Services;

import tn.esprit.backend.entities.Basket;

import java.util.List;
import java.util.Optional;

public interface IBasketSer {
    Basket addToBasket(Basket b, List<Long> idcourses);

    Iterable<Basket> showAll();

     Optional<Basket> findOne(Long id);
     Basket dropItem(Long idB, Long idC);
     void EmptyBasket(long idB);



    }
