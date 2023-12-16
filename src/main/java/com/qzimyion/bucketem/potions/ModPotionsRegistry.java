package com.qzimyion.bucketem.potions;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.items.ModItems;
import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotionsRegistry {

    public static final Potion BLISTERED_VISION_SHORT = Registry.register(Registries.POTION, new Identifier(Bucketem.MOD_ID, "blistered_vision"),
            new Potion(new StatusEffectInstance(ModStatusEffectsRegistry.BLISTERED_VISION, 3600, 0)));

    public static final Potion BLISTERED_VISION_LONG = Registry.register(Registries.POTION, new Identifier(Bucketem.MOD_ID, "blistered_vision_long"),
            new Potion(new StatusEffectInstance(ModStatusEffectsRegistry.BLISTERED_VISION, 9600, 0)));

    public static void registerPotions(){


        Bucketem.LOGGER.info("Registering mod Potions");
    }

    public static void registerPotionRecipes(){
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, ModItems.SLIME_BOTTLE, Potions.LEAPING);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.NIGHT_VISION, ModItems.MAGMA_CUBE_BOTTLE, BLISTERED_VISION_SHORT);
        BrewingRecipeRegistry.registerPotionRecipe(Potions.LONG_NIGHT_VISION, ModItems.MAGMA_CUBE_BOTTLE, BLISTERED_VISION_LONG);
        BrewingRecipeRegistry.registerPotionRecipe(BLISTERED_VISION_SHORT, Items.REDSTONE, BLISTERED_VISION_LONG);

        Bucketem.LOGGER.info("Registering mod Potion Recipes");
    }
}
