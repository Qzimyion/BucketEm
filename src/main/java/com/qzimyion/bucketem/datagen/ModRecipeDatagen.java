package com.qzimyion.bucketem.datagen;

import com.qzimyion.bucketem.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeDatagen extends FabricRecipeProvider {
    public ModRecipeDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SLIME_BALL, 3).input(ModItems.SLIME_BOTTLE).criterion("has_bottle", RecipeProvider.conditionsFromItem(Items.SLIME_BALL)).offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.MAGMA_CREAM, 3).input(ModItems.MAGMA_CUBE_BOTTLE).criterion("has_bottle", RecipeProvider.conditionsFromItem(Items.MAGMA_CREAM)).offerTo(exporter);
    }
}
