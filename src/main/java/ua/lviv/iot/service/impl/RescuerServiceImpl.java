package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.RescuerDaoImpl;
import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.service.RescuerService;

public class RescuerServiceImpl extends AbstractServiceImpl<Rescuer, Integer> implements RescuerService {
    public RescuerServiceImpl() {
        super(new RescuerDaoImpl());
    }
}
