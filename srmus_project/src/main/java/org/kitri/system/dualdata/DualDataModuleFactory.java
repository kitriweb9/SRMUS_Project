package org.kitri.system.dualdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DualDataModuleFactory implements IDualDataModuleFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public DualDataModuleFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public IDualDataModule createModule(Object dto) {
        IDualDataModule module = applicationContext.getBean(DualDataModuleImpl.class);
        module.initialize(dto);
        return module;
    }
}
