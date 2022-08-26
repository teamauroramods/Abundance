package com.teamaurora.abundance.common.levelgen.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class NemophilaFeature extends Feature<NoneFeatureConfiguration> {

    public NemophilaFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        BlockPos pos = featurePlaceContext.origin();
        WorldGenLevel level = featurePlaceContext.level();
        int i = 0;
        for (BlockPos pos2 : BlockPos.betweenClosed(pos.offset(-3, -3, -3), pos.offset(3, 3, 3))) {
            if (pos.closerThan(pos2, 3.0) && AbundanceBlocks.NEMOPHILA.get().defaultBlockState().canSurvive(level, pos2) && isAir(level, pos2)) {
                if (featurePlaceContext.random().nextBoolean()) {
                    level.setBlock(pos2, AbundanceBlocks.NEMOPHILA.get().defaultBlockState(), 2);
                    i++;
                }
            }
        }
        return i > 0;
    }
}
