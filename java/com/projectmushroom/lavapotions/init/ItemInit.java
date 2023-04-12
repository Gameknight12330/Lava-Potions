package com.projectmushroom.lavapotions.init;

import com.google.common.base.Supplier;
import com.projectmushroom.lavapotions.LavaPotions;
import com.projectmushroom.lavapotions.effect.LavaEffects;
import com.projectmushroom.lavapotions.item.LavaLingeringPotion;
import com.projectmushroom.lavapotions.item.LavaPotion;
import com.projectmushroom.lavapotions.item.LavaSplashPotion;
import com.projectmushroom.lavapotions.item.LavaSplashScalding;
import com.projectmushroom.lavapotions.item.LavaSplashStairway;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LavaPotions.MOD_ID);
	
	public static final RegistryObject<Item> REINFORCED_BOTTLE = ITEMS.register("reinforced_bottle", 
			() -> new Item(new Item.Properties().stacksTo(64).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> LAVA_BOTTLE = register("lava_bottle", 
			() -> new Item(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> FLAME_HEALING = register("flame_healing",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 1), 1f).effect(
					() -> new MobEffectInstance(MobEffects.HEAL, 20), 1f).effect(
					() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1f).build())));
	
	public static final RegistryObject<Item> SPLASH_FLAME_HEALING = register("splash_flame_healing", 
			() -> new LavaSplashPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> LINGERING_FLAME_HEALING = register("lingering_flame_healing", 
			() -> new LavaLingeringPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> SCALDING = register("scalding",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(MobEffects.HARM, 1, 1), 1f).effect(
					() -> new MobEffectInstance(MobEffects.BLINDNESS, 600), 1f).build())));
	
	public static final RegistryObject<Item> MARKING = register("marking",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 3), 1f).effect(
					() -> new MobEffectInstance(MobEffects.GLOWING, 3600), 1f).build())));
	
	public static final RegistryObject<Item> SPLASH_SCALDING = register("splash_scalding", 
			() -> new LavaSplashScalding(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> STAIRWAY = register("stairway",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(MobEffects.ABSORPTION, 6000, 19), 1f).effect(
					() -> new MobEffectInstance(MobEffects.HEAL, 20), 1f).effect(
					() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000), 1f).effect(
					() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 6000), 1f).effect(
					() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 20), 1f).effect(
					() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 20), 1f).effect(
					() -> new MobEffectInstance(MobEffects.DIG_SPEED, 6000, 1000), 1f).effect(
					() -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 6000, 15), 1f).effect(
					() -> new MobEffectInstance(MobEffects.GLOWING, 6000), 1f).effect(
					() -> new MobEffectInstance(MobEffects.LEVITATION, 100), 1f).effect(
					() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 6000, 10), 1f).effect(
					() -> new MobEffectInstance(MobEffects.JUMP, 6000, 3), 1f).effect(
					() -> new MobEffectInstance(MobEffects.LUCK, 6000, 10), 1f).effect(
					() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 15), 1f).effect(
					() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 6000), 1f).effect(
				    () -> new MobEffectInstance(MobEffects.REGENERATION, 6000, 15), 1f).effect(
					() -> new MobEffectInstance(MobEffects.SATURATION, 6000, 10), 1f).build())));
	
	public static final RegistryObject<Item> SPLASH_STAIRWAY = register("splash_stairway", 
			() -> new LavaSplashStairway(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> HIGHWAY = register("highway",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.HIGHWAY.get(), 2400), 1f).build())));

	public static final RegistryObject<Item> CRIPPLING = register("crippling",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.CRIPPLING.get(), 2400), 1f).build())));
	
    public static final RegistryObject<Item> SOUL_FLAME = register("soul_flame",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.SOUL_FLAME.get(), 2400), 1f).build())));
    
    public static final RegistryObject<Item> FIERY_REGEN = register("fiery_regen",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.FIERY_REGEN.get(), 1800), 1f).build())));
    
	public static final RegistryObject<Item> BURNING_SPEED = register("burning_speed",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.BURNING_SPEED.get(), 2400), 1f).build())));
	
	public static final RegistryObject<Item> WATER_CONTROL = register("water_control",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.WATER_CONTROL.get(), 2400), 1f).build())));
	
	public static final RegistryObject<Item> INVINC = register("invinc",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.INVINC.get(), 2400), 1f).build())));
	
	public static final RegistryObject<Item> VANISHING = register("vanishing",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.VANISHING.get(), 2400, -1), 1f).build())));
	
	public static final RegistryObject<Item> VOLCANIC = register("volcanic",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.VOLCANIC.get(), 2400), 1f).build())));
	
	public static final RegistryObject<Item> STRIDING = register("striding",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.STRIDING.get(), 3600), 1f).build())));
	
	public static final RegistryObject<Item> HELLISH = register("hellish",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.HELLISH.get(), 2400), 1f).build())));
	
	public static final RegistryObject<Item> THEOS = register("theos",
			() -> new LavaPotion(new Item.Properties().stacksTo(1).fireResistant().tab(LavaPotions.LAVA_POTIONS)
					.food(new FoodProperties.Builder().alwaysEat().effect(
					() -> new MobEffectInstance(LavaEffects.THEOS.get(), 8400), 1f).build())));
	
	public static final RegistryObject<Item> DEAD_OAK_SIGN = ITEMS.register("dead_oak_sign",
            () -> new SignItem(new Item.Properties().tab(LavaPotions.DEAD_WOOD).stacksTo(16),
                    BlockInit.DEAD_OAK_SIGN.get(), BlockInit.DEAD_OAK_WALL_SIGN.get()));
	
	public static final RegistryObject<Item> GUARDIAN_EYE = register("guardian_eye",
			() -> new Item(new Item.Properties().stacksTo(64).tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> RAVAGER_HORN = register("ravager_horn",
			() -> new Item(new Item.Properties().stacksTo(64).tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> EATEN_FISH = register("eaten_fish",
			() -> new Item(new Item.Properties().stacksTo(64).tab(LavaPotions.LAVA_POTIONS)));
	
	public static final RegistryObject<Item> STRIDER_FOOT = register("strider_foot",
			() -> new Item(new Item.Properties().stacksTo(64).fireResistant().tab(LavaPotions.LAVA_POTIONS)));
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}

}
