package com.teamaurora.abundance.core;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceMobEffects;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import net.minecraft.client.renderer.RenderType;

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
        RenderTypeRegistry.register(AbundanceBlocks.JACARANDA_DOOR.get(), RenderType.cutoutMipped());
        RenderTypeRegistry.register(AbundanceBlocks.JACARANDA_TRAPDOOR.get(), RenderType.cutoutMipped());

        RenderTypeRegistry.register(AbundanceBlocks.REDBUD_DOOR.get(), RenderType.cutoutMipped());
        RenderTypeRegistry.register(AbundanceBlocks.REDBUD_TRAPDOOR.get(), RenderType.cutoutMipped());
    }

    public static void onClientPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onCommonInit() {
        AbundanceBlocks.BLOCKS.register(Abundance.PLATFORM);
        AbundanceItems.ITEMS.register(Abundance.PLATFORM);
        AbundanceMobEffects.MOB_EFFECTS.register(Abundance.PLATFORM);

        StrippingRegistry.register(AbundanceBlocks.JACARANDA_LOG.get(), AbundanceBlocks.STRIPPED_JACARANDA_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.JACARANDA_WOOD.get(), AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get());

        StrippingRegistry.register(AbundanceBlocks.REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
        StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }
}
