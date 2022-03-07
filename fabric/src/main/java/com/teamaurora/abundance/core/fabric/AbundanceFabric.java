package com.teamaurora.abundance.core.fabric;

import com.teamaurora.abundance.core.Abundance;
import net.fabricmc.api.ModInitializer;

public class AbundanceFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Abundance.PLATFORM.setup();
    }
}
