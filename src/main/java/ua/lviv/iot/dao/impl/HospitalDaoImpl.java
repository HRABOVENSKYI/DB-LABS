package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.HospitalDao;
import ua.lviv.iot.model.Hospital;

public class HospitalDaoImpl extends AbstractDaoImpl<Hospital, Integer> implements HospitalDao {

    public HospitalDaoImpl() {
        super(Hospital.class);
    }
}
