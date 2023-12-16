package com.qzimyion.bucketem.datagen.langDatagen;

import com.qzimyion.bucketem.items.ModItems;
import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import static com.qzimyion.bucketem.items.ModItems.*;

public class HindiDatagen extends FabricLanguageProvider {
    public HindiDatagen(FabricDataOutput dataOutput) {
        super(dataOutput, "hi_in");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(STRIDER_BUCKET, "स्ट्राइडर की बाल्टी");
        translationBuilder.add(SQUID_BUCKET, "स्क्वीड की बाल्टी");
        translationBuilder.add(TEMPERATE_FROG_BUCKET, "शीतोष्ण मेंढक की बाल्टी");
        translationBuilder.add(TROPICAL_FROG_BUCKET, "उष्णकटिबंधीय मेंढक की बाल्टी");
        translationBuilder.add(TUNDRA_FROG_BUCKET, "हिमाच्छन्न मेंढक की बाल्टी");
        translationBuilder.add(DRY_TEMPERATE_FROG_BUCKET, "शीतोष्ण मेंढक की सूखी बाल्टी");
        translationBuilder.add(DRY_TROPICAL_FROG_BUCKET, "उष्णकटिबंधीय मेंढक की सूखी बाल्टी");
        translationBuilder.add(DRY_TUNDRA_FROG_BUCKET, "िमाच्छन्न मेंढक की सूखी बाल्टी");
        translationBuilder.add(TURTLE_BUCKET, "कछुए की बाल्टी");
        translationBuilder.add(GLOW_SQUID_BUCKET, "ग्लो स्क्विड की बाल्टी");
        translationBuilder.add(ALLAY_POSSESSED_BOOK, "अलाय की किताब");
        translationBuilder.add(VEX_POSSESSED_BOOK, "वेक्स की किताब");
        translationBuilder.add(BEE_BOTTLE, "बोतल में मधुमक्खी");
        translationBuilder.add(SILVERFISH_BOTTLE, "बोतल में रजत मीन");
        translationBuilder.add(ENDERMITE_BOTTLE, "बोतल में एंडर्माइट");
        translationBuilder.add(SLIME_BOTTLE, "बोतल में स्लाइम");
        translationBuilder.add(MAGMA_CUBE_BOTTLE, "बोतल में मैग्मा घन");
        translationBuilder.add(ModStatusEffectsRegistry.BLISTERED_VISION, "छालेदार दृष्टि");

    }
}
