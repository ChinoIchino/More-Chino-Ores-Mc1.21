package com.Chino.MoreChinoOres.dataGen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.worldgen.ModBiomeModifiers;
import com.Chino.MoreChinoOres.worldgen.ModConfiguredFeatures;
import com.Chino.MoreChinoOres.worldgen.ModPlacedFeatures;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class ModDatapackEntries extends DatapackBuiltinEntriesProvider{

    public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries){
        super(output, registries, BUILDER, Set.of(MoreChinoOresApp.MODID));
    }
    
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);
    
}

    // public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()

    //         .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
    //         .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
    //         .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    // public ModDatapackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
    //     super(output, registries, BUILDER, Set.of(TutorialMod.MOD_ID));
    // }
