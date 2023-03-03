package de.tale.lumpy.minecraft.interaction.action;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import java.time.Duration;
import java.util.Optional;

public class DropAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {

    private final Material material;

    public DropAction(final Material material) {
        this.material = material;
    }

    @Override
    public void react(final S event, final T entity) {
        entity.getWorld().dropItem(entity.getLocation().add(0, 1, 0), new ItemStack(material));
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }

}
