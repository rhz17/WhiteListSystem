package plugin.dev.laarky17.WhiteList;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.dev.laarky17.WhiteList.Events.Events;

import java.io.File;

public class EntryPoint extends JavaPlugin {
    private static EntryPoint PInstance = null;
    public static EntryPoint getPInstance() {
        return PInstance;
    }

    private File configFile = new File(this.getDataFolder(), "whitelist.yml");
    private FileConfiguration configConfig = YamlConfiguration.loadConfiguration(configFile);
    public FileConfiguration getConfigConfig() {
        return configConfig;
    }

    @Override
    public void onLoad() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Carregando...");

        if (!configFile.exists())
            saveResource("whitelist.yml", false);
    }

    @Override
    public void onEnable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Registrando entry point...");
        this.PInstance = this;

        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Registrando eventos...");
        this.getServer().getPluginManager().registerEvents(new Events(), this);

        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Finalizado!");
    }

    @Override
    public void onDisable() {
        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Desregistrando entry point...");
        this.PInstance = null;

        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Desregistrando eventos...");
        HandlerList.unregisterAll(new Events());

        this.getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "[WHITELIST] Finalizado!");
    }
}
