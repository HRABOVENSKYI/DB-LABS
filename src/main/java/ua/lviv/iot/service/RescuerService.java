package ua.lviv.iot.service;

import ua.lviv.iot.model.Rescuer;

import java.util.List;

public interface RescuerService {

    List<Rescuer> getAllRescuers();

    Rescuer getRescuerById(Integer id);
}
