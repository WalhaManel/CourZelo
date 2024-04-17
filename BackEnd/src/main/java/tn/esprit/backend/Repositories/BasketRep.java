package tn.esprit.backend.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.backend.entities.Basket;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public interface BasketRep extends CrudRepository<Basket,Long> {

    Basket findByUserUserId(Long idU);
    @Query("SELECT b FROM Basket b JOIN b.user u WHERE u.email = :email OR DATE(b.date_add) = :dateAdd OR b.promoCode = :promoCode")
    List<Basket> findByEmailOrDateAddOrPromoCode(@Param("email") String email, @Param("dateAdd") Date dateAdd, @Param("promoCode") String promoCode);

}
