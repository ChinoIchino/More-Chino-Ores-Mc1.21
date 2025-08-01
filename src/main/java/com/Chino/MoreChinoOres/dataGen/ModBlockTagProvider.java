package com.Chino.MoreChinoOres.dataGen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.block.ModBlocks;
import com.Chino.MoreChinoOres.util.ModTags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagProvider extends BlockTagsProvider{
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper exFileHelper){
        super(output, lookupProvider, MoreChinoOresApp.MODID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider){
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.PYRONITE_BLOCK.get())
            .add(ModBlocks.PYRONITE_ORE_BLOCK.get())
            .add(ModBlocks.PYRONITE_DEEPSLATE_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.PYRONITE_DEEPSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.PYRONITE_BLOCK.get())
            .add(ModBlocks.PYRONITE_ORE_BLOCK.get());
    
        tag(ModTags.Blocks.NEEDS_PYRONITE_TOOL)
            .add(ModBlocks.PYRONITE_BLOCK.get())
            .add(ModBlocks.PYRONITE_ORE_BLOCK.get())
            .add(ModBlocks.PYRONITE_DEEPSLATE_ORE.get())
            .add(Blocks.SOUL_SAND)
            .add(Blocks.SOUL_SOIL)
            .add(Blocks.MAGMA_BLOCK)
            .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_PYRONITE_TOOL)
            .remove(ModTags.Blocks.NEEDS_PYRONITE_TOOL)
            //Most common overworld underground blocks found (ore isnt included)
            .add(Blocks.STONE)
            .add(Blocks.COBBLESTONE)
            .add(Blocks.MOSSY_COBBLESTONE)
            .add(Blocks.ANDESITE)
            .add(Blocks.DIORITE)
            .add(Blocks.GRANITE)
            .add(Blocks.DEEPSLATE)
            .add(Blocks.TUFF)
            .add(Blocks.TUFF_BRICK_STAIRS)
            .add(Blocks.TUFF_BRICK_SLAB)
            .add(Blocks.TUFF_BRICK_WALL)
            .add(Blocks.POLISHED_TUFF)
            .add(Blocks.POLISHED_TUFF_SLAB)
            .add(Blocks.POLISHED_TUFF_STAIRS)
            .add(Blocks.POLISHED_TUFF_WALL)
            .add(Blocks.CHISELED_TUFF)
            .add(Blocks.CHISELED_TUFF_BRICKS)
            .add(Blocks.CALCITE)
            .add(Blocks.DRIPSTONE_BLOCK)
            .add(Blocks.SMOOTH_BASALT);
    }

}

