package com.teamaurora.abundance.common.block;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
import java.util.function.Supplier;

public class SmallMarigoldBlock extends ModifiedFlowerBlock implements BonemealableBlock {
    public SmallMarigoldBlock(Supplier<MobEffect> effectSupplier, int effectDuration, Properties properties) {
        super(effectSupplier, effectDuration, properties);
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel worldIn, Random rand, BlockPos pos, BlockState state) {
       if (rand.nextBoolean()) {
           worldIn.setBlock(pos, AbundanceBlocks.SUNNY_MARIGOLD.get().defaultBlockState(), 2);
       } else {
           worldIn.setBlock(pos, AbundanceBlocks.SHADY_MARIGOLD.get().defaultBlockState(), 2);
       }
    }
}
