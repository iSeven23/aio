package org.iSeven23.aio;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Aio extends JavaPlugin {

    @Override
    public void onEnable() {
        printLogo();
        createConfig();
    }

    private void printLogo(){
        System.out.println("""
                 
                 ________      ___      ________          ________  ___       ___  ___  ________  ___  ________         \s
                |\\   __  \\    |\\  \\    |\\   __  \\        |\\   __  \\|\\  \\     |\\  \\|\\  \\|\\   ____\\|\\  \\|\\   ___  \\       \s
                \\ \\  \\|\\  \\   \\ \\  \\   \\ \\  \\|\\  \\       \\ \\  \\|\\  \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\___|\\ \\  \\ \\  \\\\ \\  \\      \s
                 \\ \\   __  \\   \\ \\  \\   \\ \\  \\\\\\  \\       \\ \\   ____\\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  __\\ \\  \\ \\  \\\\ \\  \\     \s
                  \\ \\  \\ \\  \\ __\\ \\  \\ __\\ \\  \\\\\\  \\       \\ \\  \\___|\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\ \\  \\ \\  \\\\ \\  \\    \s
                   \\ \\__\\ \\__\\\\__\\ \\__\\\\__\\ \\_______\\       \\ \\__\\    \\ \\_______\\ \\_______\\ \\_______\\ \\__\\ \\__\\\\ \\__\\   \s
                    \\|__|\\|__\\|__|\\|__\\|__|\\|_______|        \\|__|     \\|_______|\\|_______|\\|_______|\\|__|\\|__| \\|__|   \s
                                                                                                                       \s 
                            """);
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