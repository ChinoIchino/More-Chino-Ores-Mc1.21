package com.Chino.MoreChinoOres.entity.custom;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class RedJellyEntity extends Slime {
    private static double ATTACK_DAMAGE = 5.0f;
    private static double ATTACK_KNOCKBACK = 2.0f;
    private static double FALL_DAMAGE_MULTIPLIER = 0.1f;
    private static double SAFE_FALL_DISTANCE = 4.0f;
    private static double MAX_HEALTH = 15.0f;
    private static double ARMOR = 5.0f;
    private static double ARMOR_TOUGHNESS = 6.0f;

    public final AnimationState jumpAnimationState = new AnimationState();
    public int jumpAnimationCooldown = 3;

    public RedJellyEntity(EntityType<? extends Slime> pEntityType, Level pLevel){
        super(pEntityType, pLevel);
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Animal.createLivingAttributes()
            .add(Attributes.ATTACK_DAMAGE, ATTACK_DAMAGE)
            .add(Attributes.ATTACK_KNOCKBACK, ATTACK_KNOCKBACK)
            .add(Attributes.FALL_DAMAGE_MULTIPLIER, FALL_DAMAGE_MULTIPLIER)
            .add(Attributes.SAFE_FALL_DISTANCE, SAFE_FALL_DISTANCE)
            .add(Attributes.MAX_HEALTH, MAX_HEALTH)
            .add(Attributes.ARMOR, ARMOR)
            .add(Attributes.ARMOR_TOUGHNESS, ARMOR_TOUGHNESS)
            .add(Attributes.BURNING_TIME, 0f);
    }

    @Override
    public boolean isOnFire(){
        return false;
    }

    // private void setupAnimationStates(){
    //     if(this.jumpAnimationCooldown <= 0){
    //         this.jumpAnimationCooldown = 100;
    //         this.jumpAnimationState.start(this.tickCount);
    //     }else{
    //         --this.jumpAnimationCooldown;
    //     }
    // }

    // @Override
    // public void tick(){
    //     super.tick();

    //     if(this.level().isClientSide()){
    //         this.setupAnimationStates();
    //     }
    // }
}
