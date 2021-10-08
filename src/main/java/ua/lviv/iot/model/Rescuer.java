package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.model.enums.Position;

import javax.persistence.*;

@Entity
@Table(name = "rescuer")
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Rescuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Column(name = "is_present")
    private boolean isPresent;
}
