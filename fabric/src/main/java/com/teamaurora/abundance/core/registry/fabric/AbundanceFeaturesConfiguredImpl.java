package com.teamaurora.abundance.core.registry.fabric;

import com.teamaurora.abundance.core.Abundance;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Supplier;

public class AbundanceFeaturesConfiguredImpl {

    public static Holder<PlacedFeature> getHolder(Supplier<PlacedFeature> feature, String name) {
        final ResourceKey<PlacedFeature> key = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Abundance.location(name));
        return BuiltinRegistries.PLACED_FEATURE.getOrCreateHolder(key);
    }
}
