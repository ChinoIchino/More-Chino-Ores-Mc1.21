package com.Chino.MoreChinoOres.dataGen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.block.ModBlocks;
import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends RecipeProvider{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> pRegistries){
        super(output, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput){
        //Material
        //PYRONITE_STICK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PYRONITE_STICK.get())
            .pattern(" A ")
            .pattern("ABA")
            .pattern(" A ")
            .define('A', ModItems.PYRONITE_SHARD.get())
            .define('B', Items.STICK)
            .unlockedBy(getHasName(ModItems.PYRONITE_SHARD.get()), has(ModItems.PYRONITE_SHARD.get())).save(pRecipeOutput);
        //PYRONITE_FROM_PYRONITE_BLOCK
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PYRONITE.get(), 9)
            .requires(ModBlocks.PYRONITE_BLOCK.get(), 1)
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get()))
            //need to add a id to avoid bugs with different crafts giving the same result
            .save(pRecipeOutput, MoreChinoOresApp.MODID + ":pyronite_from_pyronite_block");
        //PYRONITE FROM PYRONITE_SHARD 
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PYRONITE.get())
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', ModItems.PYRONITE_SHARD.get())
            //unlocked the recipe when a pyronite ingot is in the inventory
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_SHARD FROM PYRONITE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PYRONITE_SHARD.get(), 9)
            .requires(ModItems.PYRONITE.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);

        //CONTAINERS
        //CONTAINER EMPTY
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONTAINER_EMPTY.get(), 1)
            .pattern(" B ")
            .pattern("ACA")
            .pattern(" B ")
            .define('A', Items.DIAMOND)
            .define('B', Items.COPPER_BLOCK)
            .define('C', Items.GLASS)
            .unlockedBy(getHasName(ModItems.PYRONITE_SWORD.get()), has(ModItems.PYRONITE_SWORD.get())).save(pRecipeOutput);
        //CONTAINER WITH FIRE SHARD
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONTAINER_FULL_FIRE.get(), 1)
            .pattern("ACA")
            .pattern("ABA")
            .pattern("AAA")
            .define('A', Items.BLAZE_ROD)
            .define('B', ModItems.CONTAINER_EMPTY.get())
            .define('C', ModItems.SHARD_FIRE.get())
            .unlockedBy(getHasName(ModItems.SHARD_FIRE.get()), has(ModItems.SHARD_FIRE.get())).save(pRecipeOutput);
        //CONTAINER WITH WITHER SHARD
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONTAINER_FULL_WITHER.get(), 1)
            .pattern("AAA")
            .pattern("BCD")
            .pattern("EEE")
            .define('A', Items.BONE)
            .define('B', Items.WITHER_SKELETON_SKULL)
            .define('C', ModItems.CONTAINER_EMPTY.get())
            .define('D', ModItems.SHARD_WITHER.get())
            .define('E', Items.SOUL_SAND)
            .unlockedBy(getHasName(ModItems.SHARD_WITHER.get()), has(ModItems.SHARD_WITHER.get())).save(pRecipeOutput);
        //CONTAINER WITH SLOWNESS SHARD
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CONTAINER_FULL_SLOWNESS.get(), 1)
            .pattern("ACA")
            .pattern("ABA")
            .pattern("AAA")
            .define('A', Items.ROTTEN_FLESH)
            .define('B', ModItems.CONTAINER_EMPTY.get())
            .define('C', ModItems.SHARD_SLOWNESS.get())
            .unlockedBy(getHasName(ModItems.SHARD_SLOWNESS.get()), has(ModItems.SHARD_SLOWNESS.get())).save(pRecipeOutput);
        //Blocks
        //PYRONITE_BLOCK
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PYRONITE_BLOCK.get())
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', ModItems.PYRONITE.get())
            //unlocked the recipe when a pyronite ingot is in the inventory
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);


        //Tools
        //PYRONITE_SWORD
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PYRONITE_SWORD.get())
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" B ")
            .define('A', ModItems.PYRONITE.get())
            .define('B', ModItems.PYRONITE_STICK.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_SWORD_FIRE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.PYRONITE_SWORD_MODIFIER_FIRE.get())
            .requires(ModItems.CONTAINER_FULL_FIRE.get(), 1)
            .requires(ModItems.PYRONITE_SWORD.get(), 1)
            .unlockedBy(getHasName(ModItems.SHARD_FIRE.get()), has(ModItems.SHARD_FIRE.get())).save(pRecipeOutput);
        //PYRONITE_SWORD_WITHER
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.PYRONITE_SWORD_MODIFIER_WITHER.get())
            .requires(ModItems.CONTAINER_FULL_WITHER.get(), 1)
            .requires(ModItems.PYRONITE_SWORD.get(), 1)
            .unlockedBy(getHasName(ModItems.SHARD_WITHER.get()), has(ModItems.SHARD_WITHER.get())).save(pRecipeOutput);
        //PYRONITE_SWORD_SLOWNESS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.COMBAT, ModItems.PYRONITE_SWORD_MODIFIER_SLOWNESS.get())
            .requires(ModItems.CONTAINER_FULL_SLOWNESS.get(), 1)
            .requires(ModItems.PYRONITE_SWORD.get(), 1)
            .unlockedBy(getHasName(ModItems.SHARD_SLOWNESS.get()), has(ModItems.SHARD_SLOWNESS.get())).save(pRecipeOutput);
        //PYRONITE_PICKAXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRONITE_PICKAXE.get())
            .pattern("AAA")
            .pattern(" B ")
            .pattern(" B ")
            .define('A', ModItems.PYRONITE.get())
            .define('B', ModItems.PYRONITE_STICK.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_AXE
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.PYRONITE_AXE.get())
            .pattern("AA ")
            .pattern("AB ")
            .pattern(" B ")
            .define('A', ModItems.PYRONITE.get())
            .define('B', ModItems.PYRONITE_STICK.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);

        //PYRONITE_ARMOR
        //PYRONITE_HELMET
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PYRONITE_HELMET.get())
            .pattern("AAA")
            .pattern("A A")
            .define('A', ModItems.PYRONITE.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_CHESTPLATE
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PYRONITE_CHESTPLATE.get())
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', ModItems.PYRONITE.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_LEGGINGS
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PYRONITE_LEGGINGS.get())
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .define('A', ModItems.PYRONITE.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);
        //PYRONITE_BOOTS
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.PYRONITE_BOOTS.get())
            .pattern("A A")
            .pattern("A A")
            .define('A', ModItems.PYRONITE.get())
            .unlockedBy(getHasName(ModItems.PYRONITE.get()), has(ModItems.PYRONITE.get())).save(pRecipeOutput);

        //SMELTING AND BLASTING
        List<ItemLike> PYRONITE_SMELTABLES = List.of(ModItems.PYRONITE_RAW.get());

        oreSmelting(pRecipeOutput, PYRONITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRONITE.get(), 0.25f, 200, "pyronite");
        oreBlasting(pRecipeOutput, PYRONITE_SMELTABLES, RecipeCategory.MISC, ModItems.PYRONITE.get(), 0.25f, 100, "pyronite");

    }

        protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
        }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
        }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MoreChinoOresApp.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    
    }

}
