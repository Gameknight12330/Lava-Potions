package com.projectmushroom.lavapotions.client;

import java.util.Random;
import java.util.UUID;

import com.projectmushroom.lavapotions.effect.LavaEffects;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.living.PotionEvent.PotionAddedEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class WaterControlStartEvent extends Event {
	
	Random rnd = new Random();
	
	AttributeModifier waterbuff = new AttributeModifier(UUID.fromString("7ab521ed-8c51-4c1a-a8ee-576a7be48948"),
			"waterbuff", 3.0D, AttributeModifier.Operation.MULTIPLY_TOTAL);
	
	int ticks = 0;
	
	boolean applied = false;

	@SubscribeEvent
	public void onWaterControlStart(PotionAddedEvent event)
	{
		if (event.getPotionEffect().getEffect().equals(LavaEffects.WATER_CONTROL.get()))
		{
			LivingEntity entity = event.getEntityLiving();
			ticks = 0;
			System.out.println("Potion started");
			entity = event.getEntityLiving();
			if (entity.getLevel() instanceof ServerLevel) 
			{
				System.out.println("Level is a serverlevel");
				ServerLevel level = (ServerLevel) entity.getLevel();
				for (int i = 1; i < 5; i++)
				{
					controlTsunami(0, entity, level, i);
				}
		    }
	    }
	}
	
	public void controlTsunami(int stage, LivingEntity entity, ServerLevel level, int direction)
	{
		if (direction == 1)
		{
			int x = 10 + stage;
			for (int y = 0; y <= 7 - stage; y += 1) 
		    {
				for (int z = -10; z <= 10; z += 1) 
				{
				    Block block = level.getBlockState(new BlockPos(entity.getBlockX() + x, entity.getBlockY() + y, entity.getBlockZ() - z)).getBlock();
				    System.out.println("Found a block");
				    if (block.getClass() == Blocks.AIR.getClass()) 
					{
						level.setBlock(new BlockPos(entity.getBlockX() + x, entity.getBlockY() + y, entity.getBlockZ() - z), Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
					    System.out.println("there is water at " + x + y + z);
			        }
		        }
		    }
		}
		
		if (direction == 2)
		{
			int x = 10 + stage;
			for (int y = 0; y <= 7 - stage; y += 1) 
		    {
				for (int z = -10; z <= 10; z += 1) 
				{
				    Block block = level.getBlockState(new BlockPos(entity.getBlockX() - x, entity.getBlockY() + y, entity.getBlockZ() - z)).getBlock();
				    System.out.println("Found a block");
				    if (block.getClass() == Blocks.AIR.getClass()) 
					{
						level.setBlock(new BlockPos(entity.getBlockX() - x, entity.getBlockY() + y, entity.getBlockZ() - z), Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
					    System.out.println("there is water at " + x + y + z);
			        }
		        }
		    }
		}
		if (direction == 3)
		{
			int z2 = 10 + stage;
			for (int y = 0; y <= 7 - stage; y += 1) 
		    {
				for (int x2 = -10; x2 <= 10; x2 += 1) 
				{
				    Block block = level.getBlockState(new BlockPos(entity.getBlockX() + x2, entity.getBlockY() + y, entity.getBlockZ() - z2)).getBlock();
				    System.out.println("Found a block");
				    if (block.getClass() == Blocks.AIR.getClass()) 
					{
						level.setBlock(new BlockPos(entity.getBlockX() + x2, entity.getBlockY() + y, entity.getBlockZ() - z2), Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
					    System.out.println("there is water at " + x2 + y + z2);
			        }
		        }
		    }
		}
		
		if (direction == 4)
		{
			int z2 = 10 + stage;
			for (int y = 0; y <= 7 - stage; y += 1) 
		    {
				for (int x2 = -10; x2 <= 10; x2 += 1) 
				{
				    Block block = level.getBlockState(new BlockPos(entity.getBlockX() + x2, entity.getBlockY() + y, entity.getBlockZ() + z2)).getBlock();
				    System.out.println("Found a block");
				    if (block.getClass() == Blocks.AIR.getClass()) 
					{
						level.setBlock(new BlockPos(entity.getBlockX() + x2, entity.getBlockY() + y, entity.getBlockZ() + z2), Blocks.WATER.defaultBlockState(), Block.UPDATE_ALL);
					    System.out.println("there is water at " + x2 + y + z2);
			        }
		        }
		    }
		}
	}
	
	@SubscribeEvent
	public void waterControlTick(PlayerTickEvent event)
	{
		Player entity = event.player;
		if (entity.hasEffect(LavaEffects.WATER_CONTROL.get()))
		{
			ticks += 1;
			if (ticks > 0 && ticks % 10 == 0 && ticks / 10 < 7 && entity.getLevel() instanceof ServerLevel)
			{
				int stage = ticks / 10;
				for (int i = 1; i < 5; i++)
				{
					controlTsunami(stage, entity, ((ServerLevel) entity.getLevel()), i);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void waterBuffsTick(PlayerTickEvent event)
	{
		Player player = event.player;
		if (player.isInWater()) {
	        CollisionContext collisioncontext = CollisionContext.of(player);
	        if (collisioncontext.isAbove(LiquidBlock.STABLE_SHAPE, player.blockPosition(), true) && !player.level.getFluidState(player.blockPosition().above()).is(FluidTags.WATER)) {
	            player.setOnGround(true);
	        } else {
	            player.setDeltaMovement(player.getDeltaMovement().scale(0.5D).add(0.0D, 0.05D, 0.0D));
	        }
	        if (player.hasEffect(LavaEffects.WATER_CONTROL.get()) && !player.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(waterbuff))
			{
	        	player.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(waterbuff);
				player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).addTransientModifier(waterbuff);
				player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(waterbuff);
				player.getAttribute(Attributes.ATTACK_SPEED).addTransientModifier(waterbuff);
				player.getAttribute(ForgeMod.ATTACK_RANGE.get()).addTransientModifier(waterbuff);
				player.getAttribute(ForgeMod.REACH_DISTANCE.get()).addTransientModifier(waterbuff);
			}
	    } 
        if (!player.isInWater() && player.hasEffect(LavaEffects.WATER_CONTROL.get()) && player.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(waterbuff))
		{	
        	player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(waterbuff);
	    	player.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(waterbuff);
			player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(waterbuff);
			player.getAttribute(Attributes.ATTACK_SPEED).removeModifier(waterbuff);
			player.getAttribute(ForgeMod.ATTACK_RANGE.get()).removeModifier(waterbuff);
			player.getAttribute(ForgeMod.REACH_DISTANCE.get()).removeModifier(waterbuff);
		}
	}
}
