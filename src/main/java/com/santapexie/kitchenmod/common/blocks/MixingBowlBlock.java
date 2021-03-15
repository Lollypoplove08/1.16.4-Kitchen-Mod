package com.santapexie.kitchenmod.common.blocks;

import java.util.HashSet;
import java.util.stream.Stream;

import com.santapexie.kitchenmod.core.init.ItemInit;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MixingBowlBlock extends BaseHorizontalBlock {

	private static HashSet<Item> canMix = new HashSet<Item>();
	public static void main(String[] args) {
        getList();
        main(args);
    }


	public static HashSet<Item> getList() {
		canMix.add(ItemInit.FLOUR.get());
		return canMix;
	}

	public MixingBowlBlock(AbstractBlock.Properties properties) {
		super(properties);
		runCalculation(Stream.of(Block.makeCuboidShape(1, 0, 1, 15, 2, 15), Block.makeCuboidShape(0, 0, 0, 16, 16, 1),
				Block.makeCuboidShape(0, 0, 1, 1, 16, 16), Block.makeCuboidShape(15, 0, 1, 16, 16, 16),
				Block.makeCuboidShape(1, 0, 15, 15, 16, 16)).reduce((v1, v2) -> {
					return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);
				}).get());
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPES.get(this).get(state.get(HORIZONTAL_FACING));

	}

	@SuppressWarnings("deprecation")
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		if(handIn.MAIN_HAND == handIn) {
		if(!worldIn.isRemote) {
			if (player.inventory.getCurrentItem() != null) {
				if (canMix.contains(itemstack.getItem())) {
					player.getHeldItemMainhand().shrink(1);
				}
			      
	    		else {
	    			return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	    		}
	    	}
		}
			return ActionResultType.SUCCESS;
		}
		return super.onBlockActivated(state,worldIn,pos,player,handIn,hit);
}

}
