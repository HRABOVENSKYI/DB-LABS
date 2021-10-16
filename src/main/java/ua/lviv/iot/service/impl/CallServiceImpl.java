package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.CallDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Call;
import ua.lviv.iot.service.CallService;

import java.util.List;

@Service
@AllArgsConstructor
public class CallServiceImpl implements CallService {

    private final CallDao callDao;

    @Override
    public List<Call> getAllCalls() {
        return callDao.findAll();
    }

    @Override
    public Call getCallById(Integer id) {
        return callDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + id + " not found"));
    }
}
