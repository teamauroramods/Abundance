package com.teamaurora.abundance.common.world.feature;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class NemophilaFeature extends Feature<NoneFeatureConfiguration> {
    public NemophilaFeature(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        int i = 0;
        BlockPos pos = ctx.origin();
        for (BlockPos pos2 : BlockPos.betweenClosed(pos.offset(-3, -3, -3), pos.offset(3, 3, 3))) {
            if (pos.closerThan(pos2, 3.0) && AbundanceBlocks.NEMOPHILA.get().defaultBlockState().canSurvive(ctx.level(), pos2) && isAir(ctx.level(), pos2)) {
                if (ctx.random().nextBoolean()) {
                    ctx.level().setBlock(pos2, AbundanceBlocks.NEMOPHILA.get().defaultBlockState(), 2);
                    i++;
                }
            }
        }
        return i > 0;
    }
}
