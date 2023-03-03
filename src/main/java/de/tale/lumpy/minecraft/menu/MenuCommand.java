package de.tale.lumpy.minecraft.menu;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand extends Command {

    public MenuCommand(String name) {
        super(name);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (sender instanceof final Player player) {
            final var menu = MenuFactory.create(player);
            menu.open(player);
            return true;
        }
        return false;
    }
}
