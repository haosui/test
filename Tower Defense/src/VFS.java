import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VFS implements ActionListener {

      private Timer timer;
      private int currentImage;
      private  int totalImage =15;
      private  double x,y,w,h;
      private    Image[] images = new Image[this.totalImage];
      private int index;
     public VFS(long time, double x, double y, double w, double h) {

            for(int i=0;i<totalImage;i++){
                images[i] = new ImageIcon("res/VFS/" + (i+1) +".png").getImage();
            }
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            currentImage =0;
            this.index = 0;
     }

     public void draw(Graphics g) throws InterruptedException {
               g.drawImage(images[currentImage], (int) x, (int) y, (int) h, (int) w, null);
               index++;
               if(index > 1000) {
                   currentImage++;
                   index=0;
               }
               if(currentImage > images.length) return;
     }




    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}


