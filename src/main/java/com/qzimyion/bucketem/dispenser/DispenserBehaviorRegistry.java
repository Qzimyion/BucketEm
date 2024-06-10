package com.qzimyion.bucketem.dispenser;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.dispenser.behaviors.MagmaCubeBottleBehavior;
import com.qzimyion.bucketem.dispenser.behaviors.SlimeBottleBehavior;
import com.qzimyion.bucketem.items.NewItems.Bottles.EntityBottle;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;

import static com.qzimyion.bucketem.items.ModItems.*;

public class DispenserBehaviorRegistry {

    public static void registerDispenserBehavior(){

        ItemDispenserBehavior BottleDispenserBehavior = new ItemDispenserBehavior(){
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                Direction direction = pointer.state().get(DispenserBlock.FACING);
                EntityType<?> entitytype = ((EntityBottle) stack.getItem()).getEntityType(stack);
                entitytype.spawnFromItemStack(pointer.world(), stack, null, pointer.pos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                return new ItemStack(Items.GLASS_BOTTLE);
            }
        };
        ItemDispenserBehavior BookDispenserBehavior = new ItemDispenserBehavior(){
            @Override
            protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                Direction direction = pointer.state().get(DispenserBlock.FACING);
                EntityType<?> entitytype = ((EntityBottle) stack.getItem()).getEntityType(stack);
                entitytype.spawnFromItemStack(pointer.world(), stack, null, pointer.pos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
                return new ItemStack(Items.BOOK);
            }
        };

        //Buckets
        DispenserBlock.registerBehavior(STRIDER_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(SQUID_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(GLOW_SQUID_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TEMPERATE_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TROPICAL_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TUNDRA_FROG_BUCKET, new ItemDispenserBehavior());
        DispenserBlock.registerBehavior(TURTLE_BUCKET, new ItemDispenserBehavior());

        //Books
        DispenserBlock.registerBehavior(ALLAY_POSSESSED_BOOK, BookDispenserBehavior);
        DispenserBlock.registerBehavior(VEX_POSSESSED_BOOK, BookDispenserBehavior);

        //Bottles
        DispenserBlock.registerBehavior(BEE_BOTTLE, BottleDispenserBehavior);
        DispenserBlock.registerBehavior(SILVERFISH_BOTTLE, BottleDispenserBehavior);
        DispenserBlock.registerBehavior(ENDERMITE_BOTTLE, BottleDispenserBehavior);
        DispenserBlock.registerBehavior(SLIME_BOTTLE, new SlimeBottleBehavior());
        DispenserBlock.registerBehavior(MAGMA_CUBE_BOTTLE, new MagmaCubeBottleBehavior());

        Bucketem.LOGGER.info("Registering mod Dispenser Behaviors");
    }
}
