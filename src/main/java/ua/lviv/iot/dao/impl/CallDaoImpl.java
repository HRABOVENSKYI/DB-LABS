package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.CallDao;
import ua.lviv.iot.model.Call;

public class CallDaoImpl extends AbstractDaoImpl<Call, Integer> implements CallDao {
    public CallDaoImpl() {
        super(Call.class);
    }
}
