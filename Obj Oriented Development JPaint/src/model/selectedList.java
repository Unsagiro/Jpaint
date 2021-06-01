package model;

import java.util.ArrayList;

import commands.ShapeDrawCommand;

public class selectedList implements IShapeListSubject  {

	  public ArrayList<ShapeDrawCommand> selectedHere = new  ArrayList<ShapeDrawCommand>();
	 ArrayList<IShapeListObserver>observers = new ArrayList<IShapeListObserver>();
	 
	 
	 public selectedList(ArrayList<ShapeDrawCommand> selected)
	 {
		 this.selectedHere = selected;
	 }
	 
	@Override
	public void registerObserver(IShapeListObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void removeObserver(IShapeListObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addShape(ShapeDrawCommand shape) {
		// TODO Auto-generated method stub
		selectedHere.add(shape);
		notifyObservers();
	}

	@Override
	public void removeShape(ShapeDrawCommand shape) {
		// TODO Auto-generated method stub
		selectedHere.remove(shape);
		notifyObservers();
	}

	@Override
	public void addAllShapes(ArrayList<ShapeDrawCommand> shapes) {
		// TODO Auto-generated method stub
		selectedHere.addAll(shapes);
		notifyObservers();
	}
	
	public boolean containsObject(ShapeDrawCommand o )
	{
		return selectedHere.contains(o);
		
	}
	
	public void clearList() {
		selectedHere.clear();
		notifyObservers();
	}
	
	

	@Override
	public void removeAllShapes(ArrayList<ShapeDrawCommand> shapes) {
		// TODO Auto-generated method stub
		selectedHere.removeAll(shapes);
		notifyObservers();
	}

	@Override
	public ArrayList<ShapeDrawCommand> getAllShapes() {
		// TODO Auto-generated method stub
		return selectedHere;
	}
	
	private void notifyObservers()
	{
		for (IShapeListObserver observer : observers)
		{
			observer.update();
		}
	}	
		
	 
}
