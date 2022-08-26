package com.teamaurora.abundance.core.other;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.content.CompostablesRegistry;
import gg.moonflower.pollen.api.registry.content.FlammabilityRegistry;

public class AbundanceData {

    public static void init() {
        registerStrippables();
        registerFlammables();
        registerCompostables();
    }

    public static void registerStrippables() {
        StrippingRegistry.register(AbundanceBlocks.JACARANDA_LOG.get(), AbundanceBlocks.STRIPPED_JACARANDA_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.JACARANDA_WOOD.get(), AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get());
        StrippingRegistry.register(AbundanceBlocks.REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
        StrippingRegistry.register(AbundanceBlocks.REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
        StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
    }

    public static void registerFlammables() {
        FlammabilityRegistry.register(AbundanceBlocks.PINK_BLOSSOM_CARPET.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.BLUE_JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_LOG.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_WOOD.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_PLANKS.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_SLAB.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_STAIRS.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_FENCE.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.JACARANDA_FENCE_GATE.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.BUDDING_REDBUD_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get(), 30, 60);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_LOG.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_WOOD.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.STRIPPED_REDBUD_LOG.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.STRIPPED_REDBUD_WOOD.get(), 5, 5);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_PLANKS.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_SLAB.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_STAIRS.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_FENCE.get(), 5, 20);
        FlammabilityRegistry.register(AbundanceBlocks.REDBUD_FENCE_GATE.get(), 5, 20);
    }

    public static void registerCompostables() {
        CompostablesRegistry.register(AbundanceBlocks.LAVENDER.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.PINK_BLOSSOM_CARPET.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.JACARANDA_SAPLING.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.BLUE_JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.REDBUD_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.BUDDING_REDBUD_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.REDBUD_SAPLING.get(), 0.3F);
        CompostablesRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get(), 0.3F);
        CompostablesRegistry.register(AbundanceItems.PINK_BLOSSOMS.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.SUNNY_MARIGOLD.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.SHADY_MARIGOLD.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.TALL_MARIGOLD.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.AMARANTHUS.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.CHICORY.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.NEMOPHILA.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.MYOSOTIS.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.FIDDLENECK.get(), 0.65F);
        CompostablesRegistry.register(AbundanceBlocks.HELICONIA.get(), 0.65F);
        CompostablesRegistry.register(AbundanceItems.SUNFLOWER_SEEDS.get(), 0.3F);
    }
}
