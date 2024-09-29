package dev.carloshmfs.deathlocator;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandle {
    @SubscribeEvent
    public void onLivingEntityDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player) {
            this.onPlayerDeath((Player) event.getEntity());
        }
    }

    private void onPlayerDeath(Player player) {

    }
}
