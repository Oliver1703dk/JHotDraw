package org.jhotdraw.undo;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UndoRedoManagerTest {
    private UndoRedoManager undoRedoManager;

    @Before
    public void setUp() {
        undoRedoManager = new UndoRedoManager();
    }

    @Test
    public void testAddEdit() {
        assertFalse(undoRedoManager.canUndo());
    }
}
