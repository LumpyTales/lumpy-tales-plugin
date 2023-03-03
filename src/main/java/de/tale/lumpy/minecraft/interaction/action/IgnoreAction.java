package de.tale.lumpy.minecraft.interaction.action;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;

import java.time.Duration;
import java.util.Optional;

public class IgnoreAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {

    @Override
    public void react(final S event, final T entity) {
        if (Cancellable.class.isAssignableFrom(event.getClass())) {
            ((Cancellable) event).setCancelled(true);
        }
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }

}
