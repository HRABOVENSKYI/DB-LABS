package ua.lviv.iot.controller.impl;

import ua.lviv.iot.model.CallAddress;
import ua.lviv.iot.service.impl.CallAddressServiceImpl;

public class CallAddressControllerImpl extends AbstractControllerImpl<CallAddress, Integer> {
    public CallAddressControllerImpl() {
        super(new CallAddressServiceImpl());
    }
}
