package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.InjuryDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Injury;
import ua.lviv.iot.service.InjuryService;

import java.util.List;

@Service
@AllArgsConstructor
public class InjuryServiceImpl implements InjuryService {

    private final InjuryDao rescueVehicleDao;
    @Override
    public List<Injury> getAllInjuries() {
        return rescueVehicleDao.findAll();
    }

    @Override
    public Injury getInjuryById(Integer id) {
        return rescueVehicleDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }
}
