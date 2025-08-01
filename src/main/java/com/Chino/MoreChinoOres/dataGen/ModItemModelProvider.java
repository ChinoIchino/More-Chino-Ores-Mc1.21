package com.Chino.MoreChinoOres.dataGen;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider{
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, MoreChinoOresApp.MODID, exFileHelper);
    }

    @Override
    protected void registerModels(){
        basicItem(ModItems.PYRONITE.get());
        basicItem(ModItems.PYRONITE_RAW.get());
        basicItem(ModItems.PYRONITE_SHARD.get());
        basicItem(ModItems.PYRONITE_STICK.get());

        handHeldItem(ModItems.PYRONITE_SWORD);
        handHeldItem(ModItems.PYRONITE_PICKAXE);
        handHeldItem(ModItems.PYRONITE_AXE);
    }

    //used so the item is held in game like a tool
    private ItemModelBuilder handHeldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
            ResourceLocation.parse("item/handheld")).texture("layer0",
            ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, "item/" + item.getId().getPath()));
    }
}
