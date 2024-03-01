package tn.esprit.backend.Controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.Services.BasketSer;
import tn.esprit.backend.Services.CourseService;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;
import tn.esprit.backend.entities.classe.requestBody;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("pi/basket")
@CrossOrigin(origins = "http://localhost:4200")
public class BasketController {
    @Autowired
    BasketSer BasketS;

    @Autowired
    CourseService courseService;

    @PostMapping("addToBasket")
    public Basket addToBasket(@RequestBody requestBody RQ ){
        return BasketS.addToBasket(RQ.getBasket(),RQ.getCourses(),RQ.getIdu());
    }
    @GetMapping("showAll")
    public Iterable<Basket> showAll(){
        return BasketS.showAll();

    }

    @GetMapping("showAllCourses")
    public Iterable<Course> showAllCourses(){
        return courseService.showAll();

    }

    @GetMapping("showOne")
    public Optional<Basket> findOne(@RequestParam Long id){
        return BasketS.findOne(id);

    }
    @DeleteMapping("dropItem")
    public Basket dropItem(@RequestBody Basket b,@RequestParam("idc") Long idC){
        return BasketS.dropItem(b,idC);
    }

    @DeleteMapping("emptyBasket")
    public void EmptyBasket(@RequestBody Basket b){
        BasketS.EmptyBasket(b);
    }
    @GetMapping("showBasket")
    public Optional<Basket> showBasket(@RequestParam("idU") Long idU){
        return BasketS.showBasket(idU);

    }
}
