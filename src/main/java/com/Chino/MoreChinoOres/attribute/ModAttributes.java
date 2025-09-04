package com.Chino.MoreChinoOres.attribute;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModAttributes {
    public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, MoreChinoOresApp.MODID);

    public static final RegistryObject<Attribute> ENTITY_REACH = ATTRIBUTES.register("entity_reach", () -> new RangedAttribute("forge.entity_reach", 3.0D, 0.0D, 1024.0D).setSyncable(true));

}

// public class ModEffects {
//     public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MoreChinoOresApp.MODID);

//     public static final RegistryObject<MobEffect> WINDED_EFFECT = MOB_EFFECTS.register("winded",
//     () -> new WindedEffect(MobEffectCategory.HARMFUL, 0xadebb3)
//         .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, "winded"), 
//             -0.10f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

//     public static void register(IEventBus eventBus){
//         MOB_EFFECTS.register(eventBus);
//     }
    
// }