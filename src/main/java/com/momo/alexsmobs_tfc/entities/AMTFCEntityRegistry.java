package com.momo.alexsmobs_tfc.entities;

import com.momo.alexsmobs_tfc.entities.wild.AMTFCMoose;
import net.dries007.tfc.common.entities.prey.RammingPrey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;


import static com.momo.alexsmobs_tfc.AlexsMobsTFC.MODID;

public class AMTFCEntityRegistry {
    public static final DeferredRegister<EntityType<?>> DEF_REG = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);


    // Registering Alex's Mobs clones
    public static final RegistryObject<EntityType<AMTFCMoose>> MOOSE = DEF_REG.register("moose", () -> registerEntity(EntityType.Builder.of(AMTFCMoose::new, MobCategory.CREATURE).sized(1.7F, 2.4F).setTrackingRange(10), "moose"));

    private static <E extends Entity> EntityType<E> registerEntity(EntityType.Builder<E> builder, String entityName) {
        return builder.build(entityName);
    }


    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event)
    {
        event.put(MOOSE.get(), RammingPrey.createLargeAttributes().build());
    }


}
