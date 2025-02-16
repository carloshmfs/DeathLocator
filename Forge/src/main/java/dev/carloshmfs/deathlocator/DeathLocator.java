package dev.carloshmfs.deathlocator;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class DeathLocator {
    public DeathLocator() {
        Constants.LOG.info("Hello Forge world!");
        CommonClass.init();
    }
}