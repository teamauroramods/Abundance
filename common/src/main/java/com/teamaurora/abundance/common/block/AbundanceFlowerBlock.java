package com.teamaurora.abundance.common.block;

import gg.moonflower.pollen.api.item.TabFiller;
import net.minecraft.core.NonNullList;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.FlowerBlock;

import java.util.function.Supplier;

/**
 * An extension of {@link FlowerBlock} that uses deferred stew effects and inserts its item after vanilla flowers.
 * @author ebo2022
 * @since 2.0.0
 */
public class AbundanceFlowerBlock extends FlowerBlock {
    private final Supplier<MobEffect> effectSupplier;
    private final int effectDuration;

    public AbundanceFlowerBlock(Supplier<MobEffect> effectSupplier, int effectDuration, Properties properties) {
        super(MobEffects.REGENERATION, effectDuration, properties);
        this.effectSupplier = effectSupplier;
        this.effectDuration = this.getSuspiciousStewEffect().isInstantenous() ? effectDuration : effectDuration * 20;
    }

    @Override
    public MobEffect getSuspiciousStewEffect() {
        return this.effectSupplier.get();
    }

    @Override
    public void fillItemCategory(CreativeModeTab category, NonNullList<ItemStack> items) {
        TabFiller.insert(new ItemStack(this), false, items, stack -> stack.getItem() == Items.WITHER_ROSE);
    }

    @Override
    public int getEffectDuration() {
        return this.effectDuration;
    }
}
