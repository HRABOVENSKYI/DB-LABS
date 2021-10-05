package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.InjuryDao;
import ua.lviv.iot.model.Injury;

public class InjuryDaoImpl extends AbstractDaoImpl<Injury, Integer> implements InjuryDao {
    public InjuryDaoImpl() {
        super(Injury.class);
    }
}
