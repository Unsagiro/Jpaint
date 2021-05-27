package model;

import java.awt.Color;
import java.awt.Graphics2D;

import view.interfaces.PaintCanvasBase;

public class ClearCanvas {

	static PaintCanvasBase paintCanvasClear;
	
	
	public static void canvasForClear(PaintCanvasBase paintCanvas)
		{
			paintCanvasClear = paintCanvas;
		}
	
	
	public static void clearCanvas() {
		
	
		Graphics2D graphics2d = paintCanvasClear.getGraphics2D();                            // clear the canvas
		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0,0, 1920, 1080);
	}
	
}
