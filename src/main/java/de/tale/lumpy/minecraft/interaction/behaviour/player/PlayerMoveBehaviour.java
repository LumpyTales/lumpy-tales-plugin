package de.tale.lumpy.minecraft.interaction.behaviour.player;

import de.tale.lumpy.minecraft.interaction.action.EnLightBlockAction;
import de.tale.lumpy.minecraft.interaction.action.EntityAction;
import de.tale.lumpy.minecraft.interaction.behaviour.AbstractBehaviour;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.List;

public class PlayerMoveBehaviour extends AbstractBehaviour<PlayerMoveEvent, Player> {

    @Override
    protected Class<Player> behaviorOf() {
        return Player.class;
    }

    @Override
    protected List<EntityAction<PlayerMoveEvent, Player>> actions() {
        return List.of(new EnLightBlockAction<>());
    }

}
