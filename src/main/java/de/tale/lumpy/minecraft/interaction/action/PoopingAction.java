package de.tale.lumpy.minecraft.interaction.action;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;

public class PoopingAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {
    private final Component name = Component.text(ChatColor.GREEN + "Kacka");
    private final Component description = Component.text(ChatColor.GREEN + "Stinkt besonders schlimm!");

    @Override
    public void react(final S event, final T entity) {
        entity.getWorld().dropItem(entity.getLocation().add(0, 1, 0), createPoop());
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.of(Duration.ofHours(1));
    }

    private ItemStack createPoop() {
        final var itemStack = new ItemStack(Material.COAL, 1);
        final var itemMeta = itemStack.getItemMeta();
        itemStack.setItemMeta(itemMeta);

        itemMeta.displayName(name);
        itemMeta.lore(Collections.singletonList(description));

        return itemStack;
    }

}
