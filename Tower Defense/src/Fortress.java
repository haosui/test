import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Fortress extends BasicOb implements Fortresses{
    public Ellipse2D rectangle;
    public ArrayList<Bullet> bulletArrayList = new ArrayList<>();


//    public Fortress(double x, double y)
//    {
//        this.x = (int) x;
//        this.y = (int) y;
//        rectangle = new Ellipse2D.Double(x,y,151,151);
//        image = new ImageIcon("res/AssetsKit_1/sprites/DefineSprite_192/1.png").getImage();
//    }
//
//
//
//    public Fortress(){
//        image = new ImageIcon("res/AssetsKit_1/sprites/DefineSprite_192/1.png").getImage();
//    }
//
//    public void draw(Graphics g){
//        g.drawImage(image,this.x ,this.y ,null);
//        for (int i = 0; i < bulletArrayList.size(); i++) {
//            //bulletArrayList.get(i).live &&
//            if (bulletArrayList.get(i).live && bulletArrayList.get(i).getY() >= 0 && bulletArrayList.get(i).getX() >= 0 && bulletArrayList.get(i).getY() <= 600 && bulletArrayList.get(i).getX() <= 600)
//                bulletArrayList.get(i).draw(g);
//            else {
//                bulletArrayList.remove(i);
//                i--;
//
//            }
//        }
//
//        //g.dispose();
//    }
}
