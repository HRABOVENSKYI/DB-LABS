package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.RescuerController;
import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.service.impl.RescuerServiceImpl;

public class RescuerControllerImpl extends AbstractControllerImpl<Rescuer, Integer> implements RescuerController {
    public RescuerControllerImpl() {
        super(new RescuerServiceImpl());
    }
}
