package com.Chino.MoreChinoOres.item;

import java.util.List;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.custom.PyronitePickaxeItem;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreChinoOresApp.MODID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    //Materials
    public static final RegistryObject<Item> PYRONITE = ITEMS.register("pyronite", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> PYRONITE_RAW = ITEMS.register("pyronite_raw", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_raw"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> PYRONITE_SHARD = ITEMS.register("pyronite_shard", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_shard"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> PYRONITE_STICK = ITEMS.register("pyronite_stick", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_stick"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });

    //Tools
    public static final RegistryObject<Item> PYRONITE_SWORD = ITEMS.register("pyronite_sword",
        () -> new SwordItem(ModToolTiers.PYRONITE, new Item.Properties()
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));

    public static final RegistryObject<Item> PYRONITE_PICKAXE = ITEMS.register("pyronite_pickaxe", 
        () -> new PyronitePickaxeItem(ModToolTiers.PYRONITE, new Item.Properties()
        .attributes(PickaxeItem.createAttributes(ModToolTiers.PYRONITE, 1, -2.8f))));

    public static final RegistryObject<Item> PYRONITE_AXE = ITEMS.register("pyronite_axe",
        () -> new AxeItem(ModToolTiers.PYRONITE, new Item.Properties()
        .attributes(AxeItem.createAttributes(ModToolTiers.PYRONITE, 6, -3.2f))));
    // public static final RegistryObject<Item> PYRONITE_KUNAI = ITEMS.register("pyronite_kunai",
    //     () -> new BowItem(ModToolTiers.PYRONITE, new Item.Properties())
    //     .canDisableShield(null, null, null, null));

}