package com.Chino.MoreChinoOres.effect;

import com.Chino.MoreChinoOres.util.FogHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
// import net.minecraft.client.Minecraft;
// import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
// import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class WindedEffect extends MobEffect{
    public WindedEffect(MobEffectCategory pCategory, int pColor){
        super(pCategory, pColor);
        setBlendDuration(20);
    }

    @Override
    public boolean applyEffectTick(LivingEntity target, int amplifier){
        Vec3 motionOfTarget = target.getDeltaMovement();
        //if the winded target try to jump
        if(motionOfTarget.y > 0){ //!target.onGround()){
            double windedJump = target.getDeltaMovement().y / 2;
            target.setDeltaMovement(target.getDeltaMovement().x, windedJump, target.getDeltaMovement().z);
            return true;
        }
        else if((motionOfTarget.x > 0) || (motionOfTarget.z > 0)){ //if the winded target try to move in any direction
            //nerf a tad the speed of the target
            double windedRunVX = motionOfTarget.x - (motionOfTarget.x / 100 * 20);
            double windedRunVZ = motionOfTarget.z - (motionOfTarget.z / 100 * 20);

            target.setDeltaMovement(windedRunVX, motionOfTarget.y, windedRunVZ);
        }

        FogHandler.setCustomFog(true);

        LocalPlayer player = Minecraft.getInstance().player;
        MobEffectInstance effectInstance = player.getEffect(ModEffects.WINDED_EFFECT.getHolder().get());

        if(effectInstance.getDuration() == 1 || effectInstance.getDuration() == 0){
            FogHandler.setCustomFog(false);
        }

        return super.applyEffectTick(target, amplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier){
        return true;
    }

    @Override
    public MobEffect setBlendDuration(int pBlendDuration) {
        return super.setBlendDuration(pBlendDuration);
    }

    
}
