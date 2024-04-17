package tn.esprit.backend.Services;

import tn.esprit.backend.entities.Basket;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

public interface IBasketSer {
    Basket addToBasket(Long idcourse, Long idu);
    Iterable<Basket> SerachResult(String key, String  date);

    Iterable<Basket> showAll();

     Optional<Basket> findOne(Long id);
     Basket dropItem(Long idb, Long idC);

     String EmptyBasket( Long idb);




     String ApplyCode(String code, Long idb);


    }
