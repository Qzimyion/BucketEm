package com.qzimyion.bucketem.items;

import com.qzimyion.bucketem.Bucketem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import static com.qzimyion.bucketem.items.ModItems.*;
import static com.qzimyion.bucketem.items.ModItems.VEX_POSSESSED_BOOK;
import static net.minecraft.item.Items.*;

public class ModItemGroups {

    public static void registerItemGroups(){
        ItemGroupEvents.modifyEntriesEvent(net.minecraft.item.ItemGroups.TOOLS).register(content -> {
            content.addAfter(LAVA_BUCKET, STRIDER_BUCKET);
            content.addAfter(TADPOLE_BUCKET, DRY_TEMPERATE_FROG_BUCKET, DRY_TUNDRA_FROG_BUCKET, DRY_TROPICAL_FROG_BUCKET, TEMPERATE_FROG_BUCKET, TUNDRA_FROG_BUCKET, TROPICAL_FROG_BUCKET,
                    DRY_TEMPERATE_FROG_BUCKET, DRY_TROPICAL_FROG_BUCKET, DRY_TUNDRA_FROG_BUCKET, GLOW_SQUID_BUCKET, SQUID_BUCKET, TURTLE_BUCKET);
            content.addAfter(MILK_BUCKET, BEE_BOTTLE, SILVERFISH_BOTTLE, ENDERMITE_BOTTLE, SLIME_BOTTLE, MAGMA_CUBE_BOTTLE, ALLAY_POSSESSED_BOOK, VEX_POSSESSED_BOOK);
        });


        Bucketem.LOGGER.info("Registering mod Item Groups");
    }
}
