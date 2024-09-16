package com.momo.alexsmobs_tfc.common.entities;

import com.momo.alexsmobs_tfc.common.entities.wild.AMTFCEntityMoose;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.momo.alexsmobs_tfc.AlexsMobsTFC.MODID;

public class EntityRegistry {
    public static final DeferredRegister<EntityType<?>> DEF_REG = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);

    // Registering Alex's Mobs clones
    public static final RegistryObject<EntityType<AMTFCEntityMoose>> MOOSE = register("moose", EntityType.Builder.of(AMTFCEntityMoose::new, MobCategory.CREATURE).sized(1.7F, 2.4F).setTrackingRange(10));

    private static <E extends Entity> RegistryObject<EntityType<E>> register(String name, EntityType.Builder<E> builder) {
        return DEF_REG.register(name, () -> builder.build(MODID + ":" + name));
    }

    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event)
    {
        event.put(MOOSE.get(), AMTFCEntityMoose.bakeAttributes().build());
    }
}
