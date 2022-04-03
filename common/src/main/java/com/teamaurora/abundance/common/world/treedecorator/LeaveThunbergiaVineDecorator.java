package com.teamaurora.abundance.common.world.treedecorator;

import com.mojang.serialization.Codec;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class LeaveThunbergiaVineDecorator extends LeaveVineDecorator {
    public static final LeaveVineDecorator DECORATOR = new LeaveThunbergiaVineDecorator();

    public static final Codec<LeaveVineDecorator> CODEC = Codec.unit(() -> DECORATOR);

    public LeaveThunbergiaVineDecorator() {
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return AbundanceFeatures.LEAVE_THUNBERGIA_VINE.get();
    }

    @Override
    public void place(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, Random random, List<BlockPos> logPositions, List<BlockPos> leafPositions) {
        leafPositions.forEach(pos -> {
            BlockPos blockPos;
            if (random.nextInt(4) == 0 && Feature.isAir(level, blockPos = pos.west())) {
                addHangingTunbergiaVine(level, blockPos, VineBlock.EAST, blockSetter);
            }
            if (random.nextInt(4) == 0 && Feature.isAir(level, blockPos = pos.east())) {
                addHangingTunbergiaVine(level, blockPos, VineBlock.WEST, blockSetter);
            }
            if (random.nextInt(4) == 0 && Feature.isAir(level, blockPos = pos.north())) {
                addHangingTunbergiaVine(level, blockPos, VineBlock.SOUTH, blockSetter);
            }
            if (random.nextInt(4) == 0 && Feature.isAir(level, blockPos = pos.south())) {
                addHangingTunbergiaVine(level, blockPos, VineBlock.NORTH, blockSetter);
            }
        });
    }

    private static void addHangingTunbergiaVine(LevelSimulatedReader level, BlockPos pos, BooleanProperty sideProperty, BiConsumer<BlockPos, BlockState> blockSetter) {
        LeaveVineDecorator.placeVine(blockSetter, pos, sideProperty);
        pos = pos.below();
        Random rand = new Random();
        for (int i = 4; Feature.isAir(level, pos) && i > 0; --i) {
            blockSetter.accept(pos, AbundanceBlocks.THUNBERGIA_VINE.get().defaultBlockState().setValue(sideProperty, true));
            pos = pos.below();
        }
    }
}