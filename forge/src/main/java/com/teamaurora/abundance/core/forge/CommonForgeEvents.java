package com.teamaurora.abundance.core.forge;

import com.teamaurora.abundance.core.Abundance;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Abundance.MOD_ID)
public class CommonForgeEvents {

    @SubscribeEvent
    public static void onEvent(BiomeLoadingEvent event) {
        if (matchesKeys(event.getName(), Biomes.MEADOW)) {
            BiomeGenerationSettingsBuilder gen = event.getGeneration();
            gen.getFeatures(GenerationStep.Decoration.VEGETAL_DECORATION).removeIf(holder -> holder.is(VegetationPlacements.FLOWER_MEADOW.unwrapKey().orElseThrow()));
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(AbundanceFeatures.Configured.TREES_JACARANDA_MEADOW_PLACED.get()));
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(AbundanceFeatures.Configured.NEMOPHILA_DENSE.get()));
            gen.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, Holder.direct(AbundanceFeatures.Configured.MEADOW_EXTRA_FLOWERS_PLACED.get()));
        }
    }

    public static boolean matchesKeys(ResourceLocation location, ResourceKey<?>... keys) {
        for (ResourceKey<?> key : keys)
            if (key.location().equals(location))
                return true;
        return false;
    }
}
