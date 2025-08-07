package com.Chino.MoreChinoOres.entity.client;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.entity.custom.RedJellyEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RedJellyRenderer extends MobRenderer<RedJellyEntity, RedJellyModel<RedJellyEntity>>{
    public RedJellyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new RedJellyModel<>(pContext.bakeLayer(RedJellyModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(RedJellyEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, "textures/entity/red_jelly/red_jelly_texture.png");
    }
}
