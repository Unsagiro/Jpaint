package mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseHandler extends MouseAdapter {

	@Override
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		PointJpaint startPoint = new PointJpaint(x,y);
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	
		int x = e.getX();
		int y = e.getY();
		PointJpaint endPoint = new PointJpaint(x,y);

}
	
	
	
}
