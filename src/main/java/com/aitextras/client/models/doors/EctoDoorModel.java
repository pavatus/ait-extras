package com.aitextras.client.models.doors;

import dev.amble.ait.api.link.v2.block.AbstractLinkableBlockEntity;
import dev.amble.ait.client.models.doors.PoliceBoxDoorModel;
import dev.amble.ait.client.renderers.AITRenderLayers;
import dev.amble.ait.data.schema.exterior.ClientExteriorVariantSchema;
import dev.amble.ait.registry.impl.exterior.ClientExteriorVariantRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

public class EctoDoorModel extends PoliceBoxDoorModel {
    private static ClientExteriorVariantSchema variant;

    public EctoDoorModel(ModelPart root) {
        super(root);

        variant = ClientExteriorVariantRegistry.BOX_DEFAULT;
    }

    @Override
    public void renderWithAnimations(AbstractLinkableBlockEntity door, ModelPart root, MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float pAlpha) {
        VertexConsumerProvider.Immediate immediate = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
        vertices = immediate.getBuffer(AITRenderLayers.getEntityTranslucentCull(variant.texture()));

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-180f));

        super.renderWithAnimations(door, root, matrices, vertices, light, overlay, red, green, blue, pAlpha);
    }
}