package de.tale.lumpy.minecraft.undo;

import java.time.Duration;
import java.time.LocalDateTime;

public class ResetBlockAt extends ResetBlock {

    private final LocalDateTime livesUntil;

    public ResetBlockAt(final ResetBlock resetBlock, final Duration lifeTime) {
        super(resetBlock.getWorld(), resetBlock.getLocation(), resetBlock.getBlockData());
        this.livesUntil = LocalDateTime.now().plus(lifeTime);
    }

    public boolean undoNow() {
        if (LocalDateTime.now().isAfter(this.livesUntil)) {
            super.undo();
            return true;
        }
        return false;
    }

}
