package com.Chino.MoreChinoOres.worldgen;

import java.util.List;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

public class ModPlacedFeatures {
    //For Pyronite Ores
    private static int VEIN_SIZE = 4;
    private static int HIGHEST_PLACE_WHERE_THE_ORE_SPAWN = 80;
    private static int LOWEST_PLACE_WHERE_THE_ORE_SPAWN = -64;

    public static final ResourceKey<PlacedFeature> PYRONITE_ORE_PLACED_KEY = registerKey("pyronite_ore_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context){
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PYRONITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PYRONITE_ORE_KEY),
            ModOrePlacement.commonOrePlacement(VEIN_SIZE, HeightRangePlacement.uniform(
                VerticalAnchor.absolute(LOWEST_PLACE_WHERE_THE_ORE_SPAWN), VerticalAnchor.absolute(HIGHEST_PLACE_WHERE_THE_ORE_SPAWN
                ))));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                    List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    
}
