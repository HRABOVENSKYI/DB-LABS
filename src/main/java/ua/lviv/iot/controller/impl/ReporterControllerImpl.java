package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.ReporterController;
import ua.lviv.iot.model.Reporter;
import ua.lviv.iot.service.impl.ReporterServiceImpl;

public class ReporterControllerImpl extends AbstractControllerImpl<Reporter, String> implements ReporterController {
    public ReporterControllerImpl() {
        super(new ReporterServiceImpl());
    }
}
