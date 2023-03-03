package de.tale.lumpy.minecraft.menu;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Optional;

public class OnPlayerGameMenu implements Listener {
    private static final @NotNull TextComponent BUTTON_NAME = Component.text("Welt-Funktions-Menu");

    @EventHandler
    public void on(final PlayerJoinEvent event) {
        event.getPlayer().getInventory().setItem(35, createWorldAdjustButton());
    }

    @EventHandler
    public void on(final InventoryClickEvent event) {
        final var itemName = Optional.ofNullable(event.getCurrentItem()).map(ItemStack::getItemMeta).map(ItemMeta::displayName).orElse(null);
        if (BUTTON_NAME.equals(itemName)) {
            event.setCancelled(true);
            event.setResult(Event.Result.DENY);

            final var menu = MenuFactory.create(event.getWhoClicked());
            menu.open(event.getWhoClicked());
            event.getWhoClicked().getInventory().setItem(35, createWorldAdjustButton());
        }
    }

    @NotNull
    private static ItemStack createWorldAdjustButton() {
        final var worldAdjustButton = new ItemStack(Material.CREEPER_HEAD);
        final var worldAdjustButtonMeta = worldAdjustButton.getItemMeta();
        worldAdjustButtonMeta.displayName(BUTTON_NAME);
        worldAdjustButtonMeta.lore(Collections.singletonList(Component.text("Klick mich und Du kannst die Welt veraendern!")));
        worldAdjustButtonMeta.setUnbreakable(true);
        worldAdjustButtonMeta.setPlaceableKeys(Collections.emptyList());
        worldAdjustButton.setItemMeta(worldAdjustButtonMeta);
        return worldAdjustButton;
    }
}
