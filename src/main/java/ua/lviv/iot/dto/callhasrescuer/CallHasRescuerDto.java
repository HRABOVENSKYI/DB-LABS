package ua.lviv.iot.dto.callhasrescuer;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CallHasRescuerDto {

    private Integer callId;

    private Integer rescuerId;

    private Integer injuryId;
}
