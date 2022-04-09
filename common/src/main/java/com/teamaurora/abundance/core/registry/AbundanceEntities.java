package com.teamaurora.abundance.core.registry;

import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.api.registry.EntityAttributeRegistry;
import gg.moonflower.pollen.api.registry.PollinatedEntityRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.function.Supplier;

public class AbundanceEntities {
    public static final PollinatedEntityRegistry ENTITY_TYPES = PollinatedEntityRegistry.createEntity(Abundance.MOD_ID);

    public static final Supplier<EntityType<ScreecherEntity>> SCREECHER = ENTITY_TYPES.register("screecher", () -> EntityType.Builder.of(ScreecherEntity::new, MobCategory.MONSTER).sized(1.1F, 1.0F).clientTrackingRange(64).build(Abundance.MOD_ID));

    public static void registerEntityAttributes() {
        EntityAttributeRegistry.register(SCREECHER, ScreecherEntity.createScreecherAttributes());
    }
}
