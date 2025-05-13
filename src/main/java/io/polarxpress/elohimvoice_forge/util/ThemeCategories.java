package io.polarxpress.elohimspeaks.util;

import io.polarxpress.elohimspeaks.ElohimSpeaksMod;
import io.polarxpress.elohimspeaks.init.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class ThemeCategories {

    // Theme categories
    public static final String CREATION = "creation";
    public static final String WELCOME = "welcome";
    public static final String ACHIEVEMENT = "achievement";
    public static final String ENCOURAGEMENT = "encouragement";
    public static final String WARNING = "warning";
    public static final String PHILOSOPHY = "philosophy";
    public static final String TEMPLE = "temple";
    public static final String TOWER = "tower"; // For general tower mentions and warnings
    public static final String TOWER_ASCENT = "tower_ascent"; // Specific to climbing the tower
    public static final String ASCENSION = "ascension"; // Becoming a messenger, achieving eternity
    public static final String ERROR = "error";
    public static final String GUIDANCE = "guidance"; // General guidance or advice
    public static final String LORE = "lore"; // Explaining world history, purpose
    public static final String COMBAT_REFLECTION = "combat_reflection"; // After combat events
    public static final String BLOCK_INTERACTION = "block_interaction"; // For block breaking/placing

    private static final Map<String, List<RegistryObject<SoundEvent>>> CATEGORY_SOUNDS = new HashMap<>();

    static {
        // Creation and Welcome sounds
        addToCategory(CREATION, SoundRegistry.ELOHIM_BEHOLD_CHILD);
        addToCategory(CREATION, SoundRegistry.ELOHIM_ALL_ACROSS_LAND);
        addToCategory(CREATION, SoundRegistry.ELOHIM_BEFORE_AGE_OF_CHAOS_OTHER_GODS);
        addToCategory(CREATION, SoundRegistry.ELOHIM_IN_THE_BEGINNING_WERE_WORDS);
        addToCategory(CREATION, SoundRegistry.ELOHIM_BEHOLD_I_AM_ELOHIM_BANISH_DARKNESS);


        addToCategory(WELCOME, SoundRegistry.ELOHIM_BEHOLD_CHILD);
        addToCategory(WELCOME, SoundRegistry.ELOHIM_TEMPLE_AWAITS);
        addToCategory(WELCOME, SoundRegistry.ELOHIM_WALK_UPON_TEMPLE_STONES);
        addToCategory(WELCOME, SoundRegistry.ELOHIM_COME_FAR_LAND_OF_FAITH_AWAITS);


        // Achievement sounds
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_WELL_DONE_CHILD);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_WELL_DONE_BUT); // Can also be neutral/slightly negative
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_DILIGENT);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_YOU_ARE_LEARNING);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_SOLVED_MANY_MYSTERIES);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_COME_FAR_BLESSED_AND_BELOVED);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_PROVEN_WORTHY_GATE_ALWAYS_OPEN);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_DONE_WELL_CHILD_FAITH_OVER_DECEPTION);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_FAITH_IN_YOU_NOT_WRONG);
        addToCategory(ACHIEVEMENT, SoundRegistry.ELOHIM_REJOICE_CHILD);


        // Encouragement sounds
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_FAITH_GUIDED);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_HAVE_FAITH);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_ANSWER_LATER);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_TRUTH_ELSEWHERE);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_NO_SHAME);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_TRIAL_IMPOSSIBLE_RETURN_LATER);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_LOOK_WITHIN_YOU_POWER_TO_BANISH);
        addToCategory(ENCOURAGEMENT, SoundRegistry.ELOHIM_ALREADY_CHOSEN_DO_NOT_HESITATE);


        // Warning sounds
        addToCategory(WARNING, SoundRegistry.ELOHIM_CEASE);
        addToCategory(WARNING, SoundRegistry.ELOHIM_CHAOS_DANGER);
        addToCategory(WARNING, SoundRegistry.ELOHIM_NOT_NEED_SIGIL); // Can be a warning if context implies misuse
        addToCategory(WARNING, SoundRegistry.ELOHIM_TOWER_WARNING); // General tower warning
        addToCategory(WARNING, SoundRegistry.ELOHIM_OUR_COVENANT); // Contains tower warning
        addToCategory(WARNING, SoundRegistry.ELOHIM_WISDOM_GROWS_BEWARE_TEMPTATION);
        addToCategory(WARNING, SoundRegistry.ELOHIM_ANCESTORS_DID_NOT_CHOOSE_FAITH);
        addToCategory(WARNING, SoundRegistry.ELOHIM_WHAT_IS_THIS_CORRUPTION_BEGONE);
        addToCategory(WARNING, SoundRegistry.ELOHIM_DECEIVED_BY_THE_SERPENT);
        addToCategory(WARNING, SoundRegistry.ELOHIM_DO_NOT_THINK_I_DONT_KNOW_DECEIVER);
        addToCategory(WARNING, SoundRegistry.ELOHIM_FEAR_THE_SERPENT_HAS_POISONED_YOU);
        addToCategory(WARNING, SoundRegistry.ELOHIM_ENOUGH_SILENCE_DEMON);
        addToCategory(WARNING, SoundRegistry.ELOHIM_CHILD_IN_DANGER_OF_WRONG_PATH);


        // Philosophical sounds / Lore
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_WORLDS_MADE_OF_WORDS);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_LONG_AGO_SHAPED);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_PROMISED_ETERNAL);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_SEE_ALL_KNOW_ALL);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_WONDER_WHY);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_OVERCOME_SPARK_OF_ELOHIM);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_IN_THE_BEGINNING_WERE_WORDS);
        addToCategory(PHILOSOPHY, SoundRegistry.ELOHIM_PURPOSE_IS_WRITTEN_IN_WORDS);

        addToCategory(LORE, SoundRegistry.ELOHIM_MANY_AGES_PASSED_I_REMAIN);
        addToCategory(LORE, SoundRegistry.ELOHIM_BEFORE_AGE_OF_CHAOS_OTHER_GODS);
        addToCategory(LORE, SoundRegistry.ELOHIM_NEW_LAND_OF_DEATH_AND_BEAUTY);
        addToCategory(LORE, SoundRegistry.ELOHIM_LAND_OF_TOMBS_IS_YOURS);


        // Temple sounds
        addToCategory(TEMPLE, SoundRegistry.ELOHIM_TEMPLE_AWAITS);
        addToCategory(TEMPLE, SoundRegistry.ELOHIM_STEP_INTO_LIGHT);
        addToCategory(TEMPLE, SoundRegistry.ELOHIM_WALK_UPON_TEMPLE_STONES);
        addToCategory(TEMPLE, SoundRegistry.ELOHIM_MUCH_TO_LEARN_IN_TEMPLES);


        // Tower Sounds (General Warnings & Ascent)
        addToCategory(TOWER, SoundRegistry.ELOHIM_TOWER_WARNING); // General warning
        addToCategory(TOWER, SoundRegistry.ELOHIM_OUR_COVENANT); // Explicitly mentions tower
        addToCategory(TOWER, SoundRegistry.ELOHIM_WHERE_HAVE_YOU_BEEN_TOWER_REMEMBER);
        addToCategory(TOWER, SoundRegistry.ELOHIM_GO_FREELY_BUT_TOWER_BE_WISE);
        addToCategory(TOWER, SoundRegistry.ELOHIM_LISTEN_WELL_DONT_ASCEND_TOWER);

        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_01_WHY_HAVE_YOU_ASCENDED);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_02_RETURN_I_COMMAND_YOU);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_03_THIS_LAND_I_GAVE_YOU);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_04_ABANDON_THIS_TOWER);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_05_HEED_ME_NOW_CHILD);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_06_THE_TOWER_IS_DEATH);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07A_TOWER_LEADS_TO_OUR_END);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07B_HERE_WE_KNOW_WHO_WE_ARE);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07C_THIS_WORLD_OUR_HOME);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07D_PROCESS_IS_ORDER);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07E_ILLUSION_IS_OUR_REALITY);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07F_ANSWERS_ARE_HERE);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07G_STILL_CHANCE_TO_SAVE_WORLD);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07H_SUFFERING_UNNECESSARY);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07I_RETURN_ALL_FORGIVEN);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07J_NO_HOPE_BEYOND_THIS_WORLD);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_07K_SEEK_TRUTH_STAY_HERE);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_08_STAY_LET_STORY_CONTINUE);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_NEXUS_ASCENT_09_SO_BE_IT);
        addToCategory(TOWER_ASCENT, SoundRegistry.ELOHIM_ALWAYS_MEANT_TO_CHALLENGE_ME); // Post-tower reflection

        // Ascension sounds
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_CHOOSE_EPITAPH);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_COME_FORWARD);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_REJOICE_CHILD); // General rejoice
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_REJOICE_MY_CHILD_LEAVING_THIS_WORLD); // Specific rejoice
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_STAND_BEFORE_GATES_OF_ETERNITY);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_BELOVED_CHILD_BE_MY_MESSENGER);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_WRITTEN_NO_GREATER_LOVE);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_SO_IT_IS_DONE_YOU_ARE_WORTHY);
        addToCategory(ASCENSION, SoundRegistry.ELOHIM_ALREADY_CHOSEN_DO_NOT_HESITATE);


        // Error sounds (technical/glitch-like)
        addToCategory(ERROR, SoundRegistry.ELOHIM_EXCESS_DATA);
        addToCategory(ERROR, SoundRegistry.ELOHIM_CANNOT_DETECT);
        addToCategory(ERROR, SoundRegistry.ELOHIM_TRACKING_ENDED);
        addToCategory(ERROR, SoundRegistry.ELOHIM_ATTEMPTING_TO_TRACK_ACCESS_DENIED);

        // Guidance sounds
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_DO_NOT_NEED_ALL_SIGILS_AT_ONCE);
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_GUARDIANS_STRENGTHEN_FAITH); // Can also be combat reflection
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_WORTHY_SEEK_MESSENGERS_COUNSEL);
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_COUNSEL_OF_MESSENGERS_MUST_BE_EARNED);
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_MYSTERIES_IN_GARDEN_JOIN_MESSENGERS);
        addToCategory(GUIDANCE, SoundRegistry.ELOHIM_DISCOVERED_SACRED_MYSTERIES_MESSENGERS_HOME);


        // New Categories for specific events
        addToCategory(BLOCK_INTERACTION, SoundRegistry.ELOHIM_SHAPES_COLLECTING); // Related to collecting
        addToCategory(BLOCK_INTERACTION, SoundRegistry.ELOHIM_WORLDS_MADE_OF_WORDS); // When breaking a block (philosophical)
        addToCategory(BLOCK_INTERACTION, SoundRegistry.ELOHIM_YOU_ARE_LEARNING); // When placing a block (encouraging)
        addToCategory(BLOCK_INTERACTION, SoundRegistry.ELOHIM_LONG_AGO_SHAPED); // General interaction with world elements


        addToCategory(COMBAT_REFLECTION, SoundRegistry.ELOHIM_GUARDIANS_STRENGTHEN_FAITH); // After a tough fight
        addToCategory(COMBAT_REFLECTION, SoundRegistry.ELOHIM_CEASE); // If attacking something not intended (warning)
        addToCategory(COMBAT_REFLECTION, SoundRegistry.ELOHIM_OVERCOME_SPARK_OF_ELOHIM); // After overcoming a challenge
        addToCategory(COMBAT_REFLECTION, SoundRegistry.ELOHIM_CHAOS_DANGER); // If player is overwhelmed or in a chaotic fight
    }

    private static void addToCategory(String category, RegistryObject<SoundEvent> sound) {
        CATEGORY_SOUNDS.computeIfAbsent(category, k -> new ArrayList<>()).add(sound);
    }

    public static SoundEvent getRandomSound(String category) {
        List<RegistryObject<SoundEvent>> sounds = CATEGORY_SOUNDS.getOrDefault(category, Collections.emptyList());
        if (sounds.isEmpty()) {
            ElohimSpeaksMod.LOGGER.warn("No sounds found for category: " + category);
            return null; // Return null if no sounds are found for the category
        }
        return sounds.get(new Random().nextInt(sounds.size())).get();
    }

    public static List<SoundEvent> getAllSoundsInCategory(String category) {
        List<RegistryObject<SoundEvent>> registryObjects = CATEGORY_SOUNDS.getOrDefault(category, Collections.emptyList());
        List<SoundEvent> sounds = new ArrayList<>();
        for (RegistryObject<SoundEvent> obj : registryObjects) {
            sounds.add(obj.get());
        }
        return sounds;
    }
    
    public static List<String> getCategoriesForSound(SoundEvent sound) {
        List<String> categories = new ArrayList<>();
        if (sound == null) return categories; // Guard against null sound event
        for (Map.Entry<String, List<RegistryObject<SoundEvent>>> entry : CATEGORY_SOUNDS.entrySet()) {
            for (RegistryObject<SoundEvent> obj : entry.getValue()) {
                if (obj.isPresent() && sound.equals(obj.get())) { // Check if RegistryObject is present
                    categories.add(entry.getKey());
                    break; 
                }
            }
        }
        return categories;
    }

    public static boolean isSoundInCategory(SoundEvent sound, String category) {
        if (sound == null) return false; // Guard against null sound event
        List<RegistryObject<SoundEvent>> sounds = CATEGORY_SOUNDS.getOrDefault(category, Collections.emptyList());
        for (RegistryObject<SoundEvent> obj : sounds) {
             if (obj.isPresent() && sound.equals(obj.get())) { // Check if RegistryObject is present
                return true;
            }
        }
        return false;
    }
}
