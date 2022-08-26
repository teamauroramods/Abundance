package com.teamaurora.abundance.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class LavenderFeature extends Feature<NoneFeatureConfiguration> {

    public LavenderFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        BlockPos pos = featurePlaceContext.origin();
        Random random = featurePlaceContext.random();
        WorldGenLevel level = featurePlaceContext.level();
        int i = 0;
        for (BlockPos pos2 : BlockPos.betweenClosed(pos.offset(-6, -6, -6), pos.offset(6, 6, 6))) {
            if (pos.closerThan(pos2, 6.0) && AbundanceBlocks.LAVENDER.get().defaultBlockState().canSurvive(level, pos2) && isAir(level, pos2)) {
                if (pos.closerThan(pos2, 3.0)) {
                    if (random.nextBoolean()) {
                        if (AbundanceBlocks.TALL_LAVENDER.get().defaultBlockState().canSurvive(level, pos2) && isAir(level, pos2.above())) {
                            DoublePlantBlock.placeAt(level, AbundanceBlocks.TALL_LAVENDER.get().defaultBlockState(), pos2, 2);
                            level.setBlock(pos2.below(), Blocks.COARSE_DIRT.defaultBlockState(), 2);
                            i++;
                        }
                    }
                } else {
                    if (random.nextInt(3) == 0) {
                        if (AbundanceBlocks.TALL_LAVENDER.get().defaultBlockState().canSurvive(level, pos2) && isAir(level, pos2.above())) {
                            DoublePlantBlock.placeAt(level, AbundanceBlocks.TALL_LAVENDER.get().defaultBlockState(), pos2, 2);
                            level.setBlock(pos2.below(), Blocks.COARSE_DIRT.defaultBlockState(), 2);
                            i++;
                        }
                    }
                }
            }
        }
        return i > 0;
    }
}