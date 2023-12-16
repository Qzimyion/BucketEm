package com.qzimyion.bucketem.datagen;

import com.qzimyion.bucketem.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsDatagen extends FabricTagProvider.ItemTagProvider{
    public ModItemTagsDatagen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.BOOKSHELF_BOOKS)
                .add(ModItems.ALLAY_POSSESSED_BOOK)
                .add(ModItems.VEX_POSSESSED_BOOK);
    }
}
