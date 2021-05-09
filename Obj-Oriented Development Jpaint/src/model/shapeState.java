package model;

import java.io.IOException;

import model.interfaces.IShapeState;
import model.persistence.ApplicationState;



public class shapeState implements IShapeState{
	
	static ApplicationState appState = null;

	public  ShapeType shapeShape;
	public ShapeColor primaryColor;
	public ShapeColor secondaryColor;
	public ShapeShadingType shapeShading;
	public MouseMode mouseMode;
	
	
	
	public  shapeState(ShapeType shapeShape, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shapeShading, MouseMode mouseMode){
		
	this.shapeShape = shapeShape;
	this.primaryColor = primaryColor;
	this.secondaryColor = secondaryColor;
	this.shapeShading = shapeShading;
	this.mouseMode = mouseMode;
		
	}
	
	public static void stateHolder(ApplicationState stateConnection) /// HERE I RECEIVE THE STATE FROM MAIN AFTER ITS INITIALIZATION AT THE BEGGINING
		{
			
			appState = stateConnection;
		}

	@Override
	public void run() throws IOException {
		// TODO Auto-generated method stub
		
		 shapeShape = appState.getActiveShapeType();
		 primaryColor = appState.getActivePrimaryColor();
		 secondaryColor = appState.getActiveSecondaryColor();
		 shapeShading = appState.getActiveShapeShadingType();
		 mouseMode = appState.getActiveMouseMode();
	}
}
