package de.tale.lumpy.minecraft;

import de.tale.lumpy.minecraft.interaction.reaction.OnDyingReaction;
import de.tale.lumpy.minecraft.interaction.reaction.OnHurtingReaction;
import de.tale.lumpy.minecraft.interaction.reaction.OnMoveReaction;
import de.tale.lumpy.minecraft.interaction.undo.ResetBlockChanges;
import de.tale.lumpy.minecraft.menu.MenuCommand;
import de.tale.lumpy.minecraft.menu.OnPlayerGameMenu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LumpyTalesPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getCommandMap().register("menu", new MenuCommand("o"));
        Bukkit.getPluginManager().registerEvents(new OnHurtingReaction(), this);
        Bukkit.getPluginManager().registerEvents(new OnDyingReaction(), this);
        Bukkit.getPluginManager().registerEvents(new OnMoveReaction(), this);
        Bukkit.getPluginManager().registerEvents(new OnPlayerGameMenu(), this);
        Bukkit.getScheduler().runTaskTimer(this, new ResetBlockChanges(), 5, 10);
    }

    @Override
    public void onDisable() {
        ResetBlockChanges.resetAll();
        super.onDisable();
    }
}
