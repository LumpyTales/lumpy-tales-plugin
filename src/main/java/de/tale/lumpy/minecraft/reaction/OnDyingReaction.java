package de.tale.lumpy.minecraft.reaction;

import de.tale.lumpy.minecraft.behaviour.Behaviour;
import de.tale.lumpy.minecraft.behaviour.pig.PigDeathBehaviour;
import de.tale.lumpy.minecraft.behaviour.sheep.SheepDeathBehaviour;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class OnDyingReaction implements Listener {
    private static final List<Behaviour<EntityDeathEvent>> BEHAVIOURS = List.of(
            new SheepDeathBehaviour(),
            new PigDeathBehaviour()
    );

    @EventHandler
    public void on(final EntityDeathEvent event) {
        BEHAVIOURS.forEach(behaviour -> behaviour.doWhatYouCan(event, event.getEntity()));
    }

}
