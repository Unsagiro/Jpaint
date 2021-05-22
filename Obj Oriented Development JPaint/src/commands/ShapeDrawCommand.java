package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import model.ShapeType;
import model.shapeState;
import model.shapesList;
import model.whatShapeStrategy;
import model.persistence.ApplicationState;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;
import model.whatShapeStrategy;

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
		
		
		//graphics2d = paintCanvas.getGraphics2D();
       // graphics2d.setColor(Color.GREEN);
      // graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
		//switch())
		
		
		
		
		whatShapeStrategy newStrat = new whatShapeStrategy();
		//System.out.println(endPoint.toString());
		newStrat.whatShapeStrategyChoose(paintCanvas, startPoint, endPoint, width, height, shape);
	
        shapesList.shapes.add(this);
		CommandHistory.add(this);
		
		
		
	}


		
	


		
	

	@Override
	public void undo() {
		
        if (! shapesList.shapes.isEmpty()) 
        	{
        		shapesList.shapes.remove(shapesList.shapes.size() - 1 );
        		System.out.println("i am undo");
        		graphics2d = paintCanvas.getGraphics2D();
                graphics2d.setColor(Color.WHITE);
                graphics2d.fillRect(0,0, 1920, 1080);
        	}
        for (ShapeDrawCommand command : shapesList.shapes)
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
	public void redo() {
		/*graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
        ;*/
		whatShapeStrategy newStrat = new whatShapeStrategy();
		System.out.println("i am  redo");
		try {
			newStrat.whatShapeStrategyChoose(paintCanvas, startPoint, endPoint, width, height, shape);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		shapesList.shapes.add(this);
	}
}
