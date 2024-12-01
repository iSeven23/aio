package org.iSeven23.aio.Commands.Gm;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class gms implements CommandExecutor {

    private final JavaPlugin plugin;

    // Costruttore per accedere al plugin principale
    public gms(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            String permission_required = plugin.getConfig().getString("gms.permission");
            String gm_set = plugin.getConfig().getString("gms.gm_set_msg");
            String formatted_gm_set =  PlaceholderAPI.setPlaceholders(player, gm_set);

            if(player.hasPermission(permission_required)){
                System.out.println(formatted_gm_set);
            }
        }
        return true;
    }
}
