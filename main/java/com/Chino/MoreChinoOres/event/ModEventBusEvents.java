package com.Chino.MoreChinoOres.event;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.entity.ModEntities;
import com.Chino.MoreChinoOres.entity.client.RedJellyModel;
//import com.Chino.MoreChinoOres.entity.client.RedJellyModelOld;
import com.Chino.MoreChinoOres.entity.custom.RedJellyEntity;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreChinoOresApp.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(RedJellyModel.LAYER_LOCATION, RedJellyModel::createBodyLayer);
    }
    
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.RED_JELLY.get(), RedJellyEntity.createAttributes().build());
    }
}
