package com.qzimyion.bucketem.potions;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotionsRegistry {

    public static final Potion BLISTERED_VISION_SHORT = Registry.register(Registries.POTION,
            new Identifier(Bucketem.MOD_ID, "blistered_vision"),
            new Potion(new StatusEffectInstance((RegistryEntry<StatusEffect>) ModStatusEffectsRegistry.BLISTERED_VISION,
                    3600, 0)));

    public static final Potion BLISTERED_VISION_LONG = Registry.register(Registries.POTION,
            new Identifier(Bucketem.MOD_ID, "blistered_vision_long"),
            new Potion(new StatusEffectInstance((RegistryEntry<StatusEffect>) ModStatusEffectsRegistry.BLISTERED_VISION,
                    9600, 0)));

    public static void registerPotions(){
        Bucketem.LOGGER.info("Registering mod Potions");
    }
}
