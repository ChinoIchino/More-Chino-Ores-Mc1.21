package com.Chino.MoreChinoOres.effect;

import com.Chino.MoreChinoOres.util.FogHandler;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class DebugEffect extends MobEffect{
    public DebugEffect(MobEffectCategory pCategory, int pColor){
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity target, int amplifier){
        FogHandler.setCustomFog(false);


        return super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }
    
}
