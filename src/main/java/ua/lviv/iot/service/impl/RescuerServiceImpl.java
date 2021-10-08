package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.RescuerDaoImpl;
import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.service.AbstractService;

public class RescuerServiceImpl extends AbstractServiceImpl<Rescuer, Integer> {
    public RescuerServiceImpl() {
        super(new RescuerDaoImpl());
    }
}
