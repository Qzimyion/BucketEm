package com.qzimyion.bucketem.potions.StatusEffects;

import net.minecraft.entity.EntityPose;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class BlisteredVision extends StatusEffect {

    public BlisteredVision(){
        super(StatusEffectCategory.BENEFICIAL, 0x661348);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        EntityPose swimming = EntityPose.SWIMMING;
        if (entity instanceof PlayerEntity){
            if (entity.isInLava()) {
                entity.setPose(swimming);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

}
