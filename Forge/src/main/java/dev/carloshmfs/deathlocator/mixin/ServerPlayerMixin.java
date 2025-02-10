package dev.carloshmfs.deathlocator.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {
    @ModifyVariable(method = "die()V", at = @At("STORE"), ordinal = 0)
    private Component modifyDeathMessage(Component originalMessage) {
        ServerPlayer thisObject = (ServerPlayer)(Object)this;
        Vec3 playerPos = thisObject.position();

        return Component.literal(
                String.format(
                        "%s at %.1f %.1f %.1f",
                        originalMessage.getString(),
                        playerPos.x,
                        playerPos.y,
                        playerPos.z
                )
        );
    }
}
