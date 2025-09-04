package com.Chino.MoreChinoOres.util;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreChinoOresApp.MODID, value = Dist.CLIENT)
public class FogHandler {
    private static boolean customFogActiveFlag = false;

    public static void setCustomFog(boolean active){
        customFogActiveFlag = active;
    }

    @SubscribeEvent
    public static void onRenderFog(ViewportEvent.RenderFog event){
        // LocalPlayer player = Minecraft.getInstance().player;
        // if(player == null){
        //     return;
        // }
        
        // if(player.hasEffect(ModEffects.WINDED_EFFECT.getHolder().get())){
            // MobEffectInstance instanceOfEffect = player.getEffect(ModEffects.WINDED_EFFECT.getHolder().get());
            
            // if(instanceOfEffect.getDuration() <= 20){
            //     float modifier = 7.0f + (20 - instanceOfEffect.getDuration()) * 20;
            //     System.out.println("modifier: " + modifier);
            //     event.setFarPlaneDistance(modifier);
            //     event.setNearPlaneDistance(0);
            //     event.setCanceled(true);
            // }else{
            //     event.setNearPlaneDistance(0);
            //     event.setFarPlaneDistance(7.0F);
            //     event.setCanceled(true);
            // }
        // }
        if(customFogActiveFlag){
            event.setNearPlaneDistance(0.0F);
            event.setFarPlaneDistance(5F);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onFogColors(ViewportEvent.ComputeFogColor event){
        if(customFogActiveFlag){
            Entity entity = event.getCamera().getEntity();

            if(!(entity instanceof Player player)){
                return;
            }

            Level worldLevel = player.level();
            
            long currTimeOfDay = worldLevel.getDayTime() % 24000L;
            float cycle = (float) currTimeOfDay / 24000f;

            float[] dayColor = {0.6f, 0.7f, 0.9f};
            float[] nightColor = {0.05f, 0.05f, 0.1f};

            float blend = (float)(0.5f - 0.5f * Math.cos(cycle * 2 * Math.PI));

            float redColor = lerp(nightColor[0], dayColor[0], blend);
            float greenColor = lerp(nightColor[1], dayColor[1], blend);
            float blueColor = lerp(nightColor[2], dayColor[2], blend);

            event.setRed(redColor);
            event.setGreen(greenColor);
            event.setBlue(blueColor);
        }

        // Level level = event.getCamera().getEntity().level();

        // if(customFogActiveFlag){
        //     event.setRed(0.4f);
        //     event.setGreen(0.45f);
        //     event.setBlue(0.4f);
        // }
    }

    public static void turnOffFogOnEffectEnd(LivingEntity target, Holder<MobEffect> effect){
        LocalPlayer player = Minecraft.getInstance().player;

        MobEffectInstance effectInstance = player.getEffect(effect);

        if(effectInstance.getDuration() == 1 || effectInstance.getDuration() == 0){
            FogHandler.setCustomFog(false);
        }
    }

    public static float lerp(float start, float end, float alpha){
        //System.out.println("the lerped ammount with var start = " + start + " end = " + end + " and alpha = " + alpha + " equals to = " + (start + alpha * (end - start)));
        return start + alpha * (end - start);
    }
    
}

// package com.Chino.MoreChinoOres.util;

// import com.Chino.MoreChinoOres.MoreChinoOresApp;
// import com.Chino.MoreChinoOres.effect.ModEffects;

// import net.minecraft.client.Minecraft;
// import net.minecraft.client.player.LocalPlayer;
// import net.minecraft.core.Holder;
// import net.minecraft.world.effect.MobEffect;
// import net.minecraft.world.effect.MobEffectInstance;
// import net.minecraft.world.entity.LivingEntity;
// //import net.minecraft.world.level.Level;
// import net.minecraftforge.api.distmarker.Dist;
// import net.minecraftforge.client.event.ViewportEvent;
// import net.minecraftforge.eventbus.api.SubscribeEvent;
// import net.minecraftforge.fml.common.Mod;

// @Mod.EventBusSubscriber(modid = MoreChinoOresApp.MODID, value = Dist.CLIENT)
// public class FogHandler {
//     private boolean customFogActiveFlag = false;
//     private float nearPlaneDistance, farPlaneDistance, greenColorValue, blueColorValue, redColorValue;

//     public FogHandler(boolean active, float nearPlaneDistance, float farPlaneDistance, float redColorValue, float greenColorValue, float blueColorValue){
//         setCustomFog(active);
        
//         this.nearPlaneDistance = nearPlaneDistance;
//         this.farPlaneDistance = farPlaneDistance;
        
//         this.greenColorValue = greenColorValue;
//         this.blueColorValue = blueColorValue;
//         this.redColorValue = redColorValue;
//     }

//     public FogHandler(boolean active){
//         this(active, 0f, 0f, 0f, 0f, 0f);
//     }

//     public FogHandler(){
//         this(false, 0f, 0f, 0f, 0f, 0f);
//     }

//     public void setCustomFog(boolean active){
//         this.customFogActiveFlag = active;
//     }

//     public void setColorOfFog(float greenColorValue, float blueColorValue, float redColorValue){
//         this.greenColorValue = greenColorValue;
//         this.blueColorValue = blueColorValue;
//         this.redColorValue = redColorValue;
//     }

//     public void setDistanceOfFog(float nearPlaneDistance, float farPlaneDistance){
//         this.nearPlaneDistance = nearPlaneDistance;
//         this.farPlaneDistance = farPlaneDistance;
//     }

//     @SubscribeEvent
//     public void onRenderFog(ViewportEvent.RenderFog event){
//         LocalPlayer player = Minecraft.getInstance().player;
//         if(player == null){
//             return;
//         }
        
//         if(player.hasEffect(ModEffects.WINDED_EFFECT.getHolder().get())){
//             MobEffectInstance instanceOfEffect = player.getEffect(ModEffects.WINDED_EFFECT.getHolder().get());
            
//             if(instanceOfEffect.getDuration() <= 20){
                
//                 float modifier = 7.0f + (20 - instanceOfEffect.getDuration()) * 20;
//                 System.out.println("modifier: " + modifier);
//                 event.setFarPlaneDistance(modifier);
//                 event.setNearPlaneDistance(0);
//                 event.setCanceled(true);
//             }else{
//                 event.setNearPlaneDistance(this.nearPlaneDistance);
//                 event.setFarPlaneDistance(this.farPlaneDistance);
//                 event.setCanceled(true);
//             }
//         }
//     }

//     @SubscribeEvent
//     public void onFogColors(ViewportEvent.ComputeFogColor event){
//         //Level level = event.getCamera().getEntity().level();

//         if(customFogActiveFlag){
//             event.setRed(this.redColorValue);
//             event.setGreen(this.greenColorValue);
//             event.setBlue(this.blueColorValue);
//         }
//     }

//     public void turnOffFogOnEffectEnd(LivingEntity target, Holder<MobEffect> effect){
//         LocalPlayer player = Minecraft.getInstance().player;

//         MobEffectInstance effectInstance = player.getEffect(effect);

//         if(effectInstance.getDuration() == 1 || effectInstance.getDuration() == 0){
//             this.customFogActiveFlag = false;
//         }
//     }
    
// }





