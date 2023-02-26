package de.tale.lumpy.minecraft.behaviour.sheep;

import de.tale.lumpy.minecraft.behaviour.AbstractBehaviour;
import de.tale.lumpy.minecraft.action.DropAction;
import de.tale.lumpy.minecraft.action.EntityAction;
import de.tale.lumpy.minecraft.action.IgnoreAction;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class SheepDeathBehaviour extends AbstractBehaviour<EntityDeathEvent, Sheep> {
    private final List<EntityAction<EntityDeathEvent, Sheep>> actions = List.of(
            new IgnoreAction<>(),
            new DropAction<>(Material.MUTTON)
    );

    @Override
    protected Class<Sheep> behaviorOf() {
        return Sheep.class;
    }

    @Override
    protected List<EntityAction<EntityDeathEvent, Sheep>> actions() {
        return actions;
    }

}
