package com.Chino.MoreChinoOres.item;

import com.Chino.MoreChinoOres.util.ModTags;

import net.minecraft.world.item.Tier;
import net.minecraftforge.common.ForgeTier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModToolTiers {
    //uses, speed, attack dmg bonus, enchantment value
    public static final Tier PYRONITE = new ForgeTier(10000, 14.0f, 3.5f, 20,
        ModTags.Blocks.NEEDS_PYRONITE_TOOL, () -> Ingredient.of(ModItems.PYRONITE.get()),
        ModTags.Blocks.INCORRECT_FOR_PYRONITE_TOOL
    );
}
