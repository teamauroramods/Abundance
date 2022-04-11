package com.teamaurora.abundance.common.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;

/**
 * Note: the actual logic for this effect is handled elsewhere;
 *       this functions merely as a marker and visual indicator.
 */
public class DeafnessEffect extends MobEffect {

    public DeafnessEffect() {
        super(MobEffectCategory.HARMFUL, 0x45B309);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int amplifier) {

    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {

    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return false;
    }
}