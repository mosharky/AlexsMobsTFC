package com.momo.alexsmobs_tfc.items;

import com.momo.alexsmobs_tfc.entities.AMTFCEntityRegistry;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.momo.alexsmobs_tfc.AlexsMobsTFC.MODID;

public class AMTFCItemRegistry {

    public static final DeferredRegister<Item> DEF_REG = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    static {
        initSpawnEggs();
    }

    public static void initSpawnEggs() {
        //DEF_REG.register("spawn_egg_alligator_snapping_turtle", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ALLIGATOR_SNAPPING_TURTLE, 0X6C5C52,0X456926, new Item.Properties()));
        //DEF_REG.register("spawn_egg_anaconda", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ANACONDA, 0X565C22,0XD3763F, new Item.Properties()));
        //DEF_REG.register("spawn_egg_anteater", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ANTEATER, 0X4C3F3A, 0XCCBCB4, new Item.Properties()));
        //DEF_REG.register("spawn_egg_bald_eagle", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BALD_EAGLE, 0X321F18,0XF4F4F4, new Item.Properties()));
        //DEF_REG.register("spawn_egg_banana_slug", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BANANA_SLUG, 0XFFD045, 0XFFF173, new Item.Properties()));
        //DEF_REG.register("spawn_egg_bison", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BISON, 0X4C3A2E, 0X7A6546, new Item.Properties()));
        //DEF_REG.register("spawn_egg_blobfish", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BLOBFISH, 0XDBC6BD,0X9E7A7F, new Item.Properties()));
        //DEF_REG.register("spawn_egg_blue_jay", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BLUE_JAY, 0X5FB7FE, 0X293B42, new Item.Properties()));
        //DEF_REG.register("spawn_egg_bone_serpent", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BONE_SERPENT, 0XE5D9C4, 0XFF6038, new Item.Properties()));
        //DEF_REG.register("spawn_egg_bunfungus", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.BUNFUNGUS, 0X6F6D91, 0XC92B29, new Item.Properties()));
        //DEF_REG.register("spawn_egg_cachalot_whale", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CACHALOT_WHALE, 0X949899,0X5F666E, new Item.Properties()));
        //DEF_REG.register("spawn_egg_caiman", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CAIMAN, 0X5C5631, 0XBBC45C, new Item.Properties()));
        //DEF_REG.register("spawn_egg_capuchin_monkey", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CAPUCHIN_MONKEY, 0X25211F,0XF1DAB3, new Item.Properties()));
        //DEF_REG.register("spawn_egg_catfish", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CATFISH, 0X807757, 0X8A7466, new Item.Properties()));
        //DEF_REG.register("spawn_egg_centipede", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CENTIPEDE_HEAD, 0X342B2E,0X733449, new Item.Properties()));
        //DEF_REG.register("spawn_egg_cockroach", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.COCKROACH, 0X0D0909,0X42241E, new Item.Properties()));
        //DEF_REG.register("spawn_egg_comb_jelly", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.COMB_JELLY, 0XCFE9FE, 0X6EFF8B, new Item.Properties()));
        //DEF_REG.register("spawn_egg_cosmaw", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.COSMAW, 0X746DBD,0XD6BFE3, new Item.Properties()));
        //DEF_REG.register("spawn_egg_cosmic_cod", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.COSMIC_COD, 0X6985C7, 0XE2D1FF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_crimson_mosquito", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CRIMSON_MOSQUITO, 0X53403F,0XC11A1A, new Item.Properties()));
        //DEF_REG.register("spawn_egg_crocodile", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CROCODILE, 0X738940,0XA6A15E, new Item.Properties()));
        //DEF_REG.register("spawn_egg_crow", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.CROW, 0X0D111C,0X1C2030, new Item.Properties()));
        //DEF_REG.register("spawn_egg_devils_hole_pupfish", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.DEVILS_HOLE_PUPFISH, 0X567BC4, 0X6C4475, new Item.Properties()));
        //DEF_REG.register("spawn_egg_dropbear", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.DROPBEAR, 0X8A2D35,0X60A3A3, new Item.Properties()));
        //DEF_REG.register("spawn_egg_elephant", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ELEPHANT, 0X8D8987,0XEDE5D1, new Item.Properties()));
        //DEF_REG.register("spawn_egg_emu", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.EMU, 0X665346,0X3B3938, new Item.Properties()));
        //DEF_REG.register("spawn_egg_endergrade", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ENDERGRADE, 0X7862B3,0x81BDEB, new Item.Properties()));
        //DEF_REG.register("spawn_egg_enderiophage", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ENDERIOPHAGE, 0X872D83,0XF6E2CD, new Item.Properties()));
        //DEF_REG.register("spawn_egg_farseer", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FARSEER, 0X33374F, 0X91FF59, new Item.Properties()));
        //DEF_REG.register("spawn_egg_flutter", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FLUTTER, 0X70922D, 0XD07BE3, new Item.Properties()));
        //DEF_REG.register("spawn_egg_fly", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FLY, 0X464241,0X892E2E, new Item.Properties()));
        //DEF_REG.register("spawn_egg_flying_fish", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FLYING_FISH, 0X7BBCED, 0X6881B3, new Item.Properties()));
        //DEF_REG.register("spawn_egg_frilled_shark", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FRILLED_SHARK, 0X726B6B,0X873D3D, new Item.Properties()));
        //DEF_REG.register("spawn_egg_froststalker", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.FROSTSTALKER, 0X788AC1,0XA1C3FF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_gazelle", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GAZELLE, 0XDDA675,0X2C2925, new Item.Properties()));
        //DEF_REG.register("spawn_egg_gelada_monkey", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GELADA_MONKEY, 0XB08C64, 0XFF4F53, new Item.Properties()));
        //DEF_REG.register("spawn_egg_giant_squid", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GIANT_SQUID, 0XAB4B4D, 0XD67D6B, new Item.Properties()));
        //DEF_REG.register("spawn_egg_gorilla", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GORILLA, 0X595B5D,0X1C1C21, new Item.Properties()));
        //DEF_REG.register("spawn_egg_grizzly_bear", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GRIZZLY_BEAR, 0X693A2C, 0X976144, new Item.Properties()));
        //DEF_REG.register("spawn_egg_guster", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.GUSTER, 0XF8D49A,0XFF720A, new Item.Properties()));
        //DEF_REG.register("spawn_egg_hammerhead_shark", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.HAMMERHEAD_SHARK, 0X8A92B5,0XB9BED8, new Item.Properties()));
        //DEF_REG.register("spawn_egg_hummingbird", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.HUMMINGBIRD, 0X325E7F,0X44A75F, new Item.Properties()));
        //DEF_REG.register("spawn_egg_jerboa", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.JERBOA, 0XDEC58A, 0XDE9D90, new Item.Properties()));
        //DEF_REG.register("spawn_egg_kangaroo", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.KANGAROO, 0XCE9D65,0XDEBDA0, new Item.Properties()));
        //DEF_REG.register("spawn_egg_komodo_dragon", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.KOMODO_DRAGON, 0X746C4F,0X564231, new Item.Properties()));
        //DEF_REG.register("spawn_egg_laviathan", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.LAVIATHAN, 0XD68356,0X3C3947, new Item.Properties()));
        //DEF_REG.register("spawn_egg_leafcutter_ant", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.LEAFCUTTER_ANT, 0X964023,0XA65930, new Item.Properties()));
        //DEF_REG.register("spawn_egg_lobster", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.LOBSTER, 0XC43123,0XDD5F38, new Item.Properties()));
        //DEF_REG.register("spawn_egg_maned_wolf", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MANED_WOLF, 0XBB7A47,0X40271A, new Item.Properties()));
        //DEF_REG.register("spawn_egg_mantis_shrimp", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MANTIS_SHRIMP, 0XDB4858,0X15991E, new Item.Properties()));
        //DEF_REG.register("spawn_egg_mimic_octopus", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MIMIC_OCTOPUS, 0XFFEBDC,0X1D1C1F, new Item.Properties()));
        //DEF_REG.register("spawn_egg_mimicube", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MIMICUBE, 0X8A80C1,0X5E4F6F, new Item.Properties()));
        DEF_REG.register("spawn_egg_moose", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MOOSE, 0X36302A,0XD4B183, new Item.Properties()));
        //DEF_REG.register("spawn_egg_mudskipper", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MUDSKIPPER, 0X60704A, 0X49806C, new Item.Properties()));
        //DEF_REG.register("spawn_egg_mungus", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MUNGUS, 0X836A8D,0X45454C, new Item.Properties()));
        //DEF_REG.register("spawn_egg_murmur", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.MURMUR, 0X804448, 0XB5AF9C, new Item.Properties()));
        //DEF_REG.register("spawn_egg_orca", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ORCA, 0X2C2C2C,0XD6D8E4, new Item.Properties()));
        //DEF_REG.register("spawn_egg_platypus", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.PLATYPUS, 0X7D503E,0X363B43, new Item.Properties()));
        //DEF_REG.register("spawn_egg_potoo", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.POTOO, 0X8C7753, 0XFFC042, new Item.Properties()));
        //DEF_REG.register("spawn_egg_raccoon", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.RACCOON, 0X85827E,0X2A2726, new Item.Properties()));
        //DEF_REG.register("spawn_egg_rain_frog", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.RAIN_FROG, 0XC0B59B, 0X7B654F, new Item.Properties()));
        //DEF_REG.register("spawn_egg_rattlesnake", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.RATTLESNAKE, 0XCEB994,0X937A5B, new Item.Properties()));
        //DEF_REG.register("spawn_egg_rhinoceros", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.RHINOCEROS, 0XA19594, 0X827474, new Item.Properties()));
        //DEF_REG.register("spawn_egg_roadrunner", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ROADRUNNER, 0X3A2E26, 0XFBE9CE, new Item.Properties()));
        //DEF_REG.register("spawn_egg_rocky_roller", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.ROCKY_ROLLER, 0XB0856F, 0X999184, new Item.Properties()));
        //DEF_REG.register("spawn_egg_seagull", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SEAGULL, 0XC9D2DC,0XFFD850, new Item.Properties()));
        //DEF_REG.register("spawn_egg_seal", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SEAL, 0X483C32,0X66594C, new Item.Properties()));
        //DEF_REG.register("spawn_egg_shoebill", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SHOEBILL, 0X828282,0XD5B48A, new Item.Properties()));
        //DEF_REG.register("spawn_egg_skelewag", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SKELEWAG, 0XD9FCB1, 0X3A4F30, new Item.Properties()));
        //DEF_REG.register("spawn_egg_skreecher", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SKREECHER, 0X074857, 0X7FF8FF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_skunk", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SKUNK, 0X222D36, 0XE4E5F2, new Item.Properties()));
        //DEF_REG.register("spawn_egg_snow_leopard", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SNOW_LEOPARD, 0XACA293,0X26201D, new Item.Properties()));
        //DEF_REG.register("spawn_egg_soul_vulture", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SOUL_VULTURE, 0X23262D,0X57F4FF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_spectre", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SPECTRE, 0XC8D0EF,0X8791EF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_straddler", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.STRADDLER, 0X5D5F6E,0XCDA886, new Item.Properties()));
        //DEF_REG.register("spawn_egg_stradpole", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.STRADPOLE, 0X5D5F6E,0X576A8B, new Item.Properties()));
        //DEF_REG.register("spawn_egg_sugar_glider", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SUGAR_GLIDER, 0X868181, 0XEBEBE0, new Item.Properties()));
        //DEF_REG.register("spawn_egg_sunbird", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.SUNBIRD, 0XF6694F,0XFFDDA0, new Item.Properties()));
        //DEF_REG.register("spawn_egg_tarantula_hawk", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TARANTULA_HAWK, 0X234763,0XE37B38, new Item.Properties()));
        //DEF_REG.register("spawn_egg_tasmanian_devil", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TASMANIAN_DEVIL, 0X252426,0XA8B4BF, new Item.Properties()));
        //DEF_REG.register("spawn_egg_terrapin", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TERRAPIN, 0X6E6E30, 0X929647, new Item.Properties()));
        //DEF_REG.register("spawn_egg_tiger", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TIGER, 0XC7612E,0X2A3233, new Item.Properties()));
        //DEF_REG.register("spawn_egg_toucan", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TOUCAN, 0XF58F33,0X1E2133, new Item.Properties()));
        //DEF_REG.register("spawn_egg_triops", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TRIOPS, 0X967954, 0XCA7150, new Item.Properties()));
        //DEF_REG.register("spawn_egg_tusklin", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.TUSKLIN, 0X735841,0XE8E2D5, new Item.Properties()));
        //DEF_REG.register("spawn_egg_underminer", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.UNDERMINER, 0XD6E2FF, 0X6C84C4, new Item.Properties()));
        //DEF_REG.register("spawn_egg_void_worm", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.VOID_WORM, 0X0F1026,0X1699AB, new Item.Properties()));
        //DEF_REG.register("spawn_egg_warped_mosco", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.WARPED_MOSCO, 0X322F58,0X5B5EF1, new Item.Properties()));
        //DEF_REG.register("spawn_egg_warped_toad", () -> new ForgeSpawnEggItem(AMTFCEntityRegistry.WARPED_TOAD, 0X1F968E,0XFEAC6D, new Item.Properties()));
    }
}
