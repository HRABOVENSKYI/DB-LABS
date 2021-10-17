package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.CallHasRescuerDao;
import ua.lviv.iot.dto.callhasrescuer.CallHasRescuerDto;
import ua.lviv.iot.exception.EntityAlreadyExistsException;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.model.CallHasRescuer;
import ua.lviv.iot.model.Rescuer;
import ua.lviv.iot.model.compositekey.CallRescuerId;
import ua.lviv.iot.service.CallHasRescuerService;
import ua.lviv.iot.service.CallService;
import ua.lviv.iot.service.InjuryService;
import ua.lviv.iot.service.RescuerService;

import java.util.List;

@Service
@AllArgsConstructor
public class CallHasRescuerServiceImpl implements CallHasRescuerService {

    private final CallHasRescuerDao callHasRescuerDao;
    private final CallService callService;
    private final RescuerService rescuerService;
    private final InjuryService injuryService;

    @Override
    public CallHasRescuer createCallHasRescuer(CallHasRescuerDto callHasRescuerDto) {
        Integer callId = callHasRescuerDto.getCallId();
        Integer rescuerId = callHasRescuerDto.getRescuerId();
        CallRescuerId id = new CallRescuerId(callId, rescuerId);
        if (callHasRescuerDao.findById(id).isPresent()) {
            throw new EntityAlreadyExistsException("Entity with id: " + id + " already exists");
        }
        if (callHasRescuerDto.getInjuryId() != null) {
            if (injuryService.getInjuryById(callHasRescuerDto.getInjuryId()) != null) {
                throw new EntityAlreadyExistsException("Injury with id: " + id + " already exists. Create new one");
            }
        }
        Call call = callService.getCallById(callId); // will throw exception if entity doesn't exist
        Rescuer rescuer = rescuerService.getRescuerById(rescuerId); // will throw exception if entity doesn't exist
        return callHasRescuerDao.save(new CallHasRescuer(
                id,
                call,
                rescuer,
                callHasRescuerDto.getInjuryId() != null ?
                        injuryService.getInjuryById(callHasRescuerDto.getInjuryId())
                        : null
        ));
    }

    @Override
    public List<CallHasRescuer> getAllCallHasRescuers() {
        return callHasRescuerDao.findAll();
    }
}
