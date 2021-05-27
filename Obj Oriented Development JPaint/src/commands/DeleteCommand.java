package commands;

import java.io.IOException;
import java.util.ArrayList;

import model.ClearCanvas;
import model.selectedList;
import model.shapesListGetter;

public class DeleteCommand implements IUndoable, ICommand {

	
	ArrayList<ShapeDrawCommand> deletedShapes = new  ArrayList<ShapeDrawCommand>();
	
	@Override
	
	
	public void run() throws IOException {
		
		deletedShapes.addAll(selectedList.selected);
		selectedList.selected.removeAll(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().removeAllShapes(deletedShapes);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		
		selectedList.selected.addAll(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().addAllShapes(deletedShapes);

	}

	@Override
	public void redo() {
		selectedList.selected.removeAll(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().removeAllShapes(deletedShapes);

	}

}
