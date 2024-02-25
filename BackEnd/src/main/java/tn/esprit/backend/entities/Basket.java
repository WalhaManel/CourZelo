package tn.esprit.backend.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "basket",cascade = CascadeType.ALL)
    private List<Course> courses;
    @Column
    private String coupon;
    @Column
    private Double Total ;
    @OneToOne
    private Purchase purchase;
}
