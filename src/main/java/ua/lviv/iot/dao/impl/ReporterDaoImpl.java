package ua.lviv.iot.dao.impl;

import ua.lviv.iot.dao.ReporterDao;
import ua.lviv.iot.model.Reporter;

public class ReporterDaoImpl extends AbstractDaoImpl<Reporter, String> implements ReporterDao {
    public ReporterDaoImpl() {
        super(Reporter.class);
    }
}
