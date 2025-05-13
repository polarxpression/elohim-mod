package io.polarxpress.elohimspeaks.handlers;

import io.polarxpress.elohimspeaks.ElohimSpeaksMod;
import io.polarxpress.elohimspeaks.config.ElohimConfig;
import io.polarxpress.elohimspeaks.util.SoundHelper;
import io.polarxpress.elohimspeaks.util.ThemeCategories;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AdvancementEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemCraftedEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.event.level.BlockEvent.BreakEvent;
import net.minecraftforge.event.level.BlockEvent.EntityPlaceEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Handles events related to player actions.
 */
@Mod.EventBusSubscriber(modid = ElohimSpeaksMod.MOD_ID)
public class PlayerEventHandler {

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
    public static void onEntityKilledByPlayer(LivingDeathEvent event) {
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
            // Check if the advancement is not a recipe and should be announced
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
        if (!player.level().isClientSide && !event.getItemStack().isEmpty()) {
            // Potentially add item-specific checks here if needed (e.g., event.getItemStack().getItem())
            SoundHelper.tryPlaySound(player, ThemeCategories.GUIDANCE, ElohimConfig.COMMON.useItemProbability.get(), 1.0f, 1.0f);
        }
    }

    @SubscribeEvent
    public static void onItemCrafted(ItemCraftedEvent event) {
        // Event for when a player crafts an item
        Player player = event.getEntity();
        if (!player.level().isClientSide && !event.getCrafting().isEmpty()) {
             // Potentially add item-specific checks here (e.g., event.getCrafting().getItem())
            SoundHelper.tryPlaySound(player, ThemeCategories.CREATION, ElohimConfig.COMMON.craftItemProbability.get(), 1.0f, 1.0f);
        }
    }
}
