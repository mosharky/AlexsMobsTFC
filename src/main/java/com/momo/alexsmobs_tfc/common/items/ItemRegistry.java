package com.momo.alexsmobs_tfc.common.items;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.momo.alexsmobs_tfc.AlexsMobsTFC.MODID;

public class ItemRegistry {

    public static final DeferredRegister<Item> DEF_REG = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    static {
        initSpawnEggs();
    }

    public static void registerEgg(String entityName, Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, int highlightColor) {
        DEF_REG.register("spawn_egg_" + entityName, () -> new TranslatedSpawnEgg(type, backgroundColor, highlightColor, new Item.Properties()));
    }

    public static void initSpawnEggs() {
        // registerEgg("alligator_snapping_turtle", AMTFCEntityRegistry.ALLIGATOR_SNAPPING_TURTLE, 0X6C5C52,0X456926)
        // registerEgg("anaconda", AMTFCEntityRegistry.ANACONDA, 0X565C22,0XD3763F)
        // registerEgg("anteater", AMTFCEntityRegistry.ANTEATER, 0X4C3F3A, 0XCCBCB4)
        // registerEgg("bald_eagle", AMTFCEntityRegistry.BALD_EAGLE, 0X321F18,0XF4F4F4)
        // registerEgg("banana_slug", AMTFCEntityRegistry.BANANA_SLUG, 0XFFD045, 0XFFF173)
        // registerEgg("bison", AMTFCEntityRegistry.BISON, 0X4C3A2E, 0X7A6546)
        // registerEgg("blobfish", AMTFCEntityRegistry.BLOBFISH, 0XDBC6BD,0X9E7A7F)
        // registerEgg("blue_jay", AMTFCEntityRegistry.BLUE_JAY, 0X5FB7FE, 0X293B42)
        // registerEgg("bone_serpent", AMTFCEntityRegistry.BONE_SERPENT, 0XE5D9C4, 0XFF6038)
        // registerEgg("bunfungus", AMTFCEntityRegistry.BUNFUNGUS, 0X6F6D91, 0XC92B29)
        // registerEgg("cachalot_whale", AMTFCEntityRegistry.CACHALOT_WHALE, 0X949899,0X5F666E)
        // registerEgg("caiman", AMTFCEntityRegistry.CAIMAN, 0X5C5631, 0XBBC45C)
        // registerEgg("capuchin_monkey", AMTFCEntityRegistry.CAPUCHIN_MONKEY, 0X25211F,0XF1DAB3)
        // registerEgg("catfish", AMTFCEntityRegistry.CATFISH, 0X807757, 0X8A7466)
        // registerEgg("centipede", AMTFCEntityRegistry.CENTIPEDE_HEAD, 0X342B2E,0X733449)
        // registerEgg("cockroach", AMTFCEntityRegistry.COCKROACH, 0X0D0909,0X42241E)
        // registerEgg("comb_jelly", AMTFCEntityRegistry.COMB_JELLY, 0XCFE9FE, 0X6EFF8B)
        // registerEgg("cosmaw", AMTFCEntityRegistry.COSMAW, 0X746DBD,0XD6BFE3)
        // registerEgg("cosmic_cod", AMTFCEntityRegistry.COSMIC_COD, 0X6985C7, 0XE2D1FF)
        // registerEgg("crimson_mosquito", AMTFCEntityRegistry.CRIMSON_MOSQUITO, 0X53403F,0XC11A1A)
        // registerEgg("crocodile", AMTFCEntityRegistry.CROCODILE, 0X738940,0XA6A15E)
        // registerEgg("crow", AMTFCEntityRegistry.CROW, 0X0D111C,0X1C2030)
        // registerEgg("devils_hole_pupfish", AMTFCEntityRegistry.DEVILS_HOLE_PUPFISH, 0X567BC4, 0X6C4475)
        // registerEgg("dropbear", AMTFCEntityRegistry.DROPBEAR, 0X8A2D35,0X60A3A3)
        // registerEgg("elephant", AMTFCEntityRegistry.ELEPHANT, 0X8D8987,0XEDE5D1)
        // registerEgg("emu", AMTFCEntityRegistry.EMU, 0X665346,0X3B3938)
        // registerEgg("endergrade", AMTFCEntityRegistry.ENDERGRADE, 0X7862B3,0x81BDEB)
        // registerEgg("enderiophage", AMTFCEntityRegistry.ENDERIOPHAGE, 0X872D83,0XF6E2CD)
        // registerEgg("farseer", AMTFCEntityRegistry.FARSEER, 0X33374F, 0X91FF59)
        // registerEgg("flutter", AMTFCEntityRegistry.FLUTTER, 0X70922D, 0XD07BE3)
        // registerEgg("fly", AMTFCEntityRegistry.FLY, 0X464241,0X892E2E)
        // registerEgg("flying_fish", AMTFCEntityRegistry.FLYING_FISH, 0X7BBCED, 0X6881B3)
        // registerEgg("frilled_shark", AMTFCEntityRegistry.FRILLED_SHARK, 0X726B6B,0X873D3D)
        // registerEgg("froststalker", AMTFCEntityRegistry.FROSTSTALKER, 0X788AC1,0XA1C3FF)
        // registerEgg("gazelle", AMTFCEntityRegistry.GAZELLE, 0XDDA675,0X2C2925)
        // registerEgg("gelada_monkey", AMTFCEntityRegistry.GELADA_MONKEY, 0XB08C64, 0XFF4F53)
        // registerEgg("giant_squid", AMTFCEntityRegistry.GIANT_SQUID, 0XAB4B4D, 0XD67D6B)
        // registerEgg("gorilla", AMTFCEntityRegistry.GORILLA, 0X595B5D,0X1C1C21)
        // registerEgg("grizzly_bear", AMTFCEntityRegistry.GRIZZLY_BEAR, 0X693A2C, 0X976144)
        // registerEgg("guster", AMTFCEntityRegistry.GUSTER, 0XF8D49A,0XFF720A)
        // registerEgg("hammerhead_shark", AMTFCEntityRegistry.HAMMERHEAD_SHARK, 0X8A92B5,0XB9BED8)
        // registerEgg("hummingbird", AMTFCEntityRegistry.HUMMINGBIRD, 0X325E7F,0X44A75F)
        // registerEgg("jerboa", AMTFCEntityRegistry.JERBOA, 0XDEC58A, 0XDE9D90)
        // registerEgg("kangaroo", AMTFCEntityRegistry.KANGAROO, 0XCE9D65,0XDEBDA0)
        // registerEgg("komodo_dragon", AMTFCEntityRegistry.KOMODO_DRAGON, 0X746C4F,0X564231)
        // registerEgg("laviathan", AMTFCEntityRegistry.LAVIATHAN, 0XD68356,0X3C3947)
        // registerEgg("leafcutter_ant", AMTFCEntityRegistry.LEAFCUTTER_ANT, 0X964023,0XA65930)
        // registerEgg("lobster", AMTFCEntityRegistry.LOBSTER, 0XC43123,0XDD5F38)
        // registerEgg("maned_wolf", AMTFCEntityRegistry.MANED_WOLF, 0XBB7A47,0X40271A)
        // registerEgg("mantis_shrimp", AMTFCEntityRegistry.MANTIS_SHRIMP, 0XDB4858,0X15991E)
        // registerEgg("mimic_octopus", AMTFCEntityRegistry.MIMIC_OCTOPUS, 0XFFEBDC,0X1D1C1F)
        // registerEgg("mimicube", AMTFCEntityRegistry.MIMICUBE, 0X8A80C1,0X5E4F6F)
        // registerEgg("moose", EntityRegistry.MOOSE, 0X36302A,0XD4B183);
        // registerEgg("mudskipper", AMTFCEntityRegistry.MUDSKIPPER, 0X60704A, 0X49806C)
        // registerEgg("mungus", AMTFCEntityRegistry.MUNGUS, 0X836A8D,0X45454C)
        // registerEgg("murmur", AMTFCEntityRegistry.MURMUR, 0X804448, 0XB5AF9C)
        // registerEgg("orca", AMTFCEntityRegistry.ORCA, 0X2C2C2C,0XD6D8E4)
        // registerEgg("platypus", AMTFCEntityRegistry.PLATYPUS, 0X7D503E,0X363B43)
        // registerEgg("potoo", AMTFCEntityRegistry.POTOO, 0X8C7753, 0XFFC042)
        // registerEgg("raccoon", AMTFCEntityRegistry.RACCOON, 0X85827E,0X2A2726)
        // registerEgg("rain_frog", AMTFCEntityRegistry.RAIN_FROG, 0XC0B59B, 0X7B654F)
        // registerEgg("rattlesnake", AMTFCEntityRegistry.RATTLESNAKE, 0XCEB994,0X937A5B)
        // registerEgg("rhinoceros", AMTFCEntityRegistry.RHINOCEROS, 0XA19594, 0X827474)
        // registerEgg("roadrunner", AMTFCEntityRegistry.ROADRUNNER, 0X3A2E26, 0XFBE9CE)
        // registerEgg("rocky_roller", AMTFCEntityRegistry.ROCKY_ROLLER, 0XB0856F, 0X999184)
        // registerEgg("seagull", AMTFCEntityRegistry.SEAGULL, 0XC9D2DC,0XFFD850)
        // registerEgg("seal", AMTFCEntityRegistry.SEAL, 0X483C32,0X66594C)
        // registerEgg("shoebill", AMTFCEntityRegistry.SHOEBILL, 0X828282,0XD5B48A)
        // registerEgg("skelewag", AMTFCEntityRegistry.SKELEWAG, 0XD9FCB1, 0X3A4F30)
        // registerEgg("skreecher", AMTFCEntityRegistry.SKREECHER, 0X074857, 0X7FF8FF)
        // registerEgg("skunk", AMTFCEntityRegistry.SKUNK, 0X222D36, 0XE4E5F2)
        // registerEgg("snow_leopard", AMTFCEntityRegistry.SNOW_LEOPARD, 0XACA293,0X26201D)
        // registerEgg("soul_vulture", AMTFCEntityRegistry.SOUL_VULTURE, 0X23262D,0X57F4FF)
        // registerEgg("spectre", AMTFCEntityRegistry.SPECTRE, 0XC8D0EF,0X8791EF)
        // registerEgg("straddler", AMTFCEntityRegistry.STRADDLER, 0X5D5F6E,0XCDA886)
        // registerEgg("stradpole", AMTFCEntityRegistry.STRADPOLE, 0X5D5F6E,0X576A8B)
        // registerEgg("sugar_glider", AMTFCEntityRegistry.SUGAR_GLIDER, 0X868181, 0XEBEBE0)
        // registerEgg("sunbird", AMTFCEntityRegistry.SUNBIRD, 0XF6694F,0XFFDDA0)
        // registerEgg("tarantula_hawk", AMTFCEntityRegistry.TARANTULA_HAWK, 0X234763,0XE37B38)
        // registerEgg("tasmanian_devil", AMTFCEntityRegistry.TASMANIAN_DEVIL, 0X252426,0XA8B4BF)
        // registerEgg("terrapin", AMTFCEntityRegistry.TERRAPIN, 0X6E6E30, 0X929647)
        // registerEgg("tiger", AMTFCEntityRegistry.TIGER, 0XC7612E,0X2A3233)
        // registerEgg("toucan", AMTFCEntityRegistry.TOUCAN, 0XF58F33,0X1E2133)
        // registerEgg("triops", AMTFCEntityRegistry.TRIOPS, 0X967954, 0XCA7150)
        // registerEgg("tusklin", AMTFCEntityRegistry.TUSKLIN, 0X735841,0XE8E2D5)
        // registerEgg("underminer", AMTFCEntityRegistry.UNDERMINER, 0XD6E2FF, 0X6C84C4)
        // registerEgg("void_worm", AMTFCEntityRegistry.VOID_WORM, 0X0F1026,0X1699AB)
        // registerEgg("warped_mosco", AMTFCEntityRegistry.WARPED_MOSCO, 0X322F58,0X5B5EF1)
        // registerEgg("warped_toad", AMTFCEntityRegistry.WARPED_TOAD, 0X1F968E,0XFEAC6D)
    }
}
