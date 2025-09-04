package com.Chino.MoreChinoOres.dataGen;

import java.util.concurrent.CompletableFuture;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.ModItems;
import com.Chino.MoreChinoOres.loot.AddItemModifier;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider{
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries){
        super(output, MoreChinoOresApp.MODID, registries);
    } 

    @Override
    protected void start(HolderLookup.Provider registries){
        // add("wind_shards_from_creeper",
        //     new AddItemModifier(new LootItemCondition[]{
        //         new LootTableIdCondition.Builder(ResourceLocation.withDefaultNamespace("entities/creeper"))
        //             .and(LootItemRandomChanceCondition.randomChance(0.25f)).build()
        //     }, ModItems.SHARD_WIND.get()));
    }
}
