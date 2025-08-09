package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

public class PyroniteSwordModifierFire extends SwordItem {
    private static int TICK_DURATION_Of_EFFECT = 60;

    public PyroniteSwordModifierFire(Tier tier, Item.Properties properties){
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        final int fireTicksBeforeAttack = target.getRemainingFireTicks(); 

        target.setRemainingFireTicks(fireTicksBeforeAttack + TICK_DURATION_Of_EFFECT);
        
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_fire.shift_down"));
        }else{
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
        }
        super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
    }
}