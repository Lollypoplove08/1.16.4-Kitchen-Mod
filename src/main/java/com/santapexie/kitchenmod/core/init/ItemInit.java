package com.santapexie.kitchenmod.core.init;

import com.santapexie.kitchenmod.KitchenMod;
import com.santapexie.kitchenmod.common.items.FlourPaperBag;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			KitchenMod.MOD_ID);

	public static final RegistryObject<Item> DOUGH = ITEMS.register("dough",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)));

	@SuppressWarnings("deprecation")
	public static final RegistryObject<Item> COOKED_FLESH = ITEMS.register("cooked_flesh",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
					.effect(new EffectInstance(Effects.HUNGER, 200, 1), 0.2f).hunger(4).saturation(0.8f).build())
					.maxStackSize(64)));

	public static final RegistryObject<Item> FISH_STEW = ITEMS.register("fish_stew",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(6).saturation(1.2f).build()).maxStackSize(1)));

	public static final RegistryObject<Item> APPLE_PIE = ITEMS.register("apple_pie",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(8).saturation(1.2f).build()).maxStackSize(64)));

	public static final RegistryObject<Item> COOKED_PIZZA = ITEMS.register("cooked_pizza",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(8).saturation(1.2f).build()).maxStackSize(64)));

	public static final RegistryObject<Item> UNCOOKED_PIZZA = ITEMS.register("uncooked_pizza",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(3).saturation(0.9f).build()).maxStackSize(64)));

	public static final RegistryObject<Item> CUPCAKE = ITEMS.register("cupcake",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(6).saturation(0.6f).fastToEat().build()).maxStackSize(4)));

	@SuppressWarnings("deprecation")

	public static final RegistryObject<Item> RAW_MEAT_SKEWER = ITEMS.register("raw_meat_skewer",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD).food(new Food.Builder()
					.effect(new EffectInstance(Effects.HUNGER, 600, 1), 0.3f).hunger(3).saturation(0.6f).build())
					.maxStackSize(16)));

	public static final RegistryObject<Item> COOKED_MEAT_SKEWER = ITEMS.register("cooked_meat_skewer",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD)
					.food(new Food.Builder().hunger(8).saturation(1.6f).build()).maxStackSize(16)));

	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(16)));

	public static final RegistryObject<Item> PAPER_BAG = ITEMS.register("paper_bag",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64)));

	public static final RegistryObject<FlourPaperBag> FLOUR_PAPER_BAG = ITEMS.register("paper_bag_flour",
			() -> new FlourPaperBag(new Item.Properties().group(ItemGroup.MISC).maxStackSize(16)));
	
	public static final RegistryObject<Item> WOODEN_SPOON = ITEMS.register("wooden_spoon",
			() -> new Item(new Item.Properties().group(ItemGroup.MISC).maxStackSize(1)));

	// Block Items
	public static final RegistryObject<BlockItem> SEPARATOR = ITEMS.register("separator",
			() -> new BlockItem(BlockInit.SEPARATOR.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(64)));
	
	public static final RegistryObject<BlockItem> MIXING_BOWL = ITEMS.register("mixing_bowl",
			() -> new BlockItem(BlockInit.MIXING_BOWL.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS).maxStackSize(64)));

}
