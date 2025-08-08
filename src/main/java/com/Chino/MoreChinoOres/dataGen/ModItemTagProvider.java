package com.Chino.MoreChinoOres.dataGen;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagProvider extends ItemTagsProvider{
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture,
        CompletableFuture<TagLookup<Block>> lookupComletableFuture, @Nullable ExistingFileHelper exFileHelper){
            super(output, completableFuture, lookupComletableFuture, MoreChinoOresApp.MODID, exFileHelper);
        }

    @Override
    protected void addTags(HolderLookup.Provider pProvider){
        tag(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.PYRONITE_HELMET.get())
            .add(ModItems.PYRONITE_CHESTPLATE.get())
            .add(ModItems.PYRONITE_LEGGINGS.get())
            .add(ModItems.PYRONITE_BOOTS.get());
    }
    
}
