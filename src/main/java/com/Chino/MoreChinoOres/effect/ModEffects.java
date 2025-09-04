package com.Chino.MoreChinoOres.effect;

import com.Chino.MoreChinoOres.MoreChinoOresApp;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MoreChinoOresApp.MODID);

    public static final RegistryObject<MobEffect> WINDED_EFFECT = MOB_EFFECTS.register("winded_effect",
    () -> new WindedEffect(MobEffectCategory.HARMFUL, 0xadebb3));
        // .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MoreChinoOresApp.MODID, "winded"), 
        //     -0.10f, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final RegistryObject<MobEffect> OILED_EFFECT = MOB_EFFECTS.register("oiled_effect", 
    () -> new OiledEffect(MobEffectCategory.HARMFUL, 0x281e15));

    public static final RegistryObject<MobEffect> DEBUG_EFFECT = MOB_EFFECTS.register("debug_effect", 
    () -> new DebugEffect(MobEffectCategory.NEUTRAL, 0));

    public static final RegistryObject<MobEffect> GROUNDED_EFFECT = MOB_EFFECTS.register("grounded_effect",
    () -> new GroundedEffect(MobEffectCategory.HARMFUL, 0));

    public static final RegistryObject<MobEffect> BLINDNESS_EFFECT = MOB_EFFECTS.register("blindness_effect",
    () -> new BlindnessEffect(MobEffectCategory.HARMFUL, 0));
    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
    
}
