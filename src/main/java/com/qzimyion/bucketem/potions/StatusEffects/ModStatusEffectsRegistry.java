package com.qzimyion.bucketem.potions.StatusEffects;

import com.qzimyion.bucketem.Bucketem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffectsRegistry {

    public static final BlisteredVision BLISTERED_VISION = new BlisteredVision();

    public static void registerStatusEffects(){
        Registry.register(Registries.STATUS_EFFECT, new Identifier(Bucketem.MOD_ID, "blistered_vision"), BLISTERED_VISION);

        Bucketem.LOGGER.info("Registering mod Status Effects");
    }
}
