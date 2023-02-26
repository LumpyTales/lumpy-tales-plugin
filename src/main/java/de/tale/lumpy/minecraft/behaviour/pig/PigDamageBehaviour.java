package de.tale.lumpy.minecraft.behaviour.pig;

import de.tale.lumpy.minecraft.behaviour.AbstractBehaviour;
import de.tale.lumpy.minecraft.action.EntityAction;
import de.tale.lumpy.minecraft.action.SelfHealingAction;
import de.tale.lumpy.minecraft.action.ShoutOutAction;
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
