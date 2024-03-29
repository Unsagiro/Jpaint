package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ClearCanvas;
import model.IShapeListObserver;
import model.IShapeListSubject;
import model.SelectedListGetter;
import model.ShapeColor;
import model.ShapeType;
import model.ShapesCreator;
import model.selectedList;
import model.shapeState;
import model.shapesList;
import model.shapesListGetter;
import model.persistence.ApplicationState;
import mouse.mouseHandler;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;

import commands.ShapeDrawCommand;

public class Main {
	
	
    public static void main (String[] args) throws IOException{
        
    	PaintCanvasBase paintCanvas = new PaintCanvas();
        
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
       
        IJPaintController controller = new JPaintController(uiModule, appState);
        shapeState.stateHolder(appState);
        
        mouseHandler mouseHandler = new mouseHandler(paintCanvas);
        
        ClearCanvas.canvasForClear(paintCanvas);
        paintCanvas.addMouseListener(mouseHandler);
        
        
        
        
        
        ArrayList<ShapeDrawCommand> OriginalShapesList= new ArrayList<ShapeDrawCommand>();
        IShapeListSubject shapesListInstance = new shapesList(OriginalShapesList);
	    IShapeListObserver Creator = new ShapesCreator();
	    shapesListInstance.registerObserver(Creator);
       
	    
	    ArrayList<ShapeDrawCommand> OriginalSelectedList= new ArrayList<ShapeDrawCommand>();
        IShapeListSubject selectedListInstance = new selectedList(OriginalSelectedList);
	    selectedListInstance.registerObserver(Creator);
        
	    shapesListGetter shapesGetter = new shapesListGetter(shapesListInstance);
	    SelectedListGetter selectedGetter = new SelectedListGetter(selectedListInstance);
	    
        controller.setup();
        
      

        //Filled in rectangle
      
        // Outlined rectangle
      /*  graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);
        */
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // For example purposes only; remove all lines below from your final project.
/*
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         Filled in rectangle
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.GREEN);
        graphics2d.fillRect(12, 13, 200, 400);

        // Outlined rectangle
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(Color.BLUE);
        graphics2d.drawRect(12, 13, 200, 400);

        // Selected Shape
        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(7, 8, 210, 410);
    }*/
}

	
		
	}

