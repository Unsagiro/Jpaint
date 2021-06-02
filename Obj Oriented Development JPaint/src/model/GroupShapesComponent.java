/*package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.io.IOException;
import java.util.ArrayList;

import commands.ICommand;
import commands.IUndoable;
import commands.ShapeDrawCommand;
import mouse.PointJpaint;



public class GroupShapesComponent implements IshapeComponent, IUndoable{

	private int width;
	private int  height;
	private PointJpaint lowStartPoint;
	private PointJpaint highEndPoint;
	private ArrayList<ShapeDrawCommand> children;
	
	
	public void addChild(ShapeDrawCommand component)
			{
	
				children.add(component);
				
			}
	@Override
	public  void group() {
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
		 
		 width = (int) Math.abs(((lowStartPoint.getX())) - (lowStartPoint.getX()));
		 height = (int) Math.abs(highEndPoint.getY() - highEndPoint.getY());
		 Graphics2D graphics2d = dummy.paintCanvas.getGraphics2D();
		 Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0);
		 
		graphics2d.setStroke(dashed);
  		graphics2d.setColor(Color.red);
  		graphics2d.drawRect(((int)lowStartPoint.getX()) - 5,((int) highEndPoint.getY()) -5, width + 10, height + 10);
		
		
		

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
*/