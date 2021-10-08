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
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Column(name = "call_time")
    private LocalDateTime callTime;

    @ManyToOne
    @JoinColumn(name = "reporter_phone_number", nullable = false)
    private Reporter reporter;

    @ManyToOne
    @JoinColumn(name = "call_address_id", nullable = false)
    private CallAddress callAddress;

    @OneToMany(mappedBy = "call", fetch = FetchType.EAGER)
    private Set<CallHasRescuer> rescuers;

    @OneToMany(mappedBy = "call", fetch = FetchType.EAGER)
    private Set<CallHasRescueVehicle> rescueVehicles;
}
