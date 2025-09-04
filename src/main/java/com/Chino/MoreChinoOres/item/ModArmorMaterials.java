package com.Chino.MoreChinoOres.item;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {
    //PYRONITE ARMOR STATS
    private static int HELMET_DEFENSE = 3;
    private static int CHESTPLATE_DEFENSE = 7;
    private static int LEGGINGS_DEFENSE = 5;
    private static int BOOTS_DEFENSE = 3;
    private static int OVERALL_DEFENSE = 8; 

    private static int ENCHANTABILITY_OF_PYRONITE_ARMOR = 12;
    private static float TOUGHNESS_OF_PYRONITE_ARMOR = 3f;
    private static float KNOCKBACK_RESISTANCE = 0.1f; // 0.1 = +1 armor Knockback Resistance in game

    private static int TIER1_BLINDFOLD_DEFENSE = 1;

    private static int ENCHANTABILITY_OF_TIER1_BLINDFOLD = 10;
    private static float TOUGHNESS_OF_TIER1_BLINDFOLD = 1f;
    private static float KNOCKBACK_RESISTANCE_OF_TIER1_BLINDFOLD = 0f;

    public static final Holder<ArmorMaterial> PYRONITE_ARMOR_MATERIAL = register("pyronite", Util.make(new EnumMap<>(ArmorItem.Type.class),
        attribute ->{
            attribute.put(ArmorItem.Type.HELMET, HELMET_DEFENSE);
            attribute.put(ArmorItem.Type.CHESTPLATE, CHESTPLATE_DEFENSE);
            attribute.put(ArmorItem.Type.LEGGINGS, LEGGINGS_DEFENSE);
            attribute.put(ArmorItem.Type.BOOTS, BOOTS_DEFENSE);
            attribute.put(ArmorItem.Type.BODY, OVERALL_DEFENSE);
        }), ENCHANTABILITY_OF_PYRONITE_ARMOR, TOUGHNESS_OF_PYRONITE_ARMOR, KNOCKBACK_RESISTANCE, ()-> ModItems.PYRONITE.get());

    public static final Holder<ArmorMaterial> TIER1_BLINDFOLD = register("tier1_blindfold", Util.make(new EnumMap<>(ArmorItem.Type.class),
        attribute ->{
            attribute.put(ArmorItem.Type.HELMET, TIER1_BLINDFOLD_DEFENSE);
        }), ENCHANTABILITY_OF_TIER1_BLINDFOLD, TOUGHNESS_OF_TIER1_BLINDFOLD, KNOCKBACK_RESISTANCE_OF_TIER1_BLINDFOLD, null);


        private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtection,
                                                  int enchantability, float toughness, float knockbackResistance,
                                                  Supplier<Item> ingredientItem) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, name);
        Holder<SoundEvent> equipSound = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> ingredient = () -> Ingredient.of(ingredientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtection.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, location,
                new ArmorMaterial(typeProtection, enchantability, equipSound, ingredient, layers, toughness, knockbackResistance));
    }
}
