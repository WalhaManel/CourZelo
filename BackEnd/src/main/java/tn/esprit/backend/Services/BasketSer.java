package tn.esprit.backend.Services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.BasketRep;
import tn.esprit.backend.Repositories.CousreRepository;
import tn.esprit.backend.Repositories.PurshaseRep;
import tn.esprit.backend.Repositories.UserRep;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;
import tn.esprit.backend.entities.Ennumeration.Coupon;
import tn.esprit.backend.entities.Purshase;
import tn.esprit.backend.entities.User;

import java.util.*;

@Service
@AllArgsConstructor
public class BasketSer implements IBasketSer {
    @Autowired
    private BasketRep BasketR;
    @Autowired
    private PurshaseRep purshaseRep;
    @Autowired
    private CousreRepository CourseRep;

    @Autowired
    private UserRep userRep;

    public Basket addToBasket(Long idcourse, Long idu) {
        Basket b = BasketR.findByUserUserId(idu);
        Course course = CourseRep.findById(idcourse).get();
        User user = userRep.findById(idu).get();
        if (b == null){
            Basket basket = Basket.builder().date_add(new Date()).Total((double) course.getPrice()).user(user).build();
            Purshase purshase = Purshase.builder().date_purchase(new Date()).course(course).Status("en cours").basket(basket).prix(course.getPrice()).build();
            purshaseRep.save(purshase);
            BasketR.save(basket);

        }else{
            for (Purshase p :b.getPurchases()
                 ) {
                if(p.getCourse() == course){
                    return b;
                }
            }
            Purshase purshase = Purshase.builder().date_purchase(new Date()).course(course).Status("en cours").basket(b).prix(course.getPrice()).build();
            purshaseRep.save(purshase);
            b.getPurchases().add(purshase);
            b.setTotal(b.getTotal()+purshase.getPrix());
            b.setDate_add(new Date());
            BasketR.save(b);

        }

        return b;

    }

    public Iterable<Basket> showAll()
    { return BasketR.findAll();}

    public Optional<Basket> findOne(Long id)
    { return BasketR.findById(id);}



    public Basket showBasket(Long idU)
    { Basket b = BasketR.findByUserUserId(idU);
    Iterable<Purshase> purshases = b.getPurchases();
        for (Purshase p: purshases
             ) {
            if (p.getStatus().equals("Confirmed")){
                b.getPurchases().remove(p);
            }

        }
        return b;
    }

    public Basket dropItem(Long idb, Long idp){
        Basket b = BasketR.findById(idb).get();
        Purshase purshase = purshaseRep.findById(idp).get();
        for (Purshase p: b.getPurchases()
             ) {
            if(p == purshase){
                b.setTotal(b.getTotal() - purshase.getPrix());
                BasketR.save(b);
                purshaseRep.delete(purshase);
            }
        }
        return b;
    }

    public String EmptyBasket(Long idb){
        Basket b = BasketR.findById(idb).get();

        for (Purshase p: b.getPurchases()
             ) {
            if(p.getStatus().equals("en cours")) {
                purshaseRep.delete(p);

            }
            b.setTotal((double) 0);
            BasketR.save(b);
        }
        return "{\"msg\":\"affected\"}";

    }

    public String ApplyCode(String code, Long idb){
        Basket b = BasketR.findById(idb).get();
        Coupon[] coupons = Coupon.values();
        boolean isEnumValue = false;

        for (Coupon c : coupons) {
            if (c.name().equals(code)) {
                isEnumValue = true;
                break;
            }
        }
        if (isEnumValue){
            b.setTotal(b.getTotal()-b.getTotal()*0.1);
            BasketR.save(b);
            return "{\"msg\":\"applyed\"}";
        }else {
            return "{\"msg\":\"coupon invalide\"}";
        }
    }
}
