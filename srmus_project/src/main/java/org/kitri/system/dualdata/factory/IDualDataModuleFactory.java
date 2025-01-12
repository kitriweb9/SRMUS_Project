package org.kitri.system.dualdata.factory;

import org.kitri.system.dualdata.core.IDualDataModule;

public interface IDualDataModuleFactory {
    IDualDataModule createModule(Object dto);
}
