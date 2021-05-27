package model;

import java.io.IOException;

import commands.ShapeDrawCommand;

public class ShapesCreator implements IShapeListObserver{

	
	
	
	@Override
	public void update() 
		{
			
			for (ShapeDrawCommand command : shapesListGetter.getShapesList().getAllShapes())
				{
				whatShapeStrategyChoose newStrat = new whatShapeStrategyChoose();
		try {
			newStrat.whatShapeStrategyChoose(command.paintCanvas,command.startPoint, command.endPoint, command.width, command.height, command.shape);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
	}
