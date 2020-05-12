import javax.swing.*;
import java.awt.*;

public class Menu extends  BasicOb{
    public Image imageloser;
    public Image imagepause;
    public Image imageagain;
    public Image imageresume;
    Point pon = new Point(492, 240);


    public Menu() {
        this.image = new ImageIcon("res/AssetsKit_1/shapes/menu.png").getImage();
        imageloser = new ImageIcon("res/AssetsKit_1/shapes/loser.png").getImage();;
        imagepause = new ImageIcon("res/AssetsKit_1/shapes/pause.png").getImage();;
        imageagain =  new ImageIcon("res/AssetsKit_1/shapes/playagain.png").getImage();
        imageresume = new  ImageIcon("res/AssetsKit_1/shapes/resume.png").getImage();

        this.x=0;

        this.y = 0;
    }
    public  void mieru_menu(boolean j)
    {
        if (j)
        {
            this.x = 0;
            this.y = 0;
        }
        else
        {
            this.x = 1000;
            this.y = 1000;
        }
    }
    public void draw2(Graphics g)
    {
        g.drawImage(image, (int)x,(int)y , null);
    }
    public  void  draw_button (Graphics g)
    {
        g.drawImage(imagepause, pon.x,pon.y , null);
        g.drawImage(imageresume, pon.x,pon.y +50 , null);
        g.drawImage(imageagain, pon.x,pon.y+100 , null);
    }
    public int x_loser  = 1000;
    public  int y_loser = 1000;
    public void draw_lose(Graphics g)
    {
        g.drawImage(imageloser, x_loser,y_loser , null);
    }
    public  void mieru_loser(boolean j)
    {
        if (j)
        {
            x_loser = 0;
            y_loser = 0;
        }
        else
        {
            x_loser = 1000;
            y_loser= 1000;
        }
    }
    public  Point point = new Point(1000,1000);
    public  void can_see_point(boolean j)
    {
        if (j)
        {
            point.x = 150 ;
            point.y = 20;
        }
        else
        {
            point.x = 1000;
            point.y= 1000;
        }
    }
}
