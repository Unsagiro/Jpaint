package model;

import java.util.ArrayList;

import commands.ShapeDrawCommand;

public interface IShapeListSubject  {
		
	
	
	
	 void registerObserver(IShapeListObserver observer);
	
	 void removeObserver(IShapeListObserver observer);
		
	 void addShape(ShapeDrawCommand shape);
	 
	 void removeShape(ShapeDrawCommand shape);
	 
	 void addAllShapes(ArrayList<ShapeDrawCommand> shapes);
	 
	 void removeAllShapes(ArrayList<ShapeDrawCommand> shapes);
	 
	 ArrayList<ShapeDrawCommand> getAllShapes();
	 
	 boolean containsObject(ShapeDrawCommand o );
	 
	 void clearList();
}
