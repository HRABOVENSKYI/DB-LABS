package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.RescueVehicleDaoImpl;
import ua.lviv.iot.model.RescueVehicle;
import ua.lviv.iot.service.RescueVehicleService;

public class RescueVehicleServiceImpl extends AbstractServiceImpl<RescueVehicle, String> implements RescueVehicleService {
    public RescueVehicleServiceImpl() {
        super(new RescueVehicleDaoImpl());
    }
}
