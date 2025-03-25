package dev.carloshmfs.deathlocator;

import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;

public class CommonClass {
    public static void init() {
        Constants.LOG.info("DeathLocator initiated");
    }

    public static Component getFormatedDeathMessage(String originalMessage, Vec3 playerPos) {
        return Component.literal(
                String.format(
                        "%s at %.0f %.0f %.0f",
                        originalMessage,
                        playerPos.x,
                        playerPos.y,
                        playerPos.z
                )
        );
    }
}