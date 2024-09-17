package com.momo.alexsmobs_tfc.mixins.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityAnaconda;
import net.dries007.tfc.common.TFCTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityAnaconda.class)
public abstract class AMTFCAnacondaMixin extends Animal {

    protected AMTFCAnacondaMixin(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
    }

    /**
     * @author momo
     * @reason Disable breeding
     */
    @Overwrite
    public boolean isFood(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canBeLeashed(Player player) {
        return Helpers.isEntity(this, TFCTags.Entities.LEASHABLE_WILD_ANIMALS);
    };
}
