package ua.lviv.iot.service;

import ua.lviv.iot.model.Injury;

import java.util.List;

public interface InjuryService {

    List<Injury> getAllInjuries();

    Injury getInjuryById(Integer id);
}
