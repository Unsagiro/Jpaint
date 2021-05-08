package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.interfaces.IShapeStrategy;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class triangleStrategy implements IShapeStrategy {
	
		Graphics2D graphics2d;
		
	@Override
	public void draw(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, int height, shapeState shapeState) {
		// TODO Auto-generated method stub
			
		
	int[] xPoints = new int[3];
	xPoints[0] = (int)(startPoint.getX());
	xPoints[1] = (int)(startPoint.getX());
	xPoints[2] = (int)(endPoint.getX());
		
	
	
	
	int[] yPoints = new int[3];
	yPoints[0] = (int)(startPoint.getY());
	yPoints[1] = (int)(endPoint.getY());
	yPoints[2] = (int)(endPoint.getY());
	
		
		
		 
		  graphics2d = paintCanvas.getGraphics2D();
	      //graphics2d.setColor(enumMapColor.colorMap(shapeState.primaryColor));
		  graphics2d.setColor(Color.GREEN);
	      graphics2d.fillPolygon(xPoints, yPoints, 3);
	      graphics2d.setStroke(new BasicStroke(5));
	      
	      //graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
		
		
		
	}

}
