package model;

import java.io.IOException;

import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public class whatShapeFactory implements IShapeFactory {
	
	public  IShapeStrategy whatShapeStrategyChoose(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, 
			int height, shapeState shapeState) throws IOException  {
	
	IShapeStrategy ShapeStrategy = null;
	
	
	switch(shapeState.shapeShape) {
	
	case RECTANGLE:
		
		ShapeStrategy = new rectangleStrategy();
		//System.out.println("rectangle");
		break;
	case ELLIPSE:
		ShapeStrategy =  new ellipsisStrategy();
		break;
	case TRIANGLE:
		ShapeStrategy =  new triangleStrategy();
		break;

	default:
	
		System.out.println("null shape");	
		break;
	}
		return ShapeStrategy;
}

	@Override
	public  IShapeStrategy rectangleStrategy() {
		// TODO Auto-generated method stub
		return new rectangleStrategy();
	}

	@Override
	public  IShapeStrategy ellipsisStrategy() {
		// TODO Auto-generated method stub
		return new ellipsisStrategy();
	}

	@Override
	public   IShapeStrategy triangleStrategy() {
		// TODO Auto-generated method stub
		return new triangleStrategy();
	}

	
		
	}

/*
 * class whatShapeStrategyChoose implements IWhatShapeStrategyChoose {
 * @Override
 * public IShapeStrategy whatShapeStrategyChoose(PaintCanvasBase paintCanvas, PointJpaint startPoint, PointJpaint endPoint, int width, 
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
		
		return ShapeStrategy;
}
 * }
 * 
 * class Client {
 * IWhatShapeStrategyChoose whatShapeStrategyChoose;
 * 	method() {
 * 		IShapeStrategy strategy = whatShapeStrategyChoose.whatShapeStrategyChoose(...);
 * 		strategy.draw(paintCanvas, startPoint, endPoint, width, height, shapeState);

 * 	}
 * 
 * }
 * 
 */
