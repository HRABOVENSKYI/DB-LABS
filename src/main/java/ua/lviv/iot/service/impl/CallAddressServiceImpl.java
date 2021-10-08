package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.CallAddressDaoImpl;
import ua.lviv.iot.model.CallAddress;

public class CallAddressServiceImpl extends AbstractServiceImpl<CallAddress, Integer> {
    public CallAddressServiceImpl() {
        super(new CallAddressDaoImpl());
    }
}
