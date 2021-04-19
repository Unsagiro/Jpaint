package commands;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class RectangleCommand implements ICommand, IUndoable {
	
	 PaintCanvasBase paintCanvas;
	 PointJpaint startPoint;
	 int width;
	int height;
	
	
	 public RectangleCommand(PaintCanvasBase paintCanvas, PointJpaint startPoint, int width, int height) {
	        this.paintCanvas = paintCanvas;
	        this.startPoint = startPoint;
	        this.width =  width;
	        this.height = height;
	    }
	
	@Override
	public void run() throws IOException {
		
		
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
		//CommandHistory.add(this);
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
