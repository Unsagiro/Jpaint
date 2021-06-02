package model;

import java.awt.Color;
import java.io.IOException;

import commands.ShapeDrawCommand;

public class ShapesCreator implements IShapeListObserver{

	
	
	
	@Override
	public void update() 
		{
	
		
			
			for (ShapeDrawCommand command : shapesListGetter.getShapesList().getAllShapes())
				{
				if (SelectedListGetter.getSelectedList().containsObject(command))
					{
					IShapeStrategy strategy = null;
					switch(command.shape.shapeShape)
					{
					case RECTANGLE:
						strategy = new rectangleStrategy();
						break;
						
					case TRIANGLE:
						strategy = new triangleStrategy();
						break;
					
					case ELLIPSE:
						strategy = new ellipsisStrategy();
						break;
						
					default:
						break;
					}
						OutlineDecorator newOutline = new OutlineDecorator(strategy);
						newOutline.draw(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
					
					}
				else 
						{
							
							IShapeFactory newStrat = new whatShapeFactory();
							try 
								{
								IShapeStrategy strategy =  ((whatShapeFactory) newStrat).whatShapeStrategyChoose(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
								strategy.draw(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
								} 
							catch (IOException e) 
								{
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
						}
				
		
		
	}

}
	}
