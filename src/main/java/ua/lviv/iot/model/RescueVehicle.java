package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.Table;

@Table(name = "rescue_vehicle")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "number")
public class RescueVehicle {

    @Column(name = "number")
    private String number;

    @Column(name = "characteristics")
    private String characteristics;
}
