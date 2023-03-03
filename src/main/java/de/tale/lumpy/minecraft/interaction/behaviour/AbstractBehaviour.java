package de.tale.lumpy.minecraft.interaction.behaviour;

import de.tale.lumpy.minecraft.interaction.action.EntityAction;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractBehaviour<S extends Event, T extends Entity> implements Behaviour<S> {

    private final Map<EntityAction<S, T>, Map<UUID, LocalDateTime>> entityLastReactionMap = new HashMap<>();

    protected abstract Class<T> behaviorOf();

    protected abstract List<EntityAction<S, T>> actions();

    @Override
    public void doWhatYouCan(final S event, @NotNull final Entity entity) {

        if (Optional.ofNullable(entity.getType().getEntityClass())
                .map(clazz -> clazz.isAssignableFrom(behaviorOf()))
                .orElse(false)) {

            actions().forEach(action -> doReact(event, entity, action));
        }
    }

    private void doReact(S event, Entity entity, EntityAction<S, T> action) {
        final var react = action.waitBeforeAgain().map(duration -> {
            final var uuidLastReactionMap = entityLastReactionMap.computeIfAbsent(action, k -> new HashMap<>());
            final var lastReaction = uuidLastReactionMap.computeIfAbsent(entity.getUniqueId(), k -> LocalDateTime.MIN);
            if (lastReaction.plus(duration).isBefore(LocalDateTime.now())) {
                uuidLastReactionMap.put(entity.getUniqueId(), LocalDateTime.now());
                return true;
            }
            return false;
        }).orElse(true);

        if(react) {
            action.react(event, behaviorOf().cast(entity));
        }
    }

}
