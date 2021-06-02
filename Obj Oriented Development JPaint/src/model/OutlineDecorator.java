package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class OutlineDecorator implements IShapeStrategy {

	private IShapeStrategy ShapeStrategy;
	
	
	public OutlineDecorator(IShapeStrategy shapeStrategy) {
		this.ShapeStrategy = shapeStrategy;
	}
	
	@Override
	public void draw(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, int height,
			shapeState shapeState) {
		Graphics2D graphics2d = paintCanvas.getGraphics2D();
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0);
		int[] xPoints = new int[3];
		xPoints[0] = ((int)(startPoint.getX())) - 5;
		xPoints[1] = ((int)(startPoint.getX())) - 5;
		xPoints[2] = ((int)(endPoint.getX())) - 5;
			
		int[] yPoints = new int[3];
		yPoints[0] = ((int)(startPoint.getY())) - 5;
		yPoints[1] = ((int)(endPoint.getY())) - 5;
		yPoints[2] = ((int)(endPoint.getY())) -  5;
		
		
		
		
	
		
		switch(shapeState.shapeShape)
		{
			case RECTANGLE:
			
			
		  	ShapeStrategy.draw(paintCanvas, startPoint, endPoint, width, height, shapeState);
			graphics2d.setStroke(dashed);
	  		graphics2d.setColor(Color.red);
	  		graphics2d.drawRect(((int)startPoint.getX()) - 5,((int) startPoint.getY()) -5, width + 10, height + 10);
	  		
	  		break;
	  		
			case ELLIPSE:
				
				ShapeStrategy.draw(paintCanvas, startPoint, endPoint, width, height, shapeState);
				graphics2d.setStroke(dashed);
				graphics2d.setColor(Color.red);
				graphics2d.drawOval(((int)startPoint.getX()) - 5,((int)startPoint.getY()) -5 , width + 10 , height + 10);
				
			break;
			
			case TRIANGLE:
				
	  			
	  			ShapeStrategy.draw(paintCanvas, startPoint, endPoint, width, height, shapeState);
	  			graphics2d.setStroke(dashed);
	  			graphics2d.setColor(Color.red);
	  			graphics2d.drawPolygon(xPoints, yPoints, 3);
	  			break;
	  			
	  			default:
	  				break;
		 }
		
				
		}
		
		
		
		
		
		
		

	}


