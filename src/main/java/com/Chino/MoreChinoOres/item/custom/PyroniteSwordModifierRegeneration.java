package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

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

public class PyroniteSwordModifierRegeneration extends SwordItem {
    private static int TICK_DURATION_Of_EFFECT = 20;
    private static int AMPLIFIER_OF_EFFECT = 4;
    private int cooldownOfEffect;

    public PyroniteSwordModifierRegeneration(Tier tier, Item.Properties properties){
        super(tier, properties);
        this.cooldownOfEffect = 0;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker){
        if(this.cooldownOfEffect <= 0){
            //equivalent of 2 Hearth of regen every 4rd Hit
            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, TICK_DURATION_Of_EFFECT, AMPLIFIER_OF_EFFECT));
            this.cooldownOfEffect = 3;
        }else{
            this.cooldownOfEffect--;
        }
        
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
        if(Screen.hasShiftDown()){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_sword_modifier_regeneration.shift_down"));
        }else{
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
        }
        super.appendHoverText(stack, context, toolTipComponent, tooltipFlag);
    }
}