package com.projectmushroom.lavapotions.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class WaterControl extends MobEffect {

	public WaterControl(MobEffectCategory category, int amplifier) {
		super(category, amplifier);
	}
	
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		if (entity.isInWater() && entity.getHealth() < entity.getMaxHealth()) 
		{
            entity.heal(0.1F);
        }
	}
	
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}

