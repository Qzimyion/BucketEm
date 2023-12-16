package com.qzimyion.bucketem.items.NewItems.Bottles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class SlimeBottle extends Item {

    public SlimeBottle(Item.Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        world.playSound(context.getPlayer(), context.getBlockPos(), SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.BLOCKS, 1, 1);
        if (world.isClient){
            return ActionResult.SUCCESS;
        } else {
            ItemStack itemStack = context.getStack();
            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);

            BlockPos blockPos1;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()){
                blockPos1 = blockPos;
            } else {
                blockPos1 = blockPos.offset(direction);
            }
            NbtCompound nbt = itemStack.getOrCreateNbt();
            if (!Objects.requireNonNull(context.getPlayer()).getAbilities().creativeMode) {
                context.getPlayer().setStackInHand(context.getHand(), new ItemStack(Items.GLASS_BOTTLE));
            }
            SlimeEntity entity = EntityType.SLIME.spawnFromItemStack((ServerWorld) world, itemStack, null, blockPos1, SpawnReason.BUCKET, true, false);
            if (entity != null) {
                entity.setPersistent();
                entity.setSize(1, false);
            }
            int size = nbt.contains("Size") ? nbt.getInt("Size") : 1;
            assert entity != null;
            entity.setSize(size, false);
        }
        return ActionResult.CONSUME;
    }
}
