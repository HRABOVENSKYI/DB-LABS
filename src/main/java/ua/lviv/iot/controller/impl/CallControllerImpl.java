package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.Call;
import ua.lviv.iot.service.impl.CallServiceImpl;

public class CallControllerImpl extends AbstractControllerImpl<Call, Integer> {
    public CallControllerImpl() {
        super(new CallServiceImpl());
    }
}
