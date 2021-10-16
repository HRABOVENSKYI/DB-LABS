package ua.lviv.iot.service;

import ua.lviv.iot.dto.callhasrescuevehicle.CallHasRescueVehicleDto;
import ua.lviv.iot.model.CallHasRescueVehicle;

import java.util.List;

public interface CallHasRescueVehicleService {

    CallHasRescueVehicle createCallHasRescueVehicle(CallHasRescueVehicleDto callHasRescueVehicleDto);

    List<CallHasRescueVehicle> getAllCallHasRescueVehicles();

    CallHasRescueVehicle updateCallHasRescueVehicle(CallHasRescueVehicle callHasRescueVehicle);
}
