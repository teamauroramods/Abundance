package com.teamaurora.abundance.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import com.teamaurora.abundance.common.entity.living.Screecher;
import com.teamaurora.abundance.core.Abundance;
import gg.moonflower.pollen.pinwheel.api.client.animation.AnimatedEntityRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;


@Environment(EnvType.CLIENT)
public class ScreecherRenderer extends AnimatedEntityRenderer<Screecher> {
    public static final ResourceLocation SCREECHER_LOCATION = new ResourceLocation(Abundance.MOD_ID, "screecher");
    private static final ResourceLocation[] WALK_ANIMATION = new ResourceLocation[]{new ResourceLocation(Abundance.MOD_ID, "screecher.setup"), new ResourceLocation(Abundance.MOD_ID, "screecher.walking")};
    private static final ResourceLocation[] SCREECH_ANIMATION = new ResourceLocation[]{new ResourceLocation(Abundance.MOD_ID, "screecher.setup"), new ResourceLocation(Abundance.MOD_ID, "screecher.screech")};

    private boolean isMoving = true;


    public ScreecherRenderer(EntityRendererProvider.Context context) {
        super(context, new ResourceLocation(Abundance.MOD_ID, "screecher"), 1.0F);
    }


    @Override
    public ResourceLocation[] getAnimations(Screecher entity) {
        if (isMoving)
            return WALK_ANIMATION;
        else if (entity.isScreeching())
            return SCREECH_ANIMATION;
        return super.getAnimations(entity);
    }

    @Override
    public ResourceLocation getTextureTableLocation(Screecher entity) {
        return SCREECHER_LOCATION;
    }

    @Override
    public void render(Screecher entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        matrixStack.pushPose();

        float limbSwingAmount = 0.0F;
        if (entity.isAlive()) {
            limbSwingAmount = Mth.lerp(partialTicks, entity.animationSpeedOld, entity.animationSpeed);

            if (limbSwingAmount > 1.0F) {
                limbSwingAmount = 1.0F;
            }
        }
        this.isMoving = !(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F);

        matrixStack.popPose();
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }
}
