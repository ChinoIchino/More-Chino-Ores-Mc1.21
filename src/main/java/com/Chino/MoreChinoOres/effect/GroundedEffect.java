package com.Chino.MoreChinoOres.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

//Only in testing, for this version it is not intended to be used
public class GroundedEffect extends MobEffect{
    public GroundedEffect(MobEffectCategory pCategory, int pColor){
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity target, int amplifier){
        target.setDeltaMovement(-1, -1, -1);
        return super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }
    
}
