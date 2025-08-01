package com.Chino.MoreChinoOres.item.custom;

import java.util.List;

import com.Chino.MoreChinoOres.util.ModTags;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.BlockState;

public class PyronitePickaxeItem extends PickaxeItem{
    public PyronitePickaxeItem(Tier tier, Item.Properties properties){
        super(tier, properties);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state){
        //if the item is in the list of incorrect for pyronite, the speed of mining is forced to a slow mine
        if(state.is(ModTags.Blocks.INCORRECT_FOR_PYRONITE_TOOL)){
            return 0.1F;
        }
        return super.getDestroySpeed(stack, state);
    }
    
    @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            if(Screen.hasShiftDown()){
                //for line break, just need to add another component
                toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_pickaxe.shift_down"));
            }else{
                toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_pickaxe.shift_up"));
            }
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
}