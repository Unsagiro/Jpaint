package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

import model.interfaces.IShapeStrategy;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class ellipsisStrategy implements IShapeStrategy {
	Graphics2D graphics2d;
	@Override
	public void draw(PaintCanvasBase paintCanvas, PointJpaint startPoint,PointJpaint endPoint, int width, int height, shapeState shapeState) {
		// TODO Auto-generated method stub

		
		
		graphics2d = paintCanvas.getGraphics2D();
		
		
		switch(shapeState.shapeShading) 
			{
		
				case OUTLINE_AND_FILLED_IN:
		
					graphics2d.setColor(enumMapColor.colorMap(shapeState.primaryColor));
					graphics2d.fillOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
					graphics2d.setStroke(new BasicStroke(5));
					graphics2d.setColor(enumMapColor.colorMap(shapeState.secondaryColor));
					graphics2d.drawOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
		
					break;
		
				case FILLED_IN:
			
					graphics2d.setColor(enumMapColor.colorMap(shapeState.primaryColor));
					graphics2d.fillOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
					graphics2d.setStroke(new BasicStroke(5));
					graphics2d.setColor(enumMapColor.colorMap(shapeState.primaryColor));
					graphics2d.drawOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
		
					break;
				
				case OUTLINE:
				
					graphics2d.setStroke(new BasicStroke(5));
					graphics2d.setColor(enumMapColor.colorMap(shapeState.secondaryColor));
					graphics2d.drawOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
					
					break;
		
		
		
		}
		
	}

}
