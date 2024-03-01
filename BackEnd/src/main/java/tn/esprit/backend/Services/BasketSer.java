package tn.esprit.backend.Services;

import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.BasketRep;
import tn.esprit.backend.Repositories.CousreRepository;
import tn.esprit.backend.Repositories.PurshaseRep;
import tn.esprit.backend.Repositories.UserRep;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;
import tn.esprit.backend.entities.Purshase;

import java.util.*;
import java.util.logging.Logger;

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

    public Basket addToBasket(Basket b, List<Long> idcourses,Long idu) {
        b.setUser(userRep.findById(idu).get());
        Set<Purshase> purshases = new HashSet<>();
        BasketR.save(b);
        b.setDate_add(new Date());
        for (Long idc: idcourses
             ) {
            Course course = CourseRep.findById(idc).get();

        Purshase purshase = Purshase.builder().date_purchase(new Date()).course(course).Status("en cours").basket(b).build();
        purshaseRep.save(purshase);
        purshases.add(purshase);
        }
        b.setPurchases(purshases);

        return b;

    }

    public Iterable<Basket> showAll()
    { return BasketR.findAll();}

    public Optional<Basket> findOne(Long id)
    { return BasketR.findById(id);}



    public Optional<Basket> showBasket(Long idU)
    { return BasketR.findByUserUserId(idU);}

    public Basket dropItem(Basket b, Long idC){
        Course c = CourseRep.findById(idC).get();
        for (Purshase p: b.getPurchases()
             ) {
            if(p.getCourse() == c){
                purshaseRep.delete(p);
            }
        }
        return b;
    }

    public void EmptyBasket(Basket b){
        for (Purshase p: b.getPurchases()
             ) {
            purshaseRep.delete(p);
        }
    }

//    public void CouponConfirmation(Long idB){
//
//    }
}
