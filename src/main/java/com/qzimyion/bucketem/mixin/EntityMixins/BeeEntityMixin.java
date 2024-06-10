package com.qzimyion.bucketem.mixin.EntityMixins;

import com.qzimyion.bucketem.items.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@SuppressWarnings("deprecation")
@Debug(export = true)
@Mixin(BeeEntity.class)
public abstract class BeeEntityMixin extends AnimalEntity implements Bucketable {

    @Unique
    private static final TrackedData<Boolean> FROM_BOTTLE = DataTracker.registerData(BeeEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);

    protected BeeEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }


    @Inject(at = @At("HEAD"), method = "initDataTracker")
    public void initDataTracker(DataTracker.Builder builder, CallbackInfo ci){
        builder.add(FROM_BOTTLE, false);
    }

    @Inject(at = @At("HEAD"), method = "writeCustomDataToNbt")
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci){
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("FromBucket", this.isFromBucket());
    }

    @Inject(at = @At("HEAD"), method = "readCustomDataFromNbt")
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        super.readCustomDataFromNbt(nbt);
        this.setFromBucket(nbt.getBoolean("FromBottle"));
    }

    @Override
    public boolean isFromBucket() {
        return dataTracker.get(FROM_BOTTLE);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.dataTracker.set(FROM_BOTTLE, fromBucket);
    }

    @Override
    public boolean cannotDespawn() {
        return super.cannotDespawn() || this.isFromBucket();
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return !this.isFromBucket() && !this.hasCustomName();
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        return tryBottling(player, hand, this).orElse(super.interactMob(player, hand));
    }

    @Override
    public void copyDataToStack(ItemStack stack) {
        Bucketable.copyDataToStack(this, stack);
    }

    @Override
    public void copyDataFromNbt(NbtCompound nbt) {
        Bucketable.copyDataFromNbt(this, nbt);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        if (spawnReason == SpawnReason.BUCKET) {
            return entityData;
        }
        return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Override
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.BEE_BOTTLE);
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH;
    }

    @Unique
    private static <T extends LivingEntity> Optional<ActionResult> tryBottling(PlayerEntity player, Hand hand, T entity) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.GLASS_BOTTLE && entity.isAlive()) {
            entity.playSound(((Bucketable) entity).getBucketFillSound(), 1.0f, 1.0f);
            ItemStack itemStack2 = ((Bucketable) entity).getBucketItem();
            ((Bucketable) entity).copyDataToStack(itemStack2);
            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, player, itemStack2, false);
            player.setStackInHand(hand, itemStack3);
            World world = entity.getWorld();
            if (!world.isClient) {
                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)player, itemStack2);
            }
            entity.discard();
            return Optional.of(ActionResult.success(world.isClient));
        }
        return Optional.empty();
    }
}
