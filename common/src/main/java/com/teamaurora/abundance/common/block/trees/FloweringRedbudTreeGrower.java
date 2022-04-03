package com.teamaurora.abundance.common.block.trees;

import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class FloweringRedbudTreeGrower extends AbstractTreeGrower {
    @Override
    @Nullable
    protected ConfiguredFeature<TreeConfiguration, ?> getConfiguredFeature(@Nullable Random randomIn, boolean largeHive) {
       return AbundanceFeatures.Configured.FLOWERING_REDBUD.get();
    }
}