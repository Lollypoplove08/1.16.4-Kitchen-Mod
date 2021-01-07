package com.santapexie.kitchenmod.core.init;

import com.santapexie.kitchenmod.KitchenMod;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

	public static final RegistryObject<Item> FLOUR = ITEMS.register("flour",
			() -> new Item(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(4)));
}