package controller;

import java.io.IOException;

import commands.CopyCommand;
import commands.DeleteCommand;
import commands.PasteCommand;
import commands.RedoCommand;
import commands.UndoCommand;
import model.GroupShapes;

import model.IApplicationState;
import view.EventName;
import view.interfaces.IEventCallback;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
    }

    @Override
    public void setup() throws IOException {
        setupEvents();
    }

    private void setupEvents() throws IOException {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_MOUSE_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand().run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand().run());
        
        uiModule.addEvent(EventName.COPY,() -> {
			try {
				new CopyCommand().run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.PASTE,() -> {
			try {
				new PasteCommand().run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.DELETE, () -> {
			try {
				new DeleteCommand().run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        uiModule.addEvent(EventName.GROUP, () -> { new GroupShapes().run();
        });
        
        
        
        
        
        
    }
}
