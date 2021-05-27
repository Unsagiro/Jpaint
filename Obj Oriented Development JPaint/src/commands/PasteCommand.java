package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import model.ClearCanvas;
import model.ClipBoard;
import model.selectedList;
import model.shapesListGetter;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class PasteCommand implements ICommand, IUndoable {
	  
	  ArrayList<ShapeDrawCommand> oldClipBoard = new  ArrayList<ShapeDrawCommand>();
	  ArrayList<ShapeDrawCommand> newClipBoard = new  ArrayList<ShapeDrawCommand>();

	  
	  
	  
	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub

		
		
		
		 for (ShapeDrawCommand shape : ClipBoard.clipBoardList) // for shape selected
			{
			
				oldClipBoard.add(shape);
			
				PointJpaint newStartPoint = new PointJpaint(shape.startPoint.getX() + 50, shape.startPoint.getY() + 50); 
				PointJpaint newEndPoint = new PointJpaint(shape.endPoint.getX() + 50, shape.endPoint.getY() + 50 );
				ShapeDrawCommand newShapeCommand = new ShapeDrawCommand(shape.paintCanvas, newStartPoint, newEndPoint, shape.width, shape.height, shape.shape);	
			
				newClipBoard.add(newShapeCommand);
			}
				
		
		 ClearCanvas.clearCanvas();
		
		shapesListGetter.getShapesList().addAllShapes(newClipBoard);
		
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() 
		{
		
		
		 ClearCanvas.clearCanvas();
		
		 
		 shapesListGetter.getShapesList().removeAllShapes(newClipBoard);
	
		 
		 
		}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().addAllShapes(newClipBoard);
		
		
	}

	

}
