package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.InjuryDaoImpl;
import ua.lviv.iot.model.Injury;
import ua.lviv.iot.service.AbstractService;

public class InjuryServiceImpl extends AbstractServiceImpl<Injury, Integer> {
    public InjuryServiceImpl() {
        super(new InjuryDaoImpl());
    }
}
