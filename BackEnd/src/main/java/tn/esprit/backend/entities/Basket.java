package tn.esprit.backend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.backend.entities.Ennumeration.Coupon;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;


    @Column
    private Coupon coupon;
    @Column
    private Double Total ;

    @Column
    private Date date_add;

    @OneToMany(mappedBy = "basket")
    private Set<Purshase> purchases;

    @OneToOne(mappedBy = "basket")
    private User user;
}
