package com.qzimyion.bucketem.dispenser;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.dispenser.behaviors.BookBehavior;
import com.qzimyion.bucketem.dispenser.behaviors.BottleBehavior;
import com.qzimyion.bucketem.dispenser.behaviors.MagmaCubeBottleBehavior;
import com.qzimyion.bucketem.dispenser.behaviors.SlimeBottleBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;

import static com.qzimyion.bucketem.items.ModItems.*;

public class DispenserBehaviorRegistry {

    public static void registerDispenserBehavior(){
        //Buckets
        DispenserBlock.registerBehavior(STRIDER_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(SQUID_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(GLOW_SQUID_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TEMPERATE_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TROPICAL_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TUNDRA_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TURTLE_BUCKET, new ItemDispenserBehavior());

        //Books
        DispenserBlock.registerBehavior(ALLAY_POSSESSED_BOOK, new BookBehavior());
        DispenserBlock.registerBehavior(VEX_POSSESSED_BOOK, new BookBehavior());

        //Bottles
        DispenserBlock.registerBehavior(BEE_BOTTLE, new BottleBehavior());
        DispenserBlock.registerBehavior(SILVERFISH_BOTTLE, new BottleBehavior());
        DispenserBlock.registerBehavior(ENDERMITE_BOTTLE, new BottleBehavior());
        DispenserBlock.registerBehavior(SLIME_BOTTLE, new SlimeBottleBehavior());
        DispenserBlock.registerBehavior(MAGMA_CUBE_BOTTLE, new MagmaCubeBottleBehavior());

        Bucketem.LOGGER.info("Registering mod Dispenser Behaviors");
    }
}
