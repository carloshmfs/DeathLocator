package dev.carloshmfs.deathlocator.mixin;

import dev.carloshmfs.deathlocator.CommonClass;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {
    @ModifyVariable(method = "die", at = @At("STORE"), ordinal = 0)
    private Component modifyDeathMessage(Component originalMessage) {
        ServerPlayer thisObject = (ServerPlayer)(Object)this;
        Vec3 playerPos = thisObject.position();

        return CommonClass.getFormatedDeathMessage(originalMessage.getString(), playerPos);
    }
}
