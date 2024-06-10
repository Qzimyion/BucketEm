package com.qzimyion.bucketem.items.NewItems.FrogBuckets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class TropicalFrogBuckets extends BucketItem {

    public TropicalFrogBuckets(Fluid fluid, Settings settings) {
        super(fluid, settings);
    }

    @Override
    public void onEmptied(@Nullable PlayerEntity player, World world, ItemStack stack, BlockPos pos) {
        if (world instanceof ServerWorld){
            this.spawnEntity((ServerWorld) world, stack, pos);
            world.emitGameEvent(player, GameEvent.ENTITY_PLACE, pos);
        }
    }

    public void spawnEntity(ServerWorld world, ItemStack stack, BlockPos pos) {
        FrogEntity entity = EntityType.FROG.spawnFromItemStack(world, stack, null, pos, SpawnReason.BUCKET, true, false);
        if (entity != null) {
            entity.setPersistent();
            entity.setVariant((RegistryEntry<FrogVariant>) FrogVariant.WARM);
        }
    }
}
