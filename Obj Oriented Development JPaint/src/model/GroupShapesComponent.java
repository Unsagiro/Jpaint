package model;

import java.util.ArrayList;

import commands.IUndoable;
import commands.ShapeDrawCommand;
import mouse.PointJpaint;



public class GroupShapesComponent implements IshapeComponent, IUndoable{

	
	private PointJpaint lowStartPoint;
	private PointJpaint highEndPoint;
	private ArrayList<ShapeDrawCommand> children;
	
	
	public void addChild(ShapeDrawCommand component)
			{
				children.add(component);
				
			}
	@Override
	public void group() {
		for (ShapeDrawCommand shape :SelectedListGetter.getSelectedList().getAllShapes())
			
			{	
				addChild(shape);
			}
		
		SelectedListGetter.getSelectedList().clearList();
		shapesListGetter.getShapesList().removeAllShapes(children);
		ClearCanvas.clearCanvas();
		shapesListGetter.getShapesList().addAllShapes(children);
		
		 ShapeDrawCommand dummy = children.get(0);
		 lowStartPoint = dummy.startPoint;
		 highEndPoint = dummy.endPoint;
		
		for(ShapeDrawCommand shape : children)
			{
				
				if ((shape.startPoint.getX() + shape.startPoint.getX()) < (lowStartPoint.getX() + lowStartPoint.getY()))
						{
							lowStartPoint = shape.startPoint;
						}
				if ((shape.endPoint.getX() + shape.endPoint.getX()) > (highEndPoint.getX() + highEndPoint.getY()))
					{
						highEndPoint = shape.endPoint;
					}
				else
				{
					continue;
				}
				
			}
		
		
		

	}

	@Override
	public void ungroup() {
		// TODO Auto-generated method stub

	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		ungroup();
	}
	@Override
	public void redo() {
		// TODO Auto-generated method stub
		group();
	}

}
