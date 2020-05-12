import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class KeyEvent implements MouseMotionListener, MouseListener {

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void mouseClicked(MouseEvent mouseEvent) {

    }



    public void mousePressed(MouseEvent mouseEvent) {
       if( SwingUtilities.isLeftMouseButton(mouseEvent)) {
           Screen.point2 = new Point((int) mouseEvent.getPoint().getX(), (int) mouseEvent.getPoint().getY());
       }

       if(SwingUtilities.isRightMouseButton(mouseEvent)) {
           Screen.DelPoint = new Point((int) mouseEvent.getPoint().getX(), (int) mouseEvent.getPoint().getY());
       }
    }

    public void mouseReleased(MouseEvent mouseEvent) {

    }

    public void mouseDragged(MouseEvent mouseEvent) {
        Screen.point = new Point((int)mouseEvent.getPoint().getX(), (int)mouseEvent.getPoint().getY());
    }

    public void mouseMoved(MouseEvent mouseEvent) {
        Screen.point = new Point((int)mouseEvent.getPoint().getX(), (int)mouseEvent.getPoint().getY());
        FortressMove.x1 = Screen.point.x-7-75;
        FortressMove.y1 = Screen.point.y-30-75;
        samllFortressMove.x1 = Screen.point.x-7-75;
        samllFortressMove.y1 = Screen.point.y-30-75;
    }
}
