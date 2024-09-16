package com.momo.alexsmobs_tfc.mixins.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityMoose;
import com.momo.alexsmobs_tfc.common.entities.WildAnimalData;
import com.momo.alexsmobs_tfc.common.entities.IWildAnimal;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityMoose.class)
public abstract class AMTFCMooseMixin extends Animal implements IWildAnimal {

    // Accessing fields & methods from EntityMoose
    @Shadow
    public int timeUntilAntlerDrop;
    @Shadow
    public abstract void setAntlered(boolean anters);

    // Creating new fields
    @Unique
    private static final EntityDataAccessor<Boolean> GENDER = SynchedEntityData.defineId(AMTFCMooseMixin.class, EntityDataSerializers.BOOLEAN);;
    @Unique
    private static final WildAnimalData ANIMAL_DATA = new WildAnimalData(GENDER);

    protected AMTFCMooseMixin(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
    }

    public WildAnimalData animalData() {
        return ANIMAL_DATA;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return Helpers.isEntity(getEntity(), TFCTags.Entities.LEASHABLE_WILD_ANIMALS);
    };

    /**
     * @author momo
     * @reason Disable breeding & tempting
     */
    @Overwrite
    public boolean isFood(ItemStack stack) {
        return false;
    }

    /**
     * @author momo
     * @reason Balance attributes for TFC
     */
    @Overwrite
    public static AttributeSupplier.Builder bakeAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 40D).add(Attributes.ATTACK_DAMAGE, 7.5D).add(Attributes.MOVEMENT_SPEED, 0.25F).add(Attributes.KNOCKBACK_RESISTANCE, 0.5F);
    }

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    public void defineSynchedData(CallbackInfo ci) {
        defineWildAnimalData();
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    public void readAdditionalSaveData(CompoundTag tag, CallbackInfo ci) {
        readWildAnimalSaveData(tag);
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    public void addAdditionalSaveData(CompoundTag tag, CallbackInfo ci) {
        addWildAnimalSaveData(tag);
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
