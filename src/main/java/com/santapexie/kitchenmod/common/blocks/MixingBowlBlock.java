package com.santapexie.kitchenmod.common.blocks;

import java.util.HashSet;
import java.util.stream.Stream;

import com.santapexie.kitchenmod.common.tiles.MixingBowlBlockTileEntity;
import com.santapexie.kitchenmod.core.init.ItemInit;
import com.santapexie.kitchenmod.core.init.TileEntityTypesInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
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

public class MixingBowlBlock extends Block {
	
	public static final IntegerProperty LEVEL = IntegerProperty.create("level", 0, 12);

	private MixingBowlBlockTileEntity te;
	public static MixingBowlBlock C1;

	void Awake() {
		C1 = this;
	}

	private final static HashSet<Item> canMix = new HashSet<Item>();
	private final static HashSet<Item> canLiquid = new HashSet<Item>();
	private final static HashSet<Item> canBucket = new HashSet<Item>();

	public void addCanLiquid(final Item canMix) {

	}

	public void addCanBucket(final Item canBucket) {

	}

	public static HashSet<Item> getCanLiquid() {
		canLiquid.add(Items.MILK_BUCKET);
		canLiquid.add(Items.WATER_BUCKET);
		return canLiquid;
	}

	public static HashSet<Item> getCanBucket() {
		canBucket.add(Items.BUCKET);
		return canBucket;
	}

	public static HashSet<Item> getList1() {
		return canLiquid;
	}

	public static HashSet<Item> getList2() {
		return canBucket;
	}

	public void addCanMix(final Item canMix) {

	}

	public static HashSet<Item> getCanMix() {
		canMix.add(ItemInit.FLOUR.get());
		canMix.add(ItemInit.DOUGH.get());
		canMix.add(Items.EGG);
		return canMix;
	}

	public static HashSet<Item> getList() {
		return canMix;
	}

	public MixingBowlBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(LEVEL, Integer.valueOf(0)));
	}

	

	@SuppressWarnings({ "deprecation", "static-access" })
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (player.inventory.getCurrentItem().getItem() != ItemInit.WOODEN_SPOON.get()) {
			ItemStack itemstack = player.getHeldItem(handIn);
			TileEntity te = worldIn.getTileEntity(pos);
			if (handIn.MAIN_HAND == handIn) {
				if (!worldIn.isRemote) {
					if (player.isSneaking()) {
						System.out.println("U have snuk");
						if (player.getHeldItemMainhand().getItem() == Items.BUCKET) {
							System.out.println("bucket");
							if (te instanceof MixingBowlBlockTileEntity) {
								System.out.println("sfsd");
								((MixingBowlBlockTileEntity) te).removeLatestItem(player, worldIn, pos, handIn);
							}
						} else {
							if (te instanceof MixingBowlBlockTileEntity) {
								System.out.println("LOO");
								((MixingBowlBlockTileEntity) te).removeLatestLiquid(player, worldIn, pos, handIn);
							}
						}

					}
					if (player.inventory.getCurrentItem() != null) {
						if (player.getHeldItemMainhand().getItem() == Items.MILK_BUCKET) {
							if (te instanceof MixingBowlBlockTileEntity) {

								((MixingBowlBlockTileEntity) te).addLiquidInventory(player, handIn);
							}
						}

						else if (getCanMix().contains(itemstack.getItem())) {
							if (te instanceof MixingBowlBlockTileEntity) {

								((MixingBowlBlockTileEntity) te).addItemInventory(player, handIn);
							}

						} else {
							return ActionResultType.PASS;
						}
					} else {
						return ActionResultType.PASS;
					}
				} else {
					return ActionResultType.PASS;
				}
				return ActionResultType.SUCCESS;
			}
		} else {

		}

		return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
	}

	@SuppressWarnings("deprecation")
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (!state.isIn(newState.getBlock())) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof IInventory) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}

			super.onReplaced(state, worldIn, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return TileEntityTypesInit.MIXING_BOWL.get().create();
	}

}
