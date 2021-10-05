package ua.lviv.iot.controller.impl;

import ua.lviv.iot.controller.InjuryController;
import ua.lviv.iot.model.Injury;
import ua.lviv.iot.service.impl.InjuryServiceImpl;

public class InjuryControllerImpl extends AbstractControllerImpl<Injury, Integer> implements InjuryController {
    public InjuryControllerImpl() {
        super(new InjuryServiceImpl());
    }
}
