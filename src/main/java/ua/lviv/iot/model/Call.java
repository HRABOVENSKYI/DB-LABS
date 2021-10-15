package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "`call`")
@NoArgsConstructor
@Getter
@Setter
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Column(name = "call_time", nullable = false)
    private LocalDateTime callTime;

    @ManyToOne
    @JoinColumn(name = "reporter_phone_number", nullable = false)
    private Reporter reporter;

    @ManyToOne
    @JoinColumn(name = "call_address_id", nullable = false)
    private CallAddress callAddress;

    @OneToMany(mappedBy = "call")
    private Set<CallHasRescuer> rescuers;

    @OneToMany(mappedBy = "call")
    private Set<CallHasRescueVehicle> rescueVehicles;
}
