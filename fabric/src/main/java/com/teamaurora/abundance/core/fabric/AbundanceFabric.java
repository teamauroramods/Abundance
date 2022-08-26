package com.teamaurora.abundance.core.fabric;

import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class AbundanceFabric implements ModInitializer, TerraBlenderApi {
    @Override
    public void onInitialize() {
        Abundance.PLATFORM.setup();
        BiomeModifications.create(Abundance.location("modifications")).add(ModificationPhase.REPLACEMENTS, BiomeSelectors.includeByKey(Biomes.MEADOW), modifier -> {
            BiomeModificationContext.GenerationSettingsContext gen = modifier.getGenerationSettings();
            gen.removeFeature(VegetationPlacements.FLOWER_MEADOW.unwrapKey().orElseThrow());
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.TREES_MEADOW_KEY);
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.NEMOPHILA_DENSE_KEY);
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AbundanceFeatures.Configured.EXTRA_MEADOW_FLOWERS_KEY);
        });
    }

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new AbundanceRegion(Abundance.location("overworld"), 3));
    }
}
