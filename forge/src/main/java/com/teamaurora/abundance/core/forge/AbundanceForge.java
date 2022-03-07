package com.teamaurora.abundance.core.forge;

import com.teamaurora.abundance.core.Abundance;
import net.minecraftforge.fml.common.Mod;

@Mod(Abundance.MOD_ID)
public class AbundanceForge {
    public AbundanceForge() {
        Abundance.PLATFORM.setup();
    }
}
