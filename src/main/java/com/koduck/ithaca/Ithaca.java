package com.koduck.ithaca;

import com.koduck.ithaca.blocks.Forge;
import com.koduck.ithaca.blocks.ModBlocks;
import com.koduck.ithaca.blocks.Test;
import com.koduck.ithaca.setup.ClientProxy;
import com.koduck.ithaca.setup.IProxy;
import com.koduck.ithaca.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("ithaca")
public class Ithaca
{

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public Ithaca() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            blockRegistryEvent.getRegistry().register(new Forge());

            blockRegistryEvent.getRegistry().register(new Test());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> blockRegistryEvent) {
            // register a new block here
            blockRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.FORGE, new Item.Properties()).setRegistryName("forge"));
            blockRegistryEvent.getRegistry().register(new BlockItem(ModBlocks.TEST, new Item.Properties()).setRegistryName("test"));
        }
    }
}
