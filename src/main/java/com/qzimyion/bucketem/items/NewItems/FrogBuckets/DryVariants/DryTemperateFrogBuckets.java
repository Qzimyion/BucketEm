package com.qzimyion.bucketem.items.NewItems.FrogBuckets.DryVariants;

import com.qzimyion.bucketem.items.NewItems.Bottles.SlimeBottle;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class DryTemperateFrogBuckets extends SlimeBottle {

    public DryTemperateFrogBuckets(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        world.playSound(context.getPlayer(), context.getBlockPos(), SoundEvents.ITEM_BUCKET_FILL_TADPOLE, SoundCategory.BLOCKS, 1, 1);
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
            if (!Objects.requireNonNull(context.getPlayer()).getAbilities().creativeMode) {
                context.getPlayer().setStackInHand(context.getHand(), new ItemStack(Items.BUCKET));
            }
            FrogEntity entity = EntityType.FROG.spawnFromItemStack((ServerWorld) world, itemStack, null, blockPos1, SpawnReason.BUCKET, true, false);
            if (entity != null) {
                entity.setPersistent();
                entity.setVariant(FrogVariant.TEMPERATE);
            }
        }
        return ActionResult.CONSUME;
    }
}
