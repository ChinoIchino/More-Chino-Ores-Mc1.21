package com.Chino.MoreChinoOres.dataGen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider{
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture,
        CompletableFuture<TagLookup<Block>> lookupComletableFuture, @Nullable ExistingFileHelper exFileHelper){
            super(output, completableFuture, lookupComletableFuture, MoreChinoOresApp.MODID, exFileHelper);
        }

    //TODO to see the use
    @Override
    protected void addTags(HolderLookup.Provider pProvider){
    }
    
}
