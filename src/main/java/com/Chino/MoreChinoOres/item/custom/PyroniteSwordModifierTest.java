package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
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

public class PyroniteSwordModifierTest extends SwordItem {
    private static double REACH_OF_LIGHTNING_BOLT = 4.0D;

    private int cooldown;

    public PyroniteSwordModifierTest(Tier tier, Item.Properties properties){
        super(tier, properties);
        this.cooldown = 0;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        this.cooldown--;

        //used in a older version of the mod, maybe ill find use for it
        // if(target.isInWater() && (this.cooldown <= 0)){
        //     if(attacker.isInWater()){
        //         attacker.hurt(attacker.damageSources().lightningBolt(), DAMAMGE_TO_ATTACKER);
        //     }
        //     sendLightningBolt(target);
        //     this.cooldown = 2;
        // }else if(target.isInWaterOrRain() && (this.cooldown <= 0)){
        //     sendLightningBolt(target);
        //     this.cooldown = 2;
        // }else{
        //     this.cooldown--;
        // }
        
        return super.hurtEnemy(stack, target, attacker);
    }

    private static void sendLightningBoltOnEntity(LivingEntity target){
        if(target.level() instanceof ServerLevel serverLevel){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            // lightningBolt.moveTo(Vec3.atBottomCenterOf(target.blockPosition()));
            lightningBolt.moveTo(Vec3.atCenterOf(target.blockPosition()));
            lightningBolt.setVisualOnly(false);
            serverLevel.addFreshEntity(lightningBolt);
        }
    }
    private static void sendLightningBoltOnPos(LivingEntity user, Vec3 position){
        if(user.level() instanceof ServerLevel serverLevel){
            LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, serverLevel);
            
            lightningBolt.moveTo(position);
            lightningBolt.setVisualOnly(false);
            serverLevel.addFreshEntity(lightningBolt);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_test_purpose.shift_down"));
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