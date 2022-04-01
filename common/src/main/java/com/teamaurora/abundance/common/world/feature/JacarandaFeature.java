package com.teamaurora.abundance.common.world.feature;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.teamaurora.abundance.common.util.DirectionalBlockPos;
import com.teamaurora.abundance.common.util.TreeUtil;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.*;
import java.util.function.BiConsumer;

public class JacarandaFeature extends Feature<TreeConfiguration> {

    public JacarandaFeature(Codec<TreeConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> context) {
        int height = context.random().nextInt(4) + 4;
        if (context.origin().getY() <= 0 || context.origin().getY() + height > context.level().getHeight() - 2) {
            return false;
        }
        if (!TreeUtil.isValidGround(context.level(), context.origin().below())) {
            return false;
        }
        List<DirectionalBlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            logs.add(new DirectionalBlockPos(context.origin().above(i), Direction.UP));
        }

        List<Direction> dirs = new ArrayList<>();
        dirs.add(Direction.NORTH);
        dirs.add(Direction.EAST);
        dirs.add(Direction.SOUTH);
        dirs.add(Direction.EAST);

        for (int i = 2; i <= height - 2; i++) {
            Direction dir = dirs.get(context.random().nextInt(dirs.size()));
            dirs.remove(dir);
            addBranch(context.origin().above(i), dir, leaves, logs, context.random());
        }
        addCanopy(context.origin().above(height), leaves, context.random());

        List<BlockPos> leavesClean = cleanLeavesArray(leaves, logs);

        boolean flag = true;
        for (DirectionalBlockPos log : logs) {
            if (!TreeUtil.isAirOrLeaves(context.level(), log.pos)) {
                flag = false;
            }
        }
        if (!flag) return false;

        TreeUtil.setDirtAt(context.level(), context.origin().below());

        for (DirectionalBlockPos log : logs) {
            TreeUtil.placeDirectionalLogAt(context.level(), log.pos, log.direction, context.random(), context.config());
        }
        for (BlockPos leaf : leavesClean) {
            TreeUtil.placeLeafAt(context.level(), leaf, context.random(), context.config());
        }

        Set<BlockPos> set = Sets.newHashSet();
        BiConsumer<BlockPos, BlockState> decSet = (blockPos, blockState) -> {
            set.add(blockPos.immutable());
            context.level().setBlock(blockPos, blockState, 19);
        };
        BoundingBox mutableBoundingBox = BoundingBox.infinite();

        List<BlockPos> logsPos = new ArrayList<>();

        for (DirectionalBlockPos log : logs) {
            logsPos.add(log.pos);
        }

        if (!context.config().decorators.isEmpty()) {
            logsPos.sort(Comparator.comparingInt(Vec3i::getY));
            leavesClean.sort(Comparator.comparingInt(Vec3i::getY));
            context.config().decorators.forEach((decorator) -> decorator.place(context.level(), decSet, context.random(), logsPos, leavesClean));
        }

        return true;
    }

    private void addBranch(BlockPos pos, Direction dir, List<BlockPos> leaves, List<DirectionalBlockPos> logs, Random rand) {
        logs.add(new DirectionalBlockPos(pos.offset(dir.getNormal()), dir));
        int i = rand.nextInt(3) - 1;
        BlockPos b2pos = pos.above(i).offset(dir.getNormal());
        logs.add(new DirectionalBlockPos(b2pos, dir));
        addCanopy(b2pos, leaves, rand);
    }

    private void addCanopy(BlockPos pos, List<BlockPos> leaves, Random rand) {
        cir1(pos.below(), leaves, rand);
        cir2(pos, leaves, rand);
        cir2(pos.above(), leaves, rand);
        cir1(pos.below(2), leaves, rand);
    }

    private void cir1(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -1; x <= 1; x++) {
            for (int z = -1; z <= 1; z++) {
                //if (Math.abs(x) != 1 || Math.abs(z) != 1 || rand.nextBoolean()) {
                if (Math.abs(x) != 1 || Math.abs(z) != 1) {
                        leaves.add(pos.offset(x, 0, z));
                }
            }
        }
    }

    private void cir2(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                //if (Math.abs(x) != 2 || Math.abs(z) != 2 || rand.nextBoolean()) {
                if (Math.abs(x) != 2 || Math.abs(z) != 2) {
                    leaves.add(pos.offset(x, 0, z));
                }
            }
        }
    }

    private List<BlockPos> cleanLeavesArray(List<BlockPos> leaves, List<DirectionalBlockPos> logs) {
        List<BlockPos> logsPos = new ArrayList<>();
        for (DirectionalBlockPos log : logs) {
            logsPos.add(log.pos);
        }
        List<BlockPos> newLeaves = new ArrayList<>();
        for (BlockPos leaf : leaves) {
            if (!logsPos.contains(leaf)) {
                newLeaves.add(leaf);
            }
        }
        return newLeaves;
    }
}
