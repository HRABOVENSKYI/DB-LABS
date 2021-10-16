package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.model.enums.Position;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rescuer")
@NoArgsConstructor
@Getter
@Setter
public class Rescuer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "position", nullable = false)
    private Position position;

    @Column(name = "is_present", nullable = false)
    private boolean isPresent;

    @OneToMany(mappedBy = "rescuer", fetch = FetchType.EAGER)
    private Set<CallHasRescuer> calls;
}
