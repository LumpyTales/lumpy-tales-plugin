package de.tale.lumpy.minecraft.action;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

import java.time.Duration;
import java.util.Optional;

public interface EntityAction<S extends Event, T extends Entity> {

    void react(final S event, final T entity);

    /**
     * duration to wait until this reaction can be triggered again!
     *
     * @return duration if waiting is necessary
     */
    Optional<Duration> waitBeforeAgain();

}
