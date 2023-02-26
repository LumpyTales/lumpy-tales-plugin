package de.tale.lumpy.minecraft.behaviour.sheep;

import de.tale.lumpy.minecraft.behaviour.AbstractBehaviour;
import de.tale.lumpy.minecraft.action.EntityAction;
import de.tale.lumpy.minecraft.action.JumpAction;
import de.tale.lumpy.minecraft.action.PoopingAction;
import de.tale.lumpy.minecraft.action.SelfHealingAction;
import de.tale.lumpy.minecraft.action.ShoutOutAction;
import org.bukkit.entity.Sheep;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.List;

public class SheepDamageBehaviour extends AbstractBehaviour<EntityDamageByEntityEvent, Sheep> {
    private final List<EntityAction<EntityDamageByEntityEvent, Sheep>> actions = List.of(
            new PoopingAction<>(),
            new JumpAction<>(),
            new SelfHealingAction<>(),
            new ShoutOutAction<>()
    );

    @Override
    protected Class<Sheep> behaviorOf() {
        return Sheep.class;
    }

    @Override
    protected List<EntityAction<EntityDamageByEntityEvent, Sheep>> actions() {
        return actions;
    }

}
