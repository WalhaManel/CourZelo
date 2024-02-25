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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseTitle;

    private String courseDescription;

    private String imgUrl;

    private Long availablePlaces;

    //@Enumerated(EnumType.STRING)
   // private CourseType courseType;

    private Date groupTime;

    private Date meetTime;

    private String meetUrl;
    @OneToMany(mappedBy = "course")
    private List<ReservationCourse> reservationCourses;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToOne
    private Basket basket;

}
