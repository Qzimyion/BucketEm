package com.qzimyion.bucketem.potions;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.items.ModItems;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.entry.RegistryEntry;

public class ModPotionRecipeRegistry {
    public static void registerPotionRecipes(BrewingRecipeRegistry.Builder builder){
        builder.registerPotionRecipe(Potions.AWKWARD, ModItems.SLIME_BOTTLE, Potions.LEAPING);
        builder.registerPotionRecipe(Potions.NIGHT_VISION, ModItems.MAGMA_CUBE_BOTTLE, (RegistryEntry<Potion>) ModPotionsRegistry.BLISTERED_VISION_SHORT);
        builder.registerPotionRecipe(Potions.LONG_NIGHT_VISION, ModItems.MAGMA_CUBE_BOTTLE, (RegistryEntry<Potion>) ModPotionsRegistry.BLISTERED_VISION_LONG);
        builder.registerPotionRecipe((RegistryEntry<Potion>)ModPotionsRegistry.BLISTERED_VISION_SHORT, Items.REDSTONE, (RegistryEntry<Potion>)ModPotionsRegistry.BLISTERED_VISION_LONG);

        Bucketem.LOGGER.info("Registering mod Potion Recipes");
    }
}
