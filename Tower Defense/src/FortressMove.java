import javax.swing.*;
import java.awt.*;

public class FortressMove {
    public static int x1=-1000,y1=-1000;
    private Image FortressMoveImg;

    public int getY() {
        return y1;
    }

    public int getX() {
        return x1;
    }

    public void setY(int y) {
        this.y1 = y;
    }

    public void setX(int x) {
        this.x1 = x;
    }

    public Image getFortressMoveImg() {
        return FortressMoveImg;
    }
    public FortressMove(){
        FortressMoveImg = new ImageIcon("res/AssetsKit_1/sprites/DefineSprite_192/1.png").getImage();
    }

    public void draw(Graphics g){
        g.drawImage(FortressMoveImg,x1 ,y1 ,null);
        g.dispose();
    }
}
