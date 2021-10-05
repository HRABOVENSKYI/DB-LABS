package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.CallAddressDao;
import ua.lviv.iot.model.CallAddress;

public class CallAddressDaoImpl extends AbstractDaoImpl<CallAddress, Integer> implements CallAddressDao {
    public CallAddressDaoImpl() {
        super(CallAddress.class);
    }
}
