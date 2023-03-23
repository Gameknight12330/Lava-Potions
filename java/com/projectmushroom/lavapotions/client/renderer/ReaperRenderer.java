package com.projectmushroom.lavapotions.client.renderer;

import com.projectmushroom.lavapotions.LavaPotions;
import com.projectmushroom.lavapotions.client.renderer.model.ReaperModel;
import com.projectmushroom.lavapotions.entity.Reaper;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ReaperRenderer<Type extends Reaper> extends MobRenderer<Type, ReaperModel<Type>> 
{

	private static final ResourceLocation TEXTURE = new ResourceLocation(LavaPotions.MOD_ID, 
			"textures/entity/reaper.png");
	
	public ReaperRenderer(EntityRendererProvider.Context context) 
	{
		super(context, new ReaperModel<>(context.bakeLayer(ReaperModel.LAYER_LOCATION)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(Type entity) 
	{
		return TEXTURE;
	}

}
