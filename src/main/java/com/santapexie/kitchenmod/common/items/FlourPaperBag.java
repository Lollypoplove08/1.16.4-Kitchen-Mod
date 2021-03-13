package com.santapexie.kitchenmod.common.items;

import com.santapexie.kitchenmod.core.init.ItemInit;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class FlourPaperBag extends Item {

	public FlourPaperBag(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity playerIn, Hand handIn) {

		PlayerEntity player = playerIn;
		player.entityDropItem(new ItemStack(ItemInit.FLOUR.get()), 1.0f);
		player.entityDropItem(new ItemStack(ItemInit.PAPER_BAG.get()));
		playerIn.getHeldItemMainhand().shrink(1);

		playerIn.container.detectAndSendChanges();
		return super.onItemRightClick(world, playerIn, handIn);
		

	}
	
}
