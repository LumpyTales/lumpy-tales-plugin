package de.tale.lumpy.minecraft.interaction.action;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;

import java.time.Duration;
import java.util.Optional;

public class SelfHealingAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {

    @Override
    public void react(final S event, final T entity) {
        final var entityMaxHealth = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        Optional.ofNullable(entityMaxHealth).ifPresent(maxHealth -> entity.setHealth(maxHealth.getValue()));
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }

}
