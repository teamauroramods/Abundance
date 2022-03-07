package com.teamaurora.abundance.core.fabric;

import com.teamaurora.abundance.core.Abundance;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AbundanceFabricDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        Abundance.PLATFORM.dataSetup(dataGenerator);
    }
}
