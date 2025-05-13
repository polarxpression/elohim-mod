package io.polarxpress.elohimspeaks.util;

import io.polarxpress.elohimspeaks.ElohimSpeaksMod;
import io.polarxpress.elohimspeaks.config.ElohimConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SoundHelper {

    private static final Random RANDOM = new Random();
    private static long lastGlobalSoundPlayTime = 0;
    private static final Map<String, Long> lastCategorySoundPlayTime = new HashMap<>();

    /**
     * Checks if a sound should be played based on probability and cooldowns.
     * @param player The player for whom the sound would play.
     * @param category The category of the sound.
     * @param specificProbability The base probability for this specific event.
     * @return True if the sound should play, false otherwise.
     */
    public static boolean shouldPlaySound(Player player, String category, double specificProbability) {
        if (player == null || player.level().isClientSide) {
            return false;
        }

        long currentTime = System.currentTimeMillis();
        double generalProbability = ElohimConfig.COMMON.generalProbability.get();
        if (generalProbability <= 0) return false; // Sounds globally disabled

        // Check global cooldown
        long globalCooldownMillis = ElohimConfig.COMMON.globalCooldownSeconds.get() * 1000L;
        if (currentTime - lastGlobalSoundPlayTime < globalCooldownMillis) {
            return false;
        }

        // Check category cooldown
        long categoryCooldownMillis = ElohimConfig.COMMON.categoryCooldownSeconds.get() * 1000L;
        if (lastCategorySoundPlayTime.getOrDefault(category, 0L) + categoryCooldownMillis > currentTime) {
            return false;
        }

        // Check probability
        double effectiveProbability = specificProbability * generalProbability;
        if (effectiveProbability <= 0) return false;
        if (RANDOM.nextDouble() >= effectiveProbability) {
            return false;
        }

        return true;
    }

    /**
     * Plays a sound for the player if conditions are met.
     * @param player The player.
     * @param category The sound category.
     * @param specificProbability The probability for this event.
     * @param volume Sound volume.
     * @param pitch Sound pitch.
     */
    public static void tryPlaySound(Player player, String category, double specificProbability, float volume, float pitch) {
        if (shouldPlaySound(player, category, specificProbability)) {
            SoundEvent soundToPlay = ThemeCategories.getRandomSound(category);
            if (soundToPlay != null && player instanceof ServerPlayer serverPlayer) {
                serverPlayer.playNotifySound(soundToPlay, SoundSource.VOICE, volume, pitch);
                lastGlobalSoundPlayTime = System.currentTimeMillis();
                lastCategorySoundPlayTime.put(category, System.currentTimeMillis());
                ElohimSpeaksMod.LOGGER.info("Playing sound from category {} for player {}", category, player.getName().getString());
            }
        }
    }
    
    /**
     * Plays a specific sound for the player if conditions (cooldowns only, probability assumed true) are met.
     * Use this for sounds that should always play if cooldowns allow (e.g., after a direct command or major event).
     * @param player The player.
     * @param sound The specific sound event to play.
     * @param category The sound category (for cooldown tracking).
     * @param volume Sound volume.
     * @param pitch Sound pitch.
     */
    public static void forcePlaySound(Player player, SoundEvent sound, String category, float volume, float pitch) {
        if (player == null || player.level().isClientSide || sound == null) {
            return;
        }

        long currentTime = System.currentTimeMillis();
        double generalProbability = ElohimConfig.COMMON.generalProbability.get();
        if (generalProbability <= 0) return; // Sounds globally disabled by config

        // Check global cooldown
        long globalCooldownMillis = ElohimConfig.COMMON.globalCooldownSeconds.get() * 1000L;
        if (currentTime - lastGlobalSoundPlayTime < globalCooldownMillis) {
            ElohimSpeaksMod.LOGGER.debug("Global cooldown active, not playing forced sound for {}", player.getName().getString());
            return;
        }

        // Check category cooldown
        long categoryCooldownMillis = ElohimConfig.COMMON.categoryCooldownSeconds.get() * 1000L;
        if (lastCategorySoundPlayTime.getOrDefault(category, 0L) + categoryCooldownMillis > currentTime) {
            ElohimSpeaksMod.LOGGER.debug("Category cooldown active for {}, not playing forced sound for {}", category, player.getName().getString());
            return;
        }
        
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.playNotifySound(sound, SoundSource.VOICE, volume, pitch);
            lastGlobalSoundPlayTime = System.currentTimeMillis();
            lastCategorySoundPlayTime.put(category, System.currentTimeMillis());
            ElohimSpeaksMod.LOGGER.info("Force playing sound {} (category {}) for player {}", sound.getLocation(), category, player.getName().getString());
        }
    }
}