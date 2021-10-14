package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "call_address")
@NoArgsConstructor
@Getter
@Setter
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class CallAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "region", nullable = false)
    private String region;

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

    @OneToMany(mappedBy = "callAddress", fetch = FetchType.EAGER)
    private Set<Call> calls;
}
