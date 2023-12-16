package com.qzimyion.bucketem.datagen.langDatagen;

import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import static com.qzimyion.bucketem.items.ModItems.*;

public class CanadianEnglishDatagen extends FabricLanguageProvider {
    public CanadianEnglishDatagen(FabricDataOutput dataOutput) {
        super(dataOutput, "en_ca");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(STRIDER_BUCKET, "Bucket of Strider");
        translationBuilder.add(SQUID_BUCKET, "Bucket of Squid");
        translationBuilder.add(GLOW_SQUID_BUCKET, "Bucket of Glow Squid");
        translationBuilder.add(TEMPERATE_FROG_BUCKET, "Bucket of Temperate Frog");
        translationBuilder.add(TROPICAL_FROG_BUCKET, "Bucket of Tropical Frog");
        translationBuilder.add(TUNDRA_FROG_BUCKET, "Bucket of Tundra Frog");
        translationBuilder.add(DRY_TEMPERATE_FROG_BUCKET, "Dry Bucket of Temperate Frog");
        translationBuilder.add(DRY_TROPICAL_FROG_BUCKET, "Dry Bucket of Tropical Frog");
        translationBuilder.add(DRY_TUNDRA_FROG_BUCKET, "Dry Bucket of Tundra Frog");
        translationBuilder.add(TURTLE_BUCKET, "Bucket of Turtle");
        translationBuilder.add(ALLAY_POSSESSED_BOOK, "Allay Possessed Book");
        translationBuilder.add(VEX_POSSESSED_BOOK, "Vex Possessed Book");
        translationBuilder.add(BEE_BOTTLE, "Bee in a Bottle");
        translationBuilder.add(SILVERFISH_BOTTLE, "Silverfish in a Bottle");
        translationBuilder.add(ENDERMITE_BOTTLE, "Endermite in a Bottle");
        translationBuilder.add(SLIME_BOTTLE, "Slime in a Bottle");
        translationBuilder.add(MAGMA_CUBE_BOTTLE, "Magma Cube in a Bottle");
        translationBuilder.add(ModStatusEffectsRegistry.BLISTERED_VISION, "Blistered Vision");

    }
}
