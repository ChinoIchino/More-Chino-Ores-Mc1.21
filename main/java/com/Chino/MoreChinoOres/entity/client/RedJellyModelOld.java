// package com.Chino.MoreChinoOres.entity.client;

// import com.Chino.MoreChinoOres.MoreChinoOresApp;
// import com.Chino.MoreChinoOres.entity.custom.RedJellyEntity;
// import com.mojang.blaze3d.vertex.PoseStack;
// import com.mojang.blaze3d.vertex.VertexConsumer;

// import net.minecraft.client.model.HierarchicalModel;
// import net.minecraft.client.model.geom.ModelLayerLocation;
// import net.minecraft.client.model.geom.ModelPart;
// import net.minecraft.client.model.geom.PartPose;
// import net.minecraft.client.model.geom.builders.CubeDeformation;
// import net.minecraft.client.model.geom.builders.CubeListBuilder;
// import net.minecraft.client.model.geom.builders.LayerDefinition;
// import net.minecraft.client.model.geom.builders.MeshDefinition;
// import net.minecraft.client.model.geom.builders.PartDefinition;
// import net.minecraft.resources.ResourceLocation;

// public class RedJellyModelOld<T extends RedJellyEntity> extends HierarchicalModel<T> {
// 	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, "red_jelly"), "main");
// 	private final ModelPart Layers;

// 	public RedJellyModelOld(ModelPart root) {
// 		this.Layers = root.getChild("Layers");
// 	}

// 	public static LayerDefinition createBodyLayer() {
// 		MeshDefinition meshdefinition = new MeshDefinition();
// 		PartDefinition partdefinition = meshdefinition.getRoot();

// 		PartDefinition Layers = partdefinition.addOrReplaceChild("Layers", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F, -6.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
// 		.texOffs(0, 0).addBox(-8.0F, -10.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
// 		.texOffs(40, 32).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

// 		return LayerDefinition.create(meshdefinition, 64, 64);
// 	}

// 	@Override
// 	public void setupAnim(RedJellyEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

// 	}

// 	@Override
// 	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
// 		Layers.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
// 	}

//     // @Override
//     // public void setupAnim(RedJellyEntity entity, float limbSwing, limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

//     // }

//     @Override
//     public ModelPart root(){
//         return Layers;
//     }
// }
