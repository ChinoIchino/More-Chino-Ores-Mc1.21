package com.Chino.MoreChinoOres.item;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.block.ModBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MoreChinoOresApp.MODID);

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
    
    //Creative tabs for items
    public static final RegistryObject<CreativeModeTab> MORE_CHINO_ORES_ITEMS_TAB = CREATIVE_MODE_TABS.register("more_chino_ores_items_tab", 
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PYRONITE.get()))
            //the name used in the lang json
            .title(Component.translatable("creativetab.more_chino_ores.pyronite_items"))
            .displayItems((itemDisplayParameters, output) ->{
                //Materials
                output.accept(ModItems.PYRONITE_RAW.get());
                output.accept(ModItems.PYRONITE_SHARD.get());
                output.accept(ModItems.PYRONITE.get());
                output.accept(ModItems.PYRONITE_STICK.get());

                //Containers
                output.accept(ModItems.CONTAINER_EMPTY.get());
                output.accept(ModItems.CONTAINER_FULL_FIRE.get());
                output.accept(ModItems.CONTAINER_FULL_WITHER.get());
                output.accept(ModItems.CONTAINER_FULL_SLOWNESS.get());
                output.accept(ModItems.CONTAINER_FULL_WIND.get());

                //Shards
                output.accept(ModItems.SHARD_FIRE.get());
                output.accept(ModItems.SHARD_WITHER.get());
                output.accept(ModItems.SHARD_SLOWNESS.get());
                output.accept(ModItems.SHARD_WIND.get());
                
                //Tools
                output.accept(ModItems.PYRONITE_SWORD.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_FIRE.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_WITHER.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_SLOWNESS.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_REGENERATION.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_TESTPURPOSE.get());
                output.accept(ModItems.PYRONITE_SWORD_MODIFIER_WIND.get());
                output.accept(ModItems.PYRONITE_PICKAXE.get());
                output.accept(ModItems.PYRONITE_AXE.get());

                //Armor
                output.accept(ModItems.PYRONITE_HELMET.get());
                output.accept(ModItems.PYRONITE_CHESTPLATE.get());
                output.accept(ModItems.PYRONITE_LEGGINGS.get());
                output.accept(ModItems.PYRONITE_BOOTS.get());
                output.accept(ModItems.RAG_BLINDFOLD.get());
            })
        .build());

    //Creative tab for blocks
    public static final RegistryObject<CreativeModeTab> MORE_CHINO_ORES_BLOCKS_TAB = CREATIVE_MODE_TABS.register("more_chino_ores_blocks_tab", 
        () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.PYRONITE_BLOCK.get()))
            //force the block tab to be created right after the MCO items tab (MCO = More Chino Ores)
            .withTabsBefore(MORE_CHINO_ORES_ITEMS_TAB.getId())
            .title(Component.translatable("creativetab.more_chino_ores.pyronite_blocks"))
            .displayItems((itemDisplayParameters, output) ->{
                //Pyronite Blocks
                output.accept(ModBlocks.PYRONITE_ORE_BLOCK.get());
                output.accept(ModBlocks.PYRONITE_DEEPSLATE_ORE.get());
                output.accept(ModBlocks.PYRONITE_BLOCK.get());
            })
        .build());
}
