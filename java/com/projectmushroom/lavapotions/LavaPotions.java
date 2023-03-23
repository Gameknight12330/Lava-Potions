package com.projectmushroom.lavapotions;

import com.projectmushroom.lavapotions.block.entity.ModBlockEntities;
import com.projectmushroom.lavapotions.client.BurningSpeedStartEvent;
import com.projectmushroom.lavapotions.client.ClientSetup;
import com.projectmushroom.lavapotions.client.CripplingStartEvent;
import com.projectmushroom.lavapotions.client.FieryRegenStartEvent;
import com.projectmushroom.lavapotions.client.HellishStartEvent;
import com.projectmushroom.lavapotions.client.HighwayStartEvent;
import com.projectmushroom.lavapotions.client.InvincStartEvent;
import com.projectmushroom.lavapotions.client.SoulFlameStartEvent;
import com.projectmushroom.lavapotions.client.StridingStartEvent;
import com.projectmushroom.lavapotions.client.TheosStartEvent;
import com.projectmushroom.lavapotions.client.VanishingStartEvent;
import com.projectmushroom.lavapotions.client.VolcanicStartEvent;
import com.projectmushroom.lavapotions.effect.LavaEffects;
import com.projectmushroom.lavapotions.init.BlockInit;
import com.projectmushroom.lavapotions.init.EntityInit;
import com.projectmushroom.lavapotions.init.ItemInit;
import com.projectmushroom.lavapotions.screen.ModMenuTypes;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("lavapotions")
public class LavaPotions {
	
	public static final String MOD_ID = "lavapotions";
	
	public static final CreativeModeTab LAVA_POTIONS = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			return new ItemStack(ItemInit.LAVA_BOTTLE.get());
		}
	};

	public LavaPotions() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
	    IEventBus forgeBus = MinecraftForge.EVENT_BUS;
		
	    forgeBus.register(new HighwayStartEvent());
	    forgeBus.register(new BurningSpeedStartEvent());
	    forgeBus.register(new SoulFlameStartEvent());
	    forgeBus.register(new FieryRegenStartEvent());
	    forgeBus.register(new InvincStartEvent());
	    forgeBus.register(new VanishingStartEvent());
	    forgeBus.register(new VolcanicStartEvent());
	    forgeBus.register(new StridingStartEvent());
	    forgeBus.register(new CripplingStartEvent());
	    forgeBus.register(new HellishStartEvent());
	    forgeBus.register(new TheosStartEvent());
		
		ItemInit.ITEMS.register(bus);
		
		BlockInit.BLOCKS.register(bus);
		
		ModMenuTypes.MENUS.register(bus);
		
		LavaEffects.LAVA_EFFECTS.register(bus);
		
		EntityInit.ENTITIES.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
}
