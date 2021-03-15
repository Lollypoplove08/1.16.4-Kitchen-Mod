package com.santapexie.kitchenmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.santapexie.kitchenmod.common.blocks.MixingBowlBlock;
import com.santapexie.kitchenmod.core.init.BlockInit;
import com.santapexie.kitchenmod.core.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KitchenMod.MOD_ID)
public class KitchenMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "pexiekitchen";

    public KitchenMod() {
       IEventBus bus =  FMLJavaModLoadingContext.get().getModEventBus();
       bus.addListener(this::setup);
    	
       ItemInit.ITEMS.register(bus);
       BlockInit.BLOCKS.register(bus);

         MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        
    }
}
