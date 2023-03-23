package com.projectmushroom.lavapotions.entity;

import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.projectmushroom.lavapotions.init.EntityInit;
import com.projectmushroom.lavapotions.init.ItemInit;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.network.NetworkHooks;

public class LavaThrownStairway extends ThrowableItemProjectile implements ItemSupplier {
	
	@Override
	public Packet<?> getAddEntityPacket() {
	    return NetworkHooks.getEntitySpawningPacket(this);
	}
	
	public static final double SPLASH_RANGE = 4.0D;
	public static final Predicate<LivingEntity> WATER_SENSITIVE = LivingEntity::isSensitiveToWater;

	public LavaThrownStairway(EntityType<? extends LavaThrownStairway> p_37527_, Level p_37528_) {
	   super(p_37527_, p_37528_);
	}

	public LavaThrownStairway(Level p_37535_, LivingEntity p_37536_) {
	   super(EntityInit.LAVA_THROWN_STAIRWAY.get(), p_37536_, p_37535_);
	}

	public LavaThrownStairway(Level p_37530_, double p_37531_, double p_37532_, double p_37533_) {
	   super(EntityInit.LAVA_THROWN_STAIRWAY.get(), p_37531_, p_37532_, p_37533_, p_37530_);
	}

	protected Item getDefaultItem() {
	   return ItemInit.SPLASH_STAIRWAY.get();
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return createAttributes();
	}

	protected float getGravity() {
	   return 0.05F;
	}

	protected void onHitBlock(BlockHitResult p_37541_) {
	   super.onHitBlock(p_37541_);
	   if (!this.level.isClientSide) {
	      this.getItem();
	      Direction direction = p_37541_.getDirection();
	      BlockPos blockpos = p_37541_.getBlockPos();
	      blockpos.relative(direction);
	   }

       this.level.levelEvent(2002, this.blockPosition(), 16733695);
       this.discard();
	}

	protected void onHit(HitResult result) {
	   super.onHit(result);
	   if (!this.level.isClientSide) {
	      this.applySplash(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 19), 
	          MobEffects.HEAL, new MobEffectInstance(MobEffects.SATURATION, 6000, 10), 
	          new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000), 
              new MobEffectInstance(MobEffects.WATER_BREATHING, 6000), 
              new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 20), 
              new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 20), 
              new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 1000), 
              new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 15), 
              new MobEffectInstance(MobEffects.GLOWING, 6000), 
              new MobEffectInstance(MobEffects.LEVITATION, 100), 
              new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 10), 
              new MobEffectInstance(MobEffects.JUMP, 6000, 3), 
              new MobEffectInstance(MobEffects.LUCK, 6000, 10), 
              new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 15), 
              new MobEffectInstance(MobEffects.NIGHT_VISION, 6000), 
              new MobEffectInstance(MobEffects.REGENERATION, 6000, 15), 
	    	  result.getType() == HitResult.Type.ENTITY ? ((EntityHitResult)result).getEntity() : null);
	   }
	   this.discard();
	}

	private void applySplash(MobEffectInstance absorption, 
			MobEffect heal, MobEffectInstance fire_res, MobEffectInstance water_breath, 
			MobEffectInstance damage_boost, MobEffectInstance damage_res, MobEffectInstance dig_speed, 
			MobEffectInstance dolphin, MobEffectInstance glow, MobEffectInstance levitation, 
			MobEffectInstance hero, MobEffectInstance jump, MobEffectInstance luck, MobEffectInstance speed, 
			MobEffectInstance night_vision, MobEffectInstance regen, MobEffectInstance saturation, @Nullable Entity p_37549_) {
	   AABB aabb = this.getBoundingBox().inflate(4.0D, 2.0D, 4.0D);
	   List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, aabb);
	   if (!list.isEmpty()) {
	      Entity entity = this.getEffectSource();

	      for(LivingEntity livingentity : list) {
	         if (livingentity.isAffectedByPotions()) {
	            double d0 = this.distanceToSqr(livingentity);
	            if (d0 < 16.0D) {
	               double d1 = 1.0D - Math.sqrt(d0) / 4.0D;
	               if (livingentity == p_37549_) {
	                  d1 = 1.0D;
	               }
	               heal.applyInstantenousEffect(this, this.getOwner(), livingentity, 1, d1);
	               int i = (int)(d1 * (double)absorption.getDuration() + 0.5D);
	               if (i > 20) {
	                  livingentity.addEffect(new MobEffectInstance(absorption), entity);
	               }
	               int j = (int)(d1 * (double)fire_res.getDuration() + 0.5D);
	               if (j > 20) {
	                  livingentity.addEffect(new MobEffectInstance(fire_res), entity);
	               }
	               int k = (int)(d1 * (double)water_breath.getDuration() + 0.5D);
	               if (k > 20) {
	                  livingentity.addEffect(new MobEffectInstance(water_breath), entity);
	               }
	               int l = (int)(d1 * (double)damage_boost.getDuration() + 0.5D);
	               if (l > 20) {
	                  livingentity.addEffect(new MobEffectInstance(damage_boost), entity);
	               }
	               int m = (int)(d1 * (double)damage_res.getDuration() + 0.5D);
	               if (m > 20) {
	                  livingentity.addEffect(new MobEffectInstance(damage_res), entity);
	               }
	               int n = (int)(d1 * (double)dig_speed.getDuration() + 0.5D);
	               if (n > 20) {
	                  livingentity.addEffect(new MobEffectInstance(dig_speed), entity);
	               }
	               int o = (int)(d1 * (double)dolphin.getDuration() + 0.5D);
	               if (o > 20) {
	                  livingentity.addEffect(new MobEffectInstance(dolphin), entity);
	               }
	               int p = (int)(d1 * (double)glow.getDuration() + 0.5D);
	               if (p > 20) {
	                  livingentity.addEffect(new MobEffectInstance(glow), entity);
	               }
	               int q = (int)(d1 * (double)levitation.getDuration() + 0.5D);
	               if (q > 20) {
	                  livingentity.addEffect(new MobEffectInstance(levitation), entity);
	               }
	               int r = (int)(d1 * (double)hero.getDuration() + 0.5D);
	               if (r > 20) {
	                  livingentity.addEffect(new MobEffectInstance(hero), entity);
	               }
	               int s = (int)(d1 * (double)jump.getDuration() + 0.5D);
	               if (s > 20) {
	                  livingentity.addEffect(new MobEffectInstance(jump), entity);
	               }
	               int t = (int)(d1 * (double)luck.getDuration() + 0.5D);
	               if (t > 20) {
	                  livingentity.addEffect(new MobEffectInstance(luck), entity);
	               }
	               int u = (int)(d1 * (double)speed.getDuration() + 0.5D);
	               if (u > 20) {
	                  livingentity.addEffect(new MobEffectInstance(speed), entity);
	               }
	               int v = (int)(d1 * (double)night_vision.getDuration() + 0.5D);
	               if (v > 20) {
	                  livingentity.addEffect(new MobEffectInstance(night_vision), entity);
	               }
	               int w = (int)(d1 * (double)regen.getDuration() + 0.5D);
	               if (w > 20) {
	                  livingentity.addEffect(new MobEffectInstance(regen), entity);
	               }
	               int x = (int)(d1 * (double)saturation.getDuration() + 0.5D);
	               if (x > 20) {
	                  livingentity.addEffect(new MobEffectInstance(saturation), entity);
	               }
	            }
	         }
	      }
	   }
	}
}