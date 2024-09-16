package com.momo.alexsmobs_tfc.mixins.entities.wild;

import com.github.alexthe666.alexsmobs.entity.EntityAnaconda;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityAnaconda.class)
public class AMTFCAnacondaMixin {

    /**
     * @author momo
     * @reason Disable breeding
     */
    @Overwrite
    public boolean isFood(ItemStack stack) {
        return false;
    }
}
