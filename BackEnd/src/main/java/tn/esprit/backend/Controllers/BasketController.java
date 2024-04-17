package tn.esprit.backend.Controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend.Services.BasketSer;
import tn.esprit.backend.Services.CourseService;
import tn.esprit.backend.entities.Basket;
import tn.esprit.backend.entities.Course;

import java.util.Date;
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

//    @PostMapping("confirmPurshases")
//    public Basket addToBasket(@RequestParam('idb') Long idb ){
//        return BasketS.confirmPurshases(idb);
//    }
    @PostMapping("addToBasket")
    public Basket addToBasket(@RequestParam("idc") Long idc, @RequestParam("idu") Long idu ){
        return BasketS.addToBasket(idc,idu);
    }


    @GetMapping("showAll")
    public Iterable<Basket> showAll(){
        return BasketS.showAll();

    }

    @GetMapping("Search")
    public Iterable<Basket> Search(@RequestParam("key") String key,@RequestParam("date") String date){
        return BasketS.SerachResult(key,date);

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
    public Basket dropItem(@RequestParam("idb") Long b,@RequestParam("idc") Long idC){
        return BasketS.dropItem(b,idC);
    }

    @DeleteMapping("emptyBasket")
    public String EmptyBasket(@RequestParam("idb") Long idb){
       return BasketS.EmptyBasket(idb);
    }
    @GetMapping("showBasket")
    public Basket showBasket(@RequestParam("idU") Long idU){
        return BasketS.showBasket(idU);

    }

    @GetMapping("ApplyCode")
    public String ApplyCode(@RequestParam("code") String code, @RequestParam("idb") Long idb){
        return BasketS.ApplyCode(code,idb);
    }
}
