package ua.lviv.iot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.model.CallHasRescueVehicle;
import ua.lviv.iot.model.composite_key.CallRescueVehicleId;

@Repository
public interface CallHasRescueVehicleDao extends JpaRepository<CallHasRescueVehicle, CallRescueVehicleId> {
}
