package com.momo.alexsmobs_tfc.common.entities;

import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;
import com.github.alexthe666.alexsmobs.entity.EntityAlligatorSnappingTurtle;
import com.github.alexthe666.alexsmobs.entity.EntityMoose;
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
    // Land animals
    // public static final FaunaType<EntityAnteater> ANTEATER = registerAnimal(AMEntityRegistry.ANTEATER);
    public static final FaunaType<EntityMoose> MOOSE = registerAnimal(AMEntityRegistry.MOOSE);
    // Fish
    // public static final FaunaType<EntityBlobfish> BLOBFISH = registerFish(AMEntityRegistry.BLOBFISH);
    // Amphibian
    public static final FaunaType<EntityAlligatorSnappingTurtle> ALLIGATOR_SNAPPING_TURTLE = registerAmphibian(AMEntityRegistry.ALLIGATOR_SNAPPING_TURTLE);



    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        registerSpawnPlacement(event, MOOSE);
        registerSpawnPlacement(event, ALLIGATOR_SNAPPING_TURTLE);
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
