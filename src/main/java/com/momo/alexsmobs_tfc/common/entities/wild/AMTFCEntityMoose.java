package com.momo.alexsmobs_tfc.common.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityMoose;
import com.github.alexthe666.alexsmobs.entity.ai.AnimalAIWanderRanged;
import com.momo.alexsmobs_tfc.common.entities.AMTFCEntities;
import com.momo.alexsmobs_tfc.common.entities.WildAnimalData;
import com.momo.alexsmobs_tfc.common.entities.ai.AMTFCMooseAIJostle;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;

public class AMTFCEntityMoose extends EntityMoose implements IWildAnimal {

    private static final EntityDataAccessor<Boolean> GENDER = SynchedEntityData.defineId(AMTFCEntityMoose.class, EntityDataSerializers.BOOLEAN);;
    private static final WildAnimalData ANIMAL_DATA = new WildAnimalData(GENDER);

    @Override
    public WildAnimalData animalData() {
        return ANIMAL_DATA;
    }

    public AMTFCEntityMoose(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new AMTFCMooseAIJostle(this));
        this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.1D, true));
        this.goalSelector.addGoal(5, new AnimalAIWanderRanged(this, 120, 1.0D, 14, 7));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 15.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }


    @Override
    @NotNull
    // Replace translation key with alex's mobs translation key
    public Component getTypeName() {
        String replaced =  super.getType().getDescriptionId().replace("alexsmobs_tfc", "alexsmobs");
        return Component.translatable(replaced);
    }

    // Disable Alex's Mobs breeding
    @Override
    public boolean isFood(ItemStack stack) {
        return IWildAnimal.super.isFood(stack);
    }

    // Check if it can be leashed with TFC's tag
    @Override
    public boolean canBeLeashed(Player player) {
        return IWildAnimal.super.canBeLeashed(player);
    };

    // Override for babies to be this class
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return (AgeableMob) ((EntityType<?>) AMTFCEntities.MOOSE.get()).create(level);
    }


    // ⚠️ ------------------------------------------------------ ⚠️
    // ⚠️ Overriding methods from Alex's Mobs after this comment ⚠️
    // ⚠️ ------------------------------------------------------ ⚠️

    public static AttributeSupplier.Builder bakeAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40D).add(Attributes.ATTACK_DAMAGE, 7.5D).add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.KNOCKBACK_RESISTANCE, 0.5F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        defineWildAnimalData();
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        readWildAnimalSaveData(tag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        addWildAnimalSaveData(tag);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (isBaby()) {
            this.refreshDimensions();
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType type, @org.jetbrains.annotations.Nullable SpawnGroupData data, @org.jetbrains.annotations.Nullable CompoundTag tag) {
        SpawnGroupData spawnData = super.finalizeSpawn(level, difficulty, type, data, tag);
        initGender();
        // If male and not a baby, add antler (this only matters for /summon because it bothered me lol)
        if (this.getGender() == Gender.MALE && !this.isBaby()) {
            this.setAntlered(true);
        }
        // If female, disable Antler
        else {
            this.setAntlered(false);
            this.timeUntilAntlerDrop = -1;
        }
        this.setBaby(this.random.nextFloat() < 0.1F);
        return super.finalizeSpawn(level, difficulty, type, spawnData, tag);
    }
}
