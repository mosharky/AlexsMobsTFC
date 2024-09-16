package com.momo.alexsmobs_tfc.mixins.client;

import com.github.alexthe666.alexsmobs.ClientProxy;
import com.github.alexthe666.alexsmobs.client.render.RenderMoose;
import com.momo.alexsmobs_tfc.common.entities.EntityRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@OnlyIn(Dist.CLIENT)
@Mixin(ClientProxy.class)
public class AMTFCClientProxyMixin {

    // Mixin here so we don't have to do a ton of other bs that I don't understand to get rendering working
    @Inject(method = "clientInit", at = @At("HEAD"))
    public void clientInit(CallbackInfo ci) {
        EntityRenderers.register(EntityRegistry.MOOSE.get(), RenderMoose::new);
    }
}
