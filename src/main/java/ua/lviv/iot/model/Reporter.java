package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.annotations.Column;
import ua.lviv.iot.annotations.PrimaryKey;
import ua.lviv.iot.annotations.Table;

@Table(name = "reporter")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "phoneNumber")
public class Reporter {

    @PrimaryKey
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;
}
