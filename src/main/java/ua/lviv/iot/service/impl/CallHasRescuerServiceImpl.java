package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.CallHasRescuerDao;
import ua.lviv.iot.model.CallHasRescuer;
import ua.lviv.iot.service.CallHasRescuerService;

import java.util.List;

@Service
@AllArgsConstructor
public class CallHasRescuerServiceImpl implements CallHasRescuerService {

    private final CallHasRescuerDao callHasRescuerDao;

    @Override
    public List<CallHasRescuer> getAllCallHasRescuers() {
        return callHasRescuerDao.findAll();
    }
}
