package com.momo.alexsmobs_tfc.mixins.compat;

import com.github.alexthe666.alexsmobs.entity.EntityMoose;
import com.momo.alexsmobs_tfc.common.entities.IWildAnimal;
import net.dries007.tfc.compat.jade.common.EntityTooltip;
import net.dries007.tfc.compat.jade.common.EntityTooltips;
import net.dries007.tfc.compat.jade.common.RegisterCallback;
import net.dries007.tfc.util.Helpers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// this didn't need to be a mixin at all but im lazy and this inject is safe
@Mixin(EntityTooltips.class)
public class AMTFCEntityTooltipsMixin {

    @Inject(method = "register", at = @At("HEAD"))
    private static void register(RegisterCallback<EntityTooltip, net.minecraft.world.entity.Entity> registry, CallbackInfo ci) {
        registry.register("moose", AMTFC_WILD_ANIMAL, EntityMoose.class);
    }

    @Unique
    private static final EntityTooltip AMTFC_WILD_ANIMAL = (level, entity, tooltip) -> {
        if (entity instanceof IWildAnimal animal) {
            // if male
            if (animal.getGender().toBool()) {
                tooltip.accept(Helpers.translateEnum(IWildAnimal.Gender.MALE));
            }
            // if female
            else {
                tooltip.accept(Helpers.translateEnum(IWildAnimal.Gender.FEMALE));
            }
        }
    };
}
