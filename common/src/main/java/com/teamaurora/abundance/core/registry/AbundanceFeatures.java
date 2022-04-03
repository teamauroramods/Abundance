package com.teamaurora.abundance.core.registry;

import com.google.common.collect.ImmutableList;
import com.teamaurora.abundance.common.world.feature.JacarandaFeature;
import com.teamaurora.abundance.common.world.treedecorator.LeaveTunbergiaVineDecorator;
import com.teamaurora.abundance.common.world.treedecorator.TrunkTunbergiaVineDecorator;
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
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.function.Supplier;

public class AbundanceFeatures {
    public static final PollinatedRegistry<Feature<?>> FEATURES = PollinatedRegistry.create(Registry.FEATURE, Abundance.MOD_ID);
    public static final PollinatedRegistry<TreeDecoratorType<?>> TREE_DECORATOR_TYPES = PollinatedRegistry.create(Registry.TREE_DECORATOR_TYPES, Abundance.MOD_ID);
    public static final PollinatedRegistry<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = PollinatedRegistry.create(BuiltinRegistries.CONFIGURED_FEATURE, Abundance.MOD_ID);

    public static final Supplier<Feature<TreeConfiguration>> JACARANDA_TREE = FEATURES.register("cypress_tree", () -> new JacarandaFeature(TreeConfiguration.CODEC));

    public static final Supplier<TreeDecoratorType<?>> TRUNK_TUNBERGIA_VINE = TREE_DECORATOR_TYPES.register("trunk_tunbergia_vine", () -> new TreeDecoratorType<>(TrunkTunbergiaVineDecorator.CODEC));
    public static final Supplier<TreeDecoratorType<?>> LEAVE_TUNBERGIA_VINE = TREE_DECORATOR_TYPES.register("leave_tunbergia_vine", () -> new TreeDecoratorType<>(LeaveTunbergiaVineDecorator.CODEC));


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
        public static final BlockState TUNBERGIA_JUNGLE_LEAVES = AbundanceBlocks.TUNBERGIA_JUNGLE_LEAVES.get().defaultBlockState();
        public static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.defaultBlockState();
        public static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.defaultBlockState();
    }

    public static final class Configs {
        public static final TreeConfiguration JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BLUE_JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BLUE_JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_BEES_005_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_005)).build();
        public static final TreeConfiguration BLUE_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BLUE_JACARANDA_LEAVES, 3).add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 1).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration FLOWERING_BLUE_JACARANDA_TREE_BEES_0002_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JACARANDA_LOG),
                new StraightTrunkPlacer(0, 0, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.BUDDING_BLUE_JACARANDA_LEAVES, 3).add(BlockStates.FLOWERING_BLUE_JACARANDA_LEAVES, 2).build()),
                new BlobFoliagePlacer(UniformInt.of(0, 0), UniformInt.of(0, 0), 0),
                new TwoLayersFeatureSize(0, 0, 0)
        )).ignoreVines().decorators(ImmutableList.of(ABUNDANCE_BEEHIVE_0002)).build();
        public static final TreeConfiguration TUNBERGIA_JUNGLE_TREE_CONFIG = (new TreeConfiguration.TreeConfigurationBuilder(
                new SimpleStateProvider(BlockStates.JUNGLE_LOG),
                new StraightTrunkPlacer(4, 8, 0),
                new WeightedStateProvider(new SimpleWeightedRandomList.Builder().add(BlockStates.TUNBERGIA_JUNGLE_LEAVES, 3).add(BlockStates.JUNGLE_LEAVES, 2).build()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        )).decorators(ImmutableList.of(new CocoaDecorator(0.2F), TrunkTunbergiaVineDecorator.DECORATOR, LeaveTunbergiaVineDecorator.DECORATOR)).ignoreVines().build();
    }

    public static final class Configured {
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.JACARANDA_TREE_BEES_0002_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_JACARANDA_TREE_BEES_0002_CONFIG);

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.BLUE_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_BLUE_JACARANDA_TREE_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.BLUE_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_005 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_BLUE_JACARANDA_TREE_BEES_005_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> BLUE_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.BLUE_JACARANDA_TREE_BEES_0002_CONFIG);
        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> FLOWERING_BLUE_JACARANDA_BEES_0002 = () -> AbundanceFeatures.JACARANDA_TREE.get().configured(Configs.FLOWERING_BLUE_JACARANDA_TREE_BEES_0002_CONFIG);

        public static final Supplier<ConfiguredFeature<TreeConfiguration, ?>> TUNBERGIA_JUNGLE = () -> Feature.TREE.configured(Configs.TUNBERGIA_JUNGLE_TREE_CONFIG);


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
            CONFIGURED_FEATURES.register("tunbergia_jungle", Configured.TUNBERGIA_JUNGLE);
        }
    }
}
