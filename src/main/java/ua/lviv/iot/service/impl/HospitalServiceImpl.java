package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.HospitalDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Hospital;
import ua.lviv.iot.service.HospitalService;

import java.util.List;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalDao hospitalDao;

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalDao.findAll();
    }

    @Override
    public Hospital getHospitalById(Integer id) {
        return hospitalDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }
}
