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
		graphics2d.setColor(Color.GREEN);
		graphics2d.fillOval((int)startPoint.getX(),(int)startPoint.getY(), width, height);
		graphics2d.setStroke(new BasicStroke(5));
		
		
		
		
		
		
		
		
		
		
		
	}

}
