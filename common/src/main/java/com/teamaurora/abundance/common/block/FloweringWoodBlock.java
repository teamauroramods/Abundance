package com.teamaurora.abundance.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.function.Supplier;


public class FloweringWoodBlock extends RotatedPillarBlock {

    private final Supplier<Block> snipBlock;

    public FloweringWoodBlock(Properties properties, Supplier<Block> snippedBlock) {
        super(properties);
        this.snipBlock = snippedBlock;
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack item = player.getItemInHand(hand);

        if (item.getItem() instanceof ShearsItem) {
            worldIn.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + worldIn.random.nextFloat() * 0.4F);
            worldIn.setBlock(pos, snipBlock.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS)), 2);

            if (player instanceof ServerPlayer && !player.isCreative()) {
                item.hurt(1, worldIn.getRandom(), (ServerPlayer) player);
            }
            return InteractionResult.sidedSuccess(worldIn.isClientSide);
        }
        return super.use(state, worldIn, pos, player, hand, hit);
    }
}