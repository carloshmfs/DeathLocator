package dev.carloshmfs.deathlocator;

import dev.carloshmfs.deathlocator.platform.Services;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Objects;

public class CommonClass {

    // This method serves as an initialization hook for the mod. The vanilla
    // game has no mechanism to load tooltip listeners so this must be
    // invoked from a mod loader specific project like Forge or Fabric.
    public static void init() {

//        Constants.LOG.info("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.isDevelopmentEnvironment() ? "development" : "production");
        Constants.LOG.info("Diamond Item >> {}", Registry.ITEM.getKey(Items.DIAMOND));
    }

    // This method serves as a hook to modify item tooltips. The vanilla game
    // has no mechanism to load tooltip listeners so this must be registered
    // by a mod loader like Forge or Fabric.
    public static void onItemTooltip(ItemStack stack, TooltipFlag context, List<Component> tooltip) {

        if (!stack.isEmpty()) {

            final FoodProperties food = stack.getItem().getFoodProperties();

            if (food != null) {

                tooltip.add(Component.literal("Nutrition: " + food.getNutrition()));
                tooltip.add(Component.literal("Saturation: " + food.getSaturationModifier()));
            }
        }
    }

    public static void onLivingEntityDeath(Entity entity) {
        if (entity instanceof Player) {
            onPlayerDeath((Player) entity);
        }
    }

    public static void onPlayerDeath(Player player) {
        String playerLocation = player.getBlockX() + " " + player.getBlockY() + " " + player.getBlockZ();

        String defaultDeathMessage = player.getCombatTracker().getDeathMessage().getString();
        Component customDeathMessage = Component.literal(defaultDeathMessage + " at location " + playerLocation);

        try {
            Objects.requireNonNull(player.getServer()).getPlayerList().broadcastSystemMessage(customDeathMessage, false);
        } catch (NullPointerException e) {
             System.out.println(e.getMessage());
        }
    }
}