package com.teamaurora.abundance.common.potion;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

import javax.annotation.Nullable;

/**
 * Note: the actual logic for this effect is handled elsewhere.
 *       this functions merely as a marker and visual indicator.
 *
 *       {@link com.teamaurora.abundance.common.event.PlayerEvents}
 */
public class DeafnessEffect extends Effect {

    public DeafnessEffect() {
        super(EffectType.HARMFUL, 0x45B309);
    }

    @Override
    public void performEffect(LivingEntity livingEntity, int amplifier) {

    }

    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {

    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return false;
    }
}
