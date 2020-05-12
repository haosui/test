import javax.swing.*;
import java.awt.*;

public class Button extends BasicOb {

    public Button(int x, int y, String file_path ){
        this.x = x;
        this.y = y;
        //        this.image = loadIMG( "res/AssetsKit_1/buttons/DefineButton2_80/1.png");
        this.image = loadIMG(file_path);


    }
    public void draw(Graphics g){
        g.drawImage(image,(int) this.x,(int)this.y, null);
    }
}
