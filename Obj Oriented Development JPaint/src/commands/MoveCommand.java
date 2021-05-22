package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

import model.selectedList;
import model.shapeState;
import model.shapesList;
import model.whatShapeStrategy;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class MoveCommand implements ICommand, IUndoable {

	public PaintCanvasBase paintCanvas;
	public PointJpaint startPoint;
	public PointJpaint endPoint;
	Graphics2D graphics2d;
	public   ArrayList<ShapeDrawCommand> oldSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	public   ArrayList<ShapeDrawCommand> newSelectedShapesLocal = new  ArrayList<ShapeDrawCommand>();
	public double x;
	public double y;
	
	public MoveCommand( PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint)
			{
				this.paintCanvas = paintCanvas;
				this.startPoint = startPoint;
				this.endPoint = endPoint;
			}

	
	
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
		 x = (endPoint.getX() - startPoint.getX());
		 y =  (endPoint.getY() - startPoint.getY());
		
		
		 
			selectedList.selected.removeAll(oldSelectedShapesLocal);
		for (ShapeDrawCommand shape : selectedList.selected) // for shape selected
		{
			
			oldSelectedShapesLocal.add(shape);
			
			PointJpaint newStartPoint = new PointJpaint(shape.startPoint.getX() + x, shape.startPoint.getY() + y ); 
 			PointJpaint newEndPoint = new PointJpaint(shape.endPoint.getX() + x, shape.endPoint.getY() + y );
 			ShapeDrawCommand newShapeCommand = new ShapeDrawCommand(shape.paintCanvas, newStartPoint, newEndPoint, shape.width, shape.height, shape.shape);	
 			newSelectedShapesLocal.add(newShapeCommand);
		}
				 			
				 			
				 			
		shapesList.shapes.removeAll(oldSelectedShapesLocal);
		shapesList.shapes.addAll(newSelectedShapesLocal);
				 				
				 			
		selectedList.selected.removeAll(oldSelectedShapesLocal);
		selectedList.selected.addAll(newSelectedShapesLocal);
				 			
				 		
				 	
			 		
		
		graphics2d = paintCanvas.getGraphics2D(); // clear the canvas
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0, 1920, 1080);

		// I repaint  my canvas based on my new shapelist
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
		CommandHistory.add(this);
		
	}



	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
		 
		
		
		
		for (ShapeDrawCommand newSelShape : newSelectedShapesLocal) // for shape selected
		{
			shapesList.shapes.remove(newSelShape);
				
				}
			
			for (ShapeDrawCommand oldSelShape :  oldSelectedShapesLocal)
			{
				shapesList.shapes.add(oldSelShape);
			}
		
		
		/*
      for ( ShapeDrawCommand newSelect: newSelected)
      		{
    	  		if (shapesList.shapes.indexOf(newSelect) > -1 )
    	  		{
    	  			shapesList.shapes.remove(shapesList.shapes.indexOf(newSelect));
    	  		}
    	  		if(selectedList.selected.indexOf(newSelect) > -1)
    	  		{
    	  			
    	  			selectedList.selected.remove(selectedList.selected.indexOf(newSelect));
    	  		}
      		}
   
      
      for (ShapeDrawCommand oldSelect : oldSelected) 
      	{
    	  
    	  	shapesList.shapes.add(oldSelect);
    	  	selectedList.selected.add(oldSelect);
    	  	
      	}
      	*/
     // System.out.println("newSelected has " + oldSelected.size() + " shapes inside");
      graphics2d = paintCanvas.getGraphics2D();
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



	@Override
	public void redo() {///////////////main bug is here
		

		for (ShapeDrawCommand oldSelShape : oldSelectedShapesLocal) // for shape selected
		{
			shapesList.shapes.remove(oldSelShape);
				
				}
			
			for (ShapeDrawCommand newSelShape :  newSelectedShapesLocal)
			{
				shapesList.shapes.add(newSelShape);
			}
		
			   graphics2d = paintCanvas.getGraphics2D();
			   graphics2d.setColor(Color.WHITE);
			   graphics2d.fillRect(0,0, 1920, 1080);
		
		// I repaint  my canvas based on my new shapelist
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


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/* System.out.println("I am move redo");
 
      for ( ShapeDrawCommand newSelect: newSelected)
      		{
    	  		shapesList.shapes.add(newSelect);
    	  		selectedList.selected.add(newSelect);
      		}
      
      
      
      System.out.println("oldSelected has " + oldSelected.size() + " shapes inside in redo");
      System.out.println("newSelected has " + newSelected.size() + " shapes inside in redo");
      
     for (ShapeDrawCommand oldSelect : oldSelected) 
     		{
    	 if (shapesList.shapes.indexOf(oldSelect) > -1) 
    	 	{
      		shapesList.shapes.remove(shapesList.shapes.indexOf(oldSelect));
     		}
     
    	
      graphics2d = paintCanvas.getGraphics2D();
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
		
	*/
}
		
	


