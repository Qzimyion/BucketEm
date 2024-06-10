package com.qzimyion.bucketem.mixin.BlockEntityMixins;

import com.qzimyion.bucketem.items.ModItems;
import net.minecraft.block.ChiseledBookshelfBlock;
import net.minecraft.block.entity.ChiseledBookshelfBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(ChiseledBookshelfBlock.class)
public class ChiseledBookshelfMixin {

    //Please add a tag for Enchanted books Mojang

    @Inject(at = @At("HEAD"), method = "tryAddBook")
    private static void tryAddBook(World world, BlockPos pos, PlayerEntity player, ChiseledBookshelfBlockEntity blockEntity, ItemStack stack, int slot, CallbackInfo ci){
        SoundEvent soundEvents = stack.isOf(ModItems.ALLAY_POSSESSED_BOOK) ? SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM : SoundEvents.ENTITY_ALLAY_AMBIENT_WITH_ITEM;
        SoundEvent soundEvents1 = stack.isOf(ModItems.VEX_POSSESSED_BOOK) ? SoundEvents.ENTITY_VEX_AMBIENT : SoundEvents.ENTITY_VEX_HURT;
        world.playSound(null, pos, soundEvents, SoundCategory.BLOCKS, 1.0f, 1.0f);
        world.playSound(null, pos, soundEvents1, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
