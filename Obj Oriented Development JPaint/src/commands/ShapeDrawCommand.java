package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import model.ClearCanvas;
import model.ShapeType;
import model.shapeState;
import model.shapesList;
import model.shapesListGetter;
import model.whatShapeFactory;
import model.persistence.ApplicationState;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;


public class ShapeDrawCommand implements ICommand, IUndoable {
	 Graphics2D graphics2d;
	public PaintCanvasBase paintCanvas;
	public PointJpaint startPoint;
	public PointJpaint endPoint;
	public int width;
	public int height;
	public shapeState shape;
	 
	
	
//	RectangleCommand[] RecList = new RectangleCommand[100000];
	
	 public ShapeDrawCommand(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, int height ,shapeState shape) {
	        this.paintCanvas = paintCanvas;
	        this.startPoint = startPoint;
	        this.endPoint = endPoint;
	        this.width =  width;
	        this.height = height;
	        this.shape = shape;
	        
	    }
	
	@Override
	public void run() throws IOException {
		
	
		shapesListGetter.getShapesList().addShape(this);
		CommandHistory.add(this);
		
		
		
	}



	@Override
	public void undo() {
		
		ClearCanvas.clearCanvas();
	
        shapesListGetter.getShapesList().removeShape(this);;
     
	}
        
	
	
	@Override
	public void redo() {
		
		ClearCanvas.clearCanvas();
		
        shapesListGetter.getShapesList().addShape(this);
	}
}
