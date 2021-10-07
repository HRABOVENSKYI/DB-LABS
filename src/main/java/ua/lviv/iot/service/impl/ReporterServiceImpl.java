package ua.lviv.iot.service.impl;

import ua.lviv.iot.dao.impl.ReporterDaoImpl;
import ua.lviv.iot.model.Reporter;
import ua.lviv.iot.service.AbstractService;

public class ReporterServiceImpl extends AbstractServiceImpl<Reporter, String> {
    public ReporterServiceImpl() {
        super(new ReporterDaoImpl());
    }
}
