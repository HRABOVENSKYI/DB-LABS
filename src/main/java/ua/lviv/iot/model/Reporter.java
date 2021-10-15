package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "reporter")
@NoArgsConstructor
@Getter
@Setter
public class Reporter {

    @Id
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "reporter")
    private Set<Call> calls;
}
