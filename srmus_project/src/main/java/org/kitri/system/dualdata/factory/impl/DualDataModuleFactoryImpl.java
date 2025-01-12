package org.kitri.system.dualdata.factory.impl;

import org.kitri.system.dualdata.core.IDualDataModule;
import org.kitri.system.dualdata.core.Impl.DualDataModuleImpl;
import org.kitri.system.dualdata.factory.IDualDataModuleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DualDataModuleFactoryImpl implements IDualDataModuleFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public DualDataModuleFactoryImpl(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public IDualDataModule createModule(Object dto) {
        IDualDataModule module = applicationContext.getBean(DualDataModuleImpl.class);
        module.initialize(dto);
        return module;
    }
}
