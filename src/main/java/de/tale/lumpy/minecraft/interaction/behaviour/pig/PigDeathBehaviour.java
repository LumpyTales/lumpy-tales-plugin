package de.tale.lumpy.minecraft.interaction.behaviour.pig;

import de.tale.lumpy.minecraft.interaction.behaviour.AbstractBehaviour;
import de.tale.lumpy.minecraft.interaction.action.DropAction;
import de.tale.lumpy.minecraft.interaction.action.EntityAction;
import de.tale.lumpy.minecraft.interaction.action.IgnoreAction;
import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class PigDeathBehaviour extends AbstractBehaviour<EntityDeathEvent, Pig> {
    private final List<EntityAction<EntityDeathEvent, Pig>> actions = List.of(
            new IgnoreAction<>(),
            new DropAction<>(Material.PORKCHOP)
    );

    @Override
    protected Class<Pig> behaviorOf() {
        return Pig.class;
    }

    @Override
    protected List<EntityAction<EntityDeathEvent, Pig>> actions() {
        return actions;
    }

}
