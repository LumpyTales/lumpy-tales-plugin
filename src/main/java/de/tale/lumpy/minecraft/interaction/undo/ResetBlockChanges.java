package de.tale.lumpy.minecraft.interaction.undo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResetBlockChanges implements Runnable {

    private final static List<ResetBlockAt> UNDO_BLOCK_DATA = Collections.synchronizedList(new ArrayList<>());

    public static void registerForUndo(final ResetBlock resetBlock, final Duration lifeTime) {
        UNDO_BLOCK_DATA.add(new ResetBlockAt(resetBlock, lifeTime));
    }

    @Override
    public void run() {
        final var resetted = UNDO_BLOCK_DATA.stream().filter(ResetBlockAt::undoNow).toList();
        UNDO_BLOCK_DATA.removeAll(resetted);
    }

    public static void resetAll() {
        UNDO_BLOCK_DATA.forEach(ResetBlock::undo);
    }
}
