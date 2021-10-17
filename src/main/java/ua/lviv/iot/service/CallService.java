package ua.lviv.iot.service;

import ua.lviv.iot.dto.call.CreateUpdateCallDto;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.model.CallAddress;

import java.util.List;

public interface CallService {

    Call createCall(CreateUpdateCallDto createUpdateCallDto);

    List<Call> getAllCalls();

    Call getCallById(Integer id);

    Call updateCall(CreateUpdateCallDto createUpdateCallDto);
}
