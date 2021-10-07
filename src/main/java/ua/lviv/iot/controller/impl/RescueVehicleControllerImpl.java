package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.AbstractController;
import ua.lviv.iot.model.RescueVehicle;
import ua.lviv.iot.service.impl.RescueVehicleServiceImpl;

public class RescueVehicleControllerImpl extends AbstractControllerImpl<RescueVehicle, String> {
    public RescueVehicleControllerImpl() {
        super(new RescueVehicleServiceImpl());
    }
}
