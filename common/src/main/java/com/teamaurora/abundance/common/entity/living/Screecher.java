package com.teamaurora.abundance.common.entity.living;

import com.teamaurora.abundance.core.registry.AbundanceEffects;
import com.teamaurora.abundance.core.registry.AbundanceSoundEvents;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimatedPathfinder;
import gg.moonflower.pollen.pinwheel.api.common.animation.AnimationState;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Supplier;

public class Screecher extends AnimatedPathfinder {

    public static final EntityDataAccessor<Boolean> IS_SCREECHING = SynchedEntityData.defineId(Screecher.class, EntityDataSerializers.BOOLEAN);

    public static final AnimationState WALKING_ANIMATION = new AnimationState(20);
    public static final AnimationState SCREECH_ANIMATION = new AnimationState(60);

    private int timeNextScreech = 0;

    public Screecher(EntityType<? extends PathfinderMob> type, Level worldIn) {
        super(type, worldIn);
    }

    public static Supplier<AttributeSupplier.Builder> createScreecherAttributes() {
        return () -> Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0D)
                .add(Attributes.FOLLOW_RANGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_SCREECHING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 0.9D));
        this.goalSelector.addGoal(2, new ScreechGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this, Screecher.class));
    }


    public boolean canScreech() {
        return this.timeNextScreech <= 0;
    }

    public void setScreeching(boolean screeching) {
        this.entityData.set(IS_SCREECHING, screeching);
    }

    public boolean isScreeching() {
        return this.entityData.get(IS_SCREECHING);
    }

    private void newScreechTime() {
        this.timeNextScreech = 600;
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AbundanceSoundEvents.SCREECHER_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AbundanceSoundEvents.SCREECHER_DEATH.get();
    }

    protected SoundEvent getScreechSound() {
        return AbundanceSoundEvents.SCREECHER_SCREECH.get();
    }

    @Override
    public float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (!this.isScreeching()) {
            if (this.timeNextScreech > 0) {
                --this.timeNextScreech;
            }
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("ScreechTime", this.timeNextScreech);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.timeNextScreech = compoundTag.getInt("ScreechTime");
    }

    @Override
    public AnimationState[] getAnimationStates() {
        return new AnimationState[] {
                WALKING_ANIMATION,
                SCREECH_ANIMATION
        };
    }

    private static class ScreechGoal extends Goal {

        private final Screecher screecher;
        private static final int maxScreechTime = 40;
        private int screechTime;

        protected ScreechGoal(Screecher screecher) {
            this.screecher = screecher;
        }

        @Override
        public boolean canUse() {
            return this.screecher.getTarget() != null && this.screecher.canScreech();
        }

        @Override
        public boolean canContinueToUse() {
            return this.screecher.getTarget() != null && this.screecher.getTarget().isAlive() && this.screechTime < maxScreechTime;
        }

        @Override
        public void start() {
            this.screecher.setScreeching(true);
            this.screecher.setAnimationState(SCREECH_ANIMATION);
            this.screecher.level.playSound(null, this.screecher, this.screecher.getScreechSound(), SoundSource.NEUTRAL, 2.0F, this.screecher.getSoundVolume());
        }

        @Override
        public void stop() {
            this.screecher.setScreeching(false);
            this.screecher.resetAnimationState();
            this.screecher.newScreechTime();
            this.screechTime = 0;
        }

        @Override
        public void tick() {
            ++this.screechTime;

            LivingEntity target = this.screecher.getTarget();
            this.screecher.getLookControl().setLookAt(target.getX(), target.getY(), target.getZ());

            if (this.screechTime >= maxScreechTime) {
                this.doScreechEffect();
            }
        }

        private void doScreechEffect() {
            AABB box = this.screecher.getBoundingBox().expandTowards(new Vec3(14.0D, 14.0D, 14.0D));
            List<Player> nearbyPlayers = this.screecher.level.getEntitiesOfClass(Player.class, box);

            for (Player player : nearbyPlayers) {
                player.forceAddEffect(new MobEffectInstance(AbundanceEffects.DEAFNESS.get(), 140), this.screecher);
            }
        }
    }
}
