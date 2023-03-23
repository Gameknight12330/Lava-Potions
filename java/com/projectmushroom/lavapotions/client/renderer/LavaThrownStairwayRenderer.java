package com.projectmushroom.lavapotions.client.renderer;

import com.projectmushroom.lavapotions.entity.LavaThrownScalding;
import com.projectmushroom.lavapotions.entity.LavaThrownStairway;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;

public class LavaThrownStairwayRenderer extends ThrownItemRenderer<LavaThrownStairway>{
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("lavapotions:textures/entity/stairway_splash.png");

	public LavaThrownStairwayRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }
	
	public ResourceLocation getTextureLocation(LavaThrownScalding entity) {
	   return TEXTURE;
	}
}
