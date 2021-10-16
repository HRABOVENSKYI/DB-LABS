package ua.lviv.iot.service;

import ua.lviv.iot.model.Hospital;

import java.util.List;

public interface HospitalService {

    List<Hospital> getAllHospitals();

    Hospital getHospitalById(Integer id);
}
