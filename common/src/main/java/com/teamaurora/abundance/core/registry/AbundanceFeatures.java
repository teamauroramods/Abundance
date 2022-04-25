package com.teamaurora.abundance.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.world.feature.JacarandaFeature;
import com.teamaurora.abundance.common.world.feature.RedbudFeature;
import com.teamaurora.abundance.common.world.treedecorator.LeaveThunbergiaVineDecorator;
import com.teamaurora.abundance.common.world.treedecorator.TrunkThunbergiaVineDecorator;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.PollinatedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.HeightmapPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.function.Supplier;

public class AbundanceFeatures {
    public static final PollinatedRegistry<Feature<?>> FEATURES = PollinatedRegistry.create(Registry.FEATURE, Abundance.MOD_ID);
    public static final PollinatedRegistry<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = PollinatedRegistry.create(Registry.TREE_DECORATOR_TYPES, Abundance.MOD_ID);
    public static final PollinatedRegistry<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = PollinatedRegistry.create(BuiltinRegistries.CONFIGURED_FEATURE, Abundance.MOD_ID);
    public static final PollinatedRegistry<PlacedFeature> PLACED_FEATURES = PollinatedRegistry.create(BuiltinRegistries.PLACED_FEATURE, Abundance.MOD_ID);

    public static final Supplier<Feature<TreeConfiguration>> JACARANDA_TREE = FEATURES.register("jacaranda_tree", () -> new JacarandaFeature(TreeConfiguration.CODEC));
    public static final Supplier<Feature<TreeConfiguration>> REDBUD_TREE = FEATURES.register("redbud_tree", () -> new RedbudFeature(TreeConfiguration.CODEC));

    public static final Supplier<TreeDecoratorType<?>> TRUNK_THUNBERGIA_VINE = TREE_DECORATOR_TYPES.register("trunk_thunbergia_vine", () -> new TreeDecoratorType<>(TrunkThunbergiaVineDecorator.CODEC));
    public static final Supplier<TreeDecoratorType<?>> LEAVE_THUNBERGIA_VINE = TREE_DECORATOR_TYPES.register("leave_thunbergia_vine", () -> new TreeDecoratorType<>(LeaveThunbergiaVineDecorator.CODEC));


    /* Beehives */
    public static final BeehiveDecorator ABUNDANCE_BEEHIVE_0002 = new BeehiveDecorator(0.002F);
    public static final BeehiveDecorator ABUNDANCE_BEEHIVE_005 = new BeehiveDecorator(0.05F);

    public static final class BlockStates {
        public static final BlockState JACARANDA_LOG = AbundanceBlocks.JACARANDA_LOG.get().defaultBlockState();
        public static final BlockState JACARANDA_LEAVES = AbundanceBlocks.JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BLUE_JACARANDA_LEAVES = AbundanceBlocks.BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_BLUE_JACARANDA_LEAVES = AbundanceBlocks.BUDDING_BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_BLUE_JACARANDA_LEAVES = AbundanceBlocks.FLOWERING_BLUE_JACARANDA_LEAVES.get().defaultBlockState();
        public static final BlockState TUNBERGIA_JUNGLE_LEAVES = AbundanceBlocks.THUNBERGIA_JUNGLE_LEAVES.get().defaultBlockState();
        public static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.defaultBlockState();
        public static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.defaultBlockState();
        public static final BlockState REDBUG_LOG = AbundanceBlocks.REDBUD_LOG.get().defaultBlockState();
        public static final BlockState FLOWERING_REDBUD_LOG = AbundanceBlocks.FLOWERING_REDBUD_LOG.get().defaultBlockState();
        public static final BlockState REDBUD_LEAVES = AbundanceBlocks.REDBUD_LEAVES.get().defaultBlockState();
        public static final BlockState BUDDING_REDBUD_LEAVES = AbundanceBlocks.BUDDING_REDBUD_LEAVES.get().defaultBlockState();
        public static final BlockState FLOWERING_REDBUD_LEAVES = AbundanceBlocks.FLOWERING_REDBUD_LEAVES.get().defaultBlockState();
    }

    public static final class Configs {
        public static final TreeConfiguration JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(AbundanceFeatures.BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration THUNBERGIA_JUNGLE_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.JUNGLE_LOG),
                new StraightTrunkPlacer(4, 8, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.TUNBERGIA_JUNGLE_LEAVES, 3).add(AbundanceFeatures.BlockStates.JUNGLE_LEAVES, 2).build()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        )).decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkThunbergiaVineDecorator.DECORATOR, LeaveThunbergiaVineDecorator.DECORATOR)).ignoreVines().build();
        public static final TreeConfiguration REDBUD_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(AbundanceFeatures.BlockStates.REDBUG_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.REDBUD_LEAVES, 3).add(AbundanceFeatures.BlockStates.BUDDING_REDBUD_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration FLOWERING_REDBUD_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.REDBUG_LOG, 1).add(AbundanceFeatures.BlockStates.FLOWERING_REDBUD_LOG, 1).build()),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder<BlockState>().add(AbundanceFeatures.BlockStates.BUDDING_REDBUD_LEAVES, 4).add(AbundanceFeatures.BlockStates.FLOWERING_REDBUD_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
    }

    public static final class Configured {
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.JACARANDA_TREE_BEES_0002_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_JACARANDA_TREE_BEES_0002_CONFIG);

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.BLUE_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_BLUE_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.BLUE_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_BLUE_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.BLUE_JACARANDA_TREE_BEES_0002_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_BLUE_JACARANDA_TREE_BEES_0002_CONFIG);

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> THUNBERGIA_JUNGLE = () -> Feature.TREE.configured(AbundanceFeatures.Configs.THUNBERGIA_JUNGLE_TREE_CONFIG);

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> REDBUD = () -> AbundanceFeatures.REDBUD_TREE.get().configured(AbundanceFeatures.Configs.REDBUD_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_REDBUD = () -> AbundanceFeatures.REDBUD_TREE.get().configured(AbundanceFeatures.Configs.FLOWERING_REDBUD_TREE_CONFIG);

        public static final Supplier<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_JACARANDA_SPARSE = () -> Feature.RANDOM_SELECTOR.configured((new RandomFeatureConfiguration(ImmutableList.of(new WeightedPlacedFeature(Placed.BLUE_JACARANDA_BEES_0002.get(), 0.5f)), Placed.FLOWERING_BLUE_JACARANDA_BEES_0002.get())));


        public static void registerConfiguredFeatures() {
            CONFIGURED_FEATURES.register("jacaranda", Configured.JACARANDA);
            CONFIGURED_FEATURES.register("flowering_jacaranda", Configured.FLOWERING_JACARANDA);
            CONFIGURED_FEATURES.register("jacaranda_bees_005", Configured.JACARANDA_BEES_005);
            CONFIGURED_FEATURES.register("flowering_jacaranda_bees_005", Configured.FLOWERING_JACARANDA_BEES_005);
            CONFIGURED_FEATURES.register("jacaranda_bees_0002", Configured.JACARANDA_BEES_0002);
            CONFIGURED_FEATURES.register("flowering_jacaranda_bees_0002", Configured.FLOWERING_JACARANDA_BEES_0002);
            CONFIGURED_FEATURES.register("blue_jacaranda", Configured.BLUE_JACARANDA);
            CONFIGURED_FEATURES.register("flowering_blue_jacaranda", Configured.FLOWERING_BLUE_JACARANDA);
            CONFIGURED_FEATURES.register("blue_jacaranda_bees_005", Configured.BLUE_JACARANDA_BEES_005);
            CONFIGURED_FEATURES.register("flowering_blue_jacaranda_bees_005", Configured.FLOWERING_BLUE_JACARANDA_BEES_005);
            CONFIGURED_FEATURES.register("blue_jacaranda_bees_0002", Configured.BLUE_JACARANDA_BEES_0002);
            CONFIGURED_FEATURES.register("flowering_blue_jacaranda_bees_0002", Configured.FLOWERING_BLUE_JACARANDA_BEES_0002);
            CONFIGURED_FEATURES.register("thunbergia_jungle", Configured.THUNBERGIA_JUNGLE);
            CONFIGURED_FEATURES.register("redbud", Configured.REDBUD);
            CONFIGURED_FEATURES.register("flowering_redbud", Configured.FLOWERING_REDBUD);
            CONFIGURED_FEATURES.register("trees_jacaranda_sparse", Configured.TREES_JACARANDA_SPARSE);
        }
    }

    public static final class Placed {
        public static final Supplier<PlacedFeature> BLUE_JACARANDA_CHECKED = () -> Configured.BLUE_JACARANDA.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());
        public static final Supplier<PlacedFeature> FLOWERING_BLUE_JACARANDA_CHECKED = () -> Configured.FLOWERING_BLUE_JACARANDA.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());
        public static final Supplier<PlacedFeature> BLUE_JACARANDA_BEES_005 = () -> Configured.BLUE_JACARANDA_BEES_005.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());
        public static final Supplier<PlacedFeature> FLOWERING_BLUE_JACARANDA_BEES_005 = () -> Configured.FLOWERING_BLUE_JACARANDA_BEES_005.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());
        public static final Supplier<PlacedFeature> BLUE_JACARANDA_BEES_0002 = () -> Configured.BLUE_JACARANDA_BEES_0002.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());
        public static final Supplier<PlacedFeature> FLOWERING_BLUE_JACARANDA_BEES_0002 = () -> Configured.FLOWERING_BLUE_JACARANDA_BEES_0002.get().filteredByBlockSurvival(AbundanceBlocks.BLUE_JACARANDA_SAPLING.get());

        public static void registerPlacedFeatures() {
            PLACED_FEATURES.register("blue_jacaranda_checked", Placed.BLUE_JACARANDA_CHECKED);
            PLACED_FEATURES.register("flowering_blue_jacaranda_checked", Placed.FLOWERING_BLUE_JACARANDA_CHECKED);
            PLACED_FEATURES.register("blue_jacaranda_bees_005", Placed.BLUE_JACARANDA_BEES_005);
            PLACED_FEATURES.register("flowering_blue_jacaranda_bees_005", Placed.FLOWERING_BLUE_JACARANDA_BEES_005);
            PLACED_FEATURES.register("blue_jacaranda_bees_0002", Placed.BLUE_JACARANDA_BEES_0002);
            PLACED_FEATURES.register("flowering_blue_jacaranda_bees_0002", Placed.FLOWERING_BLUE_JACARANDA_BEES_0002);
        }
    }
}
