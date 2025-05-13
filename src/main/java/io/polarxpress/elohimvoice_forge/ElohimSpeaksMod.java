package io.polarxpress.elohimspeaks;

import io.polarxpress.elohimspeaks.config.ElohimConfig;
import io.polarxpress.elohimspeaks.handlers.PlayerEventHandler; // New Handler
import io.polarxpress.elohimspeaks.handlers.WorldEventHandler;   // New Handler
import io.polarxpress.elohimspeaks.init.SoundRegistry;
import io.polarxpress.elohimspeaks.client.ElohimSpeaksClient; // For client setup

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ElohimSpeaksMod.MOD_ID)
public class ElohimSpeaksMod {
    public static final String MOD_ID = "elohimspeaks";
    public static final Logger LOGGER = LogManager.getLogger();

    public ElohimSpeaksMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        // Register the setup methods for modloading
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup); // Changed from this::clientSetup to direct call
        
        // Register our sound events
        SoundRegistry.register(modEventBus);
        
        // Register configs
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ElohimConfig.COMMON_SPEC);
        
        // Register ourselves for server and other game events
        // MinecraftForge.EVENT_BUS.register(this); // No longer needed if this class has no @SubscribeEvent methods

        // Register the new specific event handlers
        MinecraftForge.EVENT_BUS.register(new PlayerEventHandler());
        MinecraftForge.EVENT_BUS.register(new WorldEventHandler());
        // The old generic EventHandler is no longer needed if its responsibilities are fully moved.
        // If you had an `EventHandler.java` file, you can remove its registration or the file itself
        // if PlayerEventHandler and WorldEventHandler cover all its previous functionality.
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("ElohimSpeaks: Initializing mod (Common Setup)");
        // Example: Network registration, etc.
        // PacketHandler.register(); 
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("ElohimSpeaks: Client setup initialized");
        ElohimSpeaksClient.init(event); // Delegate to client-specific setup
    }
}
