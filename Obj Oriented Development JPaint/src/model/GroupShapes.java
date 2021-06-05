package model;

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



public class GroupShapes implements ICommand, IUndoable{

	private int width;
	private int  height;
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	private ArrayList<ShapeDrawCommand> children;
	

	@Override
	public  void run() {
		
		
		children = SelectedListGetter.getSelectedList().getAllShapes();
		
		
		
		
		
		
		if (!(children.isEmpty())) {
		 ShapeDrawCommand dummy = children.get(0);
		  startX = (int)dummy.startPoint.getX();
		  startY = (int)dummy.startPoint.getY();
		  endX = (int)dummy.endPoint.getX();
		  endY = (int)dummy.endPoint.getY();
		
		
		 for(ShapeDrawCommand shape : children)
			{
				
				if (((int)shape.startPoint.getX()) <= startX )  
						{
							startX = (int) shape.startPoint.getX();
						}
				if ((int)shape.startPoint.getY() <= startY)
						{
							startY = (int)shape.startPoint.getY();
						}
				
				
				if ((int)shape.endPoint.getX() >= endX )
					{
						endX = (int)shape.endPoint.getX();
					}
				
				if	( (int)shape.endPoint.getY() >= endY)
					{
						endY = (int)shape.endPoint.getY();
					}
				else
				{
					continue;
				}
				
			}
		 
		 width =  Math.abs(startX - endX);
		 height =  Math.abs(startY - endY);
		 
		
		ClearCanvas.clearCanvas();
		
		 
		 Graphics2D graphics2d = dummy.paintCanvas.getGraphics2D();
		 Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL,0, new float[]{9}, 0);
		
		graphics2d.setStroke(dashed);
  		graphics2d.setColor(Color.red);
  		graphics2d.drawRect((startX - 5 ) ,(startY - 5 ) , width + 10 , height + 10);
  		

  		
		}
		
		shapesListGetter.getShapesList().removeAllShapes(children);
		ShapesCreator.switchOffSelected = true;
		shapesListGetter.getShapesList().addAllShapes(children);
		ShapesCreator.switchOffSelected = false;
		
	}
	
	public void addChild(ShapeDrawCommand component)
			{
	
				children.add(component);
				
			}
	
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
		run();
	}
	
	

}
