package com.santapexie.kitchenmod.core.init;

import com.santapexie.kitchenmod.KitchenMod;
import com.santapexie.kitchenmod.common.blocks.SeparatorBlock;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			KitchenMod.MOD_ID);

	public static final RegistryObject<SeparatorBlock> SEPARATOR = BLOCKS
			.register("separator",
					() -> new SeparatorBlock(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.GRAY)
							.hardnessAndResistance(3.5f, 3.5f).harvestTool(ToolType.PICKAXE).harvestLevel(0)
							.sound(SoundType.STONE).setRequiresTool()));
}
