package com.qzimyion.bucketem.dispenser.behaviors;

import com.qzimyion.bucketem.items.NewItems.EntityBook;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;

public class BookBehavior extends ItemDispenserBehavior {

    @Override
    protected ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        Direction direction = pointer.state().get(DispenserBlock.FACING);
        EntityType<?> entitytype = ((EntityBook) stack.getItem()).getType(stack.getNbt());
        entitytype.spawnFromItemStack(pointer.world(), stack, null, pointer.pos().offset(direction), SpawnReason.DISPENSER, direction != Direction.UP, false);
        return new ItemStack(Items.BOOK);
    }
}
