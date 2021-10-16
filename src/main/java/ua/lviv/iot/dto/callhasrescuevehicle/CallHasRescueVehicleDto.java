package ua.lviv.iot.dto.callhasrescuevehicle;

import lombok.*;
import ua.lviv.iot.model.compositekey.CallRescueVehicleId;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CallHasRescueVehicleDto {

    private Integer callId;

    private String rescueVehicleId;

    private LocalDateTime departureTime;

    private LocalDateTime returnTime;
}
