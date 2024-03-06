package tn.esprit.backend.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long EventID;
    String EventName;
    String EventDescription;
    Date EventDate;
    Float Price;
    Long AvailablePlaces;
    Long EventPlaces;
    String Latitude;
    String Longitude;

    // Image data as byte array
    @Lob
    @Basic(fetch = FetchType.LAZY)
    byte[] imageData;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Hardware> hardwares;
}
