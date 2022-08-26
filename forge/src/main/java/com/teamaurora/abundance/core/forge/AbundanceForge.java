package com.teamaurora.abundance.core.forge;

import com.teamaurora.abundance.core.Abundance;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(Abundance.MOD_ID)
public class AbundanceForge {
    public AbundanceForge() {
        Abundance.PLATFORM.setup();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> Regions.register(new AbundanceRegion(Abundance.location("overworld"), 3)));
    }
}
