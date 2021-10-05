package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.HospitalDaoImpl;
import ua.lviv.iot.model.Hospital;
import ua.lviv.iot.service.HospitalService;

public class HospitalServiceImpl extends AbstractServiceImpl<Hospital, Integer> implements HospitalService {
    public HospitalServiceImpl() {
        super(new HospitalDaoImpl());
    }
}
