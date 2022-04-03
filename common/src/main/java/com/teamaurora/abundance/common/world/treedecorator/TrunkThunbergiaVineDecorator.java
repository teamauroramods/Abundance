package com.teamaurora.abundance.common.world.treedecorator;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class TrunkThunbergiaVineDecorator extends TrunkVineDecorator {

    public static final TrunkThunbergiaVineDecorator DECORATOR = new TrunkThunbergiaVineDecorator();

    public static final Codec<TrunkThunbergiaVineDecorator> CODEC = Codec.unit(() -> {
        return DECORATOR;
    });

    public TrunkThunbergiaVineDecorator() {
    }

    @Override
    public void place(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, Random random, List<BlockPos> logPositions, List<BlockPos> leafPositions) {
        logPositions.forEach((pos) -> {
            BlockPos blockPos;
            if (random.nextInt(3) > 0) {
                blockPos = pos.west();
                if (Feature.isAir(level, blockPos)) {
                    placeTunbergiaVine(blockSetter, blockPos, VineBlock.EAST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.east();
                if (Feature.isAir(level, blockPos)) {
                    placeTunbergiaVine(blockSetter, blockPos, VineBlock.WEST);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.north();
                if (Feature.isAir(level, blockPos)) {
                    placeTunbergiaVine(blockSetter, blockPos, VineBlock.SOUTH);
                }
            }

            if (random.nextInt(3) > 0) {
                blockPos = pos.south();
                if (Feature.isAir(level, blockPos)) {
                    placeTunbergiaVine(blockSetter, blockPos, VineBlock.NORTH);
                }
            }

        });
    }

    protected static void placeTunbergiaVine(BiConsumer<BlockPos, BlockState> blockSetter, BlockPos pos, BooleanProperty sideProperty) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            blockSetter.accept(pos, AbundanceBlocks.THUNBERGIA_VINE.get().defaultBlockState().setValue(sideProperty, true));
        } else {
            blockSetter.accept(pos, Blocks.VINE.defaultBlockState().setValue(sideProperty, true));
        }
    }
}
