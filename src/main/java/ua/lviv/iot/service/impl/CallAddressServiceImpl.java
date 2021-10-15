package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.CallAddressDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.CallAddress;
import ua.lviv.iot.service.CallAddressService;

import java.util.List;

@Service
@AllArgsConstructor
public class CallAddressServiceImpl implements CallAddressService {

    private final CallAddressDao callAddressDao;

    @Override
    public CallAddress createCallAddress(CallAddress callAddress) {
        return callAddressDao.save(callAddress);
    }

    @Override
    public List<CallAddress> getAllCallAddresses() {
        return callAddressDao.findAll();
    }

    @Override
    public CallAddress getCallAddressById(Integer id) {
        return callAddressDao.findById(id)
                .orElseThrow(() -> new NoDataFoundException("Call address with id: " + id + " not found"));
    }

    @Override
    public CallAddress updateCallAddress(CallAddress callAddress) {
        CallAddress oldCallAddress = getCallAddressById(callAddress.getId());
        callAddressDao.save(callAddress);
        return oldCallAddress;
    }

    @Override
    public CallAddress deleteCallAddressById(Integer id) {
        CallAddress oldCallAddress = getCallAddressById(id);
        callAddressDao.deleteById(id);
        return oldCallAddress;
    }
}
