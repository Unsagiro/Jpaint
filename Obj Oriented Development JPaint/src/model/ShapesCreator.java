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
						OutlineDecorator newOutline = new OutlineDecorator();
						newOutline.draw(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
					
					}
				else 
						{
							whatShapeStrategyChoose newStrat = new whatShapeStrategyChoose();
							try 
								{
								newStrat.whatShapeStrategyChoose(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
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
