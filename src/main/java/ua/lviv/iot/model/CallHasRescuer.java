package ua.lviv.iot.model;

import lombok.*;
import ua.lviv.iot.model.composite_key.CallRescuerId;

import javax.persistence.*;

@Entity
@Table(name = "call_has_rescuer")
@NoArgsConstructor
@Getter
@Setter
public class CallHasRescuer {

    @EmbeddedId
    private CallRescuerId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("callId")
    private Call call;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("rescuerId")
    private Rescuer rescuer;

    @OneToOne
    @JoinColumn(name = "injury_id")
    private Injury injury;

    @Override
    public String toString() {
        return "Rescuer{" +
                "id=" + rescuer.getId() +
                '}';
    }
}
