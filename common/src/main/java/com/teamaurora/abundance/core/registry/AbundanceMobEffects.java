package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.alchemy.Potion;

public class AbundanceMobEffects {
    public static final PollinatedRegistry<Potion> POTIONS = PollinatedRegistry.create(Registry.POTION, Abundance.MOD_ID);
    public static final PollinatedRegistry<MobEffect> MOB_EFFECTS = PollinatedRegistry.create(Registry.MOB_EFFECT, Abundance.MOD_ID);
}
