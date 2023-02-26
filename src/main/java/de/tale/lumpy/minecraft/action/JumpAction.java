package de.tale.lumpy.minecraft.action;

import org.bukkit.EntityEffect;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;

import java.time.Duration;
import java.util.Optional;

public class JumpAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {

    @Override
    public void react(final S event, final T entity) {
        entity.playEffect(EntityEffect.RABBIT_JUMP);
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }

}
