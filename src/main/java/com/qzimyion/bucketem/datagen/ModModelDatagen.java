package com.qzimyion.bucketem.datagen;

import com.qzimyion.bucketem.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

import static com.qzimyion.bucketem.items.ModItems.*;

public class ModModelDatagen extends FabricModelProvider {
    public ModModelDatagen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(STRIDER_BUCKET, Models.GENERATED);
        itemModelGenerator.register(SQUID_BUCKET, Models.GENERATED);
        itemModelGenerator.register(GLOW_SQUID_BUCKET, Models.GENERATED);
        itemModelGenerator.register(TEMPERATE_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(TROPICAL_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(TUNDRA_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(DRY_TEMPERATE_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(DRY_TROPICAL_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(DRY_TUNDRA_FROG_BUCKET, Models.GENERATED);
        itemModelGenerator.register(ALLAY_POSSESSED_BOOK, Models.GENERATED);
        itemModelGenerator.register(VEX_POSSESSED_BOOK, Models.GENERATED);
        itemModelGenerator.register(BEE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(SILVERFISH_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ENDERMITE_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(SLIME_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(MAGMA_CUBE_BOTTLE, Models.GENERATED);
    }
}
