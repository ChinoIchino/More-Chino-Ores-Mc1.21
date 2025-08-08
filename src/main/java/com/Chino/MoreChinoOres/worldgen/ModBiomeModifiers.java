package com.Chino.MoreChinoOres.worldgen;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_PYRONITE_ORE = registerKey("add_pyronite_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context){
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_PYRONITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
            //For specific biomes -> HolderSet.direct(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.PLAINS), ...),
            biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
            HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.PYRONITE_ORE_PLACED_KEY)),
            GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, name));
    }
    
}
