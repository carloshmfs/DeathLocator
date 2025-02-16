package dev.carloshmfs.deathlocator;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.gameevent.GameEvent;

public class DeathLocator implements ModInitializer {
    
    @Override
    public void onInitialize() {
        CommonClass.init();
    }
}
