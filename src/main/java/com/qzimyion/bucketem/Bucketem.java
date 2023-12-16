package com.qzimyion.bucketem;

import com.qzimyion.bucketem.dispenser.DispenserBehaviorRegistry;
import com.qzimyion.bucketem.items.ModItemGroups;
import com.qzimyion.bucketem.items.ModItems;
import com.qzimyion.bucketem.potions.ModPotionsRegistry;
import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bucketem implements ModInitializer {

	public static final String MOD_ID = "bucketem";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerItems();
		ModItemGroups.registerItemGroups();
		ModEvents.registerEvents();
		DispenserBehaviorRegistry.registerDispenserBehavior();
		ModStatusEffectsRegistry.registerStatusEffects();
		ModPotionsRegistry.registerPotions();
		ModPotionsRegistry.registerPotionRecipes();
	}
}