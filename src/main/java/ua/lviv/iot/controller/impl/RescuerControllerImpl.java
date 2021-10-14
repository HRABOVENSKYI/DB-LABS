package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.service.impl.RescuerServiceImpl;

public class RescuerControllerImpl extends AbstractControllerImpl<Rescuer, Integer> {
    public RescuerControllerImpl() {
        super(new RescuerServiceImpl());
    }
}
