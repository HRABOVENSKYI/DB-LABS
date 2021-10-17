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
    public Hospital createHospital(Hospital hospital) {
        return hospitalDao.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalDao.findAll();
    }

    @Override
    public Hospital getHospitalById(Integer id) {
        return hospitalDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Hospital updateHospital(Hospital hospital) {
        getHospitalById(hospital.getId()); // will throw exception if entity doesn't exist
        return hospitalDao.save(hospital);
    }
}
