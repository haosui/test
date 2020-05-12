import javax.swing.*;
import java.awt.*;

public class BasicOb extends AbstractEnity {
    public  BasicOb()
    {
        super(0,0);

    }
      public  double x,y;
      public Image image;

    private boolean isDraw = false;
    public boolean getIsDraw() {return  isDraw;};
    public void setDraw( boolean v) {
        this.isDraw = v;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public Image getImg(){
        return this.image;
    }
    public Image loadIMG( String string)
    {
        return  new ImageIcon(string).getImage();
    }
    public void draw(Graphics g) throws InterruptedException {
        ;
    }
    public void  move()
    {
        ;
    }

}
