package com.qzimyion.bucketem.items;

import com.qzimyion.bucketem.Bucketem;
import com.qzimyion.bucketem.items.NewItems.Bottles.EntityBottle;
import com.qzimyion.bucketem.items.NewItems.Bottles.MagmaCubeBottle;
import com.qzimyion.bucketem.items.NewItems.Bottles.SlimeBottle;
import com.qzimyion.bucketem.items.NewItems.EntityBook;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.DryVariants.DryTemperateFrogBuckets;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.DryVariants.DryTropicalFrogBuckets;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.DryVariants.DryTundraFrogBuckets;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.TemperateFrogBuckets;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.TropicalFrogBuckets;
import com.qzimyion.bucketem.items.NewItems.FrogBuckets.TundraFrogBuckets;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.EntityBucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static net.minecraft.item.Items.GLASS_BOTTLE;

public class ModItems {

    //Buckets
    public static final Item STRIDER_BUCKET = registerItem("strider_bucket", new EntityBucketItem(EntityType.STRIDER, Fluids.LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA, new Item.Settings().maxCount(1)));
    public static final Item SQUID_BUCKET = registerItem("squid_bucket", new EntityBucketItem(EntityType.SQUID, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)));
    public static final Item GLOW_SQUID_BUCKET = registerItem("glow_squid_bucket", new EntityBucketItem(EntityType.GLOW_SQUID, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)));
    public static final Item TEMPERATE_FROG_BUCKET = registerItem("temperate_frog_bucket", new TemperateFrogBuckets(Fluids.WATER ,new FabricItemSettings().maxCount(1)));
    public static final Item TROPICAL_FROG_BUCKET = registerItem("tropical_frog_bucket", new TropicalFrogBuckets(Fluids.WATER , new FabricItemSettings().maxCount(1)));
    public static final Item TUNDRA_FROG_BUCKET = registerItem("tundra_frog_bucket", new TundraFrogBuckets(Fluids.WATER ,new FabricItemSettings().maxCount(1)));
    public static final Item TURTLE_BUCKET = registerItem("turtle_bucket", new EntityBucketItem(EntityType.TURTLE, Fluids.WATER, SoundEvents.ITEM_BUCKET_EMPTY_FISH, new FabricItemSettings().maxCount(1)));
    public static final Item DRY_TEMPERATE_FROG_BUCKET = registerItem("dry_temperate_frog_bucket", new DryTemperateFrogBuckets(new FabricItemSettings().maxCount(1)));
    public static final Item DRY_TROPICAL_FROG_BUCKET = registerItem("dry_tropical_frog_bucket", new DryTropicalFrogBuckets(new FabricItemSettings().maxCount(1)));
    public static final Item DRY_TUNDRA_FROG_BUCKET = registerItem("dry_tundra_frog_bucket", new DryTundraFrogBuckets(new FabricItemSettings().maxCount(1)));


    //Books
    public static final Item ALLAY_POSSESSED_BOOK = registerItem("allay_possessed_book", new EntityBook(EntityType.ALLAY ,new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item VEX_POSSESSED_BOOK = registerItem("vex_possessed_book", new EntityBook(EntityType.VEX, new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

    //Bottles
    public static final Item BEE_BOTTLE = registerItem("bee_bottle", new EntityBottle(EntityType.BEE ,new FabricItemSettings().maxCount(1)));
    public static final Item SILVERFISH_BOTTLE = registerItem("silverfish_bottle", new EntityBottle(EntityType.SILVERFISH, new FabricItemSettings().maxCount(1)));
    public static final Item ENDERMITE_BOTTLE = registerItem("endermite_bottle", new EntityBottle(EntityType.ENDERMITE, new FabricItemSettings().maxCount(1)));
    public static final Item SLIME_BOTTLE = registerItem("slime_bottle", new SlimeBottle(new FabricItemSettings().maxCount(1).recipeRemainder(GLASS_BOTTLE)));
    public static final Item MAGMA_CUBE_BOTTLE = registerItem("magma_bottle", new MagmaCubeBottle(new FabricItemSettings().maxCount(1).recipeRemainder(GLASS_BOTTLE)));


    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(Bucketem.MOD_ID, name), item);
    }

    public static void registerItems(){

        Bucketem.LOGGER.info("Registering mod Items");
    }
}
