package com.teamaurora.abundance.core;

import com.teamaurora.abundance.client.render.entity.living.ScreecherRenderer;
import com.teamaurora.abundance.core.other.AbundanceData;
import com.teamaurora.abundance.core.registry.*;
import gg.moonflower.pollen.api.config.ConfigManager;
import gg.moonflower.pollen.api.config.PollinatedConfigType;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.EntityRendererRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class Abundance {
    public static final String MOD_ID = "abundance";
    public static final AbundanceCommonConfig CONFIG = ConfigManager.register(MOD_ID, PollinatedConfigType.COMMON, AbundanceCommonConfig::new);
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(() -> Abundance::onClientInit)
            .clientPostInit(() -> Abundance::onClientPostInit)
            .commonInit(Abundance::onCommonInit)
            .commonPostInit(Abundance::onCommonPostInit)
            .build();

    public static void onClientInit() {
        ColorRegistry.register((state, level, pos, tintIndex) -> {return level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor();}, AbundanceBlocks.THUNBERGIA_VINE, AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> {return FoliageColor.getDefaultColor();}, AbundanceBlocks.THUNBERGIA_VINE, AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES);
        ColorRegistry.register((state, level, pos, tintIndex) -> {return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D);}, AbundanceBlocks.TROPICAL_GRASS, AbundanceBlocks.TROPICAL_FERN);
        ColorRegistry.register((stack, tintIndex) -> {return GrassColor.get(0.5D, 1.0D);}, AbundanceBlocks.TROPICAL_GRASS, AbundanceBlocks.TROPICAL_FERN);
        EntityRendererRegistry.register(AbundanceEntities.SCREECHER, ScreecherRenderer::new);
    }

    @Environment(EnvType.CLIENT)
    public static void onClientPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {
            RenderTypeRegistry.register(AbundanceBlocks.LAVENDER.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.SUNNY_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.SHADY_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.TALL_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_SUNNY_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_SHADY_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.JACARANDA_DOOR.get(), RenderType.cutoutMipped());
            RenderTypeRegistry.register(AbundanceBlocks.JACARANDA_TRAPDOOR.get(), RenderType.cutoutMipped());
            RenderTypeRegistry.register(AbundanceBlocks.REDBUD_DOOR.get(), RenderType.cutoutMipped());
            RenderTypeRegistry.register(AbundanceBlocks.REDBUD_TRAPDOOR.get(), RenderType.cutoutMipped());
            RenderTypeRegistry.register(AbundanceBlocks.JACARANDA_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_JACARANDA_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_BLUE_JACARANDA_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.THUNBERGIA_VINE.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.REDBUD_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_REDBUD_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_FLOWERING_REDBUD_SAPLING.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.PINK_BLOSSOM_CARPET.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.PINK_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.PURPLE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.MAGENTA_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.YELLOW_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.ORANGE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.RED_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.BLUE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_PINK_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_PURPLE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_MAGENTA_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_YELLOW_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_ORANGE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_RED_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_BLUE_DAISY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.NEMOPHILA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CHICORY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CHICORY_COLONY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.AMARANTHUS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.MYOSOTIS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.FIDDLENECK.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.HELICONIA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_NEMOPHILA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_CHICORY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_AMARANTHUS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_MYOSOTIS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_FIDDLENECK.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.TROPICAL_GRASS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.TROPICAL_FERN.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.BEGONIA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_BEGONIA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CARNATION.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_CARNATION.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CHRYSANTHEMUM.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_CHRYSANTHEMUM.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.DIANTHUS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_DIANTHUS.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.HEATHER.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_HEATHER.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.SMALL_MARIGOLD.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.POTTED_SMALL_MARIGOLD.get(), RenderType.cutout());
        });
    }

    public static void onCommonInit() {
        AbundanceBlocks.BLOCKS.register(PLATFORM);
        AbundanceItems.ITEMS.register(PLATFORM);
        AbundanceSoundEvents.SOUND_EVENTS.register(PLATFORM);
        AbundanceEffects.MOB_EFFECTS.register(PLATFORM);
        AbundanceEffects.POTIONS.register(PLATFORM);
        AbundanceEntities.ENTITIES.register(PLATFORM);
        AbundanceFeatures.load(PLATFORM);
        AbundanceFeatures.Configured.load(PLATFORM);
        AbundanceBiomes.load(PLATFORM);
        AbundanceEntities.registerEntityAttributes();
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {
            AbundanceData.init();

            // TODO: Convert to pollen brewing recipes
            AbundanceEffects.registerBrewingRecipes();
        });
    }

    public static ResourceLocation location(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
