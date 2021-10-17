package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.InjuryDao;
import ua.lviv.iot.dto.injury.InjuryDto;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Hospital;
import ua.lviv.iot.model.Injury;
import ua.lviv.iot.service.HospitalService;
import ua.lviv.iot.service.InjuryService;

import java.util.List;

@Service
@AllArgsConstructor
public class InjuryServiceImpl implements InjuryService {

    private final InjuryDao injuryDao;
    private final HospitalService hospitalService;

    @Override
    public Injury createInjury(InjuryDto injuryDto) {
        Hospital hospital = hospitalService.getHospitalById(injuryDto.getHospitalId()); // will throw exception if entity doesn't exist
        return injuryDao.save(new Injury(
                injuryDto.getDescription(),
                injuryDto.getDiagnosis(),
                hospital
        ));
    }

    @Override
    public List<Injury> getAllInjuries() {
        return injuryDao.findAll();
    }

    @Override
    public Injury getInjuryById(Integer id) {
        return injuryDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }

    @Override
    public Injury updateInjury(InjuryDto injuryDto) {
        getInjuryById(injuryDto.getId()); // will throw exception if entity doesn't exist
        Hospital hospital = hospitalService.getHospitalById(injuryDto.getHospitalId()); // will throw exception if entity doesn't exist
        return injuryDao.save(new Injury(
                injuryDto.getId(),
                injuryDto.getDescription(),
                injuryDto.getDiagnosis(),
                hospital
        ));
    }
}
