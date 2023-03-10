package de.tale.lumpy.minecraft.interaction.reaction;

import de.tale.lumpy.minecraft.interaction.behaviour.Behaviour;
import de.tale.lumpy.minecraft.interaction.behaviour.pig.PigDamageBehaviour;
import de.tale.lumpy.minecraft.interaction.behaviour.sheep.SheepDamageBehaviour;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class OnHurtingReaction implements Listener {

    private static final List<Behaviour<EntityDamageByEntityEvent>> BEHAVIOURS = List.of(
            new SheepDamageBehaviour(),
            new PigDamageBehaviour()
    );

    @EventHandler
    public void on(final EntityDamageByEntityEvent event) {
        BEHAVIOURS.forEach(behaviour -> behaviour.doWhatYouCan(event, event.getEntity()));
    }

}
