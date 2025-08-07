package com.Chino.MoreChinoOres.util;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_PYRONITE_TOOL = createTag("needs_pyronite_tool");
        public static final TagKey<Block> INCORRECT_FOR_PYRONITE_TOOL = createTag("incorrect_for_pyronite_tool");

        private static TagKey<Block> createTag(String name){
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, name));
        }
    }
}
