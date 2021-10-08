package ua.lviv.iot.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "reporter")
@NoArgsConstructor
@Getter
@Setter
@ToString(of = "phoneNumber")
@EqualsAndHashCode(of = "phoneNumber")
public class Reporter {

    @Id
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "reporter", fetch = FetchType.EAGER)
    private Set<Call> calls;
}
