package com.santapexie.kitchenmod.common.blocks;

import com.santapexie.kitchenmod.core.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class SeparatorBlock extends BaseHorizontalBlock {


	public SeparatorBlock(Properties properties) {
		super(properties);
		runCalculation(Block.makeCuboidShape(0, 0, 0, 16, 9, 16));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));
	}
	
	
	
/*	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if(handIn.MAIN_HAND == handIn) {
		if(!worldIn.isRemote) {
			if (player.inventory.getCurrentItem() != null) {
	    		
	    		if(player.inventory.getCurrentItem().getItem() == ItemInit.FLOUR_PAPER_BAG.get()) {
				player.entityDropItem(new ItemStack(ItemInit.FLOUR.get()), 1.0f);
				player.entityDropItem(new ItemStack(ItemInit.PAPER_BAG.get()), 1.0f);
				player.getHeldItemMainhand().shrink(1);	
	    		}
	    		else {
	    			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	    		}
	    	}
			return ActionResultType.SUCCESS;
		}
		}
		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}
	
	
	*/
		
	
	
}
