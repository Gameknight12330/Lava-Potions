package com.projectmushroom.lavapotions.block.entity;

import com.projectmushroom.lavapotions.LavaPotions;
import com.projectmushroom.lavapotions.block.entity.custom.LavaBrewingStationBlockEntity;
import com.projectmushroom.lavapotions.block.entity.custom.ModSignBlockEntity;
import com.projectmushroom.lavapotions.init.BlockInit;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
	
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
			DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, LavaPotions.MOD_ID);
	
	public static final RegistryObject<BlockEntityType<LavaBrewingStationBlockEntity>> LAVA_BREWING_CAULDRON_ENTITY = 
			BLOCK_ENTITIES.register("lava_brewing_cauldron_entity", () -> 
			BlockEntityType.Builder.of(LavaBrewingStationBlockEntity::new, BlockInit.LAVA_BREWING_CAULDRON.get()).build(null));
	
	public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> SIGN_BLOCK_ENTITIES =
            BLOCK_ENTITIES.register("sign_block_entity", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            BlockInit.DEAD_OAK_WALL_SIGN.get(),
                            BlockInit.DEAD_OAK_SIGN.get()).build(null));
}
