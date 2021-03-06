//import javafx.scene.canvas.GraphicsContext;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class NormalFostress extends Fortress {
    public Ellipse2D rectangle;
    public Ellipse2D rectangleCheck;
    public boolean live = true;
    public ArrayList<Bullet> bulletArrayList = new ArrayList<>();
    protected Canvas canvas = new Canvas();
    public NormalFostress(double x, double y)

    {
        this.x = (int) x;
        this.y = (int) y;
        rectangle = new Ellipse2D.Double(x,y,151,151);
        rectangleCheck = new Ellipse2D.Double((int)x+7+60-15,(int)y+30+60-15,60,60);
        image =  new ImageIcon("res/AssetsKit_1/sprites/DefineSprite_192/1.png").getImage();

    }



    public NormalFostress(){
        image = new ImageIcon("res/AssetsKit_1/sprites/DefineSprite_192/1.png").getImage();
    }




    public void draw(Graphics g){

           g.drawImage(image,(int)x,(int)y,null);
          for (int i = 0; i < bulletArrayList.size(); i++)
        {
            //bulletArrayList.get(i).live &&
            if ( bulletArrayList.get(i).live &&bulletArrayList.get(i).getY() >= 0 && bulletArrayList.get(i).getX() >= 0 && bulletArrayList.get(i).getY() <= 600 &&bulletArrayList.get(i).getX() <= 600)
                bulletArrayList.get(i).draw(g);
            else
            {
                bulletArrayList.remove(i);
                i--;
            }

        }
        //g.dispose();
    }

    public int getW() {
        return (int) rectangle.getWidth();
    }

    public int getH() {
       return (int) rectangle.getHeight();
    }


}
