package org.jhotdraw.action.edit;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.jhotdraw.api.app.Application;
import org.jhotdraw.api.app.View;
import org.junit.Before;
import org.junit.Test;

import javax.swing.ActionMap;
import java.awt.event.ActionEvent;

public class UndoActionTest {
    private UndoAction undoAction;
    private View mockedView;
    private Application mockedApp;
    private ActionMap mockedActionMap;

    @Before
    public void setUp() {
        // Mock the dependencies
        mockedApp = mock(Application.class);
        mockedView = mock(View.class);
        mockedActionMap = mock(ActionMap.class);

        // Configure mocked View to return the mocked ActionMap
        when(mockedView.getActionMap()).thenReturn(mockedActionMap);

        // Initialize UndoAction with the mocked dependencies
        undoAction = new UndoAction(mockedApp, mockedView);
    }

    @Test
    public void testUndoWhenNoActionsAvailable() {
        // Mock the ActionMap to simulate no undo action being available
        when(mockedActionMap.get(UndoAction.ID)).thenReturn(null);

        // Trigger the update of the enabled state
        undoAction.updateEnabledState();

        // Verify that UndoAction remains disabled
        assertFalse("UndoAction should be disabled when no undo action is available.", undoAction.isEnabled());
    }


    @Test
    public void testUndoActionPerformed() {
        // Create a mock Action to simulate an undo operation
        ActionEvent event = mock(ActionEvent.class);
        javax.swing.Action mockUndo = mock(javax.swing.Action.class);

        // Mock the ActionMap to return the mock undo action
        when(mockedActionMap.get(UndoAction.ID)).thenReturn(mockUndo);

        // Perform the undo action
        undoAction.actionPerformed(event);

        // Verify the undo action was invoked
        verify(mockUndo).actionPerformed(event);
    }
}
