package ua.lviv.iot.service;

import ua.lviv.iot.model.RescueVehicle;

import java.util.List;

public interface RescueVehicleService {

    RescueVehicle createRescueVehicle(RescueVehicle callAddress);

    List<RescueVehicle> getAllRescueVehicles();

    RescueVehicle getRescueVehicleById(String number);

    RescueVehicle updateRescueVehicle(RescueVehicle callAddress);

    RescueVehicle deleteRescueVehicleById(String number);
}
