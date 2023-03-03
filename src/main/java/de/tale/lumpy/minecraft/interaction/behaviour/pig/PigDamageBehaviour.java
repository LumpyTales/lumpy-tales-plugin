package de.tale.lumpy.minecraft.interaction.behaviour.pig;

import de.tale.lumpy.minecraft.interaction.behaviour.AbstractBehaviour;
import de.tale.lumpy.minecraft.interaction.action.EntityAction;
import de.tale.lumpy.minecraft.interaction.action.SelfHealingAction;
import de.tale.lumpy.minecraft.interaction.action.ShoutOutAction;
import org.bukkit.entity.Pig;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class PigDamageBehaviour extends AbstractBehaviour<EntityDamageByEntityEvent, Pig> {
    private final List<EntityAction<EntityDamageByEntityEvent, Pig>> actions = List.of(
            new SelfHealingAction<>(),
            new ShoutOutAction<>()
    );

    @Override
    protected Class<Pig> behaviorOf() {
        return Pig.class;
    }

    @Override
    protected List<EntityAction<EntityDamageByEntityEvent, Pig>> actions() {
        return actions;
    }

}
