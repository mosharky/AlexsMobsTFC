package com.momo.alexsmobs_tfc.mixins.items;

import com.github.alexthe666.alexsmobs.item.AMArmorMaterial;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.minecraft.sounds.SoundEvents;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AMItemRegistry.class)
public class AMTFCItemRegistryMixin {

    @Shadow
    @Final
    public static AMArmorMaterial MOOSE_ARMOR_MATERIAL = new AMArmorMaterial("moose", 12, new int[]{3, 3, 3, 3}, 21, SoundEvents.ARMOR_EQUIP_TURTLE, 0);
}
