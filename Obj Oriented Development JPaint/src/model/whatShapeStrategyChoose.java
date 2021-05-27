package model;

import java.io.IOException;

import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class whatShapeStrategyChoose {
	
	public void whatShapeStrategyChoose(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, 
			int height, shapeState shapeState) throws IOException  {
	
	IShapeStrategy ShapeStrategy = null;
	
	
	switch(shapeState.shapeShape) {
	
	case RECTANGLE:
		ShapeStrategy = new rectangleStrategy();
		//System.out.println("rectangle");
		break;
	case ELLIPSE:
		ShapeStrategy = new ellipsisStrategy();
		break;
	case TRIANGLE:
		ShapeStrategy = new triangleStrategy();
		break;

	default:
	
		System.out.println("null shape");	
		break;
	}
		ShapeStrategy.draw(paintCanvas, startPoint, endPoint, width, height, shapeState);
}

	
		
	}
