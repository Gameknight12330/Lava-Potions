package com.projectmushroom.lavapotions.recipe;

import com.projectmushroom.lavapotions.LavaPotions;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, LavaPotions.MOD_ID);
    
    public static RecipeType<LavaBrewingCauldronRecipe> LAVA_BREWING_TYPE;

    public static final RegistryObject<RecipeSerializer<LavaBrewingCauldronRecipe>> LAVA_BREWING_SERIALIZER =
            SERIALIZERS.register("lava_brewing", () -> LavaBrewingCauldronRecipe.Serializer.INSTANCE);
    
    public static void init() { // Run this in FMLCommonSetupEvent
        LAVA_BREWING_TYPE = RecipeType.register("lavapotions:lava_brewing");
    }
}