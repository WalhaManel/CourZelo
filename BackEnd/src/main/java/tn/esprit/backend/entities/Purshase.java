package tn.esprit.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Purshase")
public class Purshase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Long id;
    private double prix;
    @Column
    private double remise;
    @Column
    private Date date_purchase;

    @Column
    private String Status;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Basket basket;

    @ManyToOne(cascade = CascadeType.ALL)
    private Course course;


}
