package model.interfaces;

import model.shapeState;
import mouse.PointJpaint;
import view.interfaces.PaintCanvasBase;

public interface IShapeStrategy {

	public void draw(PaintCanvasBase paintCanvas, PointJpaint startPoint,PointJpaint endPoint, int width, int height, shapeState shapeState);
		
	
}
