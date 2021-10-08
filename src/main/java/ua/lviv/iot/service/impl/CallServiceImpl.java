package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.CallDaoImpl;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.service.AbstractService;

public class CallServiceImpl extends AbstractServiceImpl<Call, Integer> {
    public CallServiceImpl() {
        super(new CallDaoImpl());
    }
}
