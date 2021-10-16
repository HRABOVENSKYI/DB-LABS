package ua.lviv.iot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dao.ReporterDao;
import ua.lviv.iot.exception.NoDataFoundException;
import ua.lviv.iot.model.Reporter;
import ua.lviv.iot.service.ReporterService;

import java.util.List;

@Service
@AllArgsConstructor
public class ReporterServiceImpl implements ReporterService {

    private final ReporterDao reporterDao;

    @Override
    public List<Reporter> getAllReporters() {
        return reporterDao.findAll();
    }

    @Override
    public Reporter getReporterById(String phoneNumber) {
        return reporterDao.findById(phoneNumber)
                .orElseThrow(() -> new NoDataFoundException("Entity with id: " + phoneNumber + " not found"));
    }
}
