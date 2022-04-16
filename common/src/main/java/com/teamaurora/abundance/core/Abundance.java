package com.teamaurora.abundance.core;

import com.teamaurora.abundance.client.render.entity.living.ScreecherRenderer;
import com.teamaurora.abundance.common.other.SunflowerSeedManager;
import com.teamaurora.abundance.core.registry.*;
import gg.moonflower.pollen.api.event.events.LootTableConstructingEvent;
import gg.moonflower.pollen.api.event.events.entity.player.PlayerInteractionEvents;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.StrippingRegistry;
import gg.moonflower.pollen.api.registry.client.ColorRegistry;
import gg.moonflower.pollen.api.registry.client.EntityRendererRegistry;
import gg.moonflower.pollen.api.registry.client.RenderTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

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
        ColorRegistry.register((state, level, pos, tintIndex) -> {return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.get(0.5D, 1.0D);}, AbundanceBlocks.TROPICAL_GRASS, AbundanceBlocks.TROPICAL_FERN);
        ColorRegistry.register((stack, tintIndex) -> {return GrassColor.get(0.5D, 1.0D);}, AbundanceBlocks.TROPICAL_GRASS, AbundanceBlocks.TROPICAL_FERN);
        EntityRendererRegistry.register(AbundanceEntities.SCREECHER, ScreecherRenderer::new);
    }

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
        AbundanceBlocks.BLOCKS.register(Abundance.PLATFORM);
        AbundanceItems.ITEMS.register(Abundance.PLATFORM);
        AbundanceFeatures.FEATURES.register(Abundance.PLATFORM);
        AbundanceFeatures.CONFIGURED_FEATURES.register(Abundance.PLATFORM);
        AbundanceFeatures.TREE_DECORATOR_TYPES.register(Abundance.PLATFORM);
        AbundanceSoundEvents.SOUND_EVENTS.register(Abundance.PLATFORM);
        AbundanceEffects.MOB_EFFECTS.register(Abundance.PLATFORM);
        AbundanceEffects.POTIONS.register(Abundance.PLATFORM);
        AbundanceEntities.ENTITY_TYPES.register(Abundance.PLATFORM);
        AbundanceEntities.registerEntityAttributes();
    }

    public static void onCommonPostInit(Platform.ModSetupContext ctx) {
        ctx.enqueueWork(() -> {

            /* Strippables */
            StrippingRegistry.register(AbundanceBlocks.JACARANDA_LOG.get(), AbundanceBlocks.STRIPPED_JACARANDA_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.JACARANDA_WOOD.get(), AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get());
            StrippingRegistry.register(AbundanceBlocks.REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), AbundanceBlocks.STRIPPED_REDBUD_LOG.get());
            StrippingRegistry.register(AbundanceBlocks.REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());
            StrippingRegistry.register(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), AbundanceBlocks.STRIPPED_REDBUD_WOOD.get());

            /* Compostables */
            ComposterBlock.add(0.65f, AbundanceItems.LAVENDER.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.PINK_BLOSSOM_CARPET.get());

            ComposterBlock.add(0.3f, AbundanceBlocks.JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.JACARANDA_SAPLING.get());

            ComposterBlock.add(0.3f, AbundanceBlocks.BLUE_JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());

            ComposterBlock.add(0.3f, AbundanceBlocks.REDBUD_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.BUDDING_REDBUD_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.REDBUD_SAPLING.get());
            ComposterBlock.add(0.3f, AbundanceBlocks.FLOWERING_REDBUD_SAPLING.get());

            ComposterBlock.add(0.65f, AbundanceItems.PINK_BLOSSOMS.get());

            ComposterBlock.add(0.65f, AbundanceBlocks.SMALL_MARIGOLD.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.SUNNY_MARIGOLD.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.SHADY_MARIGOLD.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.TALL_MARIGOLD.get());

            ComposterBlock.add(0.65f, AbundanceBlocks.AMARANTHUS.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.CHICORY.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.CHICORY_COLONY.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.NEMOPHILA.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.MYOSOTIS.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.FIDDLENECK.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.HELICONIA.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.BEGONIA.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.CARNATION.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.CHRYSANTHEMUM.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.DIANTHUS.get());
            ComposterBlock.add(0.65f, AbundanceBlocks.HEATHER.get());

            ComposterBlock.add(0.3f, AbundanceItems.SUNFLOWER_SEEDS.get());

            /* Flammables */
            FireBlock fireBlock = (FireBlock) Blocks.FIRE;

            fireBlock.setFlammable(AbundanceBlocks.PINK_BLOSSOM_CARPET.get(), 30, 60);

            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.BLUE_JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_LOG.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_WOOD.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.STRIPPED_JACARANDA_LOG.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.STRIPPED_JACARANDA_WOOD.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_PLANKS.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_SLAB.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_FENCE.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.JACARANDA_FENCE_GATE.get(), 5, 20);

            fireBlock.setFlammable(AbundanceBlocks.REDBUD_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.BUDDING_REDBUD_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get(), 30, 60);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_LOG.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.FLOWERING_REDBUD_LOG.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.FLOWERING_REDBUD_WOOD.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_WOOD.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.STRIPPED_REDBUD_LOG.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.STRIPPED_REDBUD_WOOD.get(), 5, 5);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_PLANKS.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_SLAB.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_STAIRS.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_FENCE.get(), 5, 20);
            fireBlock.setFlammable(AbundanceBlocks.REDBUD_FENCE_GATE.get(), 5, 20);

            /* Misc Registry */
            AbundanceFeatures.Configured.registerConfiguredFeatures();
            AbundanceEffects.registerBrewingRecipes();
        });
    }

    public static void onDataInit(Platform.DataSetupContext ctx) {
    }

    public static ResourceLocation generateResourceLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
