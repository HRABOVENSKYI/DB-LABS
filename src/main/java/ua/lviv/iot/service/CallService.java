package ua.lviv.iot.service;

import ua.lviv.iot.model.Call;

import java.util.List;

public interface CallService {

    List<Call> getAllCalls();

    Call getCallById(Integer id);
}
