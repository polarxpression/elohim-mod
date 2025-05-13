package io.polarxpress.elohimspeaks.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ElohimConfig {
    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        // General probability for sounds to play
        public final ForgeConfigSpec.DoubleValue generalProbability;
        
        // Block break/place events
        public final ForgeConfigSpec.DoubleValue breakBlockProbability;
        public final ForgeConfigSpec.DoubleValue placeBlockProbability;
        
        // Combat events
        public final ForgeConfigSpec.DoubleValue attackEntityProbability;
        public final ForgeConfigSpec.DoubleValue takeDamageProbability;
        public final ForgeConfigSpec.DoubleValue killEntityProbability;
        
        // Advancement/achievement events
        public final ForgeConfigSpec.DoubleValue advancementProbability;
        
        // World interaction events
        public final ForgeConfigSpec.DoubleValue dimensionChangeProbability;
        public final ForgeConfigSpec.DoubleValue useItemProbability;
        public final ForgeConfigSpec.DoubleValue craftItemProbability;
        
        // Time-based events
        public final ForgeConfigSpec.DoubleValue sunriseProbability;
        public final ForgeConfigSpec.DoubleValue sunsetProbability;
        public final ForgeConfigSpec.DoubleValue midnightProbability;
        
        // Building-related events
        public final ForgeConfigSpec.DoubleValue buildTowerProbability;
        public final ForgeConfigSpec.DoubleValue buildTempleProbability;
        
        // Special locations
        public final ForgeConfigSpec.BooleanValue alwaysSpeakInTemple;
        public final ForgeConfigSpec.BooleanValue alwaysSpeakOnTower;
        
        // Cooldown settings
        public final ForgeConfigSpec.IntValue globalCooldownSeconds;
        public final ForgeConfigSpec.IntValue categoryCooldownSeconds;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("ElohimSpeaks Configuration")
                   .push("general");
            
            generalProbability = builder
                    .comment("General probability factor that affects all sound triggers (0.0 to disable all sounds, 1.0 for normal, 2.0 for double chance)")
                    .defineInRange("generalProbability", 1.0, 0.0, 10.0);
            
            globalCooldownSeconds = builder
                    .comment("Global cooldown in seconds between any Elohim sounds")
                    .defineInRange("globalCooldownSeconds", 60, 0, 3600);
                    
            categoryCooldownSeconds = builder
                    .comment("Cooldown in seconds between sounds of the same category")
                    .defineInRange("categoryCooldownSeconds", 300, 0, 3600);
            
            builder.pop().push("block_events");
            
            breakBlockProbability = builder
                    .comment("Probability of Elohim speaking when breaking blocks (0.0 to 1.0)")
                    .defineInRange("breakBlockProbability", 0.01, 0.0, 1.0);
                    
            placeBlockProbability = builder
                    .comment("Probability of Elohim speaking when placing blocks (0.0 to 1.0)")
                    .defineInRange("placeBlockProbability", 0.01, 0.0, 1.0);
            
            builder.pop().push("combat_events");
            
            attackEntityProbability = builder
                    .comment("Probability of Elohim speaking when attacking entities (0.0 to 1.0)")
                    .defineInRange("attackEntityProbability", 0.05, 0.0, 1.0);
                    
            takeDamageProbability = builder
                    .comment("Probability of Elohim speaking when taking damage (0.0 to 1.0)")
                    .defineInRange("takeDamageProbability", 0.08, 0.0, 1.0);
                    
            killEntityProbability = builder
                    .comment("Probability of Elohim speaking when killing entities (0.0 to 1.0)")
                    .defineInRange("killEntityProbability", 0.15, 0.0, 1.0);
            
            builder.pop().push("achievement_events");
            
            advancementProbability = builder
                    .comment("Probability of Elohim speaking when getting advancements (0.0 to 1.0)")
                    .defineInRange("advancementProbability", 0.7, 0.0, 1.0);
            
            builder.pop().push("world_interaction");
            
            dimensionChangeProbability = builder
                    .comment("Probability of Elohim speaking when changing dimensions (0.0 to 1.0)")
                    .defineInRange("dimensionChangeProbability", 0.9, 0.0, 1.0);
                    
            useItemProbability = builder
                    .comment("Probability of Elohim speaking when using special items (0.0 to 1.0)")
                    .defineInRange("useItemProbability", 0.05, 0.0, 1.0);
                    
            craftItemProbability = builder
                    .comment("Probability of Elohim speaking when crafting special items (0.0 to 1.0)")
                    .defineInRange("craftItemProbability", 0.1, 0.0, 1.0);
            
            builder.pop().push("time_events");
            
            sunriseProbability = builder
                    .comment("Probability of Elohim speaking at sunrise (0.0 to 1.0)")
                    .defineInRange("sunriseProbability", 0.2, 0.0, 1.0);
                    
            sunsetProbability = builder
                    .comment("Probability of Elohim speaking at sunset (0.0 to 1.0)")
                    .defineInRange("sunsetProbability", 0.2, 0.0, 1.0);
                    
            midnightProbability = builder
                    .comment("Probability of Elohim speaking at midnight (0.0 to 1.0)")
                    .defineInRange("midnightProbability", 0.3, 0.0, 1.0);
            
            builder.pop().push("building_events");
            
            buildTowerProbability = builder
                    .comment("Probability of Elohim speaking when building a tower (0.0 to 1.0)")
                    .defineInRange("buildTowerProbability", 0.3, 0.0, 1.0);
                    
            buildTempleProbability = builder
                    .comment("Probability of Elohim speaking when building temple-like structures (0.0 to 1.0)")
                    .defineInRange("buildTempleProbability", 0.4, 0.0, 1.0);
            
            builder.pop().push("special_locations");
            
            alwaysSpeakInTemple = builder
                    .comment("Always trigger temple-related voice lines when in structures tagged as temples")
                    .define("alwaysSpeakInTemple", false);
                    
            alwaysSpeakOnTower = builder
                    .comment("Always trigger tower-related voice lines when on player-built towers")
                    .define("alwaysSpeakOnTower", false);
            
            builder.pop();
        }
    }
}