package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.Call;

public class CallDaoImpl extends AbstractDaoImpl<Call, Integer> {
    public CallDaoImpl() {
        super(Call.class);
    }
}
