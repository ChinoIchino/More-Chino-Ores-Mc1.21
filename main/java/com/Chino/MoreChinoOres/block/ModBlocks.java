package com.Chino.MoreChinoOres.block;

import java.util.function.Supplier;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    //reference 1.5f is the resistance of a stone block, 0.5 = dirt block
    static final float resistanceOfPyroniteBlock = 4f;
    static final float resistanceOfPyroniteDeepslateBlock = 5f;

    //the min and max ammount of the raw material dropped
    static final int minRawOreDrop = 2;
    static final int maxRawOreDrop = 4;

    static final int minRawDeepslateOreDrop = 3;
    static final int maxRawDeepslateOreDrop = 5;

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreChinoOresApp.MODID);

    //do not give drop yet
    public static final RegistryObject<Block> PYRONITE_ORE_BLOCK = registerBlock("pyronite_ore_block", 
        () -> new DropExperienceBlock(UniformInt.of(minRawOreDrop, maxRawOreDrop),BlockBehaviour.Properties.of()
            .strength(resistanceOfPyroniteBlock).requiresCorrectToolForDrops().sound(SoundType.STONE)
    ));

    public static final RegistryObject<Block> PYRONITE_BLOCK = registerBlock("pyronite_block", 
        () -> new Block(BlockBehaviour.Properties.of()
            .strength(resistanceOfPyroniteBlock).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)
    ));

    public static final RegistryObject<Block> PYRONITE_DEEPSLATE_ORE = registerBlock("pyronite_deepslate_ore", 
        () -> new DropExperienceBlock(UniformInt.of(minRawDeepslateOreDrop, maxRawDeepslateOreDrop), BlockBehaviour.Properties.of()
            .strength(resistanceOfPyroniteDeepslateBlock).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
    ));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //connect the item with our block
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
