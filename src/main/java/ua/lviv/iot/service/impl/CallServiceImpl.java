package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.dao.impl.CallDaoImpl;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.service.CallService;

public class CallServiceImpl extends AbstractServiceImpl<Call, Integer> implements CallService {
    public CallServiceImpl() {
        super(new CallDaoImpl());
    }
}
