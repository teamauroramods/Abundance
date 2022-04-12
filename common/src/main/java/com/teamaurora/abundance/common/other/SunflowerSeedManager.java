package com.teamaurora.abundance.common.other;

import com.teamaurora.abundance.core.registry.AbundanceItems;
import gg.moonflower.pollen.api.event.events.LootTableConstructingEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;


/**
 * Allows for sunflower seeds to be dropped when the player clicks on the top half of a sunflower.
 * @author ebo2022
 */
public class SunflowerSeedManager {
    public static InteractionResult onRightClickBlock(Player player, Level level, InteractionHand hand, BlockHitResult hitResult) {
        BlockPos pos = hitResult.getBlockPos();
        BlockState state = level.getBlockState(pos);
        Random rand = level.getRandom();

        int chance = rand.nextInt(0, 4);

        if (state.getBlock() == Blocks.SUNFLOWER && state.getValue(TallFlowerBlock.HALF) == DoubleBlockHalf.UPPER) {
            if (chance == 0) {
                Block.popResource(level, pos, new ItemStack(AbundanceItems.SUNFLOWER_SEEDS.get(), rand.nextInt( 1 ,3)));
                level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
                return InteractionResult.sidedSuccess(level.isClientSide);
            }
        }
        return InteractionResult.PASS;
    }
}
