package com.projectmushroom.lavapotions.effect;

import com.projectmushroom.lavapotions.LavaPotions;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class LavaEffects {
	public static final DeferredRegister<MobEffect> LAVA_EFFECTS 
	= DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, LavaPotions.MOD_ID);
	
	public static final RegistryObject<MobEffect> HIGHWAY = LAVA_EFFECTS.register("highway", 
			() -> new Highway(MobEffectCategory.BENEFICIAL, 57172));
	
	public static final RegistryObject<MobEffect> BURNING_SPEED = LAVA_EFFECTS.register("burning_speed", 
			() -> new BurningSpeed(MobEffectCategory.BENEFICIAL, 13817855));
	
	public static final RegistryObject<MobEffect> SOUL_FLAME = LAVA_EFFECTS.register("soul_flame", 
			() -> new SoulFlame(MobEffectCategory.HARMFUL, 2818022));
	
	public static final RegistryObject<MobEffect> FIERY_REGEN = LAVA_EFFECTS.register("fiery_regen", 
			() -> new FieryRegen(MobEffectCategory.BENEFICIAL, 14707686));
	
	public static final RegistryObject<MobEffect> WATER_CONTROL = LAVA_EFFECTS.register("water_control", 
			() -> new WaterControl(MobEffectCategory.BENEFICIAL, 14707686));
	
	public static final RegistryObject<MobEffect> INVINC = LAVA_EFFECTS.register("invinc", 
			() -> new Invinc(MobEffectCategory.BENEFICIAL, 16711680)); 
	
	public static final RegistryObject<MobEffect> VANISHING = LAVA_EFFECTS.register("vanishing", 
			() -> new Vanishing(MobEffectCategory.BENEFICIAL, 15001063)); 
	
	public static final RegistryObject<MobEffect> VOLCANIC = LAVA_EFFECTS.register("volcanic", 
			() -> new Volcanic(MobEffectCategory.BENEFICIAL, 11927552));
	
	public static final RegistryObject<MobEffect> STRIDING = LAVA_EFFECTS.register("striding", 
			() -> new LavaStriding(MobEffectCategory.BENEFICIAL, 6291456));
	
	public static final RegistryObject<MobEffect> CRIPPLING = LAVA_EFFECTS.register("crippling", 
			() -> new Crippling(MobEffectCategory.HARMFUL, 1975338));
	
	public static final RegistryObject<MobEffect> HELLISH = LAVA_EFFECTS.register("hellish", 
			() -> new Hellish(MobEffectCategory.BENEFICIAL, 16727150));
	
	public static final RegistryObject<MobEffect> THEOS = LAVA_EFFECTS.register("theos", 
			() -> new Theos(MobEffectCategory.BENEFICIAL, 16777215));
	

}
