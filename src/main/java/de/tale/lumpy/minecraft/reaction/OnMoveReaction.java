package de.tale.lumpy.minecraft.reaction;

import de.tale.lumpy.minecraft.behaviour.Behaviour;
import de.tale.lumpy.minecraft.behaviour.player.PlayerMoveBehaviour;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class OnMoveReaction implements Listener {
    private static final List<Behaviour<PlayerMoveEvent>> BEHAVIOURS = List.of(
        new PlayerMoveBehaviour()
    );

    @EventHandler
    public void on(final PlayerMoveEvent event) {
        BEHAVIOURS.forEach(behaviour -> behaviour.doWhatYouCan(event, event.getPlayer()));
    }

}
