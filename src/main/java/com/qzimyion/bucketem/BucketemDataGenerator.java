package com.qzimyion.bucketem;

import com.qzimyion.bucketem.datagen.ModAdvancementsDatagen;
import com.qzimyion.bucketem.datagen.ModItemTagsDatagen;
import com.qzimyion.bucketem.datagen.ModModelDatagen;
import com.qzimyion.bucketem.datagen.ModRecipeDatagen;
import com.qzimyion.bucketem.datagen.langDatagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BucketemDataGenerator implements DataGeneratorEntrypoint {


	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModAdvancementsDatagen.AdvancementsProvider::new);
		pack.addProvider(ModItemTagsDatagen::new);
		pack.addProvider(ModModelDatagen::new);
		pack.addProvider(ModRecipeDatagen::new);

		//Lang Datagen
		pack.addProvider(AmericanEnglishDatagen::new);
		pack.addProvider(BritishEnglishDatagen::new);
		pack.addProvider(CanadianEnglishDatagen::new);
		pack.addProvider(AustralianEnglishDatagen::new);
		pack.addProvider(NewZealandEnglishDatagen::new);
		pack.addProvider(HindiDatagen::new);
	}
}
