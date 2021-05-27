package model;

import java.awt.List;
import java.util.ArrayList;


import commands.ShapeDrawCommand;
import model.IShapeListSubject;


public class shapesList implements IShapeListSubject {

	 
	 ArrayList<IShapeListObserver>observers = new ArrayList<IShapeListObserver>();
	 public  ArrayList<ShapeDrawCommand> shapesInCanvas;
	 
	public shapesList(ArrayList<ShapeDrawCommand> shapes)
	 	{
		 this.shapesInCanvas = shapes;
	 	}
	 
	public ArrayList<ShapeDrawCommand> getAllShapes()
	{
		return shapesInCanvas;
	}
	

	
	public void addShape(ShapeDrawCommand shape)
		{
			shapesInCanvas.add(shape);
			notifyObservers();
		}
	
	public void removeShape(ShapeDrawCommand shape)
		{
			shapesInCanvas.remove(shape);
			notifyObservers();
		}
	
	public void removeAllShapes(ArrayList<ShapeDrawCommand> shapes)
		{
			shapesInCanvas.removeAll(shapes);
			notifyObservers();
		}
	public void addAllShapes(ArrayList<ShapeDrawCommand> shapes)
		{
			shapesInCanvas.addAll(shapes);
			notifyObservers();
		}
	
	
	public void registerObserver(IShapeListObserver creator) {
		// TODO Auto-generated method stub
		observers.add(creator);
	}

	
	private void notifyObservers()
		{
			for (IShapeListObserver observer : observers)
			{
				observer.update();
			}
		}	
			

	
	@Override
	public void removeObserver(IShapeListObserver observer) {
		// TODO Auto-generated method stub
		
	}
}
