package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import model.selectedList;
import model.shapesList;
import model.whatShapeStrategy;
import mouse.PointJpaint;

public class MoveCommand implements ICommand, IUndoable {

	
	public PointJpaint startPoint;
	public PointJpaint endPoint;
	Graphics2D graphics2d;
	
	public MoveCommand(PointJpaint startPoint, PointJpaint endPoint)
			{
				this.startPoint = startPoint;
				this.endPoint = endPoint;
			}

		
	
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
		double x = (endPoint.getX() - startPoint.getX());
		double y =  (endPoint.getY() - startPoint.getY());
		
		
		for (ShapeDrawCommand shape : selectedList.selected) 
		{
			 for (ShapeDrawCommand shape2: shapesList.shapes)  
			 	{
				 	if (shape2.equals(shape))
				 		{
				 		
				 		
				 		
				 		
				 			PointJpaint newStartPoint = new PointJpaint(shape2.startPoint.getX() + x, shape2.startPoint.getY() + y );
				 			PointJpaint newEndPoint = new PointJpaint(shape2.endPoint.getX() + x, shape2.endPoint.getY() + y );
				 			ShapeDrawCommand newShapeCommand = new ShapeDrawCommand(shape2.paintCanvas, newStartPoint, newEndPoint, shape2.width, shape2.height, shape2.shape);
				 			shapesList.shapes.set(shapesList.shapes.indexOf(shape2), newShapeCommand);
				 			selectedList.selected.set(selectedList.selected.indexOf(shape), newShapeCommand);
				 			
				 			
				 			graphics2d = shape.paintCanvas.getGraphics2D();
				 	        graphics2d.setColor(Color.WHITE);
				 	        graphics2d.fillRect(0,0, 1920, 1080);
				 			
				 	     
				 			for(ShapeDrawCommand command : shapesList.shapes)
				 			{
				        		whatShapeStrategy newStrat = new whatShapeStrategy();
				        		try {
									newStrat.whatShapeStrategyChoose(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				        		}
				 			
				 			
				 		}
			 	}	
		}
		
		

		
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void redo() {
		// TODO Auto-generated method stub
		
	}

}
