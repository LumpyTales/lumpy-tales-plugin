package de.tale.lumpy.minecraft.menu;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.guis.Gui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class MenuFactory {

    public static final String MENU = "Welt-Funktionen";

    public static Gui create(final HumanEntity player) {
        // Main way to create a GUI
        final var menu = Gui.gui()
                .title(Component.text(MENU))
                .type(GuiType.CHEST)
                .rows(4)
                .disableAllInteractions()
                .create();

        final ItemStack creativeModeButton = createButton(Material.GRASS_BLOCK, "Kreativ", "Wechsel in den Kreativ-Modus");
        final var creativeMode = ItemBuilder.from(creativeModeButton).asGuiItem(event ->  {
            Bukkit.dispatchCommand(event.getWhoClicked(), "gm creative " + player.getName());
            menu.close(player);
        });
        final var survivalModeButton = createButton(Material.WOODEN_SWORD, "Ueberleben", "Wechsel in den Ueberlebens-Modus");
        final var survivalMode = ItemBuilder.from(survivalModeButton).asGuiItem(event ->  {
            Bukkit.dispatchCommand(event.getWhoClicked(), "gm survival " + player.getName());
            menu.close(player);
        });
        final ItemStack dayModeButton = createButton(Material.SUNFLOWER, "Tag", "Mache, dass es Tag ist");
        final var dayMode = ItemBuilder.from(dayModeButton).asGuiItem(event ->  {
            Bukkit.dispatchCommand(event.getWhoClicked(), "day");
            menu.close(player);
        });
        final var nightModeButton = createButton(Material.NETHER_STAR, "Nacht", "Mache, dass es Nacht ist");
        final var nightMode = ItemBuilder.from(nightModeButton).asGuiItem(event ->  {
            Bukkit.dispatchCommand(event.getWhoClicked(), "night");
            menu.close(player);
        });

        menu.addItem(creativeMode, survivalMode, dayMode, nightMode);

        Bukkit.getServer().getWorlds()
                .forEach(world -> world.getPlayers()
                        .forEach(otherPlayer -> {
            if (otherPlayer.getName().equals(player.getName())) {
                return;
            }

            final var teleportButton = createButton(Material.MAP, otherPlayer.getName(), "Teleportiert Dich zu diesem Spieler");
            final var teleportMode = ItemBuilder.from(teleportButton).asGuiItem(event ->  {
                Bukkit.dispatchCommand(event.getWhoClicked(), "tp " + player.getName() + " " + otherPlayer.getName());
                menu.close(player);
            });
            menu.addItem(teleportMode);
        }));

        return menu;
    }

    @NotNull
    private static ItemStack createButton(final Material material, final String name, final String description) {
        final var button = new ItemStack(material);
        final var buttonMeta = button.getItemMeta();
        buttonMeta.displayName(Component.text( name));
        buttonMeta.lore(Collections.singletonList(Component.text(description)));
        buttonMeta.setUnbreakable(true);
        buttonMeta.setPlaceableKeys(Collections.emptyList());
        button.setItemMeta(buttonMeta);
        return button;
    }
}
