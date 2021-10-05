package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.HospitalController;
import ua.lviv.iot.model.Hospital;
import ua.lviv.iot.service.impl.HospitalServiceImpl;

public class HospitalControllerImpl extends AbstractControllerImpl<Hospital, Integer> implements HospitalController {
    public HospitalControllerImpl() {
        super(new HospitalServiceImpl());
    }
}
