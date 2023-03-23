package com.projectmushroom.lavapotions.client.event;

import com.projectmushroom.lavapotions.LavaPotions;
import com.projectmushroom.lavapotions.client.renderer.model.ReaperModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LavaPotions.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {
	
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(ReaperModel.LAYER_LOCATION, ReaperModel::createBodyLayer);
	}
}
