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

public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Long id;
    private double prix;
    @Column
    private double remise;
    @Column
    private Date date_purchase;
    @OneToOne(mappedBy = "purchase")
    private Basket basket;


}
