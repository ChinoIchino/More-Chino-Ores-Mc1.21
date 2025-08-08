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
    static int HELMET_DEFENSE = 3;
    static int CHESTPLATE_DEFENSE = 7;
    static int LEGGINGS_DEFENSE = 5;
    static int BOOTS_DEFENSE = 3;
    static int OVERALL_DEFENSE = 8;

    static int ENCHANTABILITY_OF_PYRONITE_ARMOR = 12;
    static float TOUGHNESS_OF_PYRONITE_ARMOR = 3f;
    static float KNOCKBACK_RESISTANCE = 0.1f; // 0.1 = +1 armor Knockback Resistance in game

    public static final Holder<ArmorMaterial> PYRONITE_ARMOR_MATERIAL = register("pyronite", Util.make(new EnumMap<>(ArmorItem.Type.class),
        attribute ->{
            attribute.put(ArmorItem.Type.HELMET, HELMET_DEFENSE);
            attribute.put(ArmorItem.Type.CHESTPLATE, CHESTPLATE_DEFENSE);
            attribute.put(ArmorItem.Type.LEGGINGS, LEGGINGS_DEFENSE);
            attribute.put(ArmorItem.Type.BOOTS, BOOTS_DEFENSE);
            attribute.put(ArmorItem.Type.BODY, OVERALL_DEFENSE);
        }), ENCHANTABILITY_OF_PYRONITE_ARMOR, TOUGHNESS_OF_PYRONITE_ARMOR, KNOCKBACK_RESISTANCE, ()-> ModItems.PYRONITE.get());


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
