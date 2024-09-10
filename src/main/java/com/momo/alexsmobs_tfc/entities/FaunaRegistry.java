package com.momo.alexsmobs_tfc.entities;

import com.github.alexthe666.alexsmobs.entity.*;
import net.dries007.tfc.common.entities.EntityHelpers;
import net.dries007.tfc.common.entities.Fauna;
import net.dries007.tfc.common.entities.aquatic.AquaticMob;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.world.chunkdata.ChunkData;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

// Shameless reference:
// https://github.com/TerraFirmaCraft/TerraFirmaCraft/blob/1.20/src/main/java/net/dries007/tfc/common/entities/Faunas.java
public class FaunaRegistry
{
    // Land animals
    public static final FaunaType<EntityAnteater> ANTEATER = registerAnimal(AMEntityRegistry.ANTEATER);
    public static final FaunaType<EntityBaldEagle> BALD_EAGLE = registerAnimal(AMEntityRegistry.BALD_EAGLE);
    public static final FaunaType<EntityBananaSlug> BANANA_SLUG = registerAnimal(AMEntityRegistry.BANANA_SLUG);
    public static final FaunaType<EntityBison> BISON = registerAnimal(AMEntityRegistry.BISON);
    public static final FaunaType<EntityBlueJay> BLUE_JAY = registerAnimal(AMEntityRegistry.BLUE_JAY);
    public static final FaunaType<EntityCapuchinMonkey> CAPUCHIN_MONKEY = registerAnimal(AMEntityRegistry.CAPUCHIN_MONKEY);
    public static final FaunaType<EntityCrow> CROW = registerAnimal(AMEntityRegistry.CROW);
    public static final FaunaType<EntityElephant> ELEPHANT = registerAnimal(AMEntityRegistry.ELEPHANT);
    public static final FaunaType<EntityEmu> EMU = registerAnimal(AMEntityRegistry.EMU);
    public static final FaunaType<EntityGazelle> GAZELLE = registerAnimal(AMEntityRegistry.GAZELLE);
    public static final FaunaType<EntityGeladaMonkey> GELADA_MONKEY = registerAnimal(AMEntityRegistry.GELADA_MONKEY);
    public static final FaunaType<EntityGorilla> GORILLA = registerAnimal(AMEntityRegistry.GORILLA);
    public static final FaunaType<EntityGrizzlyBear> GRIZZLY_BEAR = registerAnimal(AMEntityRegistry.GRIZZLY_BEAR);
    public static final FaunaType<EntityHummingbird> HUMMINGBIRD = registerAnimal(AMEntityRegistry.HUMMINGBIRD);
    public static final FaunaType<EntityJerboa> JERBOA = registerAnimal(AMEntityRegistry.JERBOA);
    public static final FaunaType<EntityKangaroo> KANGAROO = registerAnimal(AMEntityRegistry.KANGAROO);
    public static final FaunaType<EntityKomodoDragon> KOMODO_DRAGON = registerAnimal(AMEntityRegistry.KOMODO_DRAGON);
    public static final FaunaType<EntityManedWolf> MANED_WOLF = registerAnimal(AMEntityRegistry.MANED_WOLF);
    public static final FaunaType<EntityMoose> MOOSE = registerAnimal(AMEntityRegistry.MOOSE);
    public static final FaunaType<EntityPotoo> POTOO = registerAnimal(AMEntityRegistry.POTOO);
    public static final FaunaType<EntityRaccoon> RACCOON = registerAnimal(AMEntityRegistry.RACCOON);
    public static final FaunaType<EntityRattlesnake> RATTLESNAKE = registerAnimal(AMEntityRegistry.RATTLESNAKE);
    public static final FaunaType<EntityRhinoceros> RHINOCEROS = registerAnimal(AMEntityRegistry.RHINOCEROS);
    public static final FaunaType<EntityRoadrunner> ROADRUNNER = registerAnimal(AMEntityRegistry.ROADRUNNER);
    public static final FaunaType<EntitySeagull> SEAGULL = registerAnimal(AMEntityRegistry.SEAGULL);
    public static final FaunaType<EntityShoebill> SHOEBILL = registerAnimal(AMEntityRegistry.SHOEBILL);
    public static final FaunaType<EntitySkunk> SKUNK = registerAnimal(AMEntityRegistry.SKUNK);
    public static final FaunaType<EntitySnowLeopard> SNOW_LEOPARD = registerAnimal(AMEntityRegistry.SNOW_LEOPARD);
    public static final FaunaType<EntitySugarGlider> SUGAR_GLIDER = registerAnimal(AMEntityRegistry.SUGAR_GLIDER);
    public static final FaunaType<EntityTasmanianDevil> TASMANIAN_DEVIL = registerAnimal(AMEntityRegistry.TASMANIAN_DEVIL);
    public static final FaunaType<EntityTiger> TIGER = registerAnimal(AMEntityRegistry.TIGER);
    public static final FaunaType<EntityToucan> TOUCAN = registerAnimal(AMEntityRegistry.TOUCAN);
    // Fish
    public static final FaunaType<EntityBlobfish> BLOBFISH = registerFish(AMEntityRegistry.BLOBFISH);
    public static final FaunaType<EntityCachalotWhale> CACHALOT_WHALE = registerFish(AMEntityRegistry.CACHALOT_WHALE);
    public static final FaunaType<EntityCatfish> CATFISH = registerFish(AMEntityRegistry.CATFISH);
    public static final FaunaType<EntityFlyingFish> FLYING_FISH = registerFish(AMEntityRegistry.FLYING_FISH);
    public static final FaunaType<EntityFrilledShark> FRILLED_SHARK = registerFish(AMEntityRegistry.FRILLED_SHARK);
    public static final FaunaType<EntityGiantSquid> GIANT_SQUID = registerFish(AMEntityRegistry.GIANT_SQUID);
    public static final FaunaType<EntityHammerheadShark> HAMMERHEAD_SHARK = registerFish(AMEntityRegistry.HAMMERHEAD_SHARK);
    public static final FaunaType<EntityLobster> LOBSTER = registerFish(AMEntityRegistry.LOBSTER);
    public static final FaunaType<EntityMantisShrimp> MANTIS_SHRIMP = registerFish(AMEntityRegistry.MANTIS_SHRIMP);
    public static final FaunaType<EntityMimicOctopus> MIMIC_OCTOPUS = registerFish(AMEntityRegistry.MIMIC_OCTOPUS);
    public static final FaunaType<EntityOrca> ORCA = registerFish(AMEntityRegistry.ORCA);
    public static final FaunaType<EntityTriops> TRIOPS = registerFish(AMEntityRegistry.TRIOPS);
    // Amphibian
    public static final FaunaType<EntityAlligatorSnappingTurtle> ALLIGATOR_SNAPPING_TURTLE = registerAmphibian(AMEntityRegistry.ALLIGATOR_SNAPPING_TURTLE);
    public static final FaunaType<EntityAnaconda> ANACONDA = registerAmphibian(AMEntityRegistry.ANACONDA);
    public static final FaunaType<EntityCaiman> CAIMAN = registerAmphibian(AMEntityRegistry.CAIMAN);
    public static final FaunaType<EntityCrocodile> CROCODILE = registerAmphibian(AMEntityRegistry.CROCODILE);
    public static final FaunaType<EntityMudskipper> MUDSKIPPER = registerAmphibian(AMEntityRegistry.MUDSKIPPER);
    public static final FaunaType<EntityPlatypus> PLATYPUS = registerAmphibian(AMEntityRegistry.PLATYPUS);
    public static final FaunaType<EntityRainFrog> RAIN_FROG = registerAmphibian(AMEntityRegistry.RAIN_FROG);
    public static final FaunaType<EntitySeal> SEAL = registerAmphibian(AMEntityRegistry.SEAL);
    public static final FaunaType<EntityTerrapin> TERRAPIN = registerAmphibian(AMEntityRegistry.TERRAPIN);



    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event)
    {
        registerSpawnPlacement(event, ALLIGATOR_SNAPPING_TURTLE);
        registerSpawnPlacement(event, ANACONDA);
        registerSpawnPlacement(event, ANTEATER);
        registerSpawnPlacement(event, BALD_EAGLE);
        registerSpawnPlacement(event, BANANA_SLUG);
        registerSpawnPlacement(event, BISON);
        registerSpawnPlacement(event, BLOBFISH);
        registerSpawnPlacement(event, BLUE_JAY);
        registerSpawnPlacement(event, CACHALOT_WHALE);
        registerSpawnPlacement(event, CAIMAN);
        registerSpawnPlacement(event, CAPUCHIN_MONKEY);
        registerSpawnPlacement(event, CATFISH);
        registerSpawnPlacement(event, CROCODILE);
        registerSpawnPlacement(event, CROW);
        registerSpawnPlacement(event, ELEPHANT);
        registerSpawnPlacement(event, EMU);
        registerSpawnPlacement(event, FLYING_FISH);
        registerSpawnPlacement(event, FRILLED_SHARK);
        registerSpawnPlacement(event, GAZELLE);
        registerSpawnPlacement(event, GELADA_MONKEY);
        registerSpawnPlacement(event, GIANT_SQUID);
        registerSpawnPlacement(event, GORILLA);
        registerSpawnPlacement(event, GRIZZLY_BEAR);
        registerSpawnPlacement(event, HAMMERHEAD_SHARK);
        registerSpawnPlacement(event, HUMMINGBIRD);
        registerSpawnPlacement(event, JERBOA);
        registerSpawnPlacement(event, KANGAROO);
        registerSpawnPlacement(event, KOMODO_DRAGON);
        registerSpawnPlacement(event, LOBSTER);
        registerSpawnPlacement(event, MANED_WOLF);
        registerSpawnPlacement(event, MANTIS_SHRIMP);
        registerSpawnPlacement(event, MIMIC_OCTOPUS);
        registerSpawnPlacement(event, MOOSE);
        registerSpawnPlacement(event, MUDSKIPPER);
        registerSpawnPlacement(event, ORCA);
        registerSpawnPlacement(event, PLATYPUS);
        registerSpawnPlacement(event, POTOO);
        registerSpawnPlacement(event, RACCOON);
        registerSpawnPlacement(event, RAIN_FROG);
        registerSpawnPlacement(event, RATTLESNAKE);
        registerSpawnPlacement(event, RHINOCEROS);
        registerSpawnPlacement(event, ROADRUNNER);
        registerSpawnPlacement(event, SEAGULL);
        registerSpawnPlacement(event, SEAL);
        registerSpawnPlacement(event, SHOEBILL);
        registerSpawnPlacement(event, SKUNK);
        registerSpawnPlacement(event, SNOW_LEOPARD);
        registerSpawnPlacement(event, SUGAR_GLIDER);
        registerSpawnPlacement(event, TASMANIAN_DEVIL);
        registerSpawnPlacement(event, TERRAPIN);
        registerSpawnPlacement(event, TIGER);
        registerSpawnPlacement(event, TOUCAN);
        registerSpawnPlacement(event, TRIOPS);
    }



    private static <E extends Mob> FaunaType<E> registerAnimal(RegistryObject<EntityType<E>> entity) {
        return register(entity, SpawnPlacements.Type.ON_GROUND);
    }

    private static <E extends Mob> FaunaType<E> registerFish(RegistryObject<EntityType<E>> entity) {
        return register(entity, SpawnPlacements.Type.IN_WATER);
    }

    private static <E extends Mob> FaunaType<E> registerAmphibian(RegistryObject<EntityType<E>> entity) {
        return register(entity, SpawnPlacements.Type.NO_RESTRICTIONS);
    }

    private static <E extends Mob> FaunaType<E> register(RegistryObject<EntityType<E>> entity, SpawnPlacements.Type spawnPlacement) {
        Supplier<Fauna> fauna = Fauna.MANAGER.register(entity.getId());
        return new FaunaType(entity, fauna, spawnPlacement, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES);
    }



    private static <E extends Mob> void registerSpawnPlacement(SpawnPlacementRegisterEvent event, FaunaType<E> type)
    {
        event.register(type.entity().get(), type.spawnPlacementType(), type.heightmapType(), (mob, level, heightmap, pos, rand) -> {
            final Fauna fauna = type.fauna().get();
            final ChunkGenerator generator = level.getLevel().getChunkSource().getGenerator();
            if (rand.nextInt(fauna.getChance()) != 0)
            {
                return false;
            }

            if (mob instanceof AquaticMob aquaticMob && !aquaticMob.canSpawnIn(level.getFluidState(pos).getType()))
            {
                return false;
            }

            final int seaLevel = generator.getSeaLevel();
            if (fauna.getDistanceBelowSeaLevel() != -1 && pos.getY() > (seaLevel - fauna.getDistanceBelowSeaLevel()))
            {
                return false;
            }

            final ChunkData data = EntityHelpers.getChunkDataForSpawning(level, pos);
            if (!fauna.getClimate().isValid(data, pos, rand))
            {
                return false;
            }

            final BlockPos below = pos.below();
            if (fauna.isSolidGround() && !Helpers.isBlock(level.getBlockState(below), BlockTags.VALID_SPAWN))
            {
                return false;
            }
            return fauna.getMaxBrightness() == -1 || level.getRawBrightness(pos, 0) <= fauna.getMaxBrightness();
        }, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    record FaunaType<E extends Mob>(Supplier<EntityType<E>> entity, Supplier<Fauna> fauna, SpawnPlacements.Type spawnPlacementType, Heightmap.Types heightmapType) {}
}
