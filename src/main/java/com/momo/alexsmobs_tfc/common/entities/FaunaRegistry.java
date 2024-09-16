package com.momo.alexsmobs_tfc.common.entities;

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

public class FaunaRegistry
{
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        // Land animals
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.ANTEATER));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.BALD_EAGLE));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.BANANA_SLUG));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.BISON));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.BLUE_JAY));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.CAPUCHIN_MONKEY));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.CROW));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.ELEPHANT));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.EMU));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.GAZELLE));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.GELADA_MONKEY));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.GORILLA));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.GRIZZLY_BEAR));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.HUMMINGBIRD));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.JERBOA));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.KANGAROO));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.KOMODO_DRAGON));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.MANED_WOLF));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.MOOSE));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.POTOO));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.RACCOON));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.RATTLESNAKE));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.RHINOCEROS));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.ROADRUNNER));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.SEAGULL));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.SHOEBILL));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.SKUNK));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.SNOW_LEOPARD));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.SUGAR_GLIDER));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.TASMANIAN_DEVIL));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.TIGER));
        registerSpawnPlacement(event, registerAnimal(AMEntityRegistry.TOUCAN));
        // Fish
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.BLOBFISH));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.CACHALOT_WHALE));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.CATFISH));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.FLYING_FISH));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.FRILLED_SHARK));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.GIANT_SQUID));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.HAMMERHEAD_SHARK));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.LOBSTER));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.MANTIS_SHRIMP));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.MIMIC_OCTOPUS));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.ORCA));
        registerSpawnPlacement(event, registerFish(AMEntityRegistry.TRIOPS));
        // Amphibian
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.ALLIGATOR_SNAPPING_TURTLE));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.ANACONDA));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.CAIMAN));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.CROCODILE));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.MUDSKIPPER));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.PLATYPUS));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.RAIN_FROG));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.SEAL));
        registerSpawnPlacement(event, registerAmphibian(AMEntityRegistry.TERRAPIN));
    }


    // ⚠️ All copied from TFC after this comment ⚠️
    // https://github.com/TerraFirmaCraft/TerraFirmaCraft/blob/1.20/src/main/java/net/dries007/tfc/common/entities/Faunas.java
    record FaunaType<E extends Mob>(Supplier<EntityType<E>> entity, Supplier<Fauna> fauna, SpawnPlacements.Type spawnPlacementType, Heightmap.Types heightmapType) {}

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
        return new FaunaType<>(entity, fauna, spawnPlacement, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES);
    }

    private static <E extends Mob> void registerSpawnPlacement(SpawnPlacementRegisterEvent event, FaunaType<E> type) {
        event.register(type.entity().get(), type.spawnPlacementType(), type.heightmapType(), (mob, level, heightmap, pos, rand) -> {
            final Fauna fauna = type.fauna().get();
            final ChunkGenerator generator = level.getLevel().getChunkSource().getGenerator();
            if (rand.nextInt(fauna.getChance()) != 0) {
                return false;
            }

            if (mob instanceof AquaticMob aquaticMob && !aquaticMob.canSpawnIn(level.getFluidState(pos).getType())) {
                return false;
            }

            final int seaLevel = generator.getSeaLevel();
            if (fauna.getDistanceBelowSeaLevel() != -1 && pos.getY() > (seaLevel - fauna.getDistanceBelowSeaLevel())) {
                return false;
            }

            final ChunkData data = EntityHelpers.getChunkDataForSpawning(level, pos);
            if (!fauna.getClimate().isValid(data, pos, rand)) {
                return false;
            }

            final BlockPos below = pos.below();
            if (fauna.isSolidGround() && !Helpers.isBlock(level.getBlockState(below), BlockTags.VALID_SPAWN)) {
                return false;
            }
            return fauna.getMaxBrightness() == -1 || level.getRawBrightness(pos, 0) <= fauna.getMaxBrightness();
        }, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
