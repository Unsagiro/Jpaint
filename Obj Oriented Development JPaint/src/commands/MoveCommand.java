package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import model.ClearCanvas;
import model.SelectedListGetter;
import model.selectedList;
import model.shapeState;
import model.shapesList;
import model.shapesListGetter;
import model.whatShapeStrategyChoose;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements ICommand, IUndoable {

	public PaintCanvasBase paintCanvas;
	public PointJpaint startPoint;
	public PointJpaint endPoint;
	Graphics2D graphics2d;
	   ArrayList<ShapeDrawCommand> oldSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	  ArrayList<ShapeDrawCommand> newSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	public double x;
	public double y;
	
	public MoveCommand( PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint)
			{
				this.paintCanvas = paintCanvas;
				this.startPoint = startPoint;
				this.endPoint = endPoint;
			}

	
	
	public void run() throws IOException {

		
		x = (endPoint.getX() - startPoint.getX());
		y =  (endPoint.getY() - startPoint.getY());
		
		
		SelectedListGetter.getSelectedList().removeAllShapes(oldSelectedShapesLocal);
		
		 for (ShapeDrawCommand shape : SelectedListGetter.getSelectedList().getAllShapes()) // for shape selected
			{
			
				oldSelectedShapesLocal.add(shape);
			
				PointJpaint newStartPoint = new PointJpaint(shape.startPoint.getX() + x, shape.startPoint.getY() + y ); 
				PointJpaint newEndPoint = new PointJpaint(shape.endPoint.getX() + x, shape.endPoint.getY() + y );
				ShapeDrawCommand newShapeCommand = new ShapeDrawCommand(shape.paintCanvas, newStartPoint, newEndPoint, shape.width, shape.height, shape.shape);	
 			
				newSelectedShapesLocal.add(newShapeCommand);
			}
				 			
				
		
		
		
		
				 			
		shapesListGetter.getShapesList().removeAllShapes(oldSelectedShapesLocal);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().addAllShapes(newSelectedShapesLocal);
				 				
				 			
		SelectedListGetter.getSelectedList().removeAllShapes(oldSelectedShapesLocal);
		
	
		
		SelectedListGetter.getSelectedList().addAllShapes(newSelectedShapesLocal);

    		
		CommandHistory.add(this);
		
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ClearCanvas.clearCanvas();
		
		 for (ShapeDrawCommand newSelShape : newSelectedShapesLocal) // for shape selected
				{
					shapesListGetter.getShapesList().removeShape(newSelShape);
					SelectedListGetter.getSelectedList().removeShape(newSelShape);
				}
		
		
		 for (ShapeDrawCommand oldSelShape :  oldSelectedShapesLocal)
				{
					shapesListGetter.getShapesList().addShape(oldSelShape);
					SelectedListGetter.getSelectedList().addShape(oldSelShape);
				}
		
		
		
     // System.out.println("newSelected has " + oldSelected.size() + " shapes inside");
    
		}

	@Override
	public void redo() {///////////////main bug is here
		ClearCanvas.clearCanvas();

			for (ShapeDrawCommand oldSelShape : oldSelectedShapesLocal) // for shape selected
					{
						shapesListGetter.getShapesList().removeShape(oldSelShape);
						SelectedListGetter.getSelectedList().removeShape(oldSelShape);
					}
			
			for (ShapeDrawCommand newSelShape :  newSelectedShapesLocal)
					{
						shapesListGetter.getShapesList().addShape(newSelShape);
						SelectedListGetter.getSelectedList().addShape(newSelShape);
					}
		
			
   		
   		}


	}


		
