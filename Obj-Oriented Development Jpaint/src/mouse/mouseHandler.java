package mouse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.interfaces.PaintCanvasBase;

public class mouseHandler extends MouseAdapter {

	private PointJpaint startPoint;
	private PointJpaint endPoint;
	private int width;
	private int height;
	private PaintCanvasBase paintCanvas;
	
	public mouseHandler(PaintCanvasBase paintCanvas){
	        this.paintCanvas = paintCanvas;
	    }
	
	
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		startPoint = new PointJpaint(x,y);
		
	}
	
	
	public void mouseReleased(MouseEvent e) {
	
		int x = e.getX();
		int y = e.getY();
		PointJpaint endPoint = new PointJpaint(x,y);
		width = (int) Math.abs(((startPoint.getX())) - (endPoint.getX()));
		height = (int) Math.abs(startPoint.getY() - endPoint.getY());
		
		  Graphics2D graphics2d = paintCanvas.getGraphics2D();
	        graphics2d.setColor(Color.GREEN);
	        graphics2d.fillRect((int)startPoint.getX(),(int) startPoint.getY(), width, height);
	
	

}
	
	
	
}
