package com.momo.alexsmobs_tfc.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityMoose;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class AMTFCMoose extends EntityMoose {

    public AMTFCMoose(EntityType type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return false;
    }
}
