package com.projectmushroom.lavapotions.block.entity.custom;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import com.projectmushroom.lavapotions.block.entity.ModBlockEntities;
import com.projectmushroom.lavapotions.init.ItemInit;
import com.projectmushroom.lavapotions.screen.LavaBrewingCauldronMenu;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class LavaBrewingStationBlockEntity extends BlockEntity implements MenuProvider {
	private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
        
		@Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    public LavaBrewingStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(ModBlockEntities.LAVA_BREWING_CAULDRON_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    public Component getDisplayName() {
        return new TextComponent("Lava Brewing Cauldron");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new LavaBrewingCauldronMenu(pContainerId, pInventory, this);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps()  {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        tag.put("inventory", itemHandler.serializeNBT());
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
    
    public static void tick(Level level, BlockPos pPos, BlockState pState, LavaBrewingStationBlockEntity pBlockEntity) {
    	if (hasRecipe(pBlockEntity) && hasNotReachedStackLimit(pBlockEntity)) {
    		craftItem(pBlockEntity);
    	}
    }
    
    private static void craftItem(LavaBrewingStationBlockEntity entity) {
        entity.itemHandler.extractItem(3, 1, false);
        entity.itemHandler.extractItem(4, 1, false);
        entity.itemHandler.extractItem(5, 1, false);
        for (int i = 0; i < 3; i++) 
        {
        	if (entity.itemHandler.getStackInSlot(i).getItem() == ItemInit.LAVA_BOTTLE.get())
        	{
        		entity.itemHandler.setStackInSlot(i, new ItemStack(ItemInit.STAIRWAY.get(),
                entity.itemHandler.getStackInSlot(i).getCount() + 1));
        	}
        }
    }

    private static boolean hasRecipe(LavaBrewingStationBlockEntity entity) {
        boolean hasItemInLavaBottle1Slot = entity.itemHandler.getStackInSlot(0).getItem() == ItemInit.LAVA_BOTTLE.get();
        boolean hasItemInLavaBottle2Slot = entity.itemHandler.getStackInSlot(1).getItem() == ItemInit.LAVA_BOTTLE.get();
        boolean hasItemInLavaBottle3Slot = entity.itemHandler.getStackInSlot(2).getItem() == ItemInit.LAVA_BOTTLE.get();
        boolean hasItemInIngredientSlot1 = entity.itemHandler.getStackInSlot(3).getItem() == Items.ENCHANTED_GOLDEN_APPLE;
        boolean hasItemInIngredientSlot2 = entity.itemHandler.getStackInSlot(4).getItem() == Items.NETHER_STAR;
        boolean hasItemInIngredientSlot3 = entity.itemHandler.getStackInSlot(5).getItem() == null;

        return hasItemInLavaBottle1Slot && hasItemInLavaBottle2Slot && hasItemInLavaBottle3Slot && hasItemInIngredientSlot1 && hasItemInIngredientSlot2 && hasItemInIngredientSlot3;
    }

    private static boolean hasNotReachedStackLimit(LavaBrewingStationBlockEntity entity) {
        return entity.itemHandler.getStackInSlot(3).getCount() < entity.itemHandler.getStackInSlot(3).getMaxStackSize();
    }

}
