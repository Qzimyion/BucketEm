package com.qzimyion.bucketem.items.NewItems;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
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

public class EntityBook extends Item {
    private final EntityType<?> getType;

    public EntityBook(EntityType<?> getType, Settings settings) {
        super(settings);
        this.getType = getType;
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        world.playSound(context.getPlayer(), context.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1, 1);
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

            EntityType<?> entitytype = this.getType(itemStack.getNbt());
            if (!Objects.requireNonNull(context.getPlayer()).getAbilities().creativeMode){
                context.getPlayer().setStackInHand(context.getHand(), new ItemStack(Items.BOOK));
            }
            Entity entity = entitytype.spawnFromItemStack((ServerWorld) world, itemStack, context.getPlayer(), blockPos1, SpawnReason.BUCKET, true, !Objects.equals(blockPos, blockPos1) && direction == Direction.UP);
            if (entity instanceof MobEntity){
                ((MobEntity) entity).setPersistent();
            }
            return ActionResult.CONSUME;
        }
    }

    public EntityType<?> getType(NbtCompound nbt) {
        if (nbt != null && nbt.contains("EntityTag", 10)){
            NbtCompound nbtCompound = nbt.getCompound("EntityTag");
            if (nbtCompound.contains("id", 8)){
                return EntityType.get(nbtCompound.getString("id")).orElse(this.getType);
            }
        }
        return this.getType;
    }
}
