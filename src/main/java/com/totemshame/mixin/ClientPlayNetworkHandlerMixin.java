package com.totemshame.mixin;

import com.totemshame.TotemShameManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Intercept the server entity status packet to detect totem activation client-side.
 */
@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin {
    @Shadow
    private MinecraftClient client;

    @Inject(method = "onEntityStatus", at = @At("HEAD"))
    private void onEntityStatus(EntityStatusS2CPacket packet, CallbackInfo ci) {
        // Historical status for totem activation (works with standard mappings)
        final int TOTEM_STATUS = 35;
        if (packet.getStatus() != TOTEM_STATUS) return;

        int entityId = packet.getId();
        if (client.world == null) return;
        Entity ent = client.world.getEntityById(entityId);
        if (ent == null) return;

        // Only trigger when it's the local player
        ClientPlayerEntity player = client.player;
        if (player != null && ent == player) {
            TotemShameManager.INSTANCE.triggerTotemPop(ent);
        }
    }
}