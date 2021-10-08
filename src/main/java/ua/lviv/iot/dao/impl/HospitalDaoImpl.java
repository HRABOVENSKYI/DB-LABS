package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.AbstractDao;
import ua.lviv.iot.model.Hospital;

public class HospitalDaoImpl extends AbstractDaoImpl<Hospital, Integer> {

    public HospitalDaoImpl() {
        super(Hospital.class);
    }
}
