package com.santapexie.kitchenmod.common.tiles;

import com.santapexie.kitchenmod.core.init.TileEntityTypesInit;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MixingBowlBlockTileEntity extends TileEntity {

	private NonNullList<ItemStack> bowlContents = NonNullList.withSize(12, ItemStack.EMPTY);

	public NonNullList<ItemStack> getBowlContents() {
		return bowlContents;
	}

	public void setBowlContents(NonNullList<ItemStack> bowlContents) {
		this.bowlContents = bowlContents;
		
	}

	public MixingBowlBlockTileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
		
	}

	public MixingBowlBlockTileEntity() {
		this(TileEntityTypesInit.MIXING_BOWL.get());
	}

	public CompoundNBT write(CompoundNBT compound) {
		return super.write(compound);
	}

	public void read(BlockState state, CompoundNBT nbt) {
	}

	public int getSizeInventory() {
		return 12;
	}

	public void addItemInventory(PlayerEntity playerIn, Hand handIn) {
		for (int i = 0; i < 9; i++) {
			if (!bowlContents.get(i).isEmpty()) {
				continue;
			}
			bowlContents.set(i, new ItemStack(playerIn.getHeldItemMainhand().getItem()));
			System.out.println(bowlContents);
			playerIn.getHeldItemMainhand().shrink(1);
			break;
		}

	}

	public void addLiquidInventory(PlayerEntity playerIn, Hand handIn) {
		System.out.println("addLiquidInventory has fired");
		for (int p = 9; p < 12; p++) {
			if (!bowlContents.get(p).isEmpty()) {
				continue;
			}
			bowlContents.set(p, playerIn.getHeldItemMainhand());
			int slot = playerIn.inventory.currentItem;
			playerIn.replaceItemInInventory(slot, new ItemStack(Items.BUCKET));
			System.out.println(bowlContents);
			break;
		}
	}

	public void removeLatestItem(PlayerEntity playerIn, World worldIn, BlockPos posIn, Hand handIn) {
		for (int e = 8; e > -1; e--) {
			if (!bowlContents.get(e).isEmpty()) {
				if (playerIn.inventory.getFirstEmptyStack() != -1) {
					playerIn.inventory.addItemStackToInventory(bowlContents.get(e).getStack());
					bowlContents.set(e, new ItemStack(Items.AIR));
					break;
				} else if (playerIn.inventory.hasItemStack(bowlContents.get(e).getStack())) {
					playerIn.inventory.addItemStackToInventory(bowlContents.get(e).getStack());
					bowlContents.set(e, new ItemStack(Items.AIR));
					break;
				} else {
					worldIn.addEntity(new ItemEntity(worldIn, posIn.getX() + 0.5, posIn.getY() + 1.125,
							posIn.getZ() + 0.5, bowlContents.get(e).getStack()));
					bowlContents.set(e, new ItemStack(Items.AIR));
					break;
				}
			}
			continue;

		}

	}

	public void removeLatestLiquid(PlayerEntity playerIn, World worldIn, BlockPos posIn, Hand handIn) {
		System.out.println("Right Click With Bucket Shifted");
		for (int l = 8; l > -1; l--) {
			if (!bowlContents.get(l).isEmpty()) {
				int slot = playerIn.inventory.currentItem;
				playerIn.replaceItemInInventory(slot, bowlContents.get(l).getStack());
				bowlContents.set(l, new ItemStack(Items.AIR));
				break;
			}
			continue;

		}

	}

}
