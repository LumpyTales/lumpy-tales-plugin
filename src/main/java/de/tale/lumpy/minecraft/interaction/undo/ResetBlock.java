package de.tale.lumpy.minecraft.interaction.undo;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;

public class ResetBlock {
    private final World world;
    private final Location location;
    private final BlockData blockData;
    public ResetBlock(World world, Location location, BlockData blockData) {
        this.world = world;
        this.location = location;
        this.blockData = blockData;
    }

    protected World getWorld() {
        return world;
    }

    protected Location getLocation() {
        return location;
    }

    protected BlockData getBlockData() {
        return blockData;
    }

    public void undo() {
        world.setBlockData(location, blockData);
    }
}
