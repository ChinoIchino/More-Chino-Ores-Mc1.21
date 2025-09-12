package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class PyroniteSwordModifierLightning extends SwordItem {
    private static double REACH_OF_LIGHTNING_BOLT = 4.0D;
    private static int TICK_DURATION_OF_BUFF = 60;
    private static int DAMAGE_TO_ATTACKER = 10;

    private int cooldown;

    public PyroniteSwordModifierLightning(Tier tier, Item.Properties properties){
        super(tier, properties);
        this.cooldown = 0;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        this.cooldown--;
        int roolForEffectApplied = (int) (Math.random() * 10) + 1;
        System.out.println("got the rool: " + roolForEffectApplied);
            if(roolForEffectApplied <= 2){
                //send a fake bolt on the user
                sendLightningBoltOnEntity(attacker, true);
                attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, TICK_DURATION_OF_BUFF, (roolForEffectApplied - 1), false, false));
            }else if(attacker.isInWaterOrRain()){
                sendLightningBoltOnEntity(attacker, true);
                attacker.hurt(attacker.damageSources().lightningBolt(), DAMAGE_TO_ATTACKER);
            }
        
        return super.hurtEnemy(stack, target, attacker);
    }

    private static void sendLightningBoltOnEntity(LivingEntity target, boolean visualOnly){
        if(target.level() instanceof ServerLevel serverLevel){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            
            lightningBolt.moveTo(Vec3.atBottomCenterOf(target.blockPosition()));
            lightningBolt.setVisualOnly(visualOnly);
            serverLevel.addFreshEntity(lightningBolt);
        }
    }
    private static void sendLightningBoltOnPos(LivingEntity user, Vec3 position){
        if(user.level() instanceof ServerLevel serverLevel){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            
            lightningBolt.moveTo(position);
            lightningBolt.setVisualOnly(false);
            serverLevel.addFreshEntity(lightningBolt);

            if(user.isInWaterOrRain()){
                sendLightningBoltOnEntity(user, true);
                user.hurt(user.damageSources().lightningBolt(), DAMAGE_TO_ATTACKER);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_lightning.shift_down"));
        }else{
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
        }
        super.appendHoverText(stack, context, toolTipComponent, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);

        if(!level.isClientSide && (this.cooldown <= 0)){
            sendLightningBoltOnPos(player, player.getEyePosition().add(player.getLookAngle().scale(REACH_OF_LIGHTNING_BOLT)));
            this.cooldown = 5;
        }

        return InteractionResultHolder.success(stack);
    }
}