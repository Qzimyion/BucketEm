package com.qzimyion.bucketem.potions.StatusEffects;

import com.qzimyion.bucketem.Bucketem;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModStatusEffectsRegistry {


    public static final RegistryEntry<StatusEffect> BLISTERED_VISION = ModStatusEffectsRegistry.register("blistered_vision", new BlisteredVision());

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, new Identifier(Bucketem.MOD_ID), statusEffect);
    }

     /*
    public static final StatusEffect BLISTERED_VISION = registerStatusEffect("blistered_vision", new BlisteredVision());

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect)
    {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Bucketem.MOD_ID, name), effect);
    }

      */

    public static void registerStatusEffects(){
        Bucketem.LOGGER.info("Registering mod Status Effects");
    }
}
