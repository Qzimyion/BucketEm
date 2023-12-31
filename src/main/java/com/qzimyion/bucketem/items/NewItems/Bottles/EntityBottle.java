package com.qzimyion.bucketem.items.NewItems.Bottles;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.BeeEntity;
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
import java.util.UUID;

public class EntityBottle extends Item {
    private final EntityType<?> getType;

    public EntityBottle(EntityType<?> getType, Settings settings) {
        super(settings);
        this.getType = getType;
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

            EntityType<?> entitytype = this.getType(itemStack.getNbt());
            if (!Objects.requireNonNull(context.getPlayer()).getAbilities().creativeMode){
                context.getPlayer().setStackInHand(context.getHand(), new ItemStack(Items.GLASS_BOTTLE));
            }
            Entity entity = entitytype.spawnFromItemStack((ServerWorld) world, itemStack, context.getPlayer(), blockPos1, SpawnReason.BUCKET, true, !Objects.equals(blockPos, blockPos1) && direction == Direction.UP);
            if (entity instanceof MobEntity){
                ((MobEntity) entity).setPersistent();
            }
            NbtCompound nbt = itemStack.getOrCreateNbt();
            if (entity instanceof BeeEntity bee){
                int anger = nbt.contains("Anger") ? nbt.getInt("Anger") : 0;
                UUID angryAt = nbt.contains("AngryAt") ? nbt.getUuid("AngryAt") : null;
                int age = nbt.contains("Age") ? nbt.getInt("Age") : 0;
                float health = nbt.contains("Health") ? nbt.getFloat("Health") : 10.0F;
                boolean nectar = nbt.contains("HasNectar") && nbt.getBoolean("HasNectar");
                boolean stung = nbt.contains("HasStung") && nbt.getBoolean("HasStung");

                bee.setHasNectar(nectar);
                bee.setHasStung(stung);
                bee.setBreedingAge(age);
                bee.setAngerTime(anger);
                if (angryAt != null) bee.setAngryAt(angryAt);
                bee.setHealth(health);
                bee.setPersistent();
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
