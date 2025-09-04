package com.Chino.MoreChinoOres.item.custom;

import com.google.common.collect.ImmutableMap;
import com.Chino.MoreChinoOres.effect.ModEffects;
import com.Chino.MoreChinoOres.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1, false, false)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide() && (hasFullSuitOfArmorOn(player) || hasHelmetOn(player))) {
            evaluateArmorEffects(player);
        }
        // else if(!level.isClientSide() && hasHelmetOn(player)){
        //     evaluateArmorEffects(player);
        // }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            //Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();


            if(hasPlayerCorrectArmorOn(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, player) || hasPlayerCorrectHelmetOn(ModArmorMaterials.TIER1_BLINDFOLD, player)) {
                addEffectToPlayer(player, mapEffect);
            }

            // if(hasPlayerCorrectArmorOn(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, player)) {
            //     addEffectToPlayer(player, mapEffect);
            // }else if(hasPlayerCorrectHelmetOn(ModArmorMaterials.TIER1_BLINDFOLD, player)){
            //     addEffectToPlayer(player, mapEffect);
            // }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect && hasPlayerCorrectArmorOn(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, player)) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }else if(hasPlayerCorrectHelmetOn(ModArmorMaterials.TIER1_BLINDFOLD, player)){
            player.addEffect(new MobEffectInstance(ModEffects.BLINDNESS_EFFECT.getHolder().get(),
                10, 0, false, false));
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasPlayerCorrectHelmetOn(Holder<ArmorMaterial> mapArmorMaterial, Player player){
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private boolean hasHelmetOn(Player player){
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty();
    }
}

/*
 * package com.Chino.MoreChinoOres.item.custom;

import com.google.common.collect.ImmutableMap;
import com.Chino.MoreChinoOres.effect.ModEffects;
import com.Chino.MoreChinoOres.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL,
                            List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 1, false, false)))
                    .put(ModArmorMaterials.TIER1_BLINDFOLD,
                            List.of(new MobEffectInstance(ModEffects.BLINDNESS_EFFECT.getHolder().get(), 20, 0, false, false)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if(!level.isClientSide() && (hasFullSuitOfArmorOn(player) || hasHelmetOn(player))) {
            evaluateArmorEffects(player);
        }
        // else if(!level.isClientSide() && hasHelmetOn(player)){
        //     evaluateArmorEffects(player);
        // }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            //Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();


            // if(hasPlayerCorrectArmorOn(mapArmorMaterial, player) || hasPlayerCorrectHelmetOn(ModArmorMaterials.TIER1_BLINDFOLD, player)) {
            //     addEffectToPlayer(player, mapEffect);
            // }

            if(hasPlayerCorrectArmorOn(ModArmorMaterials.PYRONITE_ARMOR_MATERIAL, player)) {
                addEffectToPlayer(player, mapEffect);
            }else if(hasPlayerCorrectHelmetOn(ModArmorMaterials.TIER1_BLINDFOLD, player)){
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }else if(mapEffect.stream().allMatch(effect -> player.hasEffect(ModEffects.BLINDNESS_EFFECT.getHolder().get()))){
            player.addEffect(new MobEffectInstance(ModEffects.BLINDNESS_EFFECT.getHolder().get(),
                10, 0, false, false));
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasPlayerCorrectHelmetOn(Holder<ArmorMaterial> mapArmorMaterial, Player player){
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }

    private boolean hasHelmetOn(Player player){
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty();
    }
}
 */