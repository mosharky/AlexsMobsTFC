package com.momo.alexsmobs_tfc.mixins;

import net.dries007.tfc.common.entities.EntityHelpers;
import net.dries007.tfc.common.entities.Temptable;
import net.dries007.tfc.common.entities.livestock.CommonAnimalData;
import net.dries007.tfc.common.entities.livestock.MammalProperties;
import net.dries007.tfc.common.entities.livestock.TFCAnimal;
import net.dries007.tfc.common.entities.livestock.TFCAnimalProperties;
import net.dries007.tfc.common.entities.livestock.pet.TamableMammal;
import net.dries007.tfc.config.animals.AnimalConfig;
import net.dries007.tfc.util.calendar.Calendars;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

@Mixin(TamableAnimal.class)
public abstract class TamableAnimalMixin extends Animal implements MammalProperties, Temptable {
    @Unique
    private static final EntityDataAccessor<Boolean> alexsMobsTFC$GENDER;
    @Unique
    private static final EntityDataAccessor<Long> alexsMobsTFC$BIRTHDAY;
    @Unique
    private static final EntityDataAccessor<Float> alexsMobsTFC$FAMILIARITY;
    @Unique
    private static final EntityDataAccessor<Integer> alexsMobsTFC$USES;
    @Unique
    private static final EntityDataAccessor<Boolean> alexsMobsTFC$FERTILIZED;
    @Unique
    private static final EntityDataAccessor<Long> OLD_DAY;
    @Unique
    private static final EntityDataAccessor<Integer> GENETIC_SIZE;
    @Unique
    private static final EntityDataAccessor<Long> LAST_FED;
    @Unique
    private static final CommonAnimalData ANIMAL_DATA;
    @Unique
    private TFCAnimalProperties.Age alexsMobsTFC$lastAge;
    @Unique
    private long alexsMobsTFC$lastFDecay;
    @Unique
    private long alexsMobsTFC$matingTime;
    @Unique
    private final AnimalConfig alexsMobsTFC$config;

    protected TamableAnimalMixin(EntityType<? extends Animal> type, Level level, AnimalConfig config) {
        super(type, level);
        this.alexsMobsTFC$lastAge = Age.CHILD;
        this.getNavigation().setCanFloat(true);
        this.setMaxUpStep(1.0F);
        this.alexsMobsTFC$matingTime = Calendars.get(level).getTicks();
        this.alexsMobsTFC$lastFDecay = Calendars.get(level).getTotalDays();
        this.alexsMobsTFC$config = config;
    }

    public @NotNull CommonAnimalData animalData() {
        return ANIMAL_DATA;
    }

    public @NotNull AnimalConfig animalConfig() {
        return this.alexsMobsTFC$config;
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerCommonData();
    }

    public void addAdditionalSaveData(CompoundTag nbt) {
        super.addAdditionalSaveData(nbt);
        this.saveCommonAnimalData(nbt);
    }

    public void readAdditionalSaveData(CompoundTag nbt) {
        super.readAdditionalSaveData(nbt);
        this.readCommonAnimalData(nbt);
    }

    public boolean isBaby() {
        return this.getAgeType() == Age.CHILD;
    }

    public void setAge(int age) {
        super.setAge(0);
    }

    public int getAge() {
        return this.isBaby() ? -24000 : 0;
    }


    public TFCAnimalProperties.@NotNull Age getLastAge() {
        return this.alexsMobsTFC$lastAge;
    }

    public void setLastAge(TFCAnimalProperties.@NotNull Age lastAge) {
        this.alexsMobsTFC$lastAge = lastAge;
    }

    @Override
    public @NotNull TagKey<Item> getFoodTag() {
        return null;
    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag tag) {
        if (reason != MobSpawnType.BREEDING) {
            this.initCommonAnimalData(level, difficulty, reason);
        }

        return super.finalizeSpawn(level, difficulty, reason, spawnData, tag);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> data) {
        super.onSyncedDataUpdated(data);
        if (alexsMobsTFC$BIRTHDAY.equals(data)) {
            this.refreshDimensions();
        }

    }

    public long getLastFamiliarityDecay() {
        return this.alexsMobsTFC$lastFDecay;
    }

    public void setLastFamiliarityDecay(long days) {
        this.alexsMobsTFC$lastFDecay = days;
    }

    public void setMated(long ticks) {
        this.alexsMobsTFC$matingTime = ticks;
    }

    public long getMated() {
        return this.alexsMobsTFC$matingTime;
    }

    public void tick() {
        super.tick();
        if (this.level().getGameTime() % 20L == 0L) {
            this.tickAnimalData();
        }

    }
//TODO find a way to getOwnerUUID to be written in the genes, bellow is the TamableMammal implementation
//    public void createGenes(CompoundTag tag, TFCAnimalProperties male) {
//        this.createGenes(tag, male);
//        if ( this.getOwnerUUID() != null) {
//            tag.putUUID("owner", this.getOwnerUUID());
//        }
//
//    }

    public void applyGenes(CompoundTag tag, MammalProperties baby) {
        this.applyGenes(tag, baby);
        if (baby instanceof TamableMammal tamable) {
            if (tag.hasUUID("owner")) {
                tamable.setOwnerUUID(tag.getUUID("owner"));
            }
        }

    }


    public @NotNull InteractionResult mobInteract(@NotNull Player player, @NotNull InteractionHand hand) {
        InteractionResult result = super.mobInteract(player, hand);
        return result == InteractionResult.PASS ? super.mobInteract(player, hand) : result;
    }

    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal.getClass() != this.getClass()) {
            return false;
        } else {
            TamableAnimalMixin other = (TamableAnimalMixin)otherAnimal;
            return this.getGender() != other.getGender() && this.isReadyToMate() && other.isReadyToMate();
        }
    }

    public boolean isFood(ItemStack stack) {
        return super.isFood(stack);
    }

    static {
        alexsMobsTFC$GENDER = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityDataSerializers.BOOLEAN);
        alexsMobsTFC$BIRTHDAY = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityHelpers.LONG_SERIALIZER);
        alexsMobsTFC$FAMILIARITY = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityDataSerializers.FLOAT);
        alexsMobsTFC$USES = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityDataSerializers.INT);
        alexsMobsTFC$FERTILIZED = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityDataSerializers.BOOLEAN);
        OLD_DAY = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityHelpers.LONG_SERIALIZER);
        GENETIC_SIZE = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityDataSerializers.INT);
        LAST_FED = SynchedEntityData.defineId(TamableAnimalMixin.class, EntityHelpers.LONG_SERIALIZER);
        ANIMAL_DATA = new CommonAnimalData(alexsMobsTFC$GENDER, alexsMobsTFC$BIRTHDAY, alexsMobsTFC$FAMILIARITY, alexsMobsTFC$USES, alexsMobsTFC$FERTILIZED, OLD_DAY, GENETIC_SIZE, LAST_FED);
    }

}
