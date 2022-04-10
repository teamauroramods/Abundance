package com.teamaurora.abundance.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamaurora.abundance.common.entity.living.ScreecherEntity;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.pinwheel.api.client.animation.AnimatedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;


@Environment(EnvType.CLIENT)
public class ScreecherRenderer extends AnimatedEntityRenderer<ScreecherEntity> {
    public static final ResourceLocation SCREECHER_LOCATION = new ResourceLocation(Abundance.MOD_ID, "screecher");
    private static final ResourceLocation[] WALK_ANIMATION = new ResourceLocation[]{new ResourceLocation(Abundance.MOD_ID, "screecher.setup"), new ResourceLocation(Abundance.MOD_ID, "screecher.walking")};

    public ScreecherRenderer(EntityRendererProvider.Context context) {
        super(context, new ResourceLocation(Abundance.MOD_ID, "screecher"), 1.0F);
    }


    @Override
    public ResourceLocation[] getAnimations(ScreecherEntity entity) {
        return WALK_ANIMATION;
    }

    @Override
    public ResourceLocation getTextureTableLocation(ScreecherEntity entity) {
        return SCREECHER_LOCATION;
    }

    @Override
    public void render(ScreecherEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();
        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}
