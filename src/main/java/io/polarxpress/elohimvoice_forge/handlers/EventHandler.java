package io.polarxpress.elohimspeaks.handlers;

import io.polarxpress.elohimspeaks.config.ElohimConfig;
import io.polarxpress.elohimspeaks.util.SoundHelper;
import io.polarxpress.elohimspeaks.util.ThemeCategories;
import io.polarxpress.elohimspeaks.ElohimSpeaksMod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.event.level.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElohimSpeaksMod.MOD_ID)
public class EventHandler {

    private boolean sunriseSoundPlayedToday = false;
    private boolean sunsetSoundPlayedToday = false;
    private boolean midnightSoundPlayedToday = false;
    private long lastDayTime = -1;

    // --- Player Action Events ---

    @SubscribeEvent
    public static void onBlockBreak(BreakEvent event) {
        // Event for when a player breaks a block
        if (event.getPlayer() != null && !event.getPlayer().level().isClientSide) {
            Player player = event.getPlayer();
            SoundHelper.tryPlaySound(player, ThemeCategories.BLOCK_INTERACTION, ElohimConfig.COMMON.breakBlockProbability.get(), 1.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public static void onBlockPlace(EntityPlaceEvent event) {
        // Event for when a player places a block
        // Check if the entity that placed the block is a player
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (!player.level().isClientSide) {
                SoundHelper.tryPlaySound(player, ThemeCategories.BLOCK_INTERACTION, ElohimConfig.COMMON.placeBlockProbability.get(), 1.0f, 1.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        // Event for when a player attacks an entity
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            SoundHelper.tryPlaySound(player, ThemeCategories.COMBAT_REFLECTION, ElohimConfig.COMMON.attackEntityProbability.get(), 1.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public static void onPlayerDamaged(LivingDamageEvent event) {
        // Event for when a player takes damage
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (!player.level().isClientSide) {
                SoundHelper.tryPlaySound(player, ThemeCategories.WARNING, ElohimConfig.COMMON.takeDamageProbability.get(), 1.0f, 1.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent event) {
        // Event for when a player kills an entity
        if (event.getSource().getEntity() instanceof Player) {
            Player player = (Player) event.getSource().getEntity();
            if (!player.level().isClientSide) {
                SoundHelper.tryPlaySound(player, ThemeCategories.ACHIEVEMENT, ElohimConfig.COMMON.killEntityProbability.get(), 1.0f, 1.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onAdvancement(AdvancementEvent.AdvancementEarnEvent event) {
        // Event for when a player earns an advancement
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            // Check if the advancement is not a recipe
             if (event.getAdvancement().getDisplay() != null && event.getAdvancement().getDisplay().shouldAnnounceChat()) {
                SoundHelper.tryPlaySound(player, ThemeCategories.ACHIEVEMENT, ElohimConfig.COMMON.advancementProbability.get(), 1.0f, 1.0f);
            }
        }
    }

    @SubscribeEvent
    public static void onDimensionChange(PlayerChangedDimensionEvent event) {
        // Event for when a player changes dimension
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            SoundHelper.tryPlaySound(player, ThemeCategories.LORE, ElohimConfig.COMMON.dimensionChangeProbability.get(), 1.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public static void onUseItem(RightClickItem event) {
        // Event for when a player uses (right-clicks) an item
        Player player = event.getEntity();
        if (!player.level().isClientSide) {
            // Potentially add item-specific checks here if needed
            SoundHelper.tryPlaySound(player, ThemeCategories.GUIDANCE, ElohimConfig.COMMON.useItemProbability.get(), 1.0f, 1.0f);
        }
    }

    // --- Time-Based Events ---
    @SubscribeEvent
    public void onWorldTick(TickEvent.LevelTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.level.dimension() == Level.OVERWORLD && !event.level.isClientSide) {
            Level world = event.level;
            long currentTime = world.getDayTime() % 24000; // Current time in ticks (0-23999)

            // Reset daily flags if new day
            if (lastDayTime > currentTime) { // New day has started
                sunriseSoundPlayedToday = false;
                sunsetSoundPlayedToday = false;
                midnightSoundPlayedToday = false;
            }
            lastDayTime = currentTime;

            // Sunrise (approx 0-100 ticks)
            if (currentTime >= 0 && currentTime < 100 && !sunriseSoundPlayedToday) {
                world.players().forEach(player -> {
                    if (player instanceof Player && !player.isSpectator()) {
                         SoundHelper.tryPlaySound(player, ThemeCategories.CREATION, ElohimConfig.COMMON.sunriseProbability.get(), 1.0f, 1.0f);
                    }
                });
                sunriseSoundPlayedToday = true;
            }
            // Sunset (approx 12000-12100 ticks)
            else if (currentTime >= 12000 && currentTime < 12100 && !sunsetSoundPlayedToday) {
                 world.players().forEach(player -> {
                    if (player instanceof Player && !player.isSpectator()) {
                        SoundHelper.tryPlaySound(player, ThemeCategories.PHILOSOPHY, ElohimConfig.COMMON.sunsetProbability.get(), 1.0f, 1.0f);
                    }
                });
                sunsetSoundPlayedToday = true;
            }
            // Midnight (approx 18000-18100 ticks)
            else if (currentTime >= 18000 && currentTime < 18100 && !midnightSoundPlayedToday) {
                world.players().forEach(player -> {
                    if (player instanceof Player && !player.isSpectator()) {
                        SoundHelper.tryPlaySound(player, ThemeCategories.WARNING, ElohimConfig.COMMON.midnightProbability.get(), 1.0f, 1.0f);
                    }
                });
                midnightSoundPlayedToday = true;
            }
        }
    }

    // --- Building Events (Conceptual - require more complex detection logic) ---
    // These would require more sophisticated structure detection logic, which is beyond
    // simple event handling. For now, these are placeholders.

    // Example: Player builds something that looks like a tower
    // public static void onTowerBuild(SomeTowerBuildEvent event) {
    //    Player player = event.getPlayer();
    //    if (!player.level().isClientSide) {
    //        SoundHelper.tryPlaySound(player, ThemeCategories.TOWER, ElohimConfig.COMMON.buildTowerProbability.get(), 1.0f, 1.0f);
    //    }
    // }

    // Example: Player builds something that looks like a temple
    // public static void onTempleBuild(SomeTempleBuildEvent event) {
    //    Player player = event.getPlayer();
    //    if (!player.level().isClientSide) {
    //        SoundHelper.tryPlaySound(player, ThemeCategories.TEMPLE, ElohimConfig.COMMON.buildTempleProbability.get(), 1.0f, 1.0f);
    //    }
    // }

    // --- Special Location Events (Conceptual - require structure/biome detection) ---
    // These would also require more complex detection (e.g., checking biome, or if player is inside a predefined structure).

    // Example: Player enters a "Temple" biome or structure
    // public static void onEnterTempleArea(PlayerTickEvent event) {
    //    Player player = event.player;
    //    if (!player.level().isClientSide && ElohimConfig.COMMON.alwaysSpeakInTemple.get()) {
    //        // Add logic to check if player is in a temple area
    //        // SoundHelper.forcePlaySound(player, SomeTempleSound, ThemeCategories.TEMPLE, 1.0f, 1.0f);
    //    }
    // }
}
