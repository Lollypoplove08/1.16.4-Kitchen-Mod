package com.santapexie.kitchenmod.core.init;

import java.util.function.Supplier;

import com.santapexie.kitchenmod.KitchenMod;
import com.santapexie.kitchenmod.common.tiles.MixingBowlBlockTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, KitchenMod.MOD_ID);
	
	public static final RegistryObject<TileEntityType<MixingBowlBlockTileEntity>> MIXING_BOWL = TILE_ENTITY_TYPE.register("mixing_bowl",  () -> TileEntityType.Builder.create(MixingBowlBlockTileEntity::new, BlockInit.MIXING_BOWL.get()).build(null));

	
	
}
