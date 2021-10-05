package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.RescueVehicleDao;
import ua.lviv.iot.model.RescueVehicle;

public class RescueVehicleDaoImpl extends AbstractDaoImpl<RescueVehicle, String> implements RescueVehicleDao {
    public RescueVehicleDaoImpl() {
        super(RescueVehicle.class);
    }
}
