package com.qzimyion.bucketem.potions;

import com.qzimyion.bucketem.Bucketem;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;

import static com.qzimyion.bucketem.items.ModItems.*;

public class ModPotionRecipeRegistry {
    public static void registerPotionRecipes(){

        FabricBrewingRecipeRegistryBuilder.BUILD.register(bucketemBuilder -> {
            bucketemBuilder.registerPotionRecipe(Potions.AWKWARD, Ingredient.ofItems(SLIME_BOTTLE), Potions.LEAPING);
            bucketemBuilder.registerPotionRecipe(Potions.NIGHT_VISION, Ingredient.ofItems(MAGMA_CUBE_BOTTLE), ModPotionsRegistry.BLISTERED_VISION_SHORT);
            bucketemBuilder.registerPotionRecipe(Potions.LONG_NIGHT_VISION, Ingredient.ofItems(MAGMA_CUBE_BOTTLE), ModPotionsRegistry.BLISTERED_VISION_LONG);
            bucketemBuilder.registerPotionRecipe(ModPotionsRegistry.BLISTERED_VISION_SHORT, Ingredient.ofItems(Items.REDSTONE), ModPotionsRegistry.BLISTERED_VISION_LONG);
        });

        Bucketem.LOGGER.info("Registering mod Potion Recipes");
    }
}