package com.teamaurora.abundance.common.block;

import com.teamaurora.abundance.core.registry.AbundanceBlocks;
import com.teamaurora.abundance.core.registry.AbundanceItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("deprecation")
public class TallLavenderBlock extends DoublePlantBlock {

    public TallLavenderBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(AbundanceBlocks.LAVENDER.get().asItem());
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        popResource(worldIn, pos, new ItemStack(AbundanceBlocks.LAVENDER.get().asItem(), 2));
        worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
        int downAmount = state.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1;
        worldIn.setBlock(pos.below(downAmount), AbundanceBlocks.LAVENDER.get().defaultBlockState().setValue(LavenderBlock.AGE, 0), 2);
        worldIn.setBlock(pos.below(downAmount).above(), Blocks.AIR.defaultBlockState(), 2);

        return InteractionResult.sidedSuccess(worldIn.isClientSide);
    }

    @Override
    public BlockBehaviour.OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
