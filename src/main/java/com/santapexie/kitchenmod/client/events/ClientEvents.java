package com.santapexie.kitchenmod.client.events;

import com.santapexie.kitchenmod.KitchenMod;
import com.santapexie.kitchenmod.core.init.ItemInit;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = KitchenMod.MOD_ID, bus = Bus.MOD)
public class ClientEvents {

	@SubscribeEvent
	public static void clientEvents(FMLClientSetupEvent event) {
		
		ItemModelsProperties.registerProperty(ItemInit.CUPCAKE.get(), new ResourceLocation(KitchenMod.MOD_ID, "count"),
				new IItemPropertyGetter() {

					@Override
					public float call(ItemStack stack, ClientWorld worldin, LivingEntity entityin) {
						switch (stack.getCount()) {
						case 1:
							return 0.25f;
						case 2:
							return 0.5f;
						case 3:
							return 0.75f;
						case 4:
							return 1.0f;
						default:
							return 0.0f;
						}
					}
				});	
		
		ItemModelsProperties.registerProperty(ItemInit.FLOUR.get(), new ResourceLocation(KitchenMod.MOD_ID, "count"),
				new IItemPropertyGetter() {

					@Override
					public float call(ItemStack stack, ClientWorld worldin, LivingEntity entityin) {
						switch (stack.getCount()) {
						case 1:
							return 0.25f;
						case 2:
							return 0.25f;
						case 3:
							return 0.25f;
						case 4:
							return 0.25f;
						case 5:
							return 0.5f;
						case 6:
							return 0.5f;
						case 7:
							return 0.5f;
						case 8:
							return 0.5f;
						case 9:
							return 0.75f;
						case 10:
							return 0.75f;
						case 11:
							return 0.75f;
						case 12:
							return 0.75f;
						case 13:
							return 1.0f;
						case 14:
							return 1.0f;
						case 15:
							return 1.0f;
						case 16:
							return 1.0f;
						default:
							return 0.0f;
						}
					}
				});
	}
		
}
