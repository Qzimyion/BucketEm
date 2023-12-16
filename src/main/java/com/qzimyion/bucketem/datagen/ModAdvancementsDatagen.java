package com.qzimyion.bucketem.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.OnKilledCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

import java.util.function.Consumer;

import static com.qzimyion.bucketem.items.ModItems.*;

public class ModAdvancementsDatagen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

    }

    public static class AdvancementsProvider extends FabricAdvancementProvider {
        public AdvancementsProvider(FabricDataOutput output) {
            super(output);
        }

        @Override
        public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
            AdvancementEntry NetherAdvancementEntry = Advancement.Builder.create()
                    .display(Blocks.RED_NETHER_BRICKS,
                            Text.translatable("advancements.nether.root.title"),
                            Text.translatable("advancements.nether.root.description"),
                            new Identifier("textures/gui/advancements/backgrounds/nether.png"),
                            AdvancementFrame.TASK, false, false, false)
                    .criterion("entered_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER)).build(consumer, "nether/root");

            AdvancementEntry AdventureAdvancementEntry = Advancement.Builder.create().display(Items.MAP,
                    (Text)Text.translatable("advancements.adventure.root.title"),
                    (Text)Text.translatable("advancements.adventure.root.description"),
                    new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                    AdvancementFrame.TASK, false, false, false)
                    .criteriaMerger(AdvancementRequirements.CriterionMerger.OR).criterion("killed_something",
                            OnKilledCriterion.Conditions.createPlayerKilledEntity()).criterion("killed_by_something",
                            OnKilledCriterion.Conditions.createEntityKilledPlayer()).build(consumer, "adventure/root");


            AdvancementEntry rootAdvancement = Advancement.Builder.create().parent(NetherAdvancementEntry)
                    .display(
                            STRIDER_BUCKET,
                            Text.translatable("Hardcore Bucketing"),
                            Text.translatable("Bucket up a strider using a lava bucket"),
                            null,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_strider_bucket", InventoryChangedCriterion.Conditions.items(STRIDER_BUCKET))
                    .build(consumer, "minecraft" + "/strider_bucketing");

            AdvancementEntry rootAdvancement1 = Advancement.Builder.create().parent(AdventureAdvancementEntry)
                    .display(
                            SLIME_BOTTLE,
                            Text.translatable("Slime Rancher"),
                            Text.translatable("Bottle up slimes snd magma cubes"),
                            null,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_slime_bottle", InventoryChangedCriterion.Conditions.items(SLIME_BOTTLE))
                    .criterion("got_magma_cube_bottle", InventoryChangedCriterion.Conditions.items(MAGMA_CUBE_BOTTLE))
                    .build(consumer, "minecraft" + "/critter_bottling");

            AdvancementEntry rootAdvancement2 = Advancement.Builder.create().parent(rootAdvancement1)
                    .display(
                            BEE_BOTTLE,
                            Text.translatable("Critter Rancher"),
                            Text.translatable("Bottle up all the critters out there"),
                            null,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_bee_bottle", InventoryChangedCriterion.Conditions.items(BEE_BOTTLE))
                    .criterion("got_silverfish_bottle", InventoryChangedCriterion.Conditions.items(SILVERFISH_BOTTLE))
                    .criterion("got_endermite_bottle", InventoryChangedCriterion.Conditions.items(ENDERMITE_BOTTLE))
                    .criterion("got_slime_bottle", InventoryChangedCriterion.Conditions.items(SLIME_BOTTLE))
                    .criterion("got_magma_cube_bottle", InventoryChangedCriterion.Conditions.items(MAGMA_CUBE_BOTTLE))
                    .build(consumer, "minecraft" + "/critter_ranching");

            AdvancementEntry turtleAdvancement = Advancement.Builder.create().parent(AdventureAdvancementEntry)
                    .display(
                            TURTLE_BUCKET,
                            Text.translatable("I like Turtles"),
                            Text.translatable("Bucket up a Turtle in a water bucket"),
                            null,
                            AdvancementFrame.TASK,
                            true,
                            true,
                            false
                    )
                    .criterion("got_turtle_bucket", InventoryChangedCriterion.Conditions.items(TURTLE_BUCKET))
                    .build(consumer, "minecraft" + "/turtle_bucketing");

        }
    }
}
