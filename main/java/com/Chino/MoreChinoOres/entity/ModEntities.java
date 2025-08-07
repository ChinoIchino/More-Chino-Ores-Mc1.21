package com.Chino.MoreChinoOres.entity;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.entity.custom.RedJellyEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoreChinoOresApp.MODID);

    public static final RegistryObject<EntityType<RedJellyEntity>> RED_JELLY = ENTITY_TYPES.register("red_jelly", () -> EntityType.Builder.of(RedJellyEntity::new, MobCategory.MONSTER)
        .sized(1f, 1f).build("red_jelly"));

    public static void register(IEventBus eventbus){
        ENTITY_TYPES.register(eventbus);
    }
}