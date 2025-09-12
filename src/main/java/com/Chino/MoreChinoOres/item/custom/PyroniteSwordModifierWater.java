package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class PyroniteSwordModifierWater extends SwordItem {
    private static int TIME_OF_RAIN_IN_TICKS = 300;
    private static int COOLDOWN_OF_ABILITY = 2400;

    private float damageOfSplash = 3.0F;

    public PyroniteSwordModifierWater(Tier tier, Item.Properties properties){
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if(attacker.isInWaterOrRain()){
            double radius = 3.0D;
            Vec3 center = target.position();

            AABB area = new AABB(
                center.x - radius, center.y - radius, center.z - radius,
                center.x + radius, center.y + radius, center.z + radius
            );

            List<LivingEntity> listOfEntitiesInRadius = attacker.level().getEntitiesOfClass(LivingEntity.class, area, e -> e != attacker);

            for(LivingEntity entity : listOfEntitiesInRadius){
                entity.hurt(attacker.damageSources().drown(), damageOfSplash);

                if(entity.isOnFire()){
                    entity.clearFire();
                }

                Vec3 entityEyePosition = entity.getEyePosition();
                ((ServerLevel) entity.level()).sendParticles(ParticleTypes.SPLASH, entityEyePosition.x, entityEyePosition.y, entityEyePosition.z, 20, 0, 0, 0, 2);
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }


    @Override
    public void inventoryTick(ItemStack pStack, Level level, Entity entity, int pSlotId, boolean pIsSelected) {
        if(entity instanceof Player player && hasPlayerItemInHand(player, ModItems.PYRONITE_SWORD_MODIFIER_WATER.get())){
            Vec3 motionOfTarget = player.getDeltaMovement();
            
            if(player.isInWater()){
                if((motionOfTarget.x <= 0.25 && motionOfTarget.x >= -0.25) && (motionOfTarget.z <= 0.25 && motionOfTarget.z >= -0.25)){
                    entity.setDeltaMovement(motionOfTarget.x * 1.1, motionOfTarget.y, motionOfTarget.z * 1.1);
                }
            }else if(player.onGround() && player.isInWaterOrRain()){
                player.setDeltaMovement((motionOfTarget.x + (motionOfTarget.x / 100 * 30)), motionOfTarget.y, (motionOfTarget.z + (motionOfTarget.z / 100 * 30)));
            }
        }
    }

    private static boolean hasPlayerItemInHand(Player player, Item itemInHand){
        return player.getItemInHand(InteractionHand.MAIN_HAND).getItem() == itemInHand;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);
        if(level instanceof ServerLevel serverLevel && player.isCrouching() && level.dimension().equals(Level.OVERWORLD)){
            serverLevel.setWeatherParameters(0, TIME_OF_RAIN_IN_TICKS, true, false);

            player.getCooldowns().addCooldown(this, COOLDOWN_OF_ABILITY);
        }
        
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_water.shift_down"));
        }else{
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
        }
        super.appendHoverText(stack, context, toolTipComponent, tooltipFlag);
    }
}