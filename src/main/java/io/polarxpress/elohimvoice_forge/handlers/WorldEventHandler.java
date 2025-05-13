package io.polarxpress.elohimspeaks.handlers;

import io.polarxpress.elohimspeaks.ElohimSpeaksMod;
import io.polarxpress.elohimspeaks.config.ElohimConfig;
import io.polarxpress.elohimspeaks.util.SoundHelper;
import io.polarxpress.elohimspeaks.util.ThemeCategories;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles events related to the game world, like time changes.
 */
@Mod.EventBusSubscriber(modid = ElohimSpeaksMod.MOD_ID)
public class WorldEventHandler {

    private boolean sunriseSoundPlayedToday = false;
    private boolean sunsetSoundPlayedToday = false;
    private boolean midnightSoundPlayedToday = false;
    private long lastDayTime = -1; // Used to detect a new day

    @SubscribeEvent
    public void onWorldTick(TickEvent.LevelTickEvent event) {
        // This event fires for each world (Overworld, Nether, End, etc.) on both server and client.
        // We are interested in server-side Overworld ticks.
        if (event.phase == TickEvent.Phase.END && event.level.dimension() == Level.OVERWORLD && !event.level.isClientSide) {
            Level world = event.level;
            long currentTimeInDay = world.getDayTime() % 24000; // Current time in ticks within a 24000-tick day cycle

            // Reset daily flags if a new day has started
            // A new day starts when the current time is less than the last recorded time (e.g., 23999 -> 0)
            if (lastDayTime > currentTimeInDay) {
                sunriseSoundPlayedToday = false;
                sunsetSoundPlayedToday = false;
                midnightSoundPlayedToday = false;
                ElohimSpeaksMod.LOGGER.debug("New day detected. Resetting daily sound flags.");
            }
            lastDayTime = currentTimeInDay;

            // Sunrise (approx 0-200 ticks, Minecraft sunrise starts at 23000 or 0)
            // Let's use a broader window around 0 (new day) and 23000 (just before new day)
            if ((currentTimeInDay >= 0 && currentTimeInDay < 200) || (currentTimeInDay >= 23000 && currentTimeInDay < 23200)) {
                if (!sunriseSoundPlayedToday) {
                    world.players().forEach(player -> {
                        if (player instanceof ServerPlayer && !player.isSpectator()) {
                            SoundHelper.tryPlaySound(player, ThemeCategories.CREATION, ElohimConfig.COMMON.sunriseProbability.get(), 1.0f, 1.0f);
                        }
                    });
                    sunriseSoundPlayedToday = true;
                    if (ElohimConfig.COMMON.sunriseProbability.get() > 0) ElohimSpeaksMod.LOGGER.info("Sunrise sound trigger checked.");
                }
            }
            // Sunset (approx 12000-12200 ticks)
            else if (currentTimeInDay >= 12000 && currentTimeInDay < 12200) {
                if (!sunsetSoundPlayedToday) {
                    world.players().forEach(player -> {
                        if (player instanceof ServerPlayer && !player.isSpectator()) {
                            SoundHelper.tryPlaySound(player, ThemeCategories.PHILOSOPHY, ElohimConfig.COMMON.sunsetProbability.get(), 1.0f, 1.0f);
                        }
                    });
                    sunsetSoundPlayedToday = true;
                     if (ElohimConfig.COMMON.sunsetProbability.get() > 0) ElohimSpeaksMod.LOGGER.info("Sunset sound trigger checked.");
                }
            }
            // Midnight (approx 18000-18200 ticks)
            else if (currentTimeInDay >= 18000 && currentTimeInDay < 18200) {
                 if (!midnightSoundPlayedToday) {
                    world.players().forEach(player -> {
                        if (player instanceof ServerPlayer && !player.isSpectator()) {
                            SoundHelper.tryPlaySound(player, ThemeCategories.WARNING, ElohimConfig.COMMON.midnightProbability.get(), 1.0f, 1.0f);
                        }
                    });
                    midnightSoundPlayedToday = true;
                    if (ElohimConfig.COMMON.midnightProbability.get() > 0) ElohimSpeaksMod.LOGGER.info("Midnight sound trigger checked.");
                }
            }
        }
    }
}
