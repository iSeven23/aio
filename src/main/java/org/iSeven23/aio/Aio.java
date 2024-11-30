package org.iSeven23.aio;
import org.bukkit.plugin.java.JavaPlugin;
import org.iSeven23.aio.Utils.Logo;
import java.io.File;

public final class Aio extends JavaPlugin {

    @Override
    public void onEnable() {
        new Logo().printlogo();
        createConfig();
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
            getLogger().info("File config.yml creato con i valori predefiniti.");
        } else {
            getLogger().info("File config.yml già esistente. Nessuna azione necessaria.");
        }
    }
}