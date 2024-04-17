package tn.esprit.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.backend.entities.Course;
import tn.esprit.backend.entities.Purshase;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.PromoCode;

import java.util.List;

public interface PromoCodeRepository   extends JpaRepository<PromoCode, Long> {

    @Query("SELECT b.user, SUM(p.prix) FROM Purshase p JOIN p.basket b GROUP BY p.basket.id")
    List<Object[]> findTotalPurchasesByBasket();
}
