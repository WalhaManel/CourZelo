package tn.esprit.backend.Services;

import tn.esprit.backend.entities.Basket;

import java.util.List;
import java.util.Optional;

public interface IBasketSer {
    Basket addToBasket(Basket b, List<Long> idcourses,Long idu);

    Iterable<Basket> showAll();

     Optional<Basket> findOne(Long id);
     Basket dropItem(Basket b, Long idC);

     void EmptyBasket(Basket b);






    }
