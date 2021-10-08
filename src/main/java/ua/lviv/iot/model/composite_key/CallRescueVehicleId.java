package ua.lviv.iot.model.composite_key;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(of = {"callId", "rescueVehicleNumber"})
public class CallRescueVehicleId implements Serializable {

    @Column(name = "call_id")
    private Integer callId;

    @Column(name = "rescue_vehicle_number", length = 8)
    private String rescueVehicleNumber;
}
