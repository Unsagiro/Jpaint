package commands;

import java.io.IOException;
import java.util.ArrayList;

import model.ClearCanvas;
import model.SelectedListGetter;
import model.selectedList;
import model.shapesListGetter;

public class DeleteCommand implements IUndoable, ICommand {

	
	ArrayList<ShapeDrawCommand> deletedShapes = new  ArrayList<ShapeDrawCommand>();
	
	@Override
	
	
	public void run() throws IOException {
		
		deletedShapes.addAll(SelectedListGetter.getSelectedList().getAllShapes());
		SelectedListGetter.getSelectedList().removeAllShapes(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().removeAllShapes(deletedShapes);
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		
		SelectedListGetter.getSelectedList().addAllShapes(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().addAllShapes(deletedShapes);

	}

	@Override
	public void redo() {
		SelectedListGetter.getSelectedList().removeAllShapes(deletedShapes);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().removeAllShapes(deletedShapes);

	}

}
