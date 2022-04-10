package com.teamaurora.abundance.client.render.entity.living;

import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.pinwheel.api.client.animation.AnimatedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;


@Environment(EnvType.CLIENT)
public class ScreecherRenderer extends AnimatedEntityRenderer<ScreecherEntity> {
    public static final ResourceLocation SCREECHER_LOCATION = new ResourceLocation(Abundance.MOD_ID, "screecher");

    public ScreecherRenderer(EntityRendererProvider.Context context) {
        super(context, new ResourceLocation(Abundance.MOD_ID, "screecher"), 1.0F);
    }

    @Override
    public ResourceLocation getTextureTableLocation(ScreecherEntity entity) {
        return SCREECHER_LOCATION;
    }
}
