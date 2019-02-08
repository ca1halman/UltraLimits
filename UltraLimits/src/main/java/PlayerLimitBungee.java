import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.logging.Level;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.ServerPing.Players;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class PlayerLimitBungee extends Plugin implements Listener {
    Configuration config;

    public void onEnable() {
        getLogger().log(Level.INFO, "Player Limit Bungee enabled!");
        try {
            configMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
        getProxy().getPluginManager().registerListener(this, this);
    }

    public void configMain() throws IOException {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        File configFile = new File(getDataFolder(), "config.yml");

        if (!configFile.exists()) {
            try (InputStream in = getResourceAsStream("config.yml")) {
                Files.copy(in, configFile.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
    }

    @EventHandler
    public void onPing(ProxyPingEvent event) {
        ServerPing re = event.getResponse();
        Players p = re.getPlayers();
        p.setMax(p.getOnline() + config.getInt("limit-size"));
        ServerPing newRe = new ServerPing(re.getVersion(), p, re.getDescriptionComponent(), re.getFaviconObject());
        event.setResponse(newRe);
    }

    public void onDisable() {
        getLogger().log(Level.INFO, "Player Limit Bungee disabled!");
    }
}