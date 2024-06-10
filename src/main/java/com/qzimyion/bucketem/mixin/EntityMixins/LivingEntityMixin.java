package com.qzimyion.bucketem.mixin.EntityMixins;

import com.qzimyion.bucketem.potions.StatusEffects.ModStatusEffectsRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("SameParameterValue")
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Unique
    public abstract boolean hasStatusEffect(StatusEffect effect);

    @Shadow protected abstract boolean shouldSwimInFluids();

    @Shadow public abstract boolean isInSwimmingPose();

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Unique
    private void modifyLavaSpeed(Vec3d movementInput, CallbackInfo ci){
        if (this.hasStatusEffect(ModStatusEffectsRegistry.BLISTERED_VISION)){
            this.setVelocity(movementInputToVelocity(movementInput, 0.21f, this.getYaw()));
        }
    }

    @Unique
    private static Vec3d movementInputToVelocity(Vec3d movementInput, float speed, float yaw) {
        double d = movementInput.lengthSquared();
        if (d < 1.0E-7) {
            return Vec3d.ZERO;
        }
        Vec3d vec3d = (d > 1.0 ? movementInput.normalize() : movementInput).multiply(speed);
        float f = MathHelper.sin(yaw * ((float)Math.PI / 180));
        float g = MathHelper.cos(yaw * ((float)Math.PI / 180));
        return new Vec3d(vec3d.x * (double)g - vec3d.z * (double)f, vec3d.y, vec3d.z * (double)g + vec3d.x * (double)f);
    }
}
