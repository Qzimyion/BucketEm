package com.qzimyion.bucketem;

import com.qzimyion.bucketem.items.ModItems;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Bucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;

@SuppressWarnings("deprecation")
public class ModEvents {

    public static void registerEvents() {

        UseEntityCallback.EVENT.register(((player, world, hand, entity, hitResult) -> {
            ItemStack itemStack = player.getStackInHand(hand);

            //Frog buckets
            if (itemStack.getItem() == Items.WATER_BUCKET && entity.isAlive() && entity instanceof FrogEntity frog){
                player.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0f, 1.0f);
                ItemStack bucket;
                if (frog.getVariant()== FrogVariant.TEMPERATE){
                    bucket = new ItemStack(ModItems.TEMPERATE_FROG_BUCKET);
                } else if (frog.getVariant()== FrogVariant.WARM) {
                    bucket = new ItemStack(ModItems.TROPICAL_FROG_BUCKET);
                } else if (frog.getVariant()== FrogVariant.COLD) {
                    bucket = new ItemStack(ModItems.TUNDRA_FROG_BUCKET);
                } else {
                    return ActionResult.SUCCESS;
                }
                Bucketable.copyDataToStack(frog, bucket);
                ItemStack itemstack2 = ItemUsage.exchangeStack(itemStack ,player, bucket, false);
                player.setStackInHand(hand, itemstack2);

                entity.discard();
            }
            //Dry variant
            if (itemStack.getItem() == Items.BUCKET && entity.isAlive() && entity instanceof FrogEntity frog){
                player.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0f, 1.0f);
                ItemStack bucket;
                if (frog.getVariant()== FrogVariant.TEMPERATE){
                    bucket = new ItemStack(ModItems.DRY_TEMPERATE_FROG_BUCKET);
                } else if (frog.getVariant()== FrogVariant.WARM) {
                    bucket = new ItemStack(ModItems.DRY_TROPICAL_FROG_BUCKET);
                } else if (frog.getVariant()== FrogVariant.COLD) {
                    bucket = new ItemStack(ModItems.DRY_TUNDRA_FROG_BUCKET);
                } else {
                    return ActionResult.SUCCESS;
                }
                Bucketable.copyDataToStack(frog, bucket);
                ItemStack itemstack2 = ItemUsage.exchangeStack(itemStack ,player, bucket, false);
                player.setStackInHand(hand, itemstack2);

                entity.discard();
            }

            //Turtles

            //Bottles
            if (itemStack.getItem() == Items.GLASS_BOTTLE && entity.isAlive() && entity instanceof SlimeEntity slime) {
                player.playSound(SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, 1.0f, 1.0f);
                ItemStack bottle;
                if (slime.getType() == EntityType.SLIME && slime.getSize() == 1) {
                    bottle = new ItemStack(ModItems.SLIME_BOTTLE);
                } else if (slime.getType() == EntityType.SLIME && slime.getSize() == 2) {
                    return ActionResult.FAIL;
                } else if (slime.getType() == EntityType.SLIME && slime.getSize() == 3) {
                    return ActionResult.FAIL;
                } else if (slime.getType() == EntityType.SLIME && slime.getSize() == 4) {
                    return ActionResult.FAIL;
                } else if (slime.getType() == EntityType.MAGMA_CUBE && slime.getSize() == 1) {
                    bottle = new ItemStack(ModItems.MAGMA_CUBE_BOTTLE);
                } else if (slime.getType() == EntityType.MAGMA_CUBE && slime.getSize() == 2) {
                    return ActionResult.FAIL;
                } else if (slime.getType() == EntityType.MAGMA_CUBE && slime.getSize() == 3) {
                    return ActionResult.FAIL;
                } else if (slime.getType() == EntityType.MAGMA_CUBE && slime.getSize() == 4) {
                    return ActionResult.FAIL;
                } else {
                    return ActionResult.SUCCESS;
                }
                Bucketable.copyDataToStack(slime, bottle);
                ItemStack itemstack2 = ItemUsage.exchangeStack(itemStack, player, bottle, false);
                player.setStackInHand(hand, itemstack2);

                entity.discard();
            }

            //Bee
            if (itemStack.getItem() == Items.GLASS_BOTTLE && entity.isAlive() && entity instanceof BeeEntity bee){
                player.playSound(SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, 1.0f, 1.0f);
                Item bottle = ModItems.BEE_BOTTLE;
                if (bottle != null)
                {
                    ItemStack bottleItem = new ItemStack(bottle);
                    NbtComponent.set(DataComponentTypes.BUCKET_ENTITY_DATA, bottleItem, nbt ->
                    {
                        nbt.putBoolean("HasNectar", bee.hasNectar());
                        nbt.putBoolean("HasStung", bee.hasStung());
                        nbt.putInt("Anger", bee.getAngerTime());
                        nbt.putInt("Age", bee.getBreedingAge());
                        nbt.putFloat("Health", bee.getHealth());
                        if (bee.getAngryAt() != null)
                            nbt.putUuid("AngryAt", bee.getAngryAt());
                    });
                    itemStack.decrement(1);
                    player.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
                    entity.discard();
                    Bucketable.copyDataToStack(bee, bottleItem);
                    ItemStack itemstack2 = ItemUsage.exchangeStack(itemStack ,player, bottleItem, false);
                    player.setStackInHand(hand, itemstack2);
                    return ActionResult.SUCCESS;
                }
            }

            //Allay
            if (itemStack.getItem() == Items.BOOK && player.isSneaking() && entity.isAlive() && entity instanceof AllayEntity allay){
                player.playSound(SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, 1.0f, 1.0f);
                ItemStack newStack = ModItems.ALLAY_POSSESSED_BOOK.getDefaultStack();
                Bucketable.copyDataToStack(allay, newStack);
                ItemStack itemstack2 = ItemUsage.exchangeStack(itemStack ,player, newStack, false);
                player.setStackInHand(hand, itemstack2);

                entity.discard();
                return ActionResult.SUCCESS;

            }
            return ActionResult.PASS;

        }));
        Bucketem.LOGGER.info("Registering mod Events");
    }
}
