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
public class User   {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Long tel;

    private String token;

    private Boolean isVerified;

    private Boolean isArchived;

    private Boolean isConfirmed;

    private Date birthDate;

    private Boolean state;

    private String description;

    private String fbLink;

    private String twitterLink;

    private String instaLink;

    private String imgUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String cvUrl;
    @ManyToMany
    private List<Grades> grades;

    @OneToMany(mappedBy = "user")
    private List<ReservationCourse> reservationCourses;

    @JsonIgnore
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Basket> baskets;
}
