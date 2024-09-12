package com.momo.alexsmobs_tfc;

import com.mojang.logging.LogUtils;
import com.momo.alexsmobs_tfc.entities.AMTFCEntityRegistry;
import com.momo.alexsmobs_tfc.entities.FaunaRegistry;
import com.momo.alexsmobs_tfc.items.AMTFCItemRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AlexsMobsTFC.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlexsMobsTFC {
    public static final String MODID = "alexsmobs_tfc";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AlexsMobsTFC()
    {
        final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(FaunaRegistry::registerSpawnPlacements);
        bus.addListener(AMTFCEntityRegistry::onEntityAttributeCreation);

        AMTFCEntityRegistry.DEF_REG.register(bus);
        AMTFCItemRegistry.DEF_REG.register(bus);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        // Do something when the setup is run on both client and server
        // LOGGER.info("HELLO from common setup!");
    }
}
