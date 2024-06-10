package com.qzimyion.bucketem.mixin.EntityMixins;

import com.qzimyion.bucketem.items.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.VexEntity;
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
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@SuppressWarnings("deprecation")
@Debug(export = true)
@Mixin(VexEntity.class)
public abstract class VexEntityMixin extends HostileEntity implements Bucketable {

    protected VexEntityMixin(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Unique
    private static final TrackedData<Boolean> FROM_BOOK = DataTracker.registerData(VexEntityMixin.class, TrackedDataHandlerRegistry.BOOLEAN);

    @Inject(at = @At("HEAD"), method = "initDataTracker")
    public void initDataTracker(DataTracker.Builder builder, CallbackInfo ci){
        builder.add(FROM_BOOK, false);
    }

    @Inject(at = @At("HEAD"), method = "writeCustomDataToNbt")
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci){
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("FromBucket", this.isFromBucket());
    }

    @Inject(at = @At("HEAD"), method = "readCustomDataFromNbt")
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        super.readCustomDataFromNbt(nbt);
        this.setFromBucket(nbt.getBoolean("FromBucket"));
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
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        return tryBook(player, hand, this).orElse(super.interactMob(player, hand));
    }

    @Override
    public boolean isFromBucket() {
        return this.dataTracker.get(FROM_BOOK);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.dataTracker.set(FROM_BOOK, fromBucket);
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
    public ItemStack getBucketItem() {
        return new ItemStack(ModItems.VEX_POSSESSED_BOOK);
    }

    @Override
    public SoundEvent getBucketFillSound() {
        return SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE;
    }

    @Unique
    private static <T extends LivingEntity> Optional<ActionResult> tryBook(PlayerEntity player, Hand hand, T entity) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() == Items.BOOK && entity.isAlive()) {
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
