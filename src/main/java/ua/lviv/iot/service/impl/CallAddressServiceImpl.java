package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.CallAddressDaoImpl;
import ua.lviv.iot.model.CallAddress;
import ua.lviv.iot.service.CallAddressService;

public class CallAddressServiceImpl extends AbstractServiceImpl<CallAddress, Integer> implements CallAddressService {
    public CallAddressServiceImpl() {
        super(new CallAddressDaoImpl());
    }
}
