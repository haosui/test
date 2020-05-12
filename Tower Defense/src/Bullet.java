import javax.swing.*;
import java.awt.*;

public class  Bullet extends BasicOb {
    public int distance_x = 0;
    public int distance_y =0 ;
    public boolean live = true;
    public Image bulletImg;
    public Rectangle rectangleBullet = new Rectangle();
    public Bullet()
    {
        x= 0;
        y =0;
        this.image =new ImageIcon("res/AssetsKit_1/shapes/137.png").getImage();
        rectangleBullet = new Rectangle((int)x, (int)y,9,9);
    }
    public boolean getLive()
    {
        return live;
    }
    public void set(Fortress fortress, Enemy enemy)
    {
        this.x = (int)fortress.getX()+65;
        this.y = (int) fortress.getY()+65;
        distance_x = (int) ((enemy.getX()+10-x)/2);
        distance_y = (int) (( enemy.getY()+10- y)/2);

    }
    public void draw(Graphics g)
    {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.drawImage(image, (int)x,(int)y , null);
    }
    public void move()
    {
        x+= distance_x*0.2;
        y+= distance_y*0.2;
        //live = true;
    }
}
