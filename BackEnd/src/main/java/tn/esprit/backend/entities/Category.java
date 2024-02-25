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

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idCateg;


    private String categDescription;


    private String categName;


    private String categImg;

    @OneToMany(mappedBy = "category")
    private List<Course> courses;

    // Constructors, getters, and setters
}
