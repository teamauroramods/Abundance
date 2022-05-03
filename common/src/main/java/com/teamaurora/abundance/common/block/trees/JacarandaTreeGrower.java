package com.teamaurora.abundance.common.block.trees;

import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class JacarandaTreeGrower extends AbstractTreeGrower {
    @Override
    @Nullable
    protected Holder<ConfiguredFeature<TreeConfiguration, ?>> getConfiguredFeature(@Nullable Random randomIn, boolean largeHive) {
        if (randomIn.nextBoolean()) {
            return largeHive ? AbundanceFeatures.Configured.JACARANDA_BEES_005.get() : AbundanceFeatures.Configured.JACARANDA.get();
        } else {
            return largeHive ? AbundanceFeatures.Configured.FLOWERING_JACARANDA_BEES_005.get() : AbundanceFeatures.Configured.FLOWERING_JACARANDA.get();
        }
    }
}