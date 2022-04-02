package com.teamaurora.abundance.common.block.trees;

import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BlueJacarandaTreeGrower extends AbstractTreeGrower {
    @Override
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(@Nullable Random randomIn, boolean largeHive) {
        if (randomIn.nextBoolean()) {
            return largeHive ? AbundanceFeatures.Configured.BLUE_JACARANDA_BEES_005.get() : AbundanceFeatures.Configured.BLUE_JACARANDA.get();
        } else {
            return largeHive ? AbundanceFeatures.Configured.FLOWERING_BLUE_JACARANDA_BEES_005.get() : AbundanceFeatures.Configured.FLOWERING_BLUE_JACARANDA.get();
        }
    }
}