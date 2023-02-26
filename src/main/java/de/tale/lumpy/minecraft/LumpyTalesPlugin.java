package de.tale.lumpy.minecraft;

import de.tale.lumpy.minecraft.reaction.OnHurtingReaction;
import de.tale.lumpy.minecraft.reaction.OnDyingReaction;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LumpyTalesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new OnHurtingReaction(), this);
        Bukkit.getPluginManager().registerEvents(new OnDyingReaction(), this);
    }

}
