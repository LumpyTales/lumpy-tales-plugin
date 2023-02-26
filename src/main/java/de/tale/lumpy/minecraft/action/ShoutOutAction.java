package de.tale.lumpy.minecraft.action;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.time.Duration;
import java.util.Optional;

public class ShoutOutAction<S extends EntityDamageByEntityEvent, T extends LivingEntity> implements EntityAction<S, T> {
    @Override
    public void react(final S event, final T entity) {
        final var damager = event.getDamager();
        if (Optional.ofNullable(damager.getType().getEntityClass())
                .map(clazz -> clazz.isAssignableFrom(Player.class))
                .orElse(false)) {

            final var player = (Player) damager;
            player.sendMessage(Component.text("Ey, lass das!"));
        }
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }
}
