package com.momo.alexsmobs_tfc.common.entities;

import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IWildAnimal {

    WildAnimalData animalData();

    default LivingEntity getEntity() {
        return (LivingEntity) this;
    }

    // Disable breeding/feeding if applicable
    default boolean isFood(ItemStack stack) {
        return false;
    }

    default boolean canBeLeashed(Player player) {
        return Helpers.isEntity(getEntity(), TFCTags.Entities.LEASHABLE_WILD_ANIMALS);
    }

    private SynchedEntityData entityData() {
        return getEntity().getEntityData();
    }

    // Use in defineSynchedData() method
    default void defineWildAnimalData() {
        entityData().define(animalData().gender(), true);
    }

    // Use in readAdditionalSaveData() method
    default void readWildAnimalSaveData(CompoundTag nbt) {
        setGender(Gender.valueOf(nbt.getBoolean("Gender")));
    }

    // Use in addAdditionalSaveData() method
    default void addWildAnimalSaveData(CompoundTag nbt) {
        nbt.putBoolean("Gender", getGender().toBool());
    }

    default Gender getGender() {
        return Gender.valueOf(entityData().get(animalData().gender()));
    }

    default void setGender(Gender gender) {
        entityData().set(animalData().gender(), gender.toBool());
    }

    // Set to a random gender in finalizeSpawn() method
    default void initGender() {
        final var random = getEntity().getRandom();
        setGender(Gender.valueOf(random.nextBoolean()));
    }

    enum Gender {
        MALE, FEMALE;

        public static Gender valueOf(boolean value) {
            return value ? MALE : FEMALE;
        }
        public boolean toBool() {
            return this == MALE;
        }
    }
}
