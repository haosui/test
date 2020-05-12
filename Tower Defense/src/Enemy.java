import javax.swing.*;
import java.awt.*;

public class Enemy extends Fortress implements Enemys{
    protected boolean isFirst = true;
    protected Image enimage;
    protected Image enemyImgDown;
    protected Image enemyImgBack;
    public Rectangle rectangleEnermy = new Rectangle();
    public int hp;
    protected int price;
    protected int dame;
    protected double speed;
    protected boolean isLive = true;
    public boolean IsBoom = false;

    public void Boom( Graphics g) throws InterruptedException {

            VFS boom = new VFS(10, x-25, y-25, 60, 60);
            boom.draw(g);
            IsBoom = true;
    }

    public boolean IsLive() {
        return hp >0;
    }

    public void SetLive(boolean live) {
        isLive = live;
    }

    public void move() {

        }

    public void draw() {

    }

}

