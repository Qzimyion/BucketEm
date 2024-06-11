package com.qzimyion.bucketem.potions;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotionsRegistry {

    public static final RegistryEntry<Potion> BLISTERED_VISION_SHORT =
            registerPotions("blistered_vision_short", new Potion(new StatusEffectInstance
                    (ModStatusEffectsRegistry.BLISTERED_VISION, 3600, 0)));

    public static final RegistryEntry<Potion> BLISTERED_VISION_LONG =
            registerPotions("blistered_vision_long", new Potion(new StatusEffectInstance
                    (ModStatusEffectsRegistry.BLISTERED_VISION, 9600, 0)));

    private static RegistryEntry<Potion> registerPotions(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, new Identifier(name), potion);
    }

    public static void registerPotions(){
        Bucketem.LOGGER.info("Registering mod Potions");
    }
}
