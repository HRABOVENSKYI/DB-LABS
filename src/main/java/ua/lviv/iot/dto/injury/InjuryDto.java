package ua.lviv.iot.dto.injury;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class InjuryDto {

    private Integer id;

    private String description;

    private String diagnosis;

    private Integer hospitalId;
}
