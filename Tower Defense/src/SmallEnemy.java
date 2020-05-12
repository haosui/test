import java.awt.*;

public class SmallEnemy extends Enemy {

  double   distancex = (double) ((700 -  x)/500);
  double   distancey = (double) ((500 - y)/500);
    public SmallEnemy() {
        this.x = 460;
        this.y = 13;
        rectangleEnermy = new Rectangle((int)x,(int)y,30,20);
        this.enimage = loadIMG( "res/AssetsKit_1/shapes/246.png");
        price = 1;
        dame = 1;
        speed = 1;
        hp = 90;
    }

    public void draw(Graphics g) throws InterruptedException {
        if(!this.isLive && !this.IsBoom) {
            Boom(g);
        }
        g.drawImage(enimage,(int)x,(int)y,30,20,null);
    }



    public void move() {
        if(hp <0) SetLive(false);
        if (this.x > 460 && this.y < 175) {
            this.x -= speed;

        }
        else {
            x -= distancex;
            y += distancey;
        }



        if(x<0) {
            hp =0;
            IsBoom = true;
            isLive = false;
        }
    }

}
