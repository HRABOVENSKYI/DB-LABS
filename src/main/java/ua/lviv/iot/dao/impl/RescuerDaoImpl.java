package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.RescuerDao;
import ua.lviv.iot.model.Rescuer;

public class RescuerDaoImpl extends AbstractDaoImpl<Rescuer, Integer> implements RescuerDao {
    public RescuerDaoImpl() {
        super(Rescuer.class);
    }
}
