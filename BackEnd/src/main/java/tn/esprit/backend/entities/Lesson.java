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

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lessonId;

    private String lessonTitle;

    private String lessonContent;

    // Other fields related to Lesson entity

    /*@ManyToOne
    private Course course;*/

    // Constructors, getters, and setters
    @ManyToOne
    private Course course;
}
