package tn.esprit.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private List<ReservationCourse> reservationCourses;


    @JsonIgnore
    @ManyToOne()
    private Category category;


    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private Set<Purshase> purshases;



}
