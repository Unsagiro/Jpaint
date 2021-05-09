package mouse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import commands.CommandHistory;
import commands.ICommand;
import commands.MoveCommand;
import commands.SelectCommand;
import commands.ShapeDrawCommand;
import model.shapeState;
import view.interfaces.PaintCanvasBase;

public class mouseHandler extends MouseAdapter {
	
	ICommand command;
	private PointJpaint startPoint;
	private PointJpaint endPoint;
	private int width;
	private int height;
	private PaintCanvasBase paintCanvas;
	
	
	
	public mouseHandler(PaintCanvasBase paintCanvas){
	        this.paintCanvas = paintCanvas;
	    }
	
	
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		startPoint = new PointJpaint(x,y);
		
	}
	
	
	public void mouseReleased(MouseEvent e) {
	
		int x2 = e.getX();
		int y2 = e.getY();
		
	
		endPoint = new PointJpaint(x2,y2);
		//System.out.println(endPoint.toString());
		width = (int) Math.abs(((startPoint.getX())) - (endPoint.getX()));
		height = (int) Math.abs(startPoint.getY() - endPoint.getY());
		
		shapeState shape = new shapeState(null, null, null, null,null);
		try {
			shape.run();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		switch(shape.mouseMode) 
			{
		
				case DRAW:
					
					command = new ShapeDrawCommand(paintCanvas, startPoint,endPoint, width, height, shape);
					
					break;
				
				case SELECT:
					command = new SelectCommand(startPoint, endPoint);
					
					break;
				
				case MOVE:
					
					command = new MoveCommand(startPoint, endPoint);
					

				default:
					
					break;
		
		
		
		}
		
		
		
		
		
		
		
		
		try {
			command.run();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} 	
	     

}
	
	
	
}
