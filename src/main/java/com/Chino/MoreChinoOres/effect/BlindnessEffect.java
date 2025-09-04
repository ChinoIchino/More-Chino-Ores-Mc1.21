package com.Chino.MoreChinoOres.effect;

import com.Chino.MoreChinoOres.util.FogHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class BlindnessEffect extends MobEffect{

    public BlindnessEffect(MobEffectCategory pCategory, int pColor){
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity target, int amplifier){
        FogHandler.setCustomFog(true);

        LocalPlayer player = Minecraft.getInstance().player;
        MobEffectInstance effectInstance = player.getEffect(ModEffects.BLINDNESS_EFFECT.getHolder().get());

        if(effectInstance.getDuration() == 1 || effectInstance.getDuration() == 2 || effectInstance.getDuration() == 0){
            FogHandler.setCustomFog(false);
        }
        
        return super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }
}
