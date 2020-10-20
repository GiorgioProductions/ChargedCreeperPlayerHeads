package es.giorgioproductions.chargedcreeperplayerheads;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§bChargedCreeperPlayerHeads v1.1 §8was loaded successfully");
        getServer().getPluginManager().registerEvents(new ExplosionListener(), this);
    }

}
