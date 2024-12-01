package org.iSeven23.aio;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.iSeven23.aio.Commands.Gm.gms;
import org.iSeven23.aio.Utils.Logo;
import java.io.File;

public final class Aio extends JavaPlugin {

    @Override
    public void onEnable() {
        if (isPluginInstalled("PlaceholderAPI")) {
            getLogger().info("PlaceholderAPI è installato!");
        } else {
            getLogger().warning("PlaceholderAPI non è installato! Alcune funzionalità potrebbero non essere disponibili.");
        }

        new Logo().printlogo();
        createConfig();

        getCommand("gms").setExecutor(new gms(this));

    }

    public boolean isPluginInstalled(String pluginName) {
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        return plugin != null && plugin.isEnabled();
    }
    private void createConfig(){
        File pluginFolder = getDataFolder(); // Rappresenta la cartella plugins/<NomePlugin>
        if (!pluginFolder.exists()) {
            if (pluginFolder.mkdirs()) {
                getLogger().info("Cartella del plugin creata con successo.");
            } else {
                getLogger().warning("Impossibile creare la cartella del plugin!");
            }
        }

        File configFile = new File(getDataFolder(), "config.yml"); // Percorso: plugins/<NomePlugin>/config.yml
        if (!configFile.exists()) {
            saveDefaultConfig(); // Copia il file predefinito dalla directory resources
            //getLogger().info("File config.yml creato con i valori predefiniti.");
        } else {
            getLogger().info("File config.yml già esistente. Nessuna azione necessaria.");
        }
    }
}