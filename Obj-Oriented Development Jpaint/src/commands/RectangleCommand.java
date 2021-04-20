package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.io.IOException;
import java.util.Stack;

import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class RectangleCommand implements ICommand, IUndoable {
	 Graphics2D graphics2d;
	 PaintCanvasBase paintCanvas;
	 PointJpaint startPoint;
	 int width;
	int height;
	
//	RectangleCommand[] RecList = new RectangleCommand[100000];
	
	 public RectangleCommand(PaintCanvasBase paintCanvas, PointJpaint startPoint, int width, int height) {
	        this.paintCanvas = paintCanvas;
	        this.startPoint = startPoint;
	        this.width =  width;
	        this.height = height;
	    }
	
	@Override
	public void run() throws IOException {
		
		
		graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
       
		CommandHistory.add(this);
	}
	
	@Override
	public void undo() {
		
		graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0,0, 1920, 1080);
        
       
		
        
	}
	
	@Override
	public void redo() {
		graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
		
	}
}
