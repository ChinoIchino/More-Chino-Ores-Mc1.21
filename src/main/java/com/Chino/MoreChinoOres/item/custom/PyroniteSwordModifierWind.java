package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import com.Chino.MoreChinoOres.effect.ModEffects;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

public class PyroniteSwordModifierWind extends SwordItem {
    private final int TICK_DURATION_Of_WINDED = 60;

    private final int TICK_DURATION_Of_SPEED = 60;
    private final int AMPLIFIER_OF_SPEED = 0;

    public PyroniteSwordModifierWind(Tier tier, Item.Properties properties){
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        int roolForEffectApplied = (int) (Math.random() * 10) + 1;

        // 20% chance of apllying winded on target
        if(2 >= roolForEffectApplied && (!attacker.level().isClientSide)){
            target.addEffect(new MobEffectInstance(ModEffects.WINDED_EFFECT.getHolder().get(), TICK_DURATION_Of_WINDED, 0, false, true));
        }else if(roolForEffectApplied > 2 && roolForEffectApplied <= 4){ //20% chance to apply speed I to attacker
            attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, TICK_DURATION_Of_SPEED, AMPLIFIER_OF_SPEED));
        }else if(roolForEffectApplied > 4 && roolForEffectApplied <= 6){ //20% chance to extinguish fire
            attacker.clearFire();
        }

        return super.hurtEnemy(stack, target, attacker);
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_wind.shift_down"));
        }else{
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
        }
        super.appendHoverText(stack, context, toolTipComponent, tooltipFlag);
    }
}