package commands;

import java.io.IOException;

import model.selectedList;
import model.shapesList;
import model.shapesListGetter;
import mouse.PointJpaint;

public class SelectCommand implements ICommand {

	
	PointJpaint startPoint;
	PointJpaint endPoint;
	static SelectCommand collision;
	
	public SelectCommand(PointJpaint startPoint, PointJpaint endPoint)
		{
			this.startPoint = startPoint;
			this.endPoint = endPoint;
		}
	
	
	@Override
	public void run() throws IOException 
		{
		// TODO Auto-generated method stub
		
			
		
			for (ShapeDrawCommand shape : shapesListGetter.getShapesList().getAllShapes())
				{
						if (	shape.startPoint.getX() < endPoint.getX() && 
								shape.endPoint.getX() > startPoint.getX() &&
								shape.startPoint.getY() < endPoint.getY() &&
								shape.endPoint.getY() > startPoint.getY()
							)
								
						{	selectedList.selected.add(shape);}
								
						else selectedList.selected.clear(); System.out.println("selected list cleared");
						
			}
		
	
		
			
		
		}

}
