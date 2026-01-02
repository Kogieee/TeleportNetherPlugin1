
package pl.twojnick.teleportnether;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TeleportNetherPlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() < -5) {
            World nether = Bukkit.getWorld("world_nether");
            if (nether == null) return;

            Location target = new Location(
                    nether,
                    player.getLocation().getX(),
                    20,
                    player.getLocation().getZ()
            );

            player.teleport(target);
            player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SLOW_FALLING,
                    20 * 10,
                    0
            ));
        }
    }
}
