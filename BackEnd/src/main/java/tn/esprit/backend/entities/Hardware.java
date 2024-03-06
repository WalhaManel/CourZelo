    package tn.esprit.backend.entities;

    import jakarta.persistence.*;
    import lombok.*;
    import lombok.experimental.FieldDefaults;
    import tn.esprit.backend.entities.Ennumeration.HardwareStatut;

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class Hardware {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
            Long HardwareID;
            String HardwareName;
            @Enumerated(EnumType.STRING)
            HardwareStatut Satut;
            Long quantity;


    }
