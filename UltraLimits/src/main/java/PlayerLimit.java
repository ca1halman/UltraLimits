import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerLimit extends org.bukkit.plugin.java.JavaPlugin implements org.bukkit.event.Listener
{
  public PlayerLimit() {}

  public void onEnable()
  {
    getServer().getConsoleSender().sendMessage("§8[§3UltraLimits§8] §7>> §aPlugin Enabled! §3Created by DarkKnights22!");
  }
  {
    getServer().getPluginManager().registerEvents(this, this);
  }
  
  @org.bukkit.event.EventHandler
  public void onPing(ServerListPingEvent event) { event.setMaxPlayers(org.bukkit.Bukkit.getOnlinePlayers().size() + 1); }

  public void onDisable()
  {
    Bukkit.getConsoleSender().sendMessage(" ");
    Bukkit.getConsoleSender().sendMessage(" ");
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Status:" + ChatColor.BOLD + ChatColor.RED + "DISABLED");
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Version:" + ChatColor.GOLD + "v1.0.1");
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]" + ChatColor.DARK_PURPLE + "Author:" + ChatColor.GOLD + "DarkKnights22");
    Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[" + ChatColor.AQUA + "UltraLimit" + ChatColor.DARK_RED + "]" + ChatColor.DARK_AQUA + "=================================");
    Bukkit.getConsoleSender().sendMessage(" ");
    Bukkit.getConsoleSender().sendMessage(" ");
    Bukkit.getConsoleSender().sendMessage(" ");
  }
  }
}
