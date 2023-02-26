package de.tale.lumpy.minecraft.behaviour;

import org.bukkit.entity.Entity;
import org.bukkit.event.Event;


public interface Behaviour<S extends Event> {

    void doWhatYouCan(final S event, final Entity entity);

}