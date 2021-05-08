package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.interfaces.IShapeStrategy;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class rectangleStrategy implements IShapeStrategy {

	Graphics2D graphics2d;
	
	
	@Override
	public void draw(PaintCanvasBase paintCanvas, PointJpaint startPoint,PointJpaint endPoint, int width, int height, shapeState shapeState) {
		
		
	  graphics2d = paintCanvas.getGraphics2D();
      graphics2d.setColor(Color.GREEN);
      graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
      graphics2d.setStroke(new BasicStroke(5));
      
		

	}

}
