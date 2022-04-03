package com.teamaurora.abundance.core;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import com.teamaurora.abundance.core.registry.AbundanceMobEffects;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import gg.moonflower.pollen.api.datagen.provider.model.PollinatedModelProvider;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.FoliageColor;

public class Abundance {
    public static final String MOD_ID = "abundance";
    public static final Platform PLATFORM = Platform.builder(MOD_ID)
            .clientInit(Abundance::onClientInit)
            .clientPostInit(Abundance::onClientPostInit)
            .commonInit(Abundance::onCommonInit)
            .commonPostInit(Abundance::onCommonPostInit)
            .dataInit(Abundance::onDataInit)
            .build();

    public static void onClientInit() {
        ColorRegistry.register((state, level, pos, tintIndex) -> {return level != null && pos != null ? BiomeColors.getAverageFoliageColor(level, pos) : FoliageColor.getDefaultColor();}, AbundanceBlocks.THUNBERGIA_VINE, AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES);
        ColorRegistry.register((stack, tintIndex) -> {return FoliageColor.getDefaultColor();}, AbundanceBlocks.THUNBERGIA_VINE, AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES);
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {
            RenderTypeRegistry.register(AbundanceBlocks.LAVENDER.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.TALL_LAVENDER.get(), RenderType.cutout());

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

            RenderTypeRegistry.register(AbundanceBlocks.NEMOPHILA.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CHICORY.get(), RenderType.cutout());
            RenderTypeRegistry.register(AbundanceBlocks.CHICORY_COLONY.get(), RenderType.cutout());
        });
    }

    public static void onCommonInit() {
        AbundanceBlocks.BLOCKS.register(Abundance.PLATFORM);
        AbundanceItems.ITEMS.register(Abundance.PLATFORM);
        AbundanceMobEffects.MOB_EFFECTS.register(Abundance.PLATFORM);
        AbundanceFeatures.FEATURES.register(Abundance.PLATFORM);
        AbundanceFeatures.CONFIGURED_FEATURES.register(Abundance.PLATFORM);
        AbundanceFeatures.TREE_DECORATOR_TYPES.register(Abundance.PLATFORM);
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {
            StrippingRegistry.register(AbundanceBlocks.JACARANDA_LOG.get(), AbundanceBlocks.STRIPPED_JACARANDA_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.JACARANDA_WOOD.get(), AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get());

            StrippingRegistry.register(AbundanceBlocks.REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
            StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());

            AbundanceFeatures.Configured.registerConfiguredFeatures();
        });
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }
}
