package com.teamaurora.abundance.common.world.feature;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.teamaurora.abundance.common.util.DirectionalBlockPos;
import com.teamaurora.abundance.common.util.TreeUtil;
import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.structure.BoundingBox;

import java.util.*;
import java.util.function.BiConsumer;

public class RedbudFeature extends Feature<TreeConfiguration> {

    public RedbudFeature(Codec<TreeConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> ctx) {
        int height = ctx.random().nextInt(3) + 2;
        if (ctx.origin().getY() <= -64 || ctx.origin().getY() + height > ctx.level().getHeight() - 2) {
            return false;
        }
        if (!TreeUtil.isValidGround(ctx.level(), ctx.origin().below())) {
            return false;
        }

        List<DirectionalBlockPos> logs = new ArrayList<>();
        List<BlockPos> leaves = new ArrayList<>();

        for (int i = 0; i <= height; i++) {
            logs.add(new DirectionalBlockPos(ctx.origin().above(i), Direction.UP));
        }

        int variant = ctx.random().nextInt(3);
        if (variant == 0) {
            Direction dir = Direction.from2DDataValue(ctx.random().nextInt(4));
            int offset1 = ctx.random().nextInt(3) - 1;
            int offset2 = ctx.random().nextInt(3) - 1;
            BlockPos bp1 = ctx.origin().above(height).relative(dir).relative(dir.getClockWise(), offset1);
            BlockPos bp2 = ctx.origin().above(height).relative(dir, -1).relative(dir.getClockWise(), offset2);
            logs.add(new DirectionalBlockPos(bp1, dir));
            logs.add(new DirectionalBlockPos(bp2, dir));
            addCanopy(bp1.relative(dir), leaves, ctx.random());
            addCanopy(bp2.relative(dir, -1), leaves, ctx.random());
        } else if (variant == 1) {
            Direction dir = Direction.from2DDataValue(ctx.random().nextInt(4));
            BlockPos bp1 = ctx.origin().above(height).relative(dir);
            BlockPos bp2 = ctx.origin().above(height).relative(dir, -1).relative(dir.getClockWise());
            BlockPos bp3 = ctx.origin().above(height).relative(dir, -1).relative(dir.getClockWise(), -1);
            logs.add(new DirectionalBlockPos(bp1, dir));
            logs.add(new DirectionalBlockPos(bp2, dir));
            logs.add(new DirectionalBlockPos(bp3, dir));
            addCanopy(bp1.relative(dir), leaves, ctx.random());
            addCanopy(bp2.relative(dir, -1), leaves, ctx.random());
            addCanopy(bp3.relative(dir, -1), leaves, ctx.random());
        } else {
            logs.add(new DirectionalBlockPos(ctx.origin().above(height).north(), Direction.NORTH));
            logs.add(new DirectionalBlockPos(ctx.origin().above(height).east(), Direction.EAST));
            logs.add(new DirectionalBlockPos(ctx.origin().above(height).south(), Direction.SOUTH));
            logs.add(new DirectionalBlockPos(ctx.origin().above(height).west(), Direction.WEST));
            addCanopy(ctx.origin().above(height).north(2), leaves, ctx.random());
            addCanopy(ctx.origin().above(height).east(2), leaves, ctx.random());
            addCanopy(ctx.origin().above(height).south(2), leaves, ctx.random());
            addCanopy(ctx.origin().above(height).west(2), leaves, ctx.random());
        }
        addCanopy(ctx.origin().above(height+1), leaves, ctx.random());


        List<BlockPos> leavesClean = cleanLeavesArray(leaves, logs);

        boolean flag = true;
        for (DirectionalBlockPos log : logs) {
            if (!TreeUtil.isAirOrLeaves(ctx.level(), log.pos)) {
                flag = false;
            }
        }
        if (!flag) return false;

        TreeUtil.setDirtAt(ctx.level(), ctx.origin().below());

        for (DirectionalBlockPos log : logs) {
            TreeUtil.placeDirectionalLogAt(ctx.level(), log.pos, log.direction, ctx.random(), ctx.config());
        }
        for (BlockPos leaf : leavesClean) {
            TreeUtil.placeLeafAt(ctx.level(), leaf, ctx.random(), ctx.config());
        }

        Set<BlockPos> set = Sets.newHashSet();
        BiConsumer<BlockPos, BlockState> decSet = (blockPos, blockState) -> {
            set.add(blockPos.immutable());
            ctx.level().setBlock(blockPos, blockState, 19);
        };

        BoundingBox BoundingBox = new BoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

        List<BlockPos> logsPos = new ArrayList<>();
        for (DirectionalBlockPos log : logs) {
            logsPos.add(log.pos);
        }

        if (!ctx.config().decorators.isEmpty()) {
            logsPos.sort(Comparator.comparingInt(Vec3i::getY));
            leavesClean.sort(Comparator.comparingInt(Vec3i::getY));
            ctx.config().decorators.forEach((decorator) -> decorator.place(ctx.level(), decSet, ctx.random(), logsPos, leavesClean));
        }
        return true;
    }

    private void addCanopy(BlockPos pos, List<BlockPos> leaves, Random rand) {
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    if (x == 0 || y == 0 || z == 0 || rand.nextInt(3) == 0) {
                        leaves.add(pos.offset(x, y, z));
                    }
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
