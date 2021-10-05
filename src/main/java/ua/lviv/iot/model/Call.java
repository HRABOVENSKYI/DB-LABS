package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

import java.time.LocalDateTime;

@Table(name = "call")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Call {

    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "reporter_phone_number")
    private Integer reporterPhoneNumber;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "detailed_description")
    private String detailedDescription;

    @Column(name = "call_address_id")
    private Integer callAddressId;

    @Column(name = "call_time")
    private LocalDateTime callTime;
}
