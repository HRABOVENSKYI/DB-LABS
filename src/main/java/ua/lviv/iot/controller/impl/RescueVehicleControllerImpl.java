package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.RescueVehicleController;
import ua.lviv.iot.model.RescueVehicle;
import ua.lviv.iot.service.impl.RescueVehicleServiceImpl;

public class RescueVehicleControllerImpl extends AbstractControllerImpl<RescueVehicle, String> implements RescueVehicleController {
    public RescueVehicleControllerImpl() {
        super(new RescueVehicleServiceImpl());
    }
}
