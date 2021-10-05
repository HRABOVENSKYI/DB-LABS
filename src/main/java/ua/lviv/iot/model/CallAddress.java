package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "call_address")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class CallAddress {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "region")
    private String region;

    @Column(name = "city_or_village")
    private String cityOrVillage;

    @Column(name = "street")
    private String street;

    @Column(name = "building")
    private String building;

    @Column(name = "flat")
    private String flat;

    @Column(name = "place")
    private String place;
}
