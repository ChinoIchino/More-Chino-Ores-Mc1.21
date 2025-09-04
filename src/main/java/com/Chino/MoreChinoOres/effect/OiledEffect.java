package com.Chino.MoreChinoOres.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class OiledEffect extends MobEffect{
    public OiledEffect(MobEffectCategory pCategory, int pColor){
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity target, int amplifier){
        if(target.isOnFire()){
            target.hurt(target.damageSources().onFire(), 1.5f);
        }else if(target.isInLava()){
            target.hurt(target.damageSources().lava(), 1.5f);
        }

        return super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }
    
}
