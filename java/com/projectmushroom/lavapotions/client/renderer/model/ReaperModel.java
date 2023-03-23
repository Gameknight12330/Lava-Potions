package com.projectmushroom.lavapotions.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.projectmushroom.lavapotions.LavaPotions;
import com.projectmushroom.lavapotions.entity.Reaper;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class ReaperModel<Type extends Reaper> extends EntityModel<Type> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation(LavaPotions.MOD_ID, "reaper"), "main");
	private final ModelPart Scythe;
	private final ModelPart Reference;

	public ReaperModel(ModelPart root) {
		this.Scythe = root.getChild("Scythe");
		this.Reference = root.getChild("Reference");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Scythe = partdefinition.addOrReplaceChild("Scythe", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Handle = Scythe.addOrReplaceChild("Handle", CubeListBuilder.create().texOffs(160, 0).addBox(-20.0F, -17.0F, -1.0F, 3.0F, 17.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(157, 157).addBox(-20.0F, -44.0F, 0.0F, 3.0F, 31.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 160).addBox(-20.0F, -64.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 160).addBox(-20.0F, -84.0F, -2.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 160).addBox(-20.0F, -104.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Blade = Scythe.addOrReplaceChild("Blade", CubeListBuilder.create().texOffs(152, 24).addBox(-20.0F, -102.0F, 2.0F, 3.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, 144).addBox(-20.0F, -101.0F, 10.0F, 3.0F, 15.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(152, 56).addBox(-20.0F, -99.0F, 21.0F, 3.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(152, 88).addBox(-20.0F, -96.0F, 29.0F, 3.0F, 10.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-20.0F, -93.0F, 37.0F, 3.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-20.0F, -90.0F, 44.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-20.0F, -86.0F, 50.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Reference = partdefinition.addOrReplaceChild("Reference", CubeListBuilder.create().texOffs(0, 32).addBox(-14.0F, -16.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(96, 128).addBox(-2.0F, -16.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 128).addBox(-2.0F, -32.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 16).addBox(-14.0F, -32.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 48).addBox(-14.0F, -48.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 112).addBox(-2.0F, -48.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 64).addBox(-14.0F, -64.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(96, 64).addBox(-2.0F, -80.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(48, 80).addBox(-14.0F, -80.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(96, 0).addBox(-2.0F, -85.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-14.0F, -85.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(96, 96).addBox(-2.0F, -64.0F, -43.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 31.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Scythe.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Reference.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}