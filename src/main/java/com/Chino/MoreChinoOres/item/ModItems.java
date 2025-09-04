package com.Chino.MoreChinoOres.item;

import java.util.List;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.custom.ModArmorItem;
import com.Chino.MoreChinoOres.item.custom.PyronitePickaxeItem;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierFire;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierRegeneration;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierSlowness;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierTest;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierWind;
import com.Chino.MoreChinoOres.item.custom.PyroniteSwordModifierWither;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
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

    //Containers for modifiers
    public static final RegistryObject<Item> CONTAINER_EMPTY = ITEMS.register("container_empty", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.container_empty"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> CONTAINER_FULL_FIRE = ITEMS.register("container_full_fire", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.container_full_fire"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> CONTAINER_FULL_WITHER = ITEMS.register("container_full_wither", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.container_full_wither"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> CONTAINER_FULL_SLOWNESS = ITEMS.register("container_full_slowness", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.container_full_slowness"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> CONTAINER_FULL_WIND = ITEMS.register("container_full_wind", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.container_full_wind"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    

    //Shards
    public static final RegistryObject<Item> SHARD_FIRE = ITEMS.register("shard_fire", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shard_fire"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> SHARD_WITHER = ITEMS.register("shard_wither", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shard_wither"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
    public static final RegistryObject<Item> SHARD_SLOWNESS = ITEMS.register("shard_slowness", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shard_slowness"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });
        public static final RegistryObject<Item> SHARD_WIND = ITEMS.register("shard_wind", () -> new Item(new Item.Properties()){
        @Override
        public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
            toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shard_wind"));
            
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });

    //Tools
    public static final RegistryObject<Item> PYRONITE_SWORD = ITEMS.register("pyronite_sword",
        () -> new SwordItem(ModToolTiers.PYRONITE, new Item.Properties()
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));

    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_FIRE = ITEMS.register("pyronite_sword_modifier_fire",
        () -> new PyroniteSwordModifierFire(ModToolTiers.PYRONITE, new Item.Properties()
        .stacksTo(4)
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_WITHER = ITEMS.register("pyronite_sword_modifier_wither",
        () -> new PyroniteSwordModifierWither(ModToolTiers.PYRONITE, new Item.Properties()
        .stacksTo(2)
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_SLOWNESS = ITEMS.register("pyronite_sword_modifier_slowness",
        () -> new PyroniteSwordModifierSlowness(ModToolTiers.PYRONITE, new Item.Properties()
        .stacksTo(1)
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_REGENERATION = ITEMS.register("pyronite_sword_modifier_regeneration",
        () -> new PyroniteSwordModifierRegeneration(ModToolTiers.PYRONITE, new Item.Properties()
        .stacksTo(1)
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_TESTPURPOSE = ITEMS.register("pyronite_sword_modifier_test_purpose", 
        () -> new PyroniteSwordModifierTest(ModToolTiers.PYRONITE, new Item.Properties()
        .attributes(SwordItem.createAttributes(ModToolTiers.PYRONITE, 3, -2.4f))));
    public static final RegistryObject<Item> PYRONITE_SWORD_MODIFIER_WIND = ITEMS.register("pyronite_sword_modifier_wind", 
        () -> new PyroniteSwordModifierWind(ModToolTiers.PYRONITE, new Item.Properties()
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

    //ARMOR
    public static final RegistryObject<Item> PYRONITE_HELMET = ITEMS.register("pyronite_helmet",
        () -> new ModArmorItem(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(30))){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_armor"));
            
                    super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
                }
            });

    public static final RegistryObject<Item> RAG_BLINDFOLD = ITEMS.register("rag_blindfold", 
    () -> new ModArmorItem(ModArmorMaterials.TIER1_BLINDFOLD, ArmorItem.Type.HELMET,
        new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
                if(Screen.hasShiftDown()){
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.tier1_blindfold.shift_down"));
                }else{
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.shift_up"));
            }
            super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
        }
    });

    public static final RegistryObject<Item> PYRONITE_CHESTPLATE = ITEMS.register("pyronite_chestplate",
        () -> new ArmorItem(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(30))){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_armor"));
            
                    super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
                }
            });

    public static final RegistryObject<Item> PYRONITE_LEGGINGS = ITEMS.register("pyronite_leggings",
        () -> new ArmorItem(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(30))){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_armor"));
            
                    super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
                }
            });

    public static final RegistryObject<Item> PYRONITE_BOOTS = ITEMS.register("pyronite_boots",
        () -> new ArmorItem(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(30))){
                @Override
                public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> toolTipComponent, TooltipFlag tooltipFlag){
                    toolTipComponent.add(Component.translatable("tooltip.more_chino_ores.pyronite_armor"));
            
                    super .appendHoverText(stack, context, toolTipComponent, tooltipFlag);
                }
            });

}