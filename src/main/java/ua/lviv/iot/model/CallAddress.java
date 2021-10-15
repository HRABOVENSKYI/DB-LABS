package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "call_address")
@NoArgsConstructor
@Getter
@Setter
public class CallAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank(message = "is required and must not be blank") // TODO: Complete validation, practice https://www.baeldung.com/javax-validation
    @Column(name = "region", nullable = false)
    private String region;

    @NotBlank(message = "is required and must not be blank")
    @Column(name = "city_or_village", nullable = false)
    private String cityOrVillage;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private String flat;

    @Column(name = "place")
    private String place;

    @OneToMany(mappedBy = "callAddress")
    private Set<Call> calls;
}
