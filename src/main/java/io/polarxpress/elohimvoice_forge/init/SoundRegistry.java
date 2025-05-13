package io.polarxpress.elohimspeaks.init;

import io.polarxpress.elohimspeaks.ElohimSpeaksMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundRegistry {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ElohimSpeaksMod.MOD_ID);

    // Existing Sounds from original file (example, ensure all your previous ones are here)
    public static final RegistryObject<SoundEvent> ELOHIM_BEHOLD_CHILD = registerSound("elohim_behold_child"); // Elohim-001
    public static final RegistryObject<SoundEvent> ELOHIM_ALL_ACROSS_LAND = registerSound("elohim_all_across_land"); // Elohim-002
    public static final RegistryObject<SoundEvent> ELOHIM_SHAPES_COLLECTING = registerSound("elohim_shapes_collecting"); // Elohim-004
    public static final RegistryObject<SoundEvent> ELOHIM_WELL_DONE_CHILD = registerSound("elohim_well_done_child"); // Elohim-005
    public static final RegistryObject<SoundEvent> ELOHIM_TEMPLE_AWAITS = registerSound("elohim_temple_awaits"); // Elohim-006
    public static final RegistryObject<SoundEvent> ELOHIM_NOT_NEED_SIGIL = registerSound("elohim_not_need_sigil"); // Elohim-007
    public static final RegistryObject<SoundEvent> ELOHIM_WELL_DONE_BUT = registerSound("elohim_well_done_but"); // Elohim-009
    public static final RegistryObject<SoundEvent> ELOHIM_DILIGENT = registerSound("elohim_diligent"); // Elohim-011
    public static final RegistryObject<SoundEvent> ELOHIM_STEP_INTO_LIGHT = registerSound("elohim_step_into_light"); // Elohim-012
    public static final RegistryObject<SoundEvent> ELOHIM_YOU_ARE_LEARNING = registerSound("elohim_you_are_learning"); // Elohim-015
    public static final RegistryObject<SoundEvent> ELOHIM_WORLDS_MADE_OF_WORDS = registerSound("elohim_worlds_made_of_words"); // Elohim-016
    public static final RegistryObject<SoundEvent> ELOHIM_LONG_AGO_SHAPED = registerSound("elohim_long_ago_shaped"); // Elohim-017
    public static final RegistryObject<SoundEvent> ELOHIM_PROMISED_ETERNAL = registerSound("elohim_promised_eternal"); // Elohim-018
    public static final RegistryObject<SoundEvent> ELOHIM_SEE_ALL_KNOW_ALL = registerSound("elohim_see_all_know_all"); // Elohim-019
    public static final RegistryObject<SoundEvent> ELOHIM_WONDER_WHY = registerSound("elohim_wonder_why"); // Elohim-020
    public static final RegistryObject<SoundEvent> ELOHIM_CEASE = registerSound("elohim_cease"); // Elohim-050
    public static final RegistryObject<SoundEvent> ELOHIM_CHAOS_DANGER = registerSound("elohim_chaos_danger"); // Elohim-023
    public static final RegistryObject<SoundEvent> ELOHIM_TOWER_WARNING = registerSound("elohim_tower_warning"); // Elohim-059 (generic tower warning)
    public static final RegistryObject<SoundEvent> ELOHIM_FAITH_GUIDED = registerSound("elohim_faith_guided"); // Elohim-036
    public static final RegistryObject<SoundEvent> ELOHIM_HAVE_FAITH = registerSound("elohim_have_faith"); // Elohim-076
    public static final RegistryObject<SoundEvent> ELOHIM_NO_SHAME = registerSound("elohim_no_shame"); // Elohim-041
    public static final RegistryObject<SoundEvent> ELOHIM_ANSWER_LATER = registerSound("elohim_answer_later"); // Elohim-042
    public static final RegistryObject<SoundEvent> ELOHIM_TRUTH_ELSEWHERE = registerSound("elohim_truth_elsewhere"); // Elohim-043
    public static final RegistryObject<SoundEvent> ELOHIM_CHOOSE_EPITAPH = registerSound("elohim_choose_epitaph"); // Elohim-067
    public static final RegistryObject<SoundEvent> ELOHIM_COME_FORWARD = registerSound("elohim_come_forward"); // Elohim-070
    public static final RegistryObject<SoundEvent> ELOHIM_REJOICE_CHILD = registerSound("elohim_rejoice_child"); // Elohim-030
    public static final RegistryObject<SoundEvent> ELOHIM_EXCESS_DATA = registerSound("elohim_excess_data"); // Elohim-054
    public static final RegistryObject<SoundEvent> ELOHIM_CANNOT_DETECT = registerSound("elohim_cannot_detect"); // Elohim-056
    public static final RegistryObject<SoundEvent> ELOHIM_TRACKING_ENDED = registerSound("elohim_tracking_ended"); // Elohim-057

    // Newly Added Sounds from transcriptions_output.txt
    public static final RegistryObject<SoundEvent> ELOHIM_DO_NOT_NEED_ALL_SIGILS_AT_ONCE = registerSound("elohim_do_not_need_all_sigils_at_once"); // Elohim-010
    public static final RegistryObject<SoundEvent> ELOHIM_WALK_UPON_TEMPLE_STONES = registerSound("elohim_walk_upon_temple_stones"); // Elohim-013
    public static final RegistryObject<SoundEvent> ELOHIM_OUR_COVENANT = registerSound("elohim_our_covenant"); // Elohim-014
    public static final RegistryObject<SoundEvent> ELOHIM_SOLVED_MANY_MYSTERIES = registerSound("elohim_solved_many_mysteries"); // Elohim-021
    public static final RegistryObject<SoundEvent> ELOHIM_OVERCOME_SPARK_OF_ELOHIM = registerSound("elohim_overcome_spark_of_elohim"); // Elohim-022
    public static final RegistryObject<SoundEvent> ELOHIM_BEFORE_AGE_OF_CHAOS_OTHER_GODS = registerSound("elohim_before_age_of_chaos_other_gods"); // Elohim-024
    public static final RegistryObject<SoundEvent> ELOHIM_MANY_AGES_PASSED_I_REMAIN = registerSound("elohim_many_ages_passed_i_remain"); // Elohim-025
    public static final RegistryObject<SoundEvent> ELOHIM_FAITH_IN_YOU_NOT_WRONG = registerSound("elohim_faith_in_you_not_wrong"); // Elohim-026
    public static final RegistryObject<SoundEvent> ELOHIM_MUCH_TO_LEARN_IN_TEMPLES = registerSound("elohim_much_to_learn_in_temples"); // Elohim-027
    public static final RegistryObject<SoundEvent> ELOHIM_COME_FAR_BLESSED_AND_BELOVED = registerSound("elohim_come_far_blessed_and_beloved"); // Elohim-028
    public static final RegistryObject<SoundEvent> ELOHIM_PROVEN_WORTHY_GATE_ALWAYS_OPEN = registerSound("elohim_proven_worthy_gate_always_open"); // Elohim-029
    public static final RegistryObject<SoundEvent> ELOHIM_NEW_LAND_OF_DEATH_AND_BEAUTY = registerSound("elohim_new_land_of_death_and_beauty"); // Elohim-031
    public static final RegistryObject<SoundEvent> ELOHIM_LAND_OF_TOMBS_IS_YOURS = registerSound("elohim_land_of_tombs_is_yours"); // Elohim-033
    public static final RegistryObject<SoundEvent> ELOHIM_COME_FAR_LAND_OF_FAITH_AWAITS = registerSound("elohim_come_far_land_of_faith_awaits"); // Elohim-034
    public static final RegistryObject<SoundEvent> ELOHIM_STAND_BEFORE_GATES_OF_ETERNITY = registerSound("elohim_stand_before_gates_of_eternity"); // Elohim-035
    public static final RegistryObject<SoundEvent> ELOHIM_GUARDIANS_STRENGTHEN_FAITH = registerSound("elohim_guardians_strengthen_faith"); // Elohim-037
    public static final RegistryObject<SoundEvent> ELOHIM_WORTHY_SEEK_MESSENGERS_COUNSEL = registerSound("elohim_worthy_seek_messengers_counsel"); // Elohim-038
    public static final RegistryObject<SoundEvent> ELOHIM_COUNSEL_OF_MESSENGERS_MUST_BE_EARNED = registerSound("elohim_counsel_of_messengers_must_be_earned"); // Elohim-039
    public static final RegistryObject<SoundEvent> ELOHIM_WISDOM_GROWS_BEWARE_TEMPTATION = registerSound("elohim_wisdom_grows_beware_temptation"); // Elohim-040
    public static final RegistryObject<SoundEvent> ELOHIM_TRIAL_IMPOSSIBLE_RETURN_LATER = registerSound("elohim_trial_impossible_return_later"); // Elohim-044
    public static final RegistryObject<SoundEvent> ELOHIM_MYSTERIES_IN_GARDEN_JOIN_MESSENGERS = registerSound("elohim_mysteries_in_garden_join_messengers"); // Elohim-045
    public static final RegistryObject<SoundEvent> ELOHIM_DISCOVERED_SACRED_MYSTERIES_MESSENGERS_HOME = registerSound("elohim_discovered_sacred_mysteries_messengers_home"); // Elohim-046
    public static final RegistryObject<SoundEvent> ELOHIM_IN_THE_BEGINNING_WERE_WORDS = registerSound("elohim_in_the_beginning_were_words"); // Elohim-047
    public static final RegistryObject<SoundEvent> ELOHIM_PURPOSE_IS_WRITTEN_IN_WORDS = registerSound("elohim_purpose_is_written_in_words"); // Elohim-049
    public static final RegistryObject<SoundEvent> ELOHIM_ANCESTORS_DID_NOT_CHOOSE_FAITH = registerSound("elohim_ancestors_did_not_choose_faith"); // Elohim-051
    public static final RegistryObject<SoundEvent> ELOHIM_BEHOLD_I_AM_ELOHIM_BANISH_DARKNESS = registerSound("elohim_behold_i_am_elohim_banish_darkness"); // Elohim-053
    public static final RegistryObject<SoundEvent> ELOHIM_WHAT_IS_THIS_CORRUPTION_BEGONE = registerSound("elohim_what_is_this_corruption_begone"); // Elohim-055
    public static final RegistryObject<SoundEvent> ELOHIM_ATTEMPTING_TO_TRACK_ACCESS_DENIED = registerSound("elohim_attempting_to_track_access_denied"); // Elohim-058
    public static final RegistryObject<SoundEvent> ELOHIM_WHERE_HAVE_YOU_BEEN_TOWER_REMEMBER = registerSound("elohim_where_have_you_been_tower_remember"); // Elohim-060B
    public static final RegistryObject<SoundEvent> ELOHIM_GO_FREELY_BUT_TOWER_BE_WISE = registerSound("elohim_go_freely_but_tower_be_wise"); // Elohim-061
    public static final RegistryObject<SoundEvent> ELOHIM_LISTEN_WELL_DONT_ASCEND_TOWER = registerSound("elohim_listen_well_dont_ascend_tower"); // Elohim-062
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_01_WHY_HAVE_YOU_ASCENDED = registerSound("elohim_nexus_ascent_01_why_have_you_ascended");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_02_RETURN_I_COMMAND_YOU = registerSound("elohim_nexus_ascent_02_return_i_command_you");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_03_THIS_LAND_I_GAVE_YOU = registerSound("elohim_nexus_ascent_03_this_land_i_gave_you");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_04_ABANDON_THIS_TOWER = registerSound("elohim_nexus_ascent_04_abandon_this_tower");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_05_HEED_ME_NOW_CHILD = registerSound("elohim_nexus_ascent_05_heed_me_now_child");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_06_THE_TOWER_IS_DEATH = registerSound("elohim_nexus_ascent_06_the_tower_is_death");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07A_TOWER_LEADS_TO_OUR_END = registerSound("elohim_nexus_ascent_07a_tower_leads_to_our_end");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07B_HERE_WE_KNOW_WHO_WE_ARE = registerSound("elohim_nexus_ascent_07b_here_we_know_who_we_are");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07C_THIS_WORLD_OUR_HOME = registerSound("elohim_nexus_ascent_07c_this_world_our_home");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07D_PROCESS_IS_ORDER = registerSound("elohim_nexus_ascent_07d_process_is_order");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07E_ILLUSION_IS_OUR_REALITY = registerSound("elohim_nexus_ascent_07e_illusion_is_our_reality");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07F_ANSWERS_ARE_HERE = registerSound("elohim_nexus_ascent_07f_answers_are_here");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07G_STILL_CHANCE_TO_SAVE_WORLD = registerSound("elohim_nexus_ascent_07g_still_chance_to_save_world");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07H_SUFFERING_UNNECESSARY = registerSound("elohim_nexus_ascent_07h_suffering_unnecessary");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07I_RETURN_ALL_FORGIVEN = registerSound("elohim_nexus_ascent_07i_return_all_forgiven");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07J_NO_HOPE_BEYOND_THIS_WORLD = registerSound("elohim_nexus_ascent_07j_no_hope_beyond_this_world");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_07K_SEEK_TRUTH_STAY_HERE = registerSound("elohim_nexus_ascent_07k_seek_truth_stay_here");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_08_STAY_LET_STORY_CONTINUE = registerSound("elohim_nexus_ascent_08_stay_let_story_continue");
    public static final RegistryObject<SoundEvent> ELOHIM_NEXUS_ASCENT_09_SO_BE_IT = registerSound("elohim_nexus_ascent_09_so_be_it");
    public static final RegistryObject<SoundEvent> ELOHIM_DECEIVED_BY_THE_SERPENT = registerSound("elohim_deceived_by_the_serpent"); // Elohim-064
    public static final RegistryObject<SoundEvent> ELOHIM_ALWAYS_MEANT_TO_CHALLENGE_ME = registerSound("elohim_always_meant_to_challenge_me"); // Elohim-065
    public static final RegistryObject<SoundEvent> ELOHIM_BELOVED_CHILD_BE_MY_MESSENGER = registerSound("elohim_beloved_child_be_my_messenger"); // Elohim-066
    public static final RegistryObject<SoundEvent> ELOHIM_WRITTEN_NO_GREATER_LOVE = registerSound("elohim_written_no_greater_love"); // Elohim-068
    public static final RegistryObject<SoundEvent> ELOHIM_SO_IT_IS_DONE_YOU_ARE_WORTHY = registerSound("elohim_so_it_is_done_you_are_worthy"); // Elohim-069
    public static final RegistryObject<SoundEvent> ELOHIM_REJOICE_MY_CHILD_LEAVING_THIS_WORLD = registerSound("elohim_rejoice_my_child_leaving_this_world"); // Elohim-071
    public static final RegistryObject<SoundEvent> ELOHIM_CHILD_IN_DANGER_OF_WRONG_PATH = registerSound("elohim_child_in_danger_of_wrong_path"); // Elohim-072
    public static final RegistryObject<SoundEvent> ELOHIM_ENOUGH_SILENCE_DEMON = registerSound("elohim_enough_silence_demon"); // Elohim-073
    public static final RegistryObject<SoundEvent> ELOHIM_DONE_WELL_CHILD_FAITH_OVER_DECEPTION = registerSound("elohim_done_well_child_faith_over_deception"); // Elohim-074
    public static final RegistryObject<SoundEvent> ELOHIM_LOOK_WITHIN_YOU_POWER_TO_BANISH = registerSound("elohim_look_within_you_power_to_banish"); // Elohim-075
    public static final RegistryObject<SoundEvent> ELOHIM_ALREADY_CHOSEN_DO_NOT_HESITATE = registerSound("elohim_already_chosen_do_not_hesitate"); // Elohim-077
    public static final RegistryObject<SoundEvent> ELOHIM_DO_NOT_THINK_I_DONT_KNOW_DECEIVER = registerSound("elohim_do_not_think_i_dont_know_deceiver"); // Elohim-078
    public static final RegistryObject<SoundEvent> ELOHIM_FEAR_THE_SERPENT_HAS_POISONED_YOU = registerSound("elohim_fear_the_serpent_has_poisoned_you"); // Elohim-079

    private static RegistryObject<SoundEvent> registerSound(String name) {
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(ElohimSpeaksMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }
}