import java.awt.*;

public class NormalEnemy extends Enemy {
    public NormalEnemy(){
        this.x = 460;
        this.y = 13;
        rectangleEnermy = new Rectangle((int)x, (int)y,30,20);
        this.enimage = loadIMG( "res/AssetsKit_1/shapes/233.png");
        this.enemyImgDown = loadIMG("res/AssetsKit_1/shapes/233-down.png");
        this.enemyImgBack =loadIMG("res/AssetsKit_1/shapes/233-back.png");
        price = 1;
        dame = 10;
        speed = 1;
        hp = 100;
    }
    public void draw(Graphics g) throws InterruptedException {
        Graphics2D g2d = (Graphics2D) g.create();
        if(x>27&&y<175) g2d.drawImage(this.enimage, (int)x,(int) y,30,20,null);
        else if((x==27|| x==26 || x==25) &&y<175) {g2d.drawImage(enemyImgDown,(int)x,(int)y,20,30,null);}
        else if(x>=27&&( y==175|| y == 176 || y==174) &&x<403){g2d.drawImage(enemyImgBack,(int)x,(int)y,30,20,null);}
        else if(y>=175&&(x==403 || x == 404 || x==402) &&y<333) {g2d.drawImage(enemyImgDown,(int)x,(int)y,20,30,null);}
        else if((y==333|| y==332||y==334)&&x<=403) {g2d.drawImage(this.enimage,(int)x,(int)y,30,20,null);}

        if(!this.isLive && !this.IsBoom) {
            Boom(g);
        }

    }



    public void move(){
        if(hp <0) SetLive(false);
        if(this.x<-1){
            this.hp =0;
            IsBoom = true;
            isLive = false;
        }
        if(speed!=0.5) {
            if (this.x > 27 && this.y < 175) {
                this.x -= speed;
                x = Math.round(x);
            } else if (x == 27 && this.y < 175) {
                this.y += speed;
                y = Math.round(y);
            } else if (this.x >= 27 && this.y == 175 && this.x < 403) {
                x += speed;
                x = Math.round(x);
            } else if (this.y >= 175 && this.x == 403 && this.y < 333) {
                this.y += speed;
                y = Math.round(y);
            } else if (this.y == 333 && this.x <= 403) {
                this.x -= speed;
                x = Math.round(x);
            }
        }

        else {
            if (this.x > 27 && this.y < 175) {
                this.x -= speed;

            } else if (x == 27 && this.y < 175) {
                this.y += speed;

            } else if (this.x >= 27 && this.y == 175 && this.x < 403) {
                x += speed;

            } else if (this.y >= 175 && this.x == 403 && this.y < 333) {
                this.y += speed;

            } else if (this.y == 333 && this.x <= 403) {
                this.x -= speed;

            }
        }

        if(hp<= 0) {

        }
    }
}
