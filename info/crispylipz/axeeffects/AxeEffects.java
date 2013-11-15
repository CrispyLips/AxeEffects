package info.crispylipz.axeeffects;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class AxeEffects extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info("AxeEffects has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("AxeEffects"));
        sender.sendMessage("You have enabled AxeEffects");
        return true;
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent event) {
        final Entity target = event.getEntity();
        final Entity damager = event.getDamager();

        event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK);
        if (damager instanceof LivingEntity) {
            LivingEntity le = (LivingEntity) damager;

            if (le.getEquipment().getItemInHand().getType() == Material.DIAMOND_AXE) {
                target.getWorld().playEffect(target.getLocation(), Effect.POTION_SWIRL, 0);
            }
        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("AxeEffects has been disabled!");
    }


}
