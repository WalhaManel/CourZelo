package tn.esprit.backend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.backend.entities.Ennumeration.Coupon;

import java.util.Date;
import java.util.List;
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

    @ManyToMany(mappedBy = "baskets")
    private Set<Course> courses;
    @Column
    private Coupon coupon;
    @Column
    private Double Total ;

    @Column
    private Date date_add;

    @Column
    private String Status;

    @JsonIgnore
    @OneToOne
    private Purchase purchase;

    @ManyToOne()
    private User user;
}
