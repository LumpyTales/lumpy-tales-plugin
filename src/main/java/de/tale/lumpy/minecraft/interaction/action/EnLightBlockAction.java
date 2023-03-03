package de.tale.lumpy.minecraft.interaction.action;

import de.tale.lumpy.minecraft.interaction.undo.ResetBlock;
import de.tale.lumpy.minecraft.interaction.undo.ResetBlockChanges;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;

import java.time.Duration;
import java.util.Optional;

public class EnLightBlockAction<S extends Event, T extends LivingEntity> implements EntityAction<S, T> {

    @Override
    public void react(final S event, final T entity) {
        final var world = entity.getWorld();
        if(world.isDayTime()) {
            return;
        }

        final var aboveEntityLocation = entity.getLocation().add(0, 1, 0);
        final var blockData = world.getBlockAt(aboveEntityLocation).getBlockData();
        if(blockData.getMaterial() != Material.AIR) {
            return;
        }
        world.setBlockData(aboveEntityLocation, Material.LIGHT.createBlockData());
        ResetBlockChanges.registerForUndo(new ResetBlock(world, aboveEntityLocation, blockData), Duration.ofSeconds(10));
    }

    @Override
    public Optional<Duration> waitBeforeAgain() {
        return Optional.empty();
    }
}
