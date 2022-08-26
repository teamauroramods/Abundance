package com.teamaurora.abundance.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.levelgen.feature.JacarandaFeature;
import com.teamaurora.abundance.common.levelgen.feature.LavenderFeature;
import com.teamaurora.abundance.common.levelgen.feature.NemophilaFeature;
import com.teamaurora.abundance.common.levelgen.feature.RedbudFeature;
import com.teamaurora.abundance.core.Abundance;
import dev.architectury.injectables.annotations.ExpectPlatform;
import gg.moonflower.pollen.api.platform.Platform;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.Supplier;

public class AbundanceFeatures {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final PollinatedRegistry<Feature<?>> FEATURES = PollinatedRegistry.create(Registry.FEATURE, Abundance.MOD_ID);
    public static final PollinatedRegistry<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = PollinatedRegistry.create(Registry.TREE_DECORATOR_TYPES, Abundance.MOD_ID);

    public static final Supplier<Feature<TreeConfiguration>> JACARANDA_TREE = FEATURES.register("jacaranda_tree", () -> new JacarandaFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> REDBUD_TREE = FEATURES.register("redbud_tree", () -> new RedbudFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> NEMOPHILA = FEATURES.register("nemophila", () -> new NemophilaFeature(NoneFeatureConfiguration.CODEC));
    public static final Supplier<Feature<NoneFeatureConfiguration>> LAVENDER = FEATURES.register("lavender", () -> new LavenderFeature(NoneFeatureConfiguration.CODEC));

    public static void load(Platform platform) {
        LOGGER.debug("Registered to platform");
        FEATURES.register(platform);
    }

    public static class BlockStates {
        public static final BlockState JACARANDA_LOG = AbundanceBlocks.JACARANDA_LOG.get().defaultBlockState();
        public static final BlockState JACARANDA_LEAVES = AbundanceBlocks.JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BLUE_JACARANDA_LEAVES = AbundanceBlocks.BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_BLUE_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_BLUE_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState THUNBERGIA_JUNGLE_LEAVES = AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES.get().defaultBlockState();
        public static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.defaultBlockState();
        public static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.defaultBlockState();
        public static final BlockState REDBUD_LOG = AbundanceBlocks.REDBUD_LOG.get().defaultBlockState();
        public static final BlockState FLOWERING_REDBUD_LOG = AbundanceBlocks.FLOWERING_REDBUD_LOG.get().defaultBlockState();
        public static final BlockState REDBUD_LEAVES = AbundanceBlocks.REDBUD_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_REDBUD_LEAVES = AbundanceBlocks.BUDDING_REDBUD_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_REDBUD_LEAVES = AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get().defaultBlockState();
        public static final BlockState BLUE_DAISY = AbundanceBlocks.BLUE_DAISY.get().defaultBlockState();
        public static final BlockState MYOSOTIS = AbundanceBlocks.MYOSOTIS.get().defaultBlockState();
    }

    public static class Configs {
        public static final TreeConfiguration.TreeConfigurationBuilder JACARANDA = (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BlockStates.JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_JACARANDA_LEAVES, 1)),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();

        public static final TreeConfiguration.TreeConfigurationBuilder FLOWERING_JACARANDA = (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_JACARANDA_LEAVES, 2)),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();

        public static final TreeConfiguration.TreeConfigurationBuilder BLUE_JACARANDA = (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1)),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();

        public static final TreeConfiguration.TreeConfigurationBuilder FLOWERING_BLUE_JACARANDA = (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2)),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();

        public static final TreeConfiguration.TreeConfigurationBuilder REDBUD = (new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(BlockStates.REDBUD_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.REDBUD_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_REDBUD_LEAVES, 1)),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();

        public static final TreeConfiguration.TreeConfigurationBuilder FLOWERING_REDBUD = (new TreeConfiguration.TreeConfigurationBuilder(
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(BlockStates.REDBUD_LOG, 1).add(BlockStates.FLOWERING_REDBUD_LOG, 1)),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_REDBUD_LEAVES, 4).add(AbundanceFeatures.BlockStates.FLOWERING_REDBUD_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines();
    }

    public static class Configured {

        private static final Logger LOGGER = LogManager.getLogger();
        public static final PollinatedRegistry<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = PollinatedRegistry.create(BuiltinRegistries.CONFIGURED_FEATURE, Abundance.MOD_ID);
        public static final PollinatedRegistry<PlacedFeature> PLACEMENTS = PollinatedRegistry.create(BuiltinRegistries.PLACED_FEATURE, Abundance.MOD_ID);

        private static final BeehiveDecorator BEES_05 = new BeehiveDecorator(1.0F);
        private static final BeehiveDecorator BEES_02 = new BeehiveDecorator(0.02F);

        // Trees
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA = CONFIGURED_FEATURES.register("jacaranda", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.JACARANDA.build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA = CONFIGURED_FEATURES.register("flowering_jacaranda", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA.build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_005 = CONFIGURED_FEATURES.register("jacaranda_bees_005", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.JACARANDA.decorators(ImmutableList.of(BEES_05)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_005 = CONFIGURED_FEATURES.register("flowering_jacaranda_bees_005", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA.decorators(ImmutableList.of(BEES_05)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_002 = CONFIGURED_FEATURES.register("jacaranda_bees_002", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.JACARANDA.decorators(ImmutableList.of(BEES_02)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_002 = CONFIGURED_FEATURES.register("flowering_jacaranda_bees_002", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.FLOWERING_JACARANDA.decorators(ImmutableList.of(BEES_02)).build()));

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA = CONFIGURED_FEATURES.register("bluejacaranda", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.BLUE_JACARANDA.build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA = CONFIGURED_FEATURES.register("flowering_blue_jacaranda", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.FLOWERING_BLUE_JACARANDA.build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_005 = CONFIGURED_FEATURES.register("blue_jacaranda_bees_005", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.BLUE_JACARANDA.decorators(ImmutableList.of(BEES_05)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_005 = CONFIGURED_FEATURES.register("flowering_blue_jacaranda_bees_005", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.FLOWERING_BLUE_JACARANDA.decorators(ImmutableList.of(BEES_05)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_002 = CONFIGURED_FEATURES.register("blue_jacaranda_bees_002", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.BLUE_JACARANDA.decorators(ImmutableList.of(BEES_02)).build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_002 = CONFIGURED_FEATURES.register("flowering_blue_jacaranda_bees_002", () -> new ConfiguredFeature<>(JACARANDA_TREE.get(), Configs.BLUE_JACARANDA.decorators(ImmutableList.of(BEES_02)).build()));

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> REDBUD = CONFIGURED_FEATURES.register("redbud", () -> new ConfiguredFeature<>(REDBUD_TREE.get(), Configs.REDBUD.build()));
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_REDBUD = CONFIGURED_FEATURES.register("flowering_redbud", () -> new ConfiguredFeature<>(REDBUD_TREE.get(), Configs.FLOWERING_REDBUD.build()));

        // Flowers
        public static final Supplier<ConfiguredFeature<NoneFeatureConfiguration, ?>> NEMOPHILA_BASE = CONFIGURED_FEATURES.register("nemophila", () -> new ConfiguredFeature<>(NEMOPHILA.get(), FeatureConfiguration.NONE));
        public static final Supplier<ConfiguredFeature<NoneFeatureConfiguration, ?>> LAVENDER_BASE = CONFIGURED_FEATURES.register("lavender", () -> new ConfiguredFeature<>(LAVENDER.get(), FeatureConfiguration.NONE));
        public static final Supplier<ConfiguredFeature<RandomPatchConfiguration, ?>> MEADOW_EXTRA_FLOWERS = CONFIGURED_FEATURES.register("meadow_extra_flowers", () -> new ConfiguredFeature<>(Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(BlockStates.BLUE_DAISY, 1).add(BlockStates.MYOSOTIS, 1)))))));

        // Placements
        public static final Supplier<PlacedFeature> BLUE_JACARANDA_BEES_02_PLACED = PLACEMENTS.register("blue_jacaranda_bees_002", () -> new PlacedFeature(Holder.direct(BLUE_JACARANDA_BEES_002.get()), List.of(PlacementUtils.filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get()))));
        public static final Supplier<PlacedFeature> FLOWERING_BLUE_JACARANDA_BEES_02_PLACED = PLACEMENTS.register("flowering_blue_jacaranda_bees_002", () -> new PlacedFeature(Holder.direct(FLOWERING_BLUE_JACARANDA_BEES_002.get()), List.of(PlacementUtils.filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get()))));
        public static final Supplier<PlacedFeature> JACARANDA_BEES_02_PLACED = PLACEMENTS.register("jacaranda_bees_002", () -> new PlacedFeature(Holder.direct(JACARANDA_BEES_002.get()), List.of(PlacementUtils.filteredByBlockSurvival(AbundanceBlocks.JACARANDA_SAPLING.get()))));
        public static final Supplier<PlacedFeature> FLOWERING_JACARANDA_BEES_02_PLACED = PLACEMENTS.register("flowering_jacaranda_bees_002", () -> new PlacedFeature(Holder.direct(FLOWERING_JACARANDA_BEES_002.get()), List.of(PlacementUtils.filteredByBlockSurvival(AbundanceBlocks.JACARANDA_SAPLING.get()))));
        public static final Supplier<PlacedFeature> MEADOW_EXTRA_FLOWERS_PLACED = PLACEMENTS.register("meadow_extra_flowers", () -> new PlacedFeature(Holder.direct(MEADOW_EXTRA_FLOWERS.get()), List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
        public static final ResourceKey<PlacedFeature> EXTRA_MEADOW_FLOWERS_KEY = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Abundance.location("meadow_extra_flowers"));

        // Natural Generation

        public static final Supplier<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_JACARANDA_MEADOW = CONFIGURED_FEATURES.register("trees_jacaranda_meadow", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(getHolder(BLUE_JACARANDA_BEES_02_PLACED, "blue_jacaranda_bees_002"), 0.5f)), getHolder(FLOWERING_BLUE_JACARANDA_BEES_02_PLACED, "flowering_blue_jacaranda_bees_002"))));
        public static final Supplier<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_JACARANDA_SPARSE = CONFIGURED_FEATURES.register("trees_jacaranda_sparse", () -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(getHolder(JACARANDA_BEES_02_PLACED, "jacaranda_bees_002"), 0.5f)), getHolder(FLOWERING_JACARANDA_BEES_02_PLACED, "flowering_jacaranda_bees_002"))));
        public static final Supplier<PlacedFeature> TREES_JACARANDA_MEADOW_PLACED = PLACEMENTS.register("trees_jacaranda_meadow", () -> new PlacedFeature(Holder.direct(TREES_JACARANDA_MEADOW.get()), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(6))));
        public static final Supplier<PlacedFeature> TREES_JACARANDA_SPARSE_PLACED = PLACEMENTS.register("trees_jacaranda_sparse", () -> new PlacedFeature(Holder.direct(TREES_JACARANDA_SPARSE.get()), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(4))));

        public static final ResourceKey<PlacedFeature> TREES_MEADOW_KEY = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Abundance.location("trees_jacaranda_meadow"));

        public static final Supplier<PlacedFeature> LAVENDER_DENSE = PLACEMENTS.register("lavender", () -> new PlacedFeature(Holder.direct(LAVENDER_BASE.get()), List.of(PlacementUtils.countExtra(3, 0.1F, 1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
        public static final Supplier<PlacedFeature> NEMOPHILA_DENSE = PLACEMENTS.register("nemophila_dense", () -> new PlacedFeature(Holder.direct(NEMOPHILA_BASE.get()), List.of(PlacementUtils.countExtra(24, 0.2F, 2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
        public static final ResourceKey<PlacedFeature> NEMOPHILA_DENSE_KEY = ResourceKey.create(Registry.PLACED_FEATURE_REGISTRY, Abundance.location("nemophila_dense"));

        @ExpectPlatform
        public static Holder<PlacedFeature> getHolder(Supplier<PlacedFeature> feature, String name) {
            return Platform.error();
        }

        public static void load(Platform platform) {
            LOGGER.debug("Registered to platform");
            CONFIGURED_FEATURES.register(platform);
            PLACEMENTS.register(platform);
        }
    }
}
