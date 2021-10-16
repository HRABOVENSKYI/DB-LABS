package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.CallDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.service.CallService;

@Service
@AllArgsConstructor
public class CallServiceImpl implements CallService {

    private final CallDao callDao;

    @Override
    public Call getCallById(Integer id) {
        return callDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Call address with id: " + id + " not found"));
    }
}
