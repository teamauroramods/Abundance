package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.other.AbundanceGeneration;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

public class AbundanceBiomes {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final PollinatedRegistry<Biome> BIOMES = PollinatedRegistry.create(BuiltinRegistries.BIOME, Abundance.MOD_ID);

    public static final ResourceKey<Biome> LAVENDER_FIELDS = createBiome("lavender_fields", AbundanceGeneration::lavenderFields);

    public static ResourceKey<Biome> createBiome(String name, Supplier<Biome> biomeSupplier) {
        ResourceLocation id = Abundance.location(name);
        BIOMES.register(name, biomeSupplier);
        return ResourceKey.create(Registry.BIOME_REGISTRY, id);
    }

    public static void load(Platform platform) {
        LOGGER.debug("Registered to platform");
        BIOMES.register(platform);
    }
}
