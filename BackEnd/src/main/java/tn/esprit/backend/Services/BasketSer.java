package tn.esprit.backend.Services;

import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.backend.Repositories.BasketRep;
import tn.esprit.backend.Repositories.CousreRepository;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;
import tn.esprit.backend.entities.User;

import java.util.*;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class BasketSer implements IBasketSer {
    @Autowired
    private BasketRep BasketR;
    @Autowired
    private CousreRepository CourseRep;


    public Basket addToBasket(Basket b, List<Long> idcourses) {
        Set<Course> courses =new HashSet<>();
        for (Long idc: idcourses
             ) {
            courses.add(CourseRep.findById(idc).get());
        }
        b.setDate_add(new Date());
        b.setCourses(courses);

        return BasketR.save(b);

    }

    public Iterable<Basket> showAll()
    { return BasketR.findAll();}

    public Optional<Basket> findOne(Long id)
    { return BasketR.findById(id);}

    public Optional<Basket> showBasket(User idU)
    { return BasketR.findByUser(idU);}

    public Basket dropItem(Long idB, Long idC){
        Basket basket = BasketR.findById(idB).get();
        Course c = CourseRep.findById(idC).get();
        basket.getCourses().remove(c);
        return basket;
    }

    public void EmptyBasket(long idB){
        BasketR.deleteById(idB);
    }

//    public void CouponConfirmation(Long idB){
//
//    }
}
