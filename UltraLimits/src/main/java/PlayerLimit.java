import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerLimit extends JavaPlugin implements Listener {
    public String MainConfig;

    public PlayerLimit() {
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
        Bukkit.getConsoleSender()
                .sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]"
                        + ChatColor.DARK_PURPLE + "Status:" + ChatColor.BOLD + ChatColor.GREEN + "ENABLED");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Version:" + ChatColor.GOLD + "v1.0.2");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Author:" + ChatColor.GOLD + "DarkKnights22");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();
        configMain();
    }

    public void configMain() {

        File config = new File(getDataFolder(), "config.yml");
        this.MainConfig = config.getPath();
        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }

    @org.bukkit.event.EventHandler
    public void onPing(org.bukkit.event.server.ServerListPingEvent event) {
        event.setMaxPlayers(Bukkit.getOnlinePlayers().size() + getConfig().getInt("limit-size"));
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
        Bukkit.getConsoleSender()
                .sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]"
                        + ChatColor.DARK_PURPLE + "Status:" + ChatColor.BOLD + ChatColor.RED + "DISABLED");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Version:" + ChatColor.GOLD + "v1.0.2");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Author:" + ChatColor.GOLD + "DarkKnights22");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit"
                + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(" ");
    }
}
